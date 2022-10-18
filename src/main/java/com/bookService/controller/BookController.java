package com.bookService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookService.model.Book;
import com.bookService.service.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	private BookServiceImpl bookService;

//	Add Book
	@PostMapping(value = "/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}

//	Get All Book
	@GetMapping(value = "/getAllBook")
	public ResponseEntity<List<Book>> getAllBook() {
		return new ResponseEntity<List<Book>>(bookService.getAllBook(), HttpStatus.OK);
	}

//	Get Book By Id
	@GetMapping(value = "/getBooKById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
	}

//	Update Book
	@PutMapping(value = "/updateBook/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.updateBook(id, book), HttpStatus.OK);
	}

//	Delete Book
	@DeleteMapping(value = "/deleteBook")
	public ResponseEntity<?> deleteBook(@RequestParam("id") int id) {
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book Details Deleted", HttpStatus.OK);
	}

}
