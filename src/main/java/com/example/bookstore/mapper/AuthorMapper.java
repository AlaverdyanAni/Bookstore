package com.example.bookstore.mapper;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {
    AuthorDto toDto(Author author);
    @Mapping(target = "id", ignore = true)
    Author toEntity(AuthorDto authorDto);
}
