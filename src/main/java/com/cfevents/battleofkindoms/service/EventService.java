package com.cfevents.battleofkindoms.service;

import com.cfevents.battleofkindoms.entity.Event;


import java.util.List;

public interface EventService {
    public List<Event> getEvents();

    public Event addEvent(Event event);

    Event getEventById(Integer eventId);

//    public Event deleteEvent(int eventId);
//
//    public Event updateEvent(int eventId, Event event);
}
