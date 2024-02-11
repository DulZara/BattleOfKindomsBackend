package com.cfevents.battleofkindoms.controller;


import com.cfevents.battleofkindoms.entity.Player;
import com.cfevents.battleofkindoms.service.PlayerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/getPlayers")
    public List<Player> getPlayer() {
        return playerService.getPlayers();
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }
    @PutMapping("/updateplayer/{playerEpf}")
    public Player updatePlayer(@RequestParam int playerEpf, @RequestBody Player player){
        return playerService.updatePlayer(playerEpf,player);
    }
    @DeleteMapping("/deletePlayer/{playerEpf}")
    public Player deletePlayer(@RequestParam int playerEpf){
        return playerService.deletePlayer(playerEpf);
    }

}
