package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.DAO.MealDAO;
import ru.javawebinar.topjava.DAO.MealDAOinRAM;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    MealDAO dao;

    public MealServlet() {
        dao = new MealDAOinRAM();
    }

    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "showAll";
        }
        if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            log.debug("Delete user id=" + id + " and redirect to meal. ");
            dao.delete(dao.getById(id));
            response.sendRedirect("/meals");
        } else {
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                log.debug("Update user id=" + id + " and redirect to meal. ");
                request.setAttribute("meal", dao.getById(id));
                request.getRequestDispatcher("/editmeal.jsp").forward(request, response);
            } else {//showAll
                log.debug("redirect to meal.Show all ");
                request.setAttribute("listMealsTo", dao.getAll());
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("id") == null) {
            LocalDateTime localDateTime = LocalDateTime.parse(request.getParameter("datetime"));
            Meal meal = MealDAOinRAM.createEmptyMeal(
                    localDateTime,
                    request.getParameter("description"),
                    Integer.parseInt(request.getParameter("calories"))
            );
            dao.addNew(meal);
            log.debug("new meal added");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            LocalDateTime localDateTime = LocalDateTime.parse(request.getParameter("datetime"));
            Meal meal = new Meal(
                    id,
                    localDateTime,
                    request.getParameter("description"),
                    Integer.parseInt(request.getParameter("calories"))
            );
            /* Замена удалением */
            dao.delete(dao.getById(id));
            dao.addNew(meal);
            log.debug("Changes saved successfully");
        }
        log.debug("redirect to meal.Show all ");
        request.setAttribute("listMealsTo", dao.getAll());
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
