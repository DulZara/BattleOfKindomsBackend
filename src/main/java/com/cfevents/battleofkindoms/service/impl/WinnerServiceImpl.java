package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.entity.Winner;
import com.cfevents.battleofkindoms.repository.WinnerRepository;
import com.cfevents.battleofkindoms.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WinnerServiceImpl implements WinnerService {

    @Autowired
    private WinnerRepository winnerRepository;

    @Override
    public List<Winner> getWinners() {
        return winnerRepository.findAll();
    }

    @Override
    public Winner addWinner(Winner winner) {
        return winnerRepository.save(winner);
    }
}
