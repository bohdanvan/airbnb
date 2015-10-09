package com.bvan.airbnb.persistence.api;

import com.bvan.airbnb.entity.ApartmentEntity;

import java.util.List;

/**
 * @author bvanchuhov
 */
public interface ApartmentDAO {
    ApartmentEntity getApartmentById(int id) throws PersistenceException;
    List<ApartmentEntity> getApartmentsByUserId(int userId) throws PersistenceException;
    List<ApartmentEntity> getAllApartments() throws PersistenceException;
}
