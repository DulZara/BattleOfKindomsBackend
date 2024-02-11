package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.DTO.WinnerDTO;
import com.cfevents.battleofkindoms.entity.Winner;
import com.cfevents.battleofkindoms.repository.WinnerRepository;
import com.cfevents.battleofkindoms.service.EventService;
import com.cfevents.battleofkindoms.service.GroupEventService;
import com.cfevents.battleofkindoms.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WinnerServiceImpl implements WinnerService {

    @Autowired
    private WinnerRepository winnerRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private GroupEventService groupEventService;


    @Override
    public List<Winner> getWinners() {
        return winnerRepository.findAll();
    }

    @Override
    public Winner addWinner(Winner winner) {
        return winnerRepository.save(winner);
    }

    @Override
    public List<WinnerDTO> getAllWinners() {
        List<Winner> winners = winnerRepository.findAll();

        return winners.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private WinnerDTO convertToDTO(Winner winner) {
        // Convert Winner entity to WinnerDTO
        // You can fetch event details and group details here if needed
        WinnerDTO winnerDTO = new WinnerDTO();
        winnerDTO.setEventId(winner.getEventId());
        // Set other properties...

        return winnerDTO;
    }

}
