package com.hometask.rockpaperscissors.controller;

import com.hometask.rockpaperscissors.service.GameService;
import lombok.AllArgsConstructor;
import org.openapi.rockpaperscissors.api.V1Api;
import org.openapi.rockpaperscissors.model.Game;
import org.openapi.rockpaperscissors.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GameController implements V1Api {

    private final GameService gameService;

    @Override
    public ResponseEntity<Game> startNewGame() {
        return ResponseEntity.ok(gameService.startNewGame());
    }

    @Override
    public ResponseEntity<Item> play(Integer gameId, Item item) {
        return ResponseEntity.ok(gameService.play(gameId, item));
    }
}