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
import java.util.List;

@WebServlet(name = "reminderController", value="/reminder/list")
@Log4j2
public class ReminderController extends HttpServlet {

    private ReminderService reminderService = ReminderService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("REMINDER LIST--------------------");
        try {
            List<ReminderDTO> dtoList = reminderService.listALL();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/reminder/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
