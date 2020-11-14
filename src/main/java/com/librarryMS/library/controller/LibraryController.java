package com.librarryMS.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.librarryMS.library.entity.Book;
import com.librarryMS.library.entity.Users;
import com.librarryMS.library.service.LibraryServiceImpl;

@Controller
public class LibraryController {
	
	@Autowired
	private LibraryServiceImpl lsi;
	
	@GetMapping("/library")
	public List<Book> getBooks(){
		return lsi.findAll();
	}

	@GetMapping("/library/{title}")
	public ResponseEntity<Book> findById(@PathVariable String title) {
		Optional<Book> oneBook =  lsi.getBookByName(title);
		if (!oneBook.isPresent()) {
			return null;
		}
		return ResponseEntity.ok(oneBook.get());
	}
	
	@DeleteMapping("/book/{title}")
	public void deleteByName(@PathVariable String title) {
		lsi.deleteBookByName(title);
	}
	
	@PatchMapping("/library/book/{title}")
	public void updateBook(@RequestBody Book book) {
		book.getId();
		lsi.addBook(book);
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		book.setId(0);
		lsi.addBook(book);
		return book;
	}
	
	@GetMapping("/borrowBook")
	public Book borrowBook(@PathVariable Book book, Users name) {
		return lsi.borrowBook(book, name);
	}
	
	@PostMapping("/returnBook")
	public Book returnBook(@RequestBody Book book) {
		return lsi.returnBook(book);
	}
}
