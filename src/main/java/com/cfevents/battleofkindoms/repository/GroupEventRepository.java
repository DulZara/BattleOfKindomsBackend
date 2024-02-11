package com.cfevents.battleofkindoms.repository;

import com.cfevents.battleofkindoms.entity.GroupEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupEventRepository extends MongoRepository<GroupEvent, Integer> {
}
