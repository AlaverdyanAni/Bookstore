package com.example.bookstore.service;

import com.example.bookstore.dto.GenreDto;
import com.example.bookstore.filter.GenreFilter;
import com.example.bookstore.mapper.GenreMapper;
import com.example.bookstore.repository.GenreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private  final GenreMapper genreMapper;
    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    public GenreDto create(GenreDto genreDto) {
        return  null;
    }

    public GenreDto update(long id, GenreDto genreDto) {
        return null;
    }

    public GenreDto delate(long id) {
        return  null;
    }

    public GenreDto get(long id) {
        return null;
    }

    public List<GenreDto> list(GenreFilter genreFilter) {
        return null;
    }
}
