package com.example.bookstore.controller;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.filter.AuthorFilter;
import com.example.bookstore.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
@Tag(name = "API для авторов", description = "Endpoint для работы с авторами")
public class AuthorController {
    private  final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @Operation( summary = "Создание автора",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Автор создан успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения")
            }
    )
    @PostMapping
    public ResponseEntity<AuthorDto> create(@Valid @RequestBody AuthorDto authorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(authorDto));
    }

    @Operation( summary = "Обновление автора",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Автор обновлён успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения"),
                    @ApiResponse(responseCode = "404", description = "Автор по id не найден")
            }
    )
    @PutMapping("/{id}")
    public AuthorDto update(@PathVariable long id, @Valid @RequestBody AuthorDto authorDto){
        return authorService.update(id, authorDto);
    }

    @Operation( summary = "Удаление автора",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Автор удалён успешно"),
                    @ApiResponse(responseCode = "404", description = "Автор по id не найден")
            }
    )
    @DeleteMapping("/{id}")
    public AuthorDto delete(@PathVariable long id){
        return authorService.delate(id);
    }
    @Operation( summary = "Получениение автора",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Автор получен успешно"),
                    @ApiResponse(responseCode = "404", description = "Автор по id не найден")
            }
    )
    @GetMapping("/{id}")
    public AuthorDto get(@PathVariable long id){
        return authorService.get(id);
    }
    @Operation( summary = "Получениение авторов по фильтру",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Авторы получены успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения")
            }
    )
    @GetMapping
    public List<AuthorDto> list(@Valid AuthorFilter authorFilter){
        return authorService.list(authorFilter);
    }
}
