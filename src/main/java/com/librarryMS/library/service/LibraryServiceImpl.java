package com.librarryMS.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarryMS.library.DAO.LibraryRepository;
import com.librarryMS.library.entity.Book;
import com.librarryMS.library.entity.Users;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private LibraryRepository libraryRepository;
	
	
	@Autowired
	public LibraryServiceImpl( LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = libraryRepository.findAll();
		return books;
	}

	@Override
	public Optional<Book> getBookByName(String title) {
		return libraryRepository.findByName(title);
	}

	@Override
	public void deleteBookByName(String title) {
		libraryRepository.deleteByName(title);	
	}

	@Override
	public Book borrowBook(Book book , Users name) {
		if(book.isAvailable() == true) {
			book.setUsers(name);
			book.setAvailable(false);
			return book;
		}
		else {
			return null;
		}
	}

	@Override
	public Book addBook(Book book) {
		return libraryRepository.save(book);
	}

	@Override
	public Book returnBook(Book book) {
		book.setAvailable(true);
		book.setId(0);
		return libraryRepository.save(book);
		
	}

}
