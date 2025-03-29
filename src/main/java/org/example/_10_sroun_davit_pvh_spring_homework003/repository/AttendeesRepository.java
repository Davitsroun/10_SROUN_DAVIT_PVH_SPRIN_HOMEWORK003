package org.example._10_sroun_davit_pvh_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Attendees;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.AttendeesRequest;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.respone.AttendeesResponees;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface AttendeesRepository {

    @Select("""
        SELECT * FROM attendees
        offset #{size} * (#{page} -1)
            limit #{size}
        """)
    @Results(id = "attendess", value = {
            @Result(property = "attendeesId" , column = "attendee_id"),
            @Result(property = "attendeesName" ,column = "attendee_name")
    })
    List<Attendees> getAllAttendees(Integer size, Integer page);


    @Select("""
         SELECT * FROM attendees
         WHERE attendee_id= #{id}
        """)
    @ResultMap("attendess")
    Attendees getAttendeesById(Integer id);


    @Select("""
    INSERT INTO attendees(attendee_name,email)
    VALUES (#{request.attendeesName},#{request.email})
    RETURNING*
    """)
    @ResultMap("attendess")
    Attendees insertAttendeesById(@Param("request") AttendeesRequest attendeesRequest);


    @Select("""
        DELETE FROM attendees
        WHERE attendee_id = #{id}
        """)
    Attendees deleteAttendeesById(Integer id);


    @Select("""
    UPDATE attendees
    SET attendee_name =#{request.attendeesName},
        email = #{request.email}
        WHERE attendee_id = #{id}
    RETURNING*
    """)
    @ResultMap("attendess")
    Attendees updateAttendeesById(Integer id,@Param("request") AttendeesRequest attendeesRequest);

    @Select("""
    SELECT a.* FROM attendees a 
     INNER JOIN event_attendee e ON a.attendee_id = e.attendee_id
    WHERE e.event_id = #{id}
    
    """)
    @ResultMap("attendess")
    List<Attendees> getAttendeesByEventsId(Integer id);

}
