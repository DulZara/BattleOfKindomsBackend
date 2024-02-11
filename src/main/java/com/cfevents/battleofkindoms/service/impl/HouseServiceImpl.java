package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.entity.House;
import com.cfevents.battleofkindoms.repository.HouseRepository;
import com.cfevents.battleofkindoms.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public List<House> getHouses() {

        return houseRepository.findAll();
    }

    @Override
    public House addHouse(House house) {

        return houseRepository.save(house);
    }
}
