package com.hometask.rockpaperscissors.service;

import com.hometask.rockpaperscissors.data.Game;
import com.hometask.rockpaperscissors.exception.GameIsCompleted;
import com.hometask.rockpaperscissors.repository.GameRepository;
import com.hometask.rockpaperscissors.util.GameMapper;
import lombok.AllArgsConstructor;
import org.openapi.rockpaperscissors.model.Item;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    @Override
    public org.openapi.rockpaperscissors.model.Game startNewGame() {
        return gameMapper.toGameDto(gameRepository.save(new Game()));
    }

    @Override
    public org.openapi.rockpaperscissors.model.Game findGameById(long gameId) {
        return gameMapper.toGameDto(getGame(gameId));
    }

    @Override
    @Transactional
    public Item play(long gameId, Item item) {
        Game game = getGame(gameId);
        if (game.isCompleted()) {
            throw new GameIsCompleted("Game with id " + gameId + " is completed");
        }
    }

    private Game getGame(long gameId) {
        return gameRepository.findById(gameId).orElseThrow(
                () -> new EntityNotFoundException("Game with id " + gameId + " not found"));
    }

}