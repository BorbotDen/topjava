package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(null,"Sergy","Mail@my.ru","sergey1996", Role.ADMIN),
            new User(null,"Anton","TohaMail@my.ru","1234five", Role.USER),
            new User(null,"Zahar","ZahMail@my.ru","880055545", Role.USER),
            new User(null,"Mischa","MixaMail@my.ru","Mix123", Role.USER)
    );

    public static List<User> getSortedUsers (Collection<User> users){
return users.stream()
        .sorted(Comparator.comparing(User::getName))
        .collect(Collectors.toList());
    }


}
