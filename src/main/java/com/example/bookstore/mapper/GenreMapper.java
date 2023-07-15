package com.example.bookstore.mapper;

import com.example.bookstore.dto.GenreDto;
import com.example.bookstore.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {
    GenreDto toDto(Genre genre);
    @Mapping(target = "id", ignore = true)
    Genre  toEntity(GenreDto genreDto);

}
