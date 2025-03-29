package org.example._10_sroun_davit_pvh_spring_homework003.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Venues {
    private  Integer venueID;
    private  String venueName;
    private  String location;
}
