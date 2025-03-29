package org.example._10_sroun_davit_pvh_spring_homework003.controller;

import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.AttendeesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.AttendeesResponees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.VenuesRespone;
import org.example._10_sroun_davit_pvh_spring_homework003.service.AttendeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/attendees")
public class AttendesController {
    private final AttendeesService attendeesService;

    public AttendesController(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @GetMapping()
    public ResponseEntity<AttendeesResponees<List<Attendees>>> getAllAttendees
            ( @RequestParam(required = false, defaultValue = "1")
              @Positive(message = "offset should be greater than 0 ") Integer offset,
              @RequestParam(required = false, defaultValue = "10")
              @Positive(message = "limit should be greater than 0 ")  Integer limit){
        return attendeesService.getAllAttendees( limit, offset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendeesResponees<Attendees>> getAttendeesById
            (@PathVariable Integer id){
        return attendeesService.getAttendeesById(id);
    }



    @PostMapping()
    public  ResponseEntity<AttendeesResponees<Attendees>> insertAttendeesById
            (@Valid @RequestBody AttendeesRequest attendeesRequest){

        return attendeesService.insertAttendeesById(attendeesRequest);
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<AttendeesResponees<Attendees>> deleteAttendeesById
            (@PathVariable Integer id){
        return  attendeesService.deleteAttendeesById(id);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<AttendeesResponees<Attendees>> updateAttendeesById
            (@PathVariable Integer id ,@Valid @RequestBody AttendeesRequest attendeesRequest){
        return  attendeesService.updateAttendeesById(id,attendeesRequest);
    }
}
