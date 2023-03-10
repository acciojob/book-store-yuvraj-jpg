package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity findBookById(@PathVariable String id){
        Book newbook = bookService.findBookById(id);
        return new ResponseEntity<>(newbook, HttpStatus.OK);
    }
    @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @GetMapping("/books/get-books-by-author?author=author+name")
    public ResponseEntity findAllBooks(){
        List<Book> list = bookService.findAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    @GetMapping("/books/get-books-by-author?author=author+name")
    public ResponseEntity findBooksByAuthor(@RequestParam String author){
        List<Book> list = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/books/get-books-by-genre?genre=genre+name")
    public ResponseEntity findBooksByGenre(@RequestParam String genre){
        List<Book> list = bookService.findBooksByAuthor(genre);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
