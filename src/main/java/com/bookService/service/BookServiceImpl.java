package com.bookService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookService.exception.BookDetailsNotFound;
import com.bookService.model.Book;
import com.bookService.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

//	Get All Book
	@Override
	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}

//	Add Book
	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

//	Delete Book
	@Override
	public void deleteBook(int id) {
		Optional<Book> getBook = bookRepo.findById(id);
		if (getBook.isPresent()) {
			bookRepo.delete(getBook.get());
		} else {
			throw new BookDetailsNotFound("Book Details Not Found");
		}

	}

//	Update Book
	@Override
	public Book updateBook(int id, Book book) {
		Optional<Book> getBook = bookRepo.findById(id);
		if (getBook.isPresent()) {
			return bookRepo.save(book);
		} else {
			throw new BookDetailsNotFound("Book Details Not Found Because Id is not Matched");
		}
	}

//	Get Book By Id
	@Override
	public Book getBookById(int id) {
		Optional<Book> getBook = bookRepo.findById(id);
		if (getBook.isPresent()) {
			return getBook.get();
		} else {
			throw new BookDetailsNotFound("Book Details Not Found in the Database");
		}
	}
}
