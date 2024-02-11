package com.cfevents.battleofkindoms.repository;

import com.cfevents.battleofkindoms.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event,Integer> {
}
