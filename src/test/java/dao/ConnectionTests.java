package dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.zerock.reminder.dao.ReminderDAO;
import org.zerock.reminder.domain.ReminderVO;

public class ConnectionTests {

    ReminderDAO reminderDAO = new ReminderDAO();

    @Test
    public void testConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/Reminder",
                "root",
                "root"
        );

        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/Reminder");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();
    }

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
}
