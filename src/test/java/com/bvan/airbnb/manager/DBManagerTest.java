package com.bvan.airbnb.manager;

import org.junit.Test;

import java.sql.Connection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DBManagerTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection connection = DBManager.INSTANCE.getConnection();

        assertThat(connection, notNullValue());
    }
}
