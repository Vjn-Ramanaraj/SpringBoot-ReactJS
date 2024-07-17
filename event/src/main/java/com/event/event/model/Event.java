package com.event.event.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="events")
public class Event {

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)

    private long id;
    @Column(name="event_name")
    private String Eventname;
    @Column(name = "event_description")
    private String Description;
    @Column(name="event_date")
    private String Date;
    @Column(name="event_location")
    private String Location;
    @Column(name="event_attendees")
    private String Attendees;
    
    
}
