package com.librarryMS.library.service;

import java.util.List;
import java.util.Optional;

import com.librarryMS.library.entity.Book;
import com.librarryMS.library.entity.Users;

public interface LibraryService {
	
	public List<Book> findAll();
	
	public Optional<Book> getBookByName(String title);
	
	public void deleteBookByName(String title);
	
	public Book borrowBook(Book book, Users name);
	
	public Book addBook(Book book);
	
	public void returnBook(Book book);


}
