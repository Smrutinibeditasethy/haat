package com.smruti.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smruti.entity.Book;

public interface BookRepository extends JpaRepository<Book, Serializable>{

}
