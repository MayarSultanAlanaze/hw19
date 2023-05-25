package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "titel can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String titel;

    @NotEmpty(message = "Author can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String Author;

    @NotEmpty(message = "Category can't be empty")
    @Column(columnDefinition = "varchar(20) not null check(Category ='Academic' or'Mystery' or'Novel')")
    private String Category;


    @NotNull
//    @Column(columnDefinition = "varchar(20)not null")
    private int ISBN;


    @NotNull
    @Size(min = 50,message = "min should be 50 pages")
 @Column(columnDefinition = "varchar(20")
    private int numberOfPages;

}
