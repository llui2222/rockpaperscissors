package com.hometask.rockpaperscissors.service;

import org.openapi.rockpaperscissors.model.Game;
import org.openapi.rockpaperscissors.model.Item;
import org.springframework.http.ResponseEntity;

public interface GameService{
    Game startNewGame();
    Game findGameById(long gameId);

    Item play(long gameId, Item item);
}