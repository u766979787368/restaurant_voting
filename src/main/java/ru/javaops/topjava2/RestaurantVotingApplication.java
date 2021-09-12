package ru.javaops.topjava2;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.javaops.topjava2.repository.MealRepository;
import ru.javaops.topjava2.repository.RestaurantRepository;
import ru.javaops.topjava2.repository.UserRepository;
import ru.javaops.topjava2.repository.VoteRepository;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final MealRepository mealRepository;
    private final VoteRepository voteRepository;


    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userRepository.findAll());
        System.out.println(restaurantRepository.findAll());
        System.out.println(mealRepository.findAll());
        System.out.println(voteRepository.findAll());
    }
}
