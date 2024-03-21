package org.zerock.reminder.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Cleanup;
import org.zerock.reminder.domain.ReminderVO;
import org.zerock.reminder.util.ConnectionUtil;

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

    public ReminderVO selectOne(long id) throws Exception {
        String sql = "SELECT * FROM reminder WHERE id = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        ReminderVO vo = ReminderVO.builder()
                .id(resultSet.getLong("id"))
                .reminder(resultSet.getString("reminder"))
                .createDate(resultSet.getDate("createDate").toLocalDate())
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .completed(resultSet.getBoolean("completed"))
                .build();

        return vo;
    }

    public void deleteOne(long id) throws Exception {
        String sql = "DELETE FROM reminder WHERE i = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public void updateOne(ReminderVO reminderVO) throws Exception {
        String sql = "UPDATE reminder SET reminder = ?, createDate = ?, dueDate = ?, completed = ? WHERE id = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, reminderVO.getReminder());
        preparedStatement.setDate(2, Date.valueOf(reminderVO.getCreateDate()));
        preparedStatement.setDate(3, Date.valueOf(reminderVO.getDueDate()));
        preparedStatement.setBoolean(4, reminderVO.isCompleted());
        preparedStatement.setLong(5, reminderVO.getId());

        preparedStatement.executeUpdate();
    }

}
