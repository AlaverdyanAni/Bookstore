package com.example.bookstore.filter;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class AuthorFilter extends BaseFilter{
    @Size(max = 10)
    private String name;
    @Size(max = 12)
    private  String surname;
    @Past
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
