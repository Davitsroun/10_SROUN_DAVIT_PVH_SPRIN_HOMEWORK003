package org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class pagenationRespone {
    @NotNull(message = "offset cannot be null")
    @Size(min =1 , message = "offset cannot be 0 ")
    private Integer offset;
    @NotNull(message = "limit cannot be null")
    @Size(min =1 , message = "limit cannot be 0 ")
    private Integer limit;
}
