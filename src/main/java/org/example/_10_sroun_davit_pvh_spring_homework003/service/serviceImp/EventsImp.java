package org.example._10_sroun_davit_pvh_spring_homework003.service.serviceImp;

import org.example._10_sroun_davit_pvh_spring_homework003.exception.NotFoundException;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Events;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.EventsRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.AttendeesResponees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.EventsRespone;
import org.example._10_sroun_davit_pvh_spring_homework003.repository.EventsRepository;
import org.example._10_sroun_davit_pvh_spring_homework003.service.EventsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventsImp implements EventsService {

    private final EventsRepository eventsRepository;

    public EventsImp(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public ResponseEntity<EventsRespone<List<Events>>> geetAllEvents(Integer limit, Integer offset) {
        EventsRespone eventsRespone= EventsRespone.<List<Events>>builder()
                .message("All Events has been successfully fecthed.")
                .payload(eventsRepository.geetAllEvents(offset,limit))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(eventsRespone);
    }

    @Override
    public ResponseEntity<EventsRespone<Events>> getEventsById(Integer id) {
        if (eventsRepository.getEventsById(id)== null){
            throw new NotFoundException("Events id:"+id+" not founded");
        }
        EventsRespone eventsRespone= EventsRespone.<Events>builder()
                .message(" Events id:"+id+" has been successfully fecthed.")
                .payload(eventsRepository.getEventsById(id))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(eventsRespone);
    }

    @Override
    public ResponseEntity<EventsRespone<Events>> insertEvent(EventsRequest eventsRequest) {
        Events events= eventsRepository.insertEvent(eventsRequest);
        for (Integer e: eventsRequest.getAttendees()){
            eventsRepository.insertEventAttendee(events.getEventId(), e);
        }
        EventsRespone eventsRespone= EventsRespone.<Events>builder()
                .message(" Events insert successfully fecthed.")
               .payload(eventsRepository.getEventsById(events.getEventId()))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(eventsRespone);
    }

    @Override
    public ResponseEntity<EventsRespone<Events>> updateEventById(Integer id, EventsRequest eventsRequest) {

        if (eventsRepository.getEventsById(id) == null){
            throw new NotFoundException("Events id:"+id+" not founded");
        }

        eventsRepository.deleteEventAtendee(id);
       eventsRepository.updateEventById(id,eventsRequest);
       Events events= eventsRepository.getEventsById(id);
        for (Integer e: eventsRequest.getAttendees()){
            eventsRepository.insertEventAttendee(events.getEventId(), e);
        }

        eventsRepository.updateEventById(id,eventsRequest);
        EventsRespone eventsRespone= EventsRespone.<Events>builder()
                .message(" Events insert successfully fecthed.")
                .payload(eventsRepository.getEventsById(events.getEventId()))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(eventsRespone);
    }

    @Override
    public ResponseEntity<EventsRespone<Events>> deleteEventById(Integer id) {
        if (eventsRepository.getEventsById(id) == null){
            throw new NotFoundException("Events id:"+id+" not founded");
        }
        eventsRepository.deleteEventById(id);

        EventsRespone eventsRespone= EventsRespone.<Events>builder()
                .message(" Events insert successfully fecthed.")
                .payload(eventsRepository.getEventsById(id))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(eventsRespone);
    }


}
