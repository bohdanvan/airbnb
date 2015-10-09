package com.bvan.airbnb.persistence.api;

import com.bvan.airbnb.entity.UserEntity;

import java.util.List;

/**
 * @author bvanchuhov
 */
public interface UserDAO {
    UserEntity getUserById(int id) throws PersistenceException;
    List<UserEntity> getAllUsers() throws PersistenceException;
}
