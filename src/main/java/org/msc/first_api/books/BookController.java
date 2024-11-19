package org.msc.first_api.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController() {
        this.bookRepository = new InMemoryBookRepository();
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findByIsbn(book.getIsbn());

        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Book> deleteIsbn(@PathVariable String isbn){
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if (!optionalBook.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookRepository.deleteIsbn(isbn);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
