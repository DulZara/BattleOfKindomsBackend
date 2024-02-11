package com.cfevents.battleofkindoms.controller;

import com.cfevents.battleofkindoms.entity.Event;
import com.cfevents.battleofkindoms.repository.EventRepository;
import com.cfevents.battleofkindoms.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/getEvents")
    public List<Event> getEvents() {

        return eventService.getEvents() ;
    }

    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event) {

        return eventService.addEvent(event);
    }
}
