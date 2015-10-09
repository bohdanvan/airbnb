package com.bvan.airbnb.entity;

/**
 * @author bvanchuhov
 */
public class ApartmentEntity {
    private final int id;
    private String city;
    private ApartmentType type;
    private int userId;

    public ApartmentEntity(int id) {
        this.id = id;
    }

    //----- Getters -----

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public ApartmentType getType() {
        return type;
    }

    public int getUserId() {
        return userId;
    }

    //----- Setters -----


    public void setCity(String city) {
        this.city = city;
    }

    public void setType(ApartmentType type) {
        this.type = type;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApartmentEntity)) return false;

        ApartmentEntity that = (ApartmentEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApartmentEntity{");
        sb.append("id=").append(id);
        sb.append(", city='").append(city).append('\'');
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
