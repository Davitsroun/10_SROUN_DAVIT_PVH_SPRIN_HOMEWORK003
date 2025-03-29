package org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttendeesRequest {
    @NotNull(message = "AttendeesName cannot be null")
    @Size(min = 3 , max = 20, message = "AttendeesName must between 3 and 20 characters ")
    private  String attendeesName;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be a valid email address")
    private  String email;
}
