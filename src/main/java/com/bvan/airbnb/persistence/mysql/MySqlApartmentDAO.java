package com.bvan.airbnb.persistence.mysql;

import com.bvan.airbnb.entity.ApartmentEntity;
import com.bvan.airbnb.entity.ApartmentType;
import com.bvan.airbnb.manager.DBManager;
import com.bvan.airbnb.persistence.api.ApartmentDAO;
import com.bvan.airbnb.persistence.api.PersistenceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class MySqlApartmentDAO implements ApartmentDAO {
    private static final String QUERY_ALL_APARTMENTS = "SELECT * FROM apartments";
    private static final String QUERY_APARTMENTS_BY_USER_ID = "SELECT * FROM apartments WHERE user_id = ?";
    private static final String QUERY_APARTMENT_BY_ID = "SELECT * FROM apartments WHERE id = ?";

    private DBManager dbManager = DBManager.INSTANCE;

    @Override
    public ApartmentEntity getApartmentById(int id) throws PersistenceException {
        Connection connection = dbManager.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_APARTMENT_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return createApartment(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<ApartmentEntity> getApartmentsByUserId(int userId) throws PersistenceException {
        Connection connection = dbManager.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_APARTMENTS_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            return createApartments(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public List<ApartmentEntity> getAllApartments() throws PersistenceException {
        Connection connection = dbManager.getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_ALL_APARTMENTS);
            return createApartments(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private List<ApartmentEntity> createApartments(ResultSet resultSet) throws SQLException {
        List<ApartmentEntity> apartmentEntities = new ArrayList<>();

        while (resultSet.next()) {
            ApartmentEntity apartmentEntity = createApartment(resultSet);
            apartmentEntities.add(apartmentEntity);
        }

        return apartmentEntities;
    }

    private ApartmentEntity createApartment(ResultSet resultSet) throws SQLException {
        ApartmentEntity apartmentEntity = new ApartmentEntity(resultSet.getInt("id"));
        apartmentEntity.setCity(resultSet.getString("city"));
        apartmentEntity.setType(ApartmentType.valueOf(resultSet.getString("type")));
        apartmentEntity.setUserId(resultSet.getInt("user_id"));

        return apartmentEntity;
    }
}
