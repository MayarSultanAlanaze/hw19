package com.example.demo.Service;

import com.example.demo.AipException.ApiException;
import com.example.demo.Model.Book;
import com.example.demo.Model.Librarian;
import com.example.demo.Repository.RepositoryBook;
import com.example.demo.Repository.RepositoryLibarian;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLibrarian {

        private final RepositoryLibarian repositoryLibarian;

        public List <Librarian> getAllLibrarian() {
           return repositoryLibarian.findAll();
        }

        public void addLibrarian(Librarian librarian) {
            repositoryLibarian.save(librarian);
        }

        public boolean updateLibrarian(Librarian librarian, Integer id) {
            Librarian librarian1= repositoryLibarian.getById(id);
            if (librarian1== null) {

            }

           repositoryLibarian.save(librarian1);
            return true;
        }
        public Librarian deleteLibrarian(Integer id) {
            Librarian librarian = repositoryLibarian.getById(id);
            if (librarian== null) {
                throw new ApiException("librarian Delete");
            }
            repositoryLibarian.delete(librarian);
            return librarian;
        }
        public Librarian findLibrarianByEmail(String email){
           Librarian librarian=repositoryLibarian.findLibrarianByEmail(email);
            if (librarian==null){
                throw new ApiException("not exist");
            }
            return librarian;

        }
        public Librarian findLibrarianByUsernameAndPassword(String username , String password){
            Librarian librarian=repositoryLibarian.findLibrarianByUsernameAndPassword(username,password);
            if (librarian==null){
                throw new ApiException("not exist");
            }
            return librarian;
        }

    }

