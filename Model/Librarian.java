package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;

    @NotEmpty(message = "username can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Pattern (regexp = "(?=^[ -~]{6,64}$)(?=.*([a-z][A-Z]))(?=.*[0-9])")
    private String password;

    @Email(message = "should be valid email")
   @NotEmpty (message = "username can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
}
