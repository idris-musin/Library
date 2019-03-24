package ru.itpark.domain;

public class Book {
    private int id;
    private String name;
    private String author;
    private String genre;
    private long isbn;

    public Book(int id, String name, String author, String genre, long isbn) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
}
