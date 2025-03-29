package org.example._10_sroun_davit_pvh_spring_homework003.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Attendees {
    private  Integer attendeesId;
    private  String attendeesName;
    private  String email;
}
