package org.zerock.reminder.dto;

import jdk.internal.vm.annotation.IntrinsicCandidate;
import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderDTO {
    private long id;
    private String reminder;
    private LocalDate createDate;
    private LocalDate dueDate;
    private boolean completed;
}
