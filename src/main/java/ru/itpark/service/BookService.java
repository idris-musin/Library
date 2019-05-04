package ru.itpark.service;

import ru.itpark.domain.Book;
import ru.itpark.repository.BookRepository;

public class BookService {
    private BookRepository repository;
    private int nextId = 1;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void create(String name, String author, String genre, String isbn) {
        Book book = new Book(nextId, name, author, genre, isbn);
        repository.add(book);
        nextId++;
    }

    public Book[] search(String name, String author, String genre, String isbn) {
        Book[] result = new Book[10];
        int resultIndex = 0;

        Book[] books = repository.getAll();
        for (Book book : books) {
            if (book == null) {
                continue;
            }

            if (name != null && !book.getName().contains(name)) {
                continue;
            }

            if (author != null && !book.getAuthor().contains(author)) {
                continue;
            }

            if (genre != null && !book.getGenre().contains(genre)) {
                continue;
            }

            if (isbn != null && !book.getIsbn().contains(isbn)) {
                continue;
            }

            if (resultIndex == result.length) {
                break;
            }

            result[resultIndex] = book;
            resultIndex++;
        }

        return result;
    }
}