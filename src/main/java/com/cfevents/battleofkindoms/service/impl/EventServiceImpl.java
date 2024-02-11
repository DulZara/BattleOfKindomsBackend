package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.entity.Event;
import com.cfevents.battleofkindoms.repository.EventRepository;
import com.cfevents.battleofkindoms.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

//    @Override
//    public Event deleteEvent(int eventId) {
//        return null;
//    }
//
//    @Override
//    public Event updateEvent(int eventId, Event event) {
//        return null;
//    }
}
