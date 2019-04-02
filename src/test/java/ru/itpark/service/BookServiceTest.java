package ru.itpark.service;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.Book;
import ru.itpark.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    public void create(){
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        service.create("", "", "", "");
        service.create("", "", "", "");

        Book[] books = repository.getAll();

        assertNotEquals(0, books[0].getId());
        assertNotEquals(0, books[1].getId());
        assertNotEquals(books[0].getId(), books[1].getId());
    }

    @Test
    public void searchByName() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        service.create("War and peace".toLowerCase(), "", "", "");
        service.create("Peace and War".toLowerCase(), "", "", "");
        service.create("Time".toLowerCase(), "", "", "");

        Book[] books = service.search("war".toLowerCase(), null, null, null);

        assertEquals ("War and peace".toLowerCase(), books[0].getName());
        assertEquals ("Peace and War".toLowerCase(), books[1].getName());
    }

    @Test
    public void searchByAuthor() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        service.create("", "Stephen king".toLowerCase(), "", "");
        service.create("", "Patrick KING".toLowerCase(), "", "");
        service.create("", "William Shakespeare".toLowerCase(), "", "");

        Book[] books = service.search(null, "king", null, null);

        assertEquals("Stephen king".toLowerCase(), books[0].getAuthor());
        assertEquals("Patrick KING".toLowerCase(), books[1].getAuthor());
    }

    @Test
    public void searchByGenre(){
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        service.create("","","Novel, Adventure".toLowerCase(), "");
        service.create("","","adVenture".toLowerCase(),"");
        service.create("","","fantasy".toLowerCase(),"");

        Book[] books = service.search(null, null, "adventure", null);

        assertEquals("Novel, Adventure".toLowerCase(), books[0].getGenre());
        assertEquals("adVenture".toLowerCase(), books[1].getGenre());
    }

    @Test
    public void searchByIsbn() {
        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);

        service.create("","","","9785171059668");
        service.create("","","","9785171059667");

        Book[] books = service.search(null, null, null, "9785171059668");

        assertEquals("9785171059668", books[0].getIsbn());
    }
}