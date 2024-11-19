package org.msc.first_api.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private final static List<Book> booksDb = new ArrayList<>();

    public InMemoryBookRepository() {
        booksDb.add(new Book("A123", "Título1", "Autor1"));
        booksDb.add(new Book("A124", "Título2", "Autor2"));
        booksDb.add(new Book("A125", "Título3", "Autor3"));
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {

        for (Book book : booksDb){
            if (book.getIsbn().equals(isbn)) return Optional.of(book);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Book> save(Book book) {
        booksDb.add(book);
        return null;
    }

    @Override
    public List<Book> findAll() {
        return Collections.unmodifiableList(booksDb);
    }
}
