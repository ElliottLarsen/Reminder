package dao;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import org.zerock.reminder.dao.ReminderDAO;
import org.zerock.reminder.domain.ReminderVO;

public class CRUDTests {

    ReminderDAO reminderDAO = new ReminderDAO();

    @Test
    public void testCreate() throws Exception {
        ReminderVO reminderVO = ReminderVO.builder()
                .reminder("Example Reminder...")
                .dueDate(LocalDate.of(2024, 3, 17))
                .build();

        reminderDAO.createReminder(reminderVO);
    }

    @Test
    public void testListAll() throws Exception {
        List<ReminderVO> list = reminderDAO.selectAll();

        for (int i = 0; i < list.size(); i++) {
            System.out.println("-> " + list.get(i));
        }
    }

    @Test
    public void testGetOne() throws Exception {
        ReminderVO vo = reminderDAO.selectOne(1L);
        System.out.println(vo);
    }

    @Test
    public void testUpdateOne() throws Exception {
        ReminderVO reminderVO = ReminderVO.builder()
                .id(1L)
                .reminder("Update Test")
                .createDate(LocalDate.of(2024, 3, 20))
                .dueDate(LocalDate.of(2024, 3, 21))
                .completed(true)
                .build();

        reminderDAO.updateOne(reminderVO);
    }
}
