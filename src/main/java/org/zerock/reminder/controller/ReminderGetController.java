package org.zerock.reminder.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.reminder.dto.ReminderDTO;
import org.zerock.reminder.service.ReminderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reminderGetController", value = "/reminder/get")
@Log4j2
public class ReminderGetController extends HttpServlet {
    private ReminderService reminderService = ReminderService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            ReminderDTO reminderDTO = reminderService.get(id);

            req.setAttribute("dto", reminderDTO);
            req.getRequestDispatcher("/WEB-INF/reminder/get.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServletException("Get Error");
        }
    }
}
