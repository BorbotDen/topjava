package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealDao {
    void add(Meal meal);

    void delete(int id);

    List<MealTo> getAll();

    Meal getById(int id);

    void update(Meal meal);
}
