package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDAOinRAM implements MealDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    List<Meal> mealDataBase = new CopyOnWriteArrayList<>(Arrays.asList(
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
            new Meal(AUTO_ID.getAndIncrement(), LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
    ));

    @Override
    public void addNew(Meal meal) {
        mealDataBase.add(meal);
    }

    @Override
    public void delete(Meal meal) {
        mealDataBase.remove(meal);
    }

    @Override
    public List<MealTo> getAll() {
        return MealsUtil.filteredByStreams(mealDataBase);
    }

    @Override
    public Meal getById(int id) {
        return mealDataBase.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public static Meal createEmptyMeal(LocalDateTime dateTime, String description, int calories) {
        return new Meal(AUTO_ID.getAndIncrement(), dateTime, description, calories);
    }
}
