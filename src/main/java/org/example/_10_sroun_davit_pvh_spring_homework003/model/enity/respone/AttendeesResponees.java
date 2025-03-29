package org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendeesResponees <T>{
    private String message;
    private T payload;
    private String status;
    private LocalDateTime localDateTime;

}
