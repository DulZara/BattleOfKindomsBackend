package com.cfevents.battleofkindoms.repository;

import com.cfevents.battleofkindoms.entity.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Integer> {
}
