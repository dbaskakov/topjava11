package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MealTestData {

    public static final Meal MEAL1 = new Meal(100002, LocalDateTime.parse("2017-05-16T10:36:38") ,"test1",111);
    public static final Meal MEAL2 = new Meal(100003, LocalDateTime.parse("2017-05-16T11:36:38") ,"test2",222);
    public static final Meal MEAL3 = new Meal(100003,LocalDateTime.parse("2017-07-16T10:36:38") ,"UPDATE",999);
    public static final Meal MEAL5 = new Meal(LocalDateTime.parse("2017-07-16T10:36:38") ,"UPDATE",999);

    public static final List<Meal> meals=new ArrayList<Meal>(){{
        add(MEAL2);
        add(MEAL1);
    }};


    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>(
            ((expected, actual) -> expected==actual||
                    (Objects.equals(expected.getDateTime(),actual.getDateTime()))
                    && Objects.equals(expected.getDescription(),actual.getDescription())
                    && Objects.equals(expected.getCalories(),actual.getCalories())
            )
    );

}
