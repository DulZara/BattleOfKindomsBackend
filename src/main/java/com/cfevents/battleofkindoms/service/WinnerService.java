package com.cfevents.battleofkindoms.service;


import com.cfevents.battleofkindoms.DTO.WinnerDTO;
import com.cfevents.battleofkindoms.entity.Winner;

import java.util.List;

public interface WinnerService {
    public List<Winner> getWinners();

    public Winner addWinner(Winner winner);
    List<WinnerDTO> getAllWinners();
}
