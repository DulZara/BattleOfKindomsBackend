package com.cfevents.battleofkindoms.controller;

import com.cfevents.battleofkindoms.entity.House;
import com.cfevents.battleofkindoms.entity.Player;
import com.cfevents.battleofkindoms.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("updateHouse/{houseName}")
    public ResponseEntity<House> updateHouse(@PathVariable String houseName, @RequestBody House updatedHouse) {
        House updated = houseService.updateHouse(houseName, updatedHouse);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            // Handle case when the house with the given name doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{houseName}")
    public ResponseEntity<House> getHouseByNames(@PathVariable String houseName) {
        Optional<House> houseOptional = houseService.getHouseByNames(houseName);

        return houseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
