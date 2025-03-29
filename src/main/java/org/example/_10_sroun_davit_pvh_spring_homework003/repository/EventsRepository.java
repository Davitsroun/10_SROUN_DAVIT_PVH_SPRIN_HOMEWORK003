package org.example._10_sroun_davit_pvh_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._10_sroun_davit_pvh_spring_homework003.model.dto.Events;
import org.example._10_sroun_davit_pvh_spring_homework003.model.enity.request.EventsRequest;

import java.util.List;

@Mapper
public interface EventsRepository {

    @Select("""
        SELECT * FROM  events
        offset #{size} * (#{page} -1)
            limit #{size}
        """)
    @Results(id="event" ,value = {
            @Result(property = "eventId" , column = "event_id"),
            @Result( property = "eventName", column = "event_name"),
            @Result(property = "localDateTime", column = "event_date"),
            @Result(property = "venues", column = "venue_id",
            one = @One(select ="org.example._10_sroun_davit_pvh_spring_homework003.repository.VenuesRepository.getVenuesById")),
            @Result(property = "attendees", column = "event_id" ,
            many = @Many(select = "org.example._10_sroun_davit_pvh_spring_homework003.repository.AttendeesRepository.getAttendeesByEventsId"))
    })
    List<Events> geetAllEvents(Integer size, Integer page);


    @Select("""
    SELECT * FROM events
    WHERE event_id = #{id}
    """)
    @ResultMap("event")
    Events getEventsById(Integer id);



    @Select("""
    INSERT INTO events(event_name,event_date,venue_id)
    VALUES (#{request.eventName},#{request.localDateTime},#{request.venues})
    RETURNING*
    """)
    @ResultMap("event")
    Events insertEvent(@Param("request") EventsRequest eventsRequest);

    @Select("""
        INSERT INTO event_attendee(event_id,attendee_id)
        VALUES (#{eventId} ,#{attendeeid})
        """)
    Events insertEventAttendee(  Integer eventId,Integer attendeeid);


    @Select("""
            UPDATE events
            SET event_name = #{request.eventName},
                event_date =#{request.localDateTime},
                venue_id = #{request.venues} 
                WHERE event_id =#{id}
            
        """)
    Events updateEventById(Integer id,@Param("request") EventsRequest eventsRequest);

    @Select("""
        DELETE  FROM event_attendee
        WHERE  event_id =#{id}
        """)
    void  deleteEventAtendee(Integer id);


    @Select("""
        DELETE FROM events 
               WHERE  event_id = #{id}
                               
        """)

    void deleteEventById(Integer id);
}
