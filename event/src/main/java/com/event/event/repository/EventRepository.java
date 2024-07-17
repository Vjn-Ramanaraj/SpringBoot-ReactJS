package com.event.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.event.model.Event;

// import java.util.List;


public interface EventRepository extends JpaRepository<Event ,Long>{

    //All crud operations

    // List<Event> findByPriceLessThanEqual(Integer maxPrice);
    // List<Event> findByPriceGreaterThanEqual(Integer minPrice);
    // List<Event> findByPriceBetween(Integer minPrice, Integer maxPrice);
}
