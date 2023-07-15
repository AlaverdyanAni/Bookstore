package com.example.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.Set;

public class BookDtoIn {
    @Schema(name = "title", description = "Название книги", maxLength = 20, example = "Сказка о царе Салтане")
    @NotBlank
    @Size(max = 20)
    private String title;
    @Schema(name = "publicationDate", description = "Дата публикации", pattern = "dd.mm.yyyy", example = "26.05.1832")
    @NotNull
    @Past
    @JsonFormat(pattern = "dd.mm.yyyy")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate publicationDate;
    @Schema(name = "pages", description = "Количество страниц", minimum = "1", example = "123")
    @NotBlank
    @Positive
    private int pages;
    @Schema(name = "authorId", description = "Id автора книги", minimum = "1", example = "1")
    @NotBlank
    @Positive
    private long authorId;
    @Schema(name = "genres", description = "Id жанров книги",example = "[1,2]")
    @NotEmpty
    private Set<@Positive Long> genreIds;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Set<Long> getGenresId() {
        return genreIds;
    }

    public void setGenresId(Set<Long> genresId) {
        this.genreIds = genreIds;
    }
}
