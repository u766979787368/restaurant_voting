package ru.javaops.topjava2.web.meal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaops.topjava2.model.Meal;
import ru.javaops.topjava2.repository.MealRepository;
import ru.javaops.topjava2.repository.RestaurantRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.javaops.topjava2.util.validation.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(value = MealController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class MealController {

    static final String REST_URL = "/api/profile/restaurants/{restaurantId}/meals";

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@PathVariable int restaurantId, @Valid @RequestBody Meal meal) {
        log.info("create {}", meal);
        meal.setRestaurant(restaurantRepository.getById(restaurantId));
        Meal created = mealRepository.save(meal);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(restaurantId, created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int restaurantId, @Valid @RequestBody Meal meal, @PathVariable int id) {
        log.info("update {} with id={}", meal, id);
        meal.setRestaurant(restaurantRepository.getById(restaurantId));
        assureIdConsistent(meal, id);
        mealRepository.save(meal);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int restaurantId, @PathVariable int id) {
        mealRepository.deleteByRestaurantIdAndId(restaurantId, id);
    }

    @GetMapping
    public List<Meal> getAll(@PathVariable int restaurantId) {
        log.info("getAll");
        return mealRepository.findAllByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> get(@PathVariable int restaurantId, @PathVariable int id) {
        return  ResponseEntity.of(mealRepository.findById(id));
    }
}
