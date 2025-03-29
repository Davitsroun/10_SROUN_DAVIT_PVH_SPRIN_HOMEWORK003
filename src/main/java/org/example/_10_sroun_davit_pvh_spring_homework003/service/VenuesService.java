package org.example._10_sroun_davit_pvh_spring_homework003.service;

import jakarta.validation.Valid;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.VenuesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.VenuesRespone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VenuesService {
    ResponseEntity<VenuesRespone<List<Venues>>> getAllVenues(Integer size, Integer page);

    ResponseEntity<VenuesRespone<Venues>> getVenuesById(Integer id);

    ResponseEntity<VenuesRespone<Venues>> insertVenues(@Valid VenuesRequest venuesRequest);

    ResponseEntity<VenuesRespone<Venues>> deleteVenuesById(Integer id);

    ResponseEntity<VenuesRespone<Venues>> updateVenuesById(Integer id, @Valid VenuesRequest venuesRequest);
}
