package com.event.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.event.exception.ResourceNotFoundException;
import com.event.event.model.Event;
import com.event.event.repository.EventRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
        
    }
    //create event RestAPI
    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
    
    //create getemployee by id
@GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id){
        Event event=eventRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Event not Exists with id :"+id));
        return ResponseEntity.ok(event);
    }


         //build update event RestAPI
         @PutMapping("/{id}")
        public ResponseEntity<Event> updateEvent(@PathVariable long id,@RequestBody Event eventDetails){
        Event updateEvent =eventRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Event not Exists with id :"+id));
          
        updateEvent.setEventname(eventDetails.getEventname());
        updateEvent.setPrice(eventDetails.getPrice());

         eventRepository.save(updateEvent);
         return ResponseEntity.ok(updateEvent);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable long id){

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not exist with id: " + id));

                eventRepository.delete(event);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
