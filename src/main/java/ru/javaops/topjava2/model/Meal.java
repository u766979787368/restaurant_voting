package ru.javaops.topjava2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal")
@Getter
@Setter
@ToString(callSuper = true, exclude = {"restaurant"})
public class Meal extends NamedEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    private int price;

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
