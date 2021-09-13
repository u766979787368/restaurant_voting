package ru.javaops.topjava2.web.meal;

import ru.javaops.topjava2.model.Meal;
import ru.javaops.topjava2.web.MatcherFactory;

import java.util.List;

public class MealTestData {
    public static final MatcherFactory.Matcher<Meal> MATCHER = MatcherFactory.usingEqualsComparator(Meal.class);

    public static final int MEAL_1_R1_ID = 1;
    public static final int MEAL_2_R1_ID = 2;
    public static final int MEAL_3_R1_ID = 3;
    public static final int MEAL_1_R2_ID = 4;
    public static final int MEAL_2_R2_ID = 5;
    public static final int MEAL_3_R2_ID = 6;
    public static final int MEAL_1_R3_ID = 7;
    public static final int MEAL_2_R3_ID = 8;
    public static final int MEAL_3_R3_ID = 9;

    public static final Meal meal_1 = new Meal(MEAL_1_R1_ID, "Еда ресторана 1_1", 500);
    public static final Meal meal_2 = new Meal(MEAL_2_R1_ID, "Еда ресторана 1_2", 600);
    public static final Meal meal_3 = new Meal(MEAL_3_R1_ID, "Еда ресторана 1_3", 700);
    public static final Meal meal_4 = new Meal(MEAL_1_R2_ID, "Еда ресторана 2_1", 500);
    public static final Meal meal_5 = new Meal(MEAL_2_R2_ID, "Еда ресторана 2_2", 600);
    public static final Meal meal_6 = new Meal(MEAL_3_R2_ID, "Еда ресторана 2_3", 700);
    public static final Meal meal_7 = new Meal(MEAL_1_R3_ID, "Еда ресторана 3_1", 500);
    public static final Meal meal_8 = new Meal(MEAL_2_R3_ID, "Еда ресторана 3_2", 600);
    public static final Meal meal_9 = new Meal(MEAL_3_R3_ID, "Еда ресторана 3_3", 700);

    public static Meal getNew() {
        return new Meal(null, "newMeal", 900);
    }

    public static List<Meal> getAllMealsForRestaurant1() {
        return List.of(meal_1, meal_2, meal_3);
    }

    public static Meal getUpdated() {
        return new Meal(MEAL_1_R1_ID, "updatedName", 300);
    }

}
