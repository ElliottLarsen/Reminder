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

@WebServlet(name = "reminderUpdateController", value = "/reminder/update")
@Log4j2
public class ReminderUpdateController extends HttpServlet {
    private ReminderService reminderService = ReminderService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            ReminderDTO reminderDTO = reminderService.get(id);
            req.setAttribute("dto", reminderDTO);
            req.getRequestDispatcher("/WEB-INF/reminder/update.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServletException("Update GET... Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String completedStr = req.getParameter("completed");

        ReminderDTO reminderDTO = ReminderDTO.builder()
                .id(Long.parseLong(req.getParameter("id")))
                .reminder(req.getParameter("reminder"))
                .createDate(LocalDate.parse(req.getParameter("createDate"), DATEFORMATTER))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                .completed(completedStr != null && completedStr.equals("on"))
                .build();

        System.out.println("/reminder/update POST...");
        System.out.println(reminderDTO);

        try {
            reminderService.update(reminderDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/reminder/list");
    }
}
