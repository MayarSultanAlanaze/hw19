package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Model.Librarian;
import com.example.demo.Service.ServiceBok;
import com.example.demo.Service.ServiceLibrarian;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/librarian")
public class ControllerLibraian {

    private final ServiceLibrarian serviceLibrarian;

    @GetMapping("/get")
    public ResponseEntity getAllLibrarian(){
       List< Librarian> librarians =serviceLibrarian.getAllLibrarian();
        return ResponseEntity.status(200).body(librarians);
    }
    @PostMapping("/add")
    public ResponseEntity addLibarians(@Valid @RequestBody Librarian librarian, Errors errors) {
        serviceLibrarian.addLibrarian(librarian);
        return ResponseEntity.status(200).body("add Librarian");
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateLibrarian(@Valid @RequestBody Librarian librarian, @PathVariable Integer id, Errors errors) {
        serviceLibrarian.updateLibrarian(librarian, id);
        return ResponseEntity.status(200).body("update Librarian");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id ) {
        serviceLibrarian.deleteLibrarian(id);
        return ResponseEntity.status(200).body("delete librarian");
    }
    @GetMapping("/get-user/{username}/{password}")
    public ResponseEntity findLibrarianByUsernameAndPassword(@PathVariable String username,String password){
        Librarian librarian=serviceLibrarian.findLibrarianByUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body(librarian);
    }
    @GetMapping("/get-email/{email}")
    public ResponseEntity findLibrarianByEmail(@PathVariable String email) {
       Librarian librarian=serviceLibrarian .findLibrarianByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }

}

