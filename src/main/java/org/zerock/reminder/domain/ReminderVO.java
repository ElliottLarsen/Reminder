package org.zerock.reminder.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class ReminderVO {
    private Long id;
    private String reminder;
    private LocalDate createDate;
    private LocalDate duDate;
    private boolean completed;
}
