package org.example._10_sroun_davit_pvh_spring_homework003.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    private Integer eventId;
    private String eventName;
    private LocalDateTime localDateTime ;
    private Venues venues;
    private List<Attendees> attendees;
}
