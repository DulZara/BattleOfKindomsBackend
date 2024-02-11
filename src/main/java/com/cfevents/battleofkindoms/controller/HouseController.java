package com.cfevents.battleofkindoms.controller;

import com.cfevents.battleofkindoms.entity.House;
import com.cfevents.battleofkindoms.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/getHouses")
    public List<House> getHouses() {
        return houseService.getHouses();
    }
    @PostMapping("/addHouse")
    public House addHouse(@RequestBody House house) {
        return houseService.addHouse(house);
    }
}
