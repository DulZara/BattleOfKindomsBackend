package com.cfevents.battleofkindoms.repository;

import com.cfevents.battleofkindoms.entity.Winner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WinnerRepository extends MongoRepository<Winner, Integer> {
}
