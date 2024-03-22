package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.reminder.dto.ReminderDTO;
import org.zerock.reminder.service.ReminderService;

import java.time.LocalDate;

public class ServiceTests {

    private ReminderService reminderService;

    @BeforeEach
    public void prepare() {
        reminderService = ReminderService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        ReminderDTO reminderDTO = ReminderDTO.builder()
                .reminder("Service Test Title")
                .createDate(LocalDate.now())
                .dueDate(LocalDate.now())
                .completed(true)
                .build();

        reminderService.register(reminderDTO);
    }

}
