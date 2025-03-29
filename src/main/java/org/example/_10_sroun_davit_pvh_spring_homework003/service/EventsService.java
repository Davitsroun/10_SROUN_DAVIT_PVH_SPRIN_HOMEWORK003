package org.example._10_sroun_davit_pvh_spring_homework003.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Events;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.EventsRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.EventsRespone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventsService {
    ResponseEntity<EventsRespone<List<Events>>> geetAllEvents( Integer limit,Integer offset);

    ResponseEntity<EventsRespone<Events>> getEventsById(Integer id);

    ResponseEntity<EventsRespone<Events>> insertEvent(@Valid EventsRequest eventsRequest);

    ResponseEntity<EventsRespone<Events>> updateEventById(Integer id, @Valid EventsRequest eventsRequest);

    ResponseEntity<EventsRespone<Events>> deleteEventById(Integer id);
}
