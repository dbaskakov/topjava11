package ru.javawebinar.topjava.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by d.baskakov on 25.07.2017.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void get() throws Exception {
        Meal meal=service.get(100003,100000);
        Assert.assertEquals(meal, MealTestData.MEAL1);
    }

    @Test
    public void delete() throws Exception {
        //todo
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
        //todo
    }

    @Test
    public void getAll() throws Exception {
        List<Meal> mealList=service.getAll(100000);
        mealList.forEach(m-> System.out.println(m));
    }

    @Test
    public void update() throws Exception {
        //todo
        Meal meal=service.update(MealTestData.MEAL2,100000);
        Assert.assertEquals(meal,service.get(meal.getId(),100000));
    }

    @Test
    public void save() throws Exception {
        Meal meal=service.save(MealTestData.MEAL9,100000);
        Assert.assertEquals(meal,service.get(meal.getId(),100000));

    }


}