package com.librarryMS.library.service;

import java.util.List;
import java.util.Optional;

import com.librarryMS.library.entity.Book;

public interface BookService {
	
	public List<Book> findAll();
	
	public Optional<Book> getBookByName(String title);
	
	public void saveBook(Book book);
	
	public void deleteByName(String title);
	
	public void borrowBook(String title);

}
