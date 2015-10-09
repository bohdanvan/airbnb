package com.bvan.airbnb.persistence.test_data;

import com.bvan.airbnb.entity.ApartmentEntity;

import java.util.Arrays;
import java.util.List;

import static com.bvan.airbnb.entity.ApartmentType.APARTMENT;
import static com.bvan.airbnb.entity.ApartmentType.CORNER;
import static com.bvan.airbnb.entity.ApartmentType.ROOM;

/**
 * @author bvanchuhov
 */
public final class TestApartments {
    private TestApartments() {}

    private static List<ApartmentEntity> testApartments;

    public static ApartmentEntity getTestApartment(int index) {
        return getTestApartments().get(index);
    }

    public static List<ApartmentEntity> getTestApartments() {
        if (testApartments == null) {
            testApartments = Arrays.asList(
                    getTestApartment1(),
                    getTestApartment2(),
                    getTestApartment3()
            );
        }
        return testApartments;
    }

    private static ApartmentEntity getTestApartment1() {
        ApartmentEntity apartment = new ApartmentEntity(1);
        apartment.setCity("Kyiv");
        apartment.setType(APARTMENT);
        apartment.setUserId(1);

        return apartment;
    }

    private static ApartmentEntity getTestApartment2() {
        ApartmentEntity apartment = new ApartmentEntity(2);
        apartment.setCity("Lviv");
        apartment.setType(CORNER);
        apartment.setUserId(1);

        return apartment;
    }

    private static ApartmentEntity getTestApartment3() {
        ApartmentEntity apartment = new ApartmentEntity(3);
        apartment.setCity("Lviv");
        apartment.setType(ROOM);
        apartment.setUserId(2);

        return apartment;
    }
}
