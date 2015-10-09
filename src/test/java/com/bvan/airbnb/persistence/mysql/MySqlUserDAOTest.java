package com.bvan.airbnb.persistence.mysql;

import com.bvan.airbnb.entity.UserEntity;
import com.bvan.airbnb.persistence.api.UserDAO;
import org.junit.Test;

import java.util.List;

import static com.bvan.airbnb.persistence.test_data.TestUsers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MySqlUserDAOTest {
    private UserDAO userDAO = new MySqlUserDAO();

    @Test
    public void testGetAllUsers() throws Exception {
        List<UserEntity> users = userDAO.getAllUsers();

        assertThat(users, is(getTestUsers()));
    }

    @Test
    public void testGetUserById() throws Exception {
        UserEntity user = userDAO.getUserById(1);

        assertThat(user, is(getTestUser(0)));
    }
}
