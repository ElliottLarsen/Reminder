package org.zerock.reminder.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.reminder.dto.ReminderDTO;
import org.zerock.reminder.service.ReminderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "reminderRemoveController", value = "/reminder/remove")
@Log4j2
public class ReminderRemoveController extends HttpServlet {
    private ReminderService reminderService = ReminderService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        System.out.println("id: " + id);
        try {
            reminderService.remove(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("Remove Error");
        }
        resp.sendRedirect("/reminder/list");
    }
}
