package ru.dmi3ev.lab04.servlet;

import ru.dmi3ev.lab04.dao.UserDao;
import ru.dmi3ev.lab04.entity.Complete;
import ru.dmi3ev.lab04.logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletIndex extends HttpServlet {

    List<Complete> completeList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDao ud = new UserDao(Logic.getConnection());
            completeList = ud.listAllWork();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(completeList.size());
        req.setAttribute("works", completeList);
        req.getRequestDispatcher("/AllWorks.jsp").forward(req,resp);
    }
}
