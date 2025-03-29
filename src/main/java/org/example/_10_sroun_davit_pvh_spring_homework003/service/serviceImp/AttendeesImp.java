package org.example._10_sroun_davit_pvh_spring_homework003.service.serviceImp;

import org.example._10_sroun_davit_pvh_spring_homework003.exception.NotFoundException;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.AttendeesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.AttendeesResponees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.VenuesRespone;
import org.example._10_sroun_davit_pvh_spring_homework003.repository.AttendeesRepository;
import org.example._10_sroun_davit_pvh_spring_homework003.service.AttendeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendeesImp implements AttendeesService {
    private final AttendeesRepository attendeesRepository;

    public AttendeesImp(AttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    @Override
    public ResponseEntity<AttendeesResponees<List<Attendees>>> getAllAttendees(Integer limit, Integer offset) {
        AttendeesResponees venuesRespone= AttendeesResponees.<List<Attendees>>builder()
                .message("All attendees has been successfully fecthed.")
                .payload(attendeesRepository.getAllAttendees(limit,offset))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }

    @Override
    public ResponseEntity<AttendeesResponees<Attendees>> getAttendeesById(Integer id) {
        if (attendeesRepository.getAttendeesById(id) == null){
            throw new NotFoundException("The attendees id:"+id+ " does not exist.");
        }
        AttendeesResponees venuesRespone= AttendeesResponees.<Attendees>builder()
                .message("All attendees has been successfully fecthed.")
                .payload(attendeesRepository.getAttendeesById(id))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }

    @Override
    public ResponseEntity<AttendeesResponees<Attendees>> insertAttendeesById( AttendeesRequest attendeesRequest) {
        AttendeesResponees venuesRespone= AttendeesResponees.<Attendees>builder()
                .message("Insert attendees successfully fecthed.")
                .payload(attendeesRepository.insertAttendeesById(attendeesRequest))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }

    @Override
    public ResponseEntity<AttendeesResponees<Attendees>> deleteAttendeesById(Integer id) {
        Attendees attendees = attendeesRepository.getAttendeesById(id) ;
        if(attendees== null){
            throw new NotFoundException("The attendees id:"+id+ " does not exist.");
        } else {
            System.out.println(attendees.getAttendeesId());

            AttendeesResponees attendeesResponees = AttendeesResponees.<Attendees>builder()
                    .message("Delete Attendees by id successfully.")
                    .status("OK")
                    .payload(attendeesRepository.deleteAttendeesById(id))
                    .localDateTime(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(201).body(attendeesResponees);
        }
    }

    @Override
    public ResponseEntity<AttendeesResponees<Attendees>> updateAttendeesById(Integer id, AttendeesRequest attendeesRequest) {
        AttendeesResponees attendeesResponees = AttendeesResponees.<Attendees>builder()
                .message("update Attendees by id successfully.")
                .status("OK")
                .payload(attendeesRepository.updateAttendeesById(id,attendeesRequest))
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(attendeesResponees);
    }
}
