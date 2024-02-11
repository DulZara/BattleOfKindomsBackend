package com.cfevents.battleofkindoms.service;

import com.cfevents.battleofkindoms.entity.House;


import java.util.List;
import java.util.Optional;

public interface HouseService {

    public List<House> getHouses();

    public House addHouse(House house);

    House getHouseByName(String houseName);

}
