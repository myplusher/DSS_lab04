package ru.dmi3ev.lab04.servlet;

import ru.dmi3ev.lab04.dao.UserDao;
import ru.dmi3ev.lab04.entity.Complete;
import ru.dmi3ev.lab04.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AddUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String subject = request.getParameter("subject");
            Date data_complete = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data_complete"));
            int percent_compl = Integer.parseInt(request.getParameter("percent_compl"));
            String type_work = request.getParameter("type_work");


            Complete complete = new Complete(subject, data_complete, percent_compl, type_work);

            try (Connection connection = Logic.getConnection()) {
                UserDao us = new UserDao(connection);
                System.out.println(complete.getSubject() + "!!!!!!!!!!!");
                us.addWork(complete);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("/");
        }
        catch (Exception ex) {
            response.sendRedirect("/AddUser");

        }

    }
}
