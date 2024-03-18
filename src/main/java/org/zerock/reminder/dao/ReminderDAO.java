package org.zerock.reminder.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Cleanup;
import org.zerock.reminder.domain.ReminderVO;

public class ReminderDAO {

    public String getTime() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("SELECT NOW()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }

    public void createReminder(ReminderVO vo) throws Exception {
        String sql = "INSERT INTO reminder (reminder, createDate, dueDate, completed) VALUES (?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getReminder());
        preparedStatement.setString(2, getTime());
        preparedStatement.setDate(3, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(4, vo.isCompleted());

        preparedStatement.executeUpdate();

    }

    public List<ReminderVO> selectAll() throws Exception {
        String sql = "SELECT * FROM reminder";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<ReminderVO> list = new ArrayList<>();

        while (resultSet.next()) {
            ReminderVO vo = ReminderVO.builder()
                    .id(resultSet.getLong("id"))
                    .reminder(resultSet.getString("reminder"))
                    .createDate(resultSet.getDate("createDate").toLocalDate())
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .completed(resultSet.getBoolean("completed"))
                    .build();

            list.add(vo);
        }

        return list;
    }

}
