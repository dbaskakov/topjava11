package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;

public class MealTestData {

    public static final Meal MEAL1 = new Meal(100003, LocalDateTime.parse("2017-05-16T10:36:38") ,"test2",222);
    public static final Meal MEAL2 = new Meal(100003, LocalDateTime.parse("2017-01-01T10:01:01") ,"UPDATE",111);
    public static final Meal MEAL9 = new Meal(LocalDateTime.parse("2017-07-16T10:36:38") ,"NEW",999);

    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>();

}
