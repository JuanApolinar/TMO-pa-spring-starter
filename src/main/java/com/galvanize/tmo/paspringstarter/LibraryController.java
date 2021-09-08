package com.galvanize.tmo.paspringstarter;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();


    @GetMapping(value="/api/books", produces = "application/json")
    public List<Book> health() {
        return bookList;
    }

    @PostMapping(value = "/api/books", consumes = "application/json", produces = "application/json")
    public Book postBooks(@RequestBody Book newBook){
        newBook.setId(bookList.size() + 1);
        bookList.add(newBook);
        return newBook;
    }

    @DeleteMapping("/api/books")
    public void deleteBooks(){
        bookList.clear();
    }
}
