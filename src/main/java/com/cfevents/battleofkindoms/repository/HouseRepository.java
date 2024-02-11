package com.cfevents.battleofkindoms.repository;

import com.cfevents.battleofkindoms.entity.House;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HouseRepository extends MongoRepository<House, String> {
    Optional<House> findByHouseName(String houseName);
}
