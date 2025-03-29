package org.example._10_sroun_davit_pvh_spring_homework003.service;

import jakarta.validation.constraints.Min;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.AttendeesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.AttendeesResponees;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AttendeesService {
    ResponseEntity<AttendeesResponees<List<Attendees>>> getAllAttendees(Integer limit, Integer offset);

    ResponseEntity<AttendeesResponees<Attendees>> getAttendeesById(Integer id);

    ResponseEntity<AttendeesResponees<Attendees>> insertAttendeesById( AttendeesRequest attendeesRequest);

    ResponseEntity<AttendeesResponees<Attendees>> deleteAttendeesById(Integer id);

    ResponseEntity<AttendeesResponees<Attendees>> updateAttendeesById(Integer id, AttendeesRequest attendeesRequest);
}
