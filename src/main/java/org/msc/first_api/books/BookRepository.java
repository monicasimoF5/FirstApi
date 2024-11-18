package org.msc.first_api.books;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

}