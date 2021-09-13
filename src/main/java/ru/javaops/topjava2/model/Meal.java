package ru.javaops.topjava2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "date"}, name = "uk_meal_name_date")})
@Getter
@Setter
@ToString(callSuper = true, exclude = {"restaurant"})
@NoArgsConstructor
public class Meal extends NamedEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    private int price;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    public Meal(Integer id, String name, int price) {
        super(id, name);
        this.price = price;
    }
}
