package ru.itpark.service;

import ru.itpark.domain.Book;
import ru.itpark.repository.BookRepository;

public class BookService {
    private BookRepository repository;
    int nextId = 1;

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

            if (name != null) {
                if (!book.getName().contains(name)) {
                    continue;
                }
            }

            if (author != null) {
                if (!book.getAuthor().contains(author)) {
                    continue;
                }
            }

            if (genre != null) {
                if (!book.getGenre().contains(genre)) {
                    continue;
                }
            }

            if (isbn != null) {
                if (!book.getIsbn().contains(isbn))
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