package com.example.bookstore.controller;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.dto.GenreDto;
import com.example.bookstore.filter.AuthorFilter;
import com.example.bookstore.filter.GenreFilter;
import com.example.bookstore.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/genres")
@Tag(name = "API для жанров", description = "Endpoint для работы с жанрами")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @Operation( summary = "Создание жанра",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Жанр создан успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения"),
                    @ApiResponse(responseCode = "409", description = "Жанр с таким названием уже был создан")
            }
    )
    @PostMapping
    public ResponseEntity<GenreDto> create(@Valid @RequestBody GenreDto genreDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.create(genreDto));
    }

    @Operation( summary = "Обновление жанра",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Жанр обновлён успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения"),
                    @ApiResponse(responseCode = "404", description = "Жанр по id не найден")
            }
    )
    @PutMapping("/{id}")
    public GenreDto update(@PathVariable long id, @Valid @RequestBody GenreDto genreDto){
        return genreService.update(id, genreDto);
    }

    @Operation( summary = "Удаление жанра",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Жанр удалён успешно"),
                    @ApiResponse(responseCode = "404", description = "Жанр по id не найден")
            }
    )
    @DeleteMapping("/{id}")
    public GenreDto delete(@PathVariable long id){
        return genreService.delate(id);
    }
    @Operation( summary = "Получениение жанра",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Жанр получен успешно"),
                    @ApiResponse(responseCode = "404", description = "Жанр по id не найден")
            }
    )
    @GetMapping("/{id}")
    public GenreDto get(@PathVariable long id){
        return genreService.get(id);
    }
    @Operation( summary = "Получениение жанров по фильтру",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Жанры получены успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения")
            }
    )
    @GetMapping
    public List<GenreDto> list(@Valid GenreFilter genreFilter){
        return genreService.list(genreFilter);
    }
}
