package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.entity.House;
import com.cfevents.battleofkindoms.repository.HouseRepository;
import com.cfevents.battleofkindoms.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public House getHouseByName(String houseName) {
        Optional<House> optionalHouse = houseRepository.findByHouseName(houseName);
        return optionalHouse.orElse(null); // You may want to handle null differently based on your needs
    }
}
