package com.bvan.airbnb.persistence.mysql;

import com.bvan.airbnb.entity.ApartmentEntity;
import com.bvan.airbnb.manager.DBManager;
import com.bvan.airbnb.entity.UserEntity;
import com.bvan.airbnb.persistence.api.ApartmentDAO;
import com.bvan.airbnb.persistence.api.PersistenceException;
import com.bvan.airbnb.persistence.api.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class MySqlUserDAO implements UserDAO {
    private static final String QUERY_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String QUERY_ALL_USERS = "SELECT * FROM users";

    private DBManager dbManager = DBManager.INSTANCE;
    private ApartmentDAO apartmentDAO = new MySqlApartmentDAO();

    @Override
    public UserEntity getUserById(int id) throws PersistenceException {
        Connection connection = dbManager.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_USER_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createUser(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<UserEntity> getAllUsers() throws PersistenceException {
        Connection connection = dbManager.getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_ALL_USERS);

            return createUsers(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private List<UserEntity> createUsers(ResultSet resultSet) throws SQLException, PersistenceException {
        List<UserEntity> users = new ArrayList<>();

        while (resultSet.next()) {
            UserEntity user = createUser(resultSet);
            users.add(user);
        }

        return users;
    }

    private UserEntity createUser(ResultSet resultSet) throws SQLException, PersistenceException {
        UserEntity user = new UserEntity(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));

        List<ApartmentEntity> apartments = apartmentDAO.getApartmentsByUserId(user.getId());
        user.setApartmentIds(apartmentsToIds(apartments));

        return user;
    }

    private List<Integer> apartmentsToIds(List<ApartmentEntity> apartments) {
        List<Integer> ids = new ArrayList<>();

        for (ApartmentEntity apartment : apartments) {
            ids.add(apartment.getId());
        }

        return ids;
    }
}
