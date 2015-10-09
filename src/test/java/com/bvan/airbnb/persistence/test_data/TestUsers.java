package com.bvan.airbnb.persistence.test_data;

import com.bvan.airbnb.entity.UserEntity;

import java.util.Arrays;
import java.util.List;

/**
 * @author bvanchuhov
 */
public final class TestUsers {
    private TestUsers() {}

    private static List<UserEntity> users;

    public static UserEntity getTestUser(int index) {
        return getTestUsers().get(index);
    }

    public static List<UserEntity> getTestUsers() {
        if (users == null) {
            users = Arrays.asList(getUser1(), getUser2(), getUser3());
        }
        return users;
    }

    public static UserEntity getUser1() {
        UserEntity userEntity = new UserEntity(1);
        userEntity.setName("John");
        userEntity.setEmail("john@gmail.com");
        userEntity.setApartmentIds(Arrays.asList(1, 2));

        return userEntity;
    }

    private static UserEntity getUser2() {
        UserEntity userEntity = new UserEntity(2);
        userEntity.setName("Bill");
        userEntity.setEmail("bill@gmail.com");
        userEntity.setApartmentIds(Arrays.asList(3));

        return userEntity;
    }

    private static UserEntity getUser3() {
        UserEntity userEntity = new UserEntity(3);
        userEntity.setName("Bob");
        userEntity.setEmail("bob@gmail.com");

        return userEntity;
    }
}
