package org.example._10_sroun_davit_pvh_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Venues;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.VenuesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.VenuesRespone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface VenuesRepository {

    @Select("""
            SELECT  * FROM venues
            offset #{size} * (#{page} -1)
            limit #{size}
        """)
    @Results(id="venues", value = {
            @Result(property = "venueID", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venues> getAllVenues(Integer size, Integer page);


    @Select("""
        SELECT * FROM venues WHERE venue_id = #{id}
        """)
    @ResultMap("venues")
    Venues getVenuesById(Integer id);



    @Select("""
    INSERT INTO  venues (venue_name, location)
    VALUES (#{request.venueName} ,#{request.location})
     RETURNING*
    """)
    @ResultMap("venues")
    Venues insertVenues(@Param("request") VenuesRequest venuesRequest);


    @Select("""
        DELETE FROM venues WHERE venue_id = #{id}
    """)
    Venues deleteVenuesById(Integer id);




    @Select("""
        UPDATE  venues 
        SET venue_name=#{request.venueName},
            location=#{request.location}
        WHERE venue_id = #{id}
        RETURNING*
        """)

    @ResultMap("venues")
    Venues updateVenuesById(Integer id, @Param("request") VenuesRequest venuesRequest);
}
