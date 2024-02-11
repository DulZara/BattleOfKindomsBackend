package com.cfevents.battleofkindoms.service;

import com.cfevents.battleofkindoms.entity.Player;
import org.bson.types.ObjectId;

import java.util.List;

public interface PlayerService {

    public List<Player> getPlayers();

    public Player addPlayer(Player player);

    public Player deletePlayer(int playerEpf);

    public Player updatePlayer(int playerEpf, Player player);
}
