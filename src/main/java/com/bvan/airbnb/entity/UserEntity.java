package com.bvan.airbnb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bvanchuhov
 */
public class UserEntity {
    private final int id;
    private String name;
    private String email;
    private List<Integer> apartmentIds = new ArrayList<>();

    public UserEntity(int id) {
        this.id = id;
    }

    public void addApartment(Integer integer) {
        apartmentIds.add(integer);
    }

    //----- Getters -----

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public List<Integer> getApartmentIds() {
        return apartmentIds;
    }

    //----- Setters -----

    public void setEmail(String email) {
        this.email = email;
    }

    public void setApartmentIds(List<Integer> apartmentIds) {
        this.apartmentIds = apartmentIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return !(apartmentIds != null ? !apartmentIds.equals(that.apartmentIds) : that.apartmentIds != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (apartmentIds != null ? apartmentIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", apartmentList=").append(apartmentIds);
        sb.append('}');
        return sb.toString();
    }
}
