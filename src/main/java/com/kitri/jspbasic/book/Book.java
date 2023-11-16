package com.kitri.jspbasic.book;

import java.time.LocalDate;

public class Book {
    private Long id;
    private String name;
    private String author;
    private LocalDate publishedDate;

    public Book() {
    }

    public Book(String name, String author, LocalDate publishedDate) {
        this.name = name;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
