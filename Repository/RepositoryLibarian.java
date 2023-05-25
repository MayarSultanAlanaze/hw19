package com.example.demo.Repository;

import com.example.demo.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryLibarian extends JpaRepository<Librarian ,Integer> {
   List <Librarian> findLibrarianById(Integer Id);

    Librarian findLibrarianByEmail(String email);

    Librarian findLibrarianByUsernameAndPassword(String password,String username);

}
