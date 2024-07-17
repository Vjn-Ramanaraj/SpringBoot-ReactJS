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
 //import org.springframework.web.bind.annotation.RequestParam;
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
        updateEvent.setDescription(eventDetails.getDescription());
        updateEvent.setDate(eventDetails.getDate());
        updateEvent.setLocation(eventDetails.getLocation());
        updateEvent.setAttendees(eventDetails.getAttendees());


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

      // Filter events by price range
  // @GetMapping("/filter")
  // public List<Event> getEventsByPriceRange(
  //         @RequestParam(required = false) Integer minPrice,
  //         @RequestParam(required = false) Integer maxPrice) {

  //   if (minPrice == null && maxPrice == null) {
  //     // If both minPrice and maxPrice are not provided, return all events
  //     return eventRepository.findAll();
  //   } else if (minPrice == null) {
  //     // If only maxPrice is provided, filter events with price less than or equal to maxPrice
  //     return eventRepository.findByPriceLessThanEqual(maxPrice);
  //   } else if (maxPrice == null) {
  //     // If only minPrice is provided, filter events with price greater than or equal to minPrice
  //     return eventRepository.findByPriceGreaterThanEqual(minPrice);
  //   } else {
  //     // If both minPrice and maxPrice are provided, filter events within the specified price range
  //     return eventRepository.findByPriceBetween(minPrice, maxPrice);
  //   }
  // }

}
