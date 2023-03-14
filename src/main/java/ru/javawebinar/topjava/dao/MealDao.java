package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealDao {
    Meal add(Meal meal);

    void delete(int id);

    Collection<Meal> getAll();

    Meal getById(int id);

    Meal update(Meal meal);
}