package com.example.bookstore.filter;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class BookFilter extends BaseFilter{
    @Size(max = 20)
    private String title;
    @Past
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate publicationDate;

    @Positive
    private Integer minPages;
    @Positive
    private Integer axPages;
    @Size(max = 12)
    private String author;
    @Size(max = 12)
    private String genre;

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

    public Integer getMinPages() {
        return minPages;
    }

    public void setMinPages(Integer minPages) {
        this.minPages = minPages;
    }

    public Integer getAxPages() {
        return axPages;
    }

    public void setAxPages(Integer axPages) {
        this.axPages = axPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
