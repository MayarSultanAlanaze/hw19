package com.example.demo.Controller;


import com.example.demo.Model.Book;
import com.example.demo.Service.ServiceBok;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/book")
public class ControllerBook {

    private final ServiceBok serviceBok;

    @GetMapping("/get")
    public ResponseEntity getAllBook(){
        List<Book>bookList=serviceBok.getAllBook();
        return ResponseEntity.status(200).body(bookList);
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book, Errors errors){
       serviceBok.addBook(book);
       return ResponseEntity.status(200).body("add Book");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book, @PathVariable Integer id, Errors errors) {
        serviceBok.updateBook(book, id);
        return ResponseEntity.status(200).body("update Book");
    }
    @DeleteMapping("/delete/{id }")
    public ResponseEntity deleteBook(@PathVariable Integer id ){
        serviceBok.deleteBook(id);
        return ResponseEntity.status(200).body("delete book");
    }
    @GetMapping("/get-category/{category}")
    public ResponseEntity getBookCategory(@PathVariable String category){
        List<Book> book=serviceBok.findBookByCategory(category);
        return ResponseEntity.status(200).body(book);
        }
   @GetMapping("/get-Author/{author}")
    public ResponseEntity getBookByAuthor (@PathVariable String author){
        Book book=serviceBok.getBookByAuthor(author);
        return ResponseEntity.status(200).body(book);
    }
    @GetMapping("/search-Titel/{titel}")
    public ResponseEntity getBookByTitel(@PathVariable String titel) {
      List < Book> book = serviceBok.getBookByTitel(titel);
        return ResponseEntity.status(200).body(book);
    }

}
