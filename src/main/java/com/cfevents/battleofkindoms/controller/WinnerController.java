package com.cfevents.battleofkindoms.controller;

import com.cfevents.battleofkindoms.DTO.WinnerDTO;
import com.cfevents.battleofkindoms.entity.Winner;
import com.cfevents.battleofkindoms.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/winners")
public class WinnerController {

    @Autowired
    private WinnerService winnerService;

    @GetMapping("/getWinners")
    public List<Winner> getWinners() {
        return winnerService.getWinners();
    }

    @PostMapping("/addWinner")
    public Winner addWinner(@RequestBody Winner winner) {
        return winnerService.addWinner(winner);
    }
    @GetMapping("/getAllWinners")
    public List<WinnerDTO> getAllWinners() {
        return winnerService.getAllWinners();
    }
}
