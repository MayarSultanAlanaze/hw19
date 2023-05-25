package com.example.demo.Repository;

import com.example.demo.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryBook extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    List<Book > findBookByCategory(String category);
    List<Book> findBookByNumberOfPagesGreaterThan(int numberOfPages);
  Book findBookByAuthor(String author);
   List <Book> searchBookByTitel(String titel);



}
