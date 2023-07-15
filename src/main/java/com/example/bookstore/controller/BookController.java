package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDtoIn;
import com.example.bookstore.dto.BookDtoOut;
import com.example.bookstore.filter.BookFilter;
import com.example.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "API для книг", description = "Endpoint для работы с книгами")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation( summary = "Создание книги",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Книга создана успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения")
            }
    )
    @PostMapping
    public ResponseEntity<BookDtoOut> create(@Valid @RequestBody BookDtoIn bookDtoIn){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(bookDtoIn));
    }

    @Operation( summary = "Обновление книги",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Книга обновлена успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения"),
                    @ApiResponse(responseCode = "404", description = "Книга по id не найдена")
            }
    )
    @PutMapping("/{id}")
    public BookDtoOut update(@PathVariable long id, @Valid @RequestBody BookDtoIn bookDtoIn){
        return bookService.update(id, bookDtoIn);
    }

    @Operation( summary = "Удаление книги",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Книга удалёна успешно"),
                    @ApiResponse(responseCode = "404", description = "Книга по id не найдена")
            }
    )
    @DeleteMapping("/{id}")
    public BookDtoOut delete(@PathVariable long id){
        return bookService.delate(id);
    }
    @Operation( summary = "Получениение книги",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Книга получена успешно"),
                    @ApiResponse(responseCode = "404", description = "Книга по id не найдена")
            }
    )
    @GetMapping("/{id}")
    public BookDtoOut get(@PathVariable long id){
        return bookService.get(id);
    }
    @Operation( summary = "Получениение книг по фильтру",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Книги получены успешно"),
                    @ApiResponse(responseCode = "400", description = "Некорректные значения")
            }
    )
    @GetMapping
    public List<BookDtoOut> list(@Valid BookFilter bookFilter){
        return bookService.list(bookFilter);
    }
}

