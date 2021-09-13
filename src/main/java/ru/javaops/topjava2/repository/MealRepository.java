package ru.javaops.topjava2.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava2.model.Meal;

import java.util.List;

public interface MealRepository extends BaseRepository<Meal> {

    List<Meal> findAllByRestaurantId(Integer id);

    @Transactional
    @Modifying
    void deleteByRestaurantIdAndId(int restaurantId, int id);
}
