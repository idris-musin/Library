package ru.itpark.repository;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    @Test
    public void addOneBook() {
        BookRepository repository = new BookRepository();
        Book book = new Book(1, "", "", "", null);

        repository.add(book);

        Book[] books = repository.getAll();

        assertEquals(book, books[0]);
    }

    @Test
    public void addTwoBook() {
        BookRepository repository = new BookRepository();
        Book first = new Book(1, "", "", "", null);
        Book second = new Book(2, "", "", "", null);

        repository.add(first);
        repository.add(second);

        Book[] books = repository.getAll();

        assertEquals(first, books[0]);
        assertEquals(second, books[1]);
    }
}