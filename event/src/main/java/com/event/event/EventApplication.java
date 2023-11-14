package com.event.event;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.event.event.model.Event;
import com.event.event.repository.EventRepository;

@SpringBootApplication
public class EventApplication implements CommandLineRunner {

    public EventApplication(EventRepository eventRepository) {
    }

    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Event event = new Event();
        // event.setEventname("Ramesh");
        // event.setPrice(10);
        // eventRepository.save(event);

		// Event event1 = new Event();
        // event1.setEventname("Rajubhai");
        // event1.setPrice(30);
        // eventRepository.save(event1);
    }
}


