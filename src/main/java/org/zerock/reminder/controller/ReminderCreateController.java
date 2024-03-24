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

@WebServlet(name = "reminderCreateController", value = "/reminder/create")
@Log4j2
public class ReminderCreateController extends HttpServlet {
    private ReminderService reminderService = ReminderService.INSTANCE;
    private final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-mm-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/reminder/create GET....................");
        req.getRequestDispatcher("/WEB-INF/reminder/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReminderDTO reminderDTO = ReminderDTO.builder()
                .reminder(req.getParameter("reminder"))
                .createDate(LocalDate.parse(req.getParameter("createDate"), DATETIMEFORMATTER))
                .dueDate(LocalDate.parse(req.getParameter("dueDATE"), DATETIMEFORMATTER))
                .build();

                System.out.println("/reminder/create POST....................");
                log.info(reminderDTO);
                try {
                    reminderService.create(reminderDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                resp.sendRedirect("/reminder/list");
    }
}
