package ru.javaops.topjava2.web.restaurant;

import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.web.MatcherFactory;

import java.util.List;

public class RestaurantTestData {
    public static final MatcherFactory.Matcher<Restaurant> MATCHER = MatcherFactory.usingEqualsComparator(Restaurant.class);

    public static final int RESTAURANT_1_ID = 1;
    public static final int RESTAURANT_2_ID = 2;
    public static final int RESTAURANT_3_ID = 3;
    public static final int NOT_FOUND = 100;

    public static final Restaurant restaurant_1 = new Restaurant(RESTAURANT_1_ID, "Ресторан_1");
    public static final Restaurant restaurant_2 = new Restaurant(RESTAURANT_2_ID, "Ресторан_2");
    public static final Restaurant restaurant_3 = new Restaurant(RESTAURANT_3_ID, "Ресторан_3");

    public static Restaurant getNew() {
        return new Restaurant(null, "New");
    }

    public static List<Restaurant> getAllRestaurants() {
        return List.of(restaurant_1, restaurant_2, restaurant_3);
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT_1_ID, "updatedName");
    }
}
