package com.example.bookstore.mapper;

import com.example.bookstore.dto.BookDtoIn;
import com.example.bookstore.dto.BookDtoOut;
import com.example.bookstore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {AuthorMapper.class, GenreMapper.class})
public interface BookMapper {
    BookDtoOut toBook(Book book);
    Book toEntity(BookDtoIn bookDtoIn);
}
