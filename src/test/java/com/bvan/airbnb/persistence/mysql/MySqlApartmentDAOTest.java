package com.bvan.airbnb.persistence.mysql;

import com.bvan.airbnb.entity.ApartmentEntity;
import com.bvan.airbnb.persistence.api.ApartmentDAO;
import org.junit.Test;

import java.util.List;

import static com.bvan.airbnb.persistence.test_data.TestApartments.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MySqlApartmentDAOTest {
    private ApartmentDAO apartmentDAO = new MySqlApartmentDAO();

    @Test
    public void testGetAllApartments() throws Exception {
        List<ApartmentEntity> apartments = apartmentDAO.getAllApartments();

        assertThat(apartments, is(getTestApartments()));
    }

    @Test
    public void testGetApartmentById() throws Exception {
        ApartmentEntity apartment = apartmentDAO.getApartmentById(1);

        assertThat(apartment, is(getTestApartment(0)));
    }

    @Test
    public void testGetApartmentsByUserId() throws Exception {
        List<ApartmentEntity> apartments = apartmentDAO.getApartmentsByUserId(1);

        assertThat(apartments, hasItems(getTestApartment(0), getTestApartment(1)));
    }
}
