package org.example._10_sroun_davit_pvh_spring_homework003.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Events;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.EventsRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.AttendeesResponees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.EventsRespone;
import org.example._10_sroun_davit_pvh_spring_homework003.service.EventsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }
    @GetMapping()
    public ResponseEntity<EventsRespone<List<Events>>> geetAllEvents
            (  @RequestParam(required = false, defaultValue = "1")
               @Positive(message = "offset should be greater than 0 ") Integer offset,
               @RequestParam(required = false, defaultValue = "10")
               @Positive(message = "limit should be greater than 0 ")  Integer limit){
        return eventsService.geetAllEvents(offset,limit);
    }


    @GetMapping("/{id}")
    public  ResponseEntity<EventsRespone<Events>> getEventsById(@PathVariable Integer id){
        return eventsService.getEventsById(id);
    }

    @PostMapping()
    public   ResponseEntity<EventsRespone<Events>> insertEvent(@Valid @RequestBody EventsRequest eventsRequest){
        return eventsService.insertEvent(eventsRequest);
    }

    @PutMapping("/{id}")
    public   ResponseEntity<EventsRespone<Events>> updateEventById
            (@PathVariable Integer id, @Valid @RequestBody EventsRequest eventsRequest ){
        return eventsService.updateEventById(id, eventsRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventsRespone<Events>> deleteEventById(@PathVariable Integer id){
        return eventsService.deleteEventById(id);
    }
}
