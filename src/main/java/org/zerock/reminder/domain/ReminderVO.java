package org.zerock.reminder.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReminderVO {
    private Long id;
    private String reminder;
    private LocalDate createDate;
    private LocalDate dueDate;
    private boolean completed;
}
