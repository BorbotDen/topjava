package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.util.List;

public interface MealDAO {
    void addNew(Meal meal);

    void delete(Meal meal);

    List<MealTo> getAll();

    Meal getById(int id);
}
