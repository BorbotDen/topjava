package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDaoInRam implements MealDao {
    private final AtomicInteger autoId = new AtomicInteger(0);
    private final Map<Integer, Meal> mealDataBase = new ConcurrentHashMap<>();

    {
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    @Override
    public Meal add(Meal meal) {
        int id = autoId.getAndIncrement();
        meal.setId(id);
        return mealDataBase.computeIfAbsent(id, m -> meal);
    }

    @Override
    public void delete(int id) {
        mealDataBase.remove(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return mealDataBase.values();
    }

    @Override
    public Meal getById(int id) {
        return mealDataBase.get(id);
    }

    @Override
    public Meal update(Meal meal) {
        return mealDataBase.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
    }
}