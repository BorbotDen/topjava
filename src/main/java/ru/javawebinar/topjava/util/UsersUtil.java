package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.*;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(null, "AntonUser", "TohaMail@my.ru", "1234five", Role.USER),
            new User(null, "AdminSergy", "Mail@my.ru", "sergey1996", Role.ADMIN),
            new User(null, "Zahar", "ZahMail@my.ru", "880055545", Role.USER),
            new User(null, "Mischa", "MixaMail@my.ru", "Mix123", Role.USER)
    );


}
