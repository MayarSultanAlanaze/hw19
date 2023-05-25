package com.example.demo.Service;

import ch.qos.logback.core.joran.spi.ActionException;
import com.example.demo.AipException.ApiException;
import com.example.demo.Model.Book;
import com.example.demo.Repository.RepositoryBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
    @Service
    @RequiredArgsConstructor
    public class ServiceBok {

        private final RepositoryBook repositoryBook;

        public List<Book> getAllBook() {
            return repositoryBook.findAll();
        }

        public void addBook(Book book) {
            repositoryBook.save(book);
        }

        public boolean updateBook(Book book, Integer id) {
            Book book1 = repositoryBook.getById(id);
            if (book1 == null) {

                book1.setAuthor(book.getAuthor());
                book1.setISBN(book.getISBN());
                book1.setCategory(book.getCategory());
                book1.setTitel(book.getTitel());
            }

            repositoryBook.save(book1);
            return true;
        }
        public Book deleteBook(Integer id) {
            Book book = repositoryBook.getById(id);
            if (book == null) {
                throw new ApiException("book Delete");
            }
            repositoryBook.delete(book);
            return book;
        }
        public List<Book >findBookByCategory(String category){
           List <Book >books=repositoryBook.findBookByCategory(category);
            if (books==null){
                throw new ApiException("not exist");
            }
            return books;

        }
        public List<Book> getBookByNumberOfPagesGreater(Integer numberOfPages){
            List<Book>books=repositoryBook.findBookByNumberOfPagesGreaterThan(numberOfPages);
            if (numberOfPages==null){
                throw new ApiException("not exist");
            }
            return books;
        }
        public Book getBookByAuthor(String author){
            Book book=repositoryBook.findBookByAuthor(author);
            if (author==null){
                throw new ApiException("not exist");
            }return book;

        }
       public List<Book> getBookByTitel(String titel){
         List   <Book> book=repositoryBook.searchBookByTitel(titel);
            if (titel==null){
                throw new ApiException("not exist");
            }return book;

       }
    }
