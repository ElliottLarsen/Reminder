package org.zerock.reminder.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.reminder.service.ReminderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reminderController", value="/reminder/list")
@Log4j2
public class ReminderController extends HttpServlet {

    private ReminderService reminderService = ReminderService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("REMINDER LIST--------------------");
    }
}
