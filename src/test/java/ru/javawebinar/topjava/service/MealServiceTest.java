package ru.javawebinar.topjava.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;

/**
 * Created by d.baskakov on 25.07.2017.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql("classpath:db/populateDB.sql")
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void get() throws Exception {
        Meal meal=service.get(100003,100000);
        MATCHER.assertEquals(meal, MEAL2);
    }

    @Test
    public void delete() throws Exception {
        service.delete(100003,100000);
        MATCHER.assertCollectionEquals(service.getAll(100000), Arrays.asList(MEAL1));
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        List<Meal> meals=service.getBetweenDateTimes(LocalDateTime.parse("2017-05-16T11:00:00"),LocalDateTime.MAX,100000);
        MATCHER.assertCollectionEquals(Arrays.asList(MEAL2),meals);
    }

    @Test
    public void getAll() throws Exception {
        List<Meal> mealList=service.getAll(100000);
       MATCHER.assertCollectionEquals(mealList,meals);
    }

    @Test
    public void update() throws Exception {
        Meal meal=service.update(MEAL3,100000);
        MATCHER.assertEquals(meal,MEAL3);
    }

    @Test
    public void save() throws Exception {
        service.save(MEAL5,100000);
        MATCHER.assertCollectionEquals(service.getAll(100000), Arrays.asList(MEAL5,MEAL2,MEAL1));

    }


}