package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);
    private MealDao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new MealDaoInRam() {
        };
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "showAll";
        }
        if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            log.debug("Delete user id={} and redirect to meal. ", id);
            dao.delete(id);
            response.sendRedirect("meals");
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            log.debug("Update user id={} and redirect to meal. ", id);
            request.setAttribute("meal", dao.getById(id));
            request.getRequestDispatcher("/editmeal.jsp").forward(request, response);
        } else if (action.equals("new")) {
            log.debug("redirect to newmeal.");
            request.getRequestDispatcher("/editmeal.jsp").forward(request, response);
        } else {//showAll
            log.debug("redirect to meal.Show all ");
            request.setAttribute("listMealsTo", dao.getAll());
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LocalDateTime localDateTime = LocalDateTime.parse(request.getParameter("datetime"));
        Meal meal = new Meal(
                null,
                localDateTime,
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories"))
        );
        if (request.getParameter("id") == null) {
            dao.add(meal);
            log.debug("new meal added");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            meal.setId(id);
            dao.update(meal);
            log.debug("Changes saved successfully");
        }
        log.debug("redirect from doPost to meal.Show all ");
        response.sendRedirect("meals");
    }
}
