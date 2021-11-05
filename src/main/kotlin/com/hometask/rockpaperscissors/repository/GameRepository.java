package com.hometask.rockpaperscissors.repository;

import com.hometask.rockpaperscissors.data.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long>{

}
