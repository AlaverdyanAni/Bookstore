package com.example.bookstore.service;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.filter.AuthorFilter;
import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private  final AuthorMapper authorMapper;
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorDto create(AuthorDto authorDto){
        return null;
    }


    public AuthorDto update(long id, AuthorDto authorDto) {
        return null;
    }

    public AuthorDto delate(long id) {
        return null;
    }

    public AuthorDto get(long id) {
        return null;
    }

    public List<AuthorDto> list(AuthorFilter authorFilter) {
        return null;
    }
}
