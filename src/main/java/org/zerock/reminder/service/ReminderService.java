package org.zerock.reminder.service;

import jdk.internal.icu.text.NormalizerBase;
import org.modelmapper.ModelMapper;
import org.zerock.reminder.dao.ReminderDAO;
import org.zerock.reminder.domain.ReminderVO;
import org.zerock.reminder.dto.ReminderDTO;
import org.zerock.reminder.util.MapperUtil;

import java.util.Map;

public enum ReminderService {
    INSTANCE;

    private ReminderDAO dao;
    private ModelMapper modelMapper;

    ReminderService() {
        dao = new ReminderDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(ReminderDTO reminderDTO) throws Exception {
        ReminderVO reminderVO = modelMapper.map(reminderDTO, ReminderVO.class);
        System.out.println("reminderVO: " + reminderVO);
        dao.createReminder(reminderVO);
    }



}
