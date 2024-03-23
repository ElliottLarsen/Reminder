package org.zerock.reminder.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.reminder.dao.ReminderDAO;
import org.zerock.reminder.domain.ReminderVO;
import org.zerock.reminder.dto.ReminderDTO;
import org.zerock.reminder.util.MapperUtil;

@Log4j2
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
        //System.out.println("reminderVO: " + reminderVO);
        log.info(reminderVO);
        dao.createReminder(reminderVO);
    }



}
