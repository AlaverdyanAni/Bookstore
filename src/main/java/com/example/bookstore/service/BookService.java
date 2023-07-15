package com.example.bookstore.service;

import com.example.bookstore.dto.BookDtoIn;
import com.example.bookstore.dto.BookDtoOut;
import com.example.bookstore.filter.BookFilter;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookDtoOut create(BookDtoIn bookDtoIn) {
        return null;
    }

    public BookDtoOut update(long id, BookDtoIn bookDtoIn) {
        return null;
    }

    public BookDtoOut delate(long id) {
        return null;
    }

    public BookDtoOut get(long id) {
        return null;
    }

    public List<BookDtoOut> list(BookFilter bookFilter) {
        return null;
    }
}
