package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoInRam implements MealDao {
    private final AtomicInteger autoId = new AtomicInteger(0);
    List<Meal> mealDataBase = new CopyOnWriteArrayList<>();

    {
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        mealDataBase.add(new Meal(autoId.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    @Override
    public void add(Meal meal) {
        mealDataBase.add(new Meal(autoId.getAndIncrement(),
                meal.getDateTime(),
                meal.getDescription(),
                meal.getCalories()));
    }

    @Override
    public void delete(int id) {
        mealDataBase.remove(getById(id));
    }

    @Override
    public List<MealTo> getAll() {
        return MealsUtil.filteredByStreams(mealDataBase, LocalTime.of(0, 0), LocalTime.of(23, 59), 2000);
    }

    @Override
    public Meal getById(int id) {
        return mealDataBase.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    @Override
    public void update(Meal meal) {
        delete(meal.getId());
        mealDataBase.add(meal);
    }
}