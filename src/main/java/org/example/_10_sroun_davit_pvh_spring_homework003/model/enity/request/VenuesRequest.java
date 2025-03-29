package org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class VenuesRequest {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3 , max = 20, message = "Username must between 3 and 20 characters ")
    private  String venueName;
    @NotNull(message = "location cannot be null")
    private  String location;

}
