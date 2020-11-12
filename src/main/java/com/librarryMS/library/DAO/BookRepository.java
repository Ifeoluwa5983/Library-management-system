package com.librarryMS.library.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarryMS.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
