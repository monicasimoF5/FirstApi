package org.msc.first_api.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final static List<Book> booksDb = new ArrayList<>();

    public BookController() {
        booksDb.add(new Book("A123", "Título1", "Autor1"));
        booksDb.add(new Book("A124", "Título2", "Autor2"));
        booksDb.add(new Book("A125", "Título3", "Autor3"));
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return booksDb;
    }
}
