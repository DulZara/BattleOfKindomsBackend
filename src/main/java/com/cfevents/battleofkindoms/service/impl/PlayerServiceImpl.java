package com.cfevents.battleofkindoms.service.impl;

import com.cfevents.battleofkindoms.entity.Player;
import com.cfevents.battleofkindoms.repository.PlayerRepository;
import com.cfevents.battleofkindoms.service.PlayerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player deletePlayer(int playerEpf) {
        Player player =playerRepository.findById(playerEpf).get();
        playerRepository.delete(player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerEpf, Player player) {
        Player playerVar =playerRepository.findById(playerEpf).get();
        playerVar.setPlayerName(player.getPlayerName());
        playerVar.setBranchName(player.getBranchName());
        playerVar.setMobNo(player.getMobNo());
        playerRepository.save(playerVar);
        return playerVar;
    }
}
