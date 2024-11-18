package org.msc.first_api.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController() {
        this.bookRepository = new InMemoryBookRepository();
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }
}
