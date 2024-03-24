package org.zerock.reminder.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.reminder.dao.ReminderDAO;
import org.zerock.reminder.domain.ReminderVO;
import org.zerock.reminder.dto.ReminderDTO;
import org.zerock.reminder.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum ReminderService {
    INSTANCE;

    private ReminderDAO dao;
    private ModelMapper modelMapper;

    ReminderService() {
        dao = new ReminderDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void create(ReminderDTO reminderDTO) throws Exception {
        ReminderVO reminderVO = modelMapper.map(reminderDTO, ReminderVO.class);
        //System.out.println("reminderVO: " + reminderVO);
        log.info(reminderVO);
        dao.createReminder(reminderVO);
    }

    public List<ReminderDTO> listALL() throws Exception {
        List<ReminderVO> voList = dao.selectAll();
        log.info("voList....................");
        log.info(voList);

        List<ReminderDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, ReminderDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

}
