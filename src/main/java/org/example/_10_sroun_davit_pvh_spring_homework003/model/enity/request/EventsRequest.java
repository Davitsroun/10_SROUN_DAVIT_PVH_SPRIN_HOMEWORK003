package org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventsRequest {
    @NotNull(message = "EventName cannot be null")
    @Size(min = 3 , max = 20, message = "EventName must between 3 and 20 characters ")
    private String eventName;

    @NotNull(message = "localDateTime cannot be null")
    private LocalDateTime localDateTime ;
    @NotNull(message = "Venues cannot be null")
    private Integer venues;
    private List<Integer> attendees;
}
