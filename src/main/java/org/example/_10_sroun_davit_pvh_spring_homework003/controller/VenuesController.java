package org.example._10_sroun_davit_pvh_spring_homework003.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.executable.ValidateOnExecution;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.VenuesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.VenuesRespone;
import org.example._10_sroun_davit_pvh_spring_homework003.service.VenuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Validated
@RestController
@RequestMapping("/api/v1/venues")
public class VenuesController {

    private final VenuesService venuesService;

    public VenuesController(VenuesService venuesService) {
        this.venuesService = venuesService;
    }


    @GetMapping()
    public ResponseEntity<VenuesRespone<List<Venues>>> getAllVenues(

            @RequestParam(required = false, defaultValue = "1")
            @Positive(message = "offset should be greater than 0 ") Integer offset,
            @RequestParam(required = false, defaultValue = "10")
            @Positive(message = "limit should be greater than 0 ")  Integer limit){
        return venuesService.getAllVenues(limit,offset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenuesRespone<Venues>> getVenuesById(@PathVariable Integer id){
        return venuesService.getVenuesById(id);}

    @PostMapping()
    public  ResponseEntity<VenuesRespone<Venues>> insertVenues (
            @Valid @RequestBody VenuesRequest venuesRequest){
        return venuesService.insertVenues(venuesRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VenuesRespone<Venues>> deleteVenuesById(@PathVariable Integer id){
        return venuesService.deleteVenuesById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenuesRespone<Venues>> updateVenuesById(
            @PathVariable Integer id,@Valid @RequestBody VenuesRequest VenuesRequest){
        return  venuesService.updateVenuesById(id,VenuesRequest);
    }
}
