package com.librarryMS.library.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarryMS.library.entity.Book;

public interface LibraryRepository extends JpaRepository<Book, Long> {

	public Optional<Book> findByName(String title);
	
	public void deleteByName(String title);

	
	


}
