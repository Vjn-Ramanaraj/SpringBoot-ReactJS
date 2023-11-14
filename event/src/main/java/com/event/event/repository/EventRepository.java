package com.event.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.event.model.Event;



public interface EventRepository extends JpaRepository<Event ,Long>{

    //All crud operations
}
