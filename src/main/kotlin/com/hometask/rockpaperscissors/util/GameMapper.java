package com.hometask.rockpaperscissors.util;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapi.rockpaperscissors.model.Game;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface GameMapper {
    Game toGameDto(com.hometask.rockpaperscissors.data.Game game);
}
