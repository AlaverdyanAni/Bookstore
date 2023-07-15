package com.example.bookstore.mapper;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDto toDto(User user);
    ;
}

