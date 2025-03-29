package org.example._10_sroun_davit_pvh_spring_homework003.service.serviceImp;

import org.example._10_sroun_davit_pvh_spring_homework003.exception.NotFoundException;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.VenuesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.VenuesRespone;
import org.example._10_sroun_davit_pvh_spring_homework003.repository.VenuesRepository;
import org.example._10_sroun_davit_pvh_spring_homework003.service.VenuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VenuesImp implements VenuesService {


    private final VenuesRepository venuesRepository;

    public VenuesImp(VenuesRepository venuesRepository) {
        this.venuesRepository = venuesRepository;
    }
    @Override
    public ResponseEntity<VenuesRespone<List<Venues>>> getAllVenues( Integer offset, Integer limit){

        VenuesRespone venuesRespone= VenuesRespone.<List<Venues>>builder()
                .message("The venues has been successfully founded.")
                .payload(venuesRepository.getAllVenues(offset,limit))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }

    @Override
    public ResponseEntity<VenuesRespone<Venues>> getVenuesById(Integer id) {
        if (venuesRepository.getVenuesById(id) == null){
            throw new  NotFoundException("The venues id:"+id+ " does not exist.");
        }
        VenuesRespone venuesRespone= VenuesRespone.<Venues>builder()
                .message("The attendee by id:"+id+" founded.")
                .payload(venuesRepository.getVenuesById(id))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }

    @Override
    public ResponseEntity<VenuesRespone<Venues>> insertVenues(VenuesRequest venuesRequest) {
        VenuesRespone venuesRespone= VenuesRespone.<Venues>builder()
                .message("The venues has been add successfully.")
                .payload(venuesRepository.insertVenues(venuesRequest))
                .status("OK")
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }

    @Override
    public ResponseEntity<VenuesRespone<Venues>> deleteVenuesById(Integer id) {
        Venues venues = venuesRepository.getVenuesById(id) ;
        if(venues== null){
            throw new NotFoundException("The venues id:"+id+ " does not exist.");
        } else {
            System.out.println(venues.getVenueID());

            VenuesRespone venuesRespone= VenuesRespone.<Venues>builder()
                    .message("Delete Venues by id successfully.")
                    .status("OK")
                    .payload(venuesRepository.deleteVenuesById(id))
                    .localDateTime(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(201).body(venuesRespone);
        }


    }

    @Override
    public ResponseEntity<VenuesRespone<Venues>> updateVenuesById(Integer id, VenuesRequest venuesRequest) {
        VenuesRespone venuesRespone= VenuesRespone.<Venues>builder()
                .message("Delete Venues by id successfully.")
                .status("OK")
                .payload(venuesRepository.updateVenuesById(id,venuesRequest))
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(201).body(venuesRespone);
    }
}
