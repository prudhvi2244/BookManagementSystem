package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.repo.BookRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository brepo;

	@Override
	public Book saveBook(Book book) {
		Book savedBook = brepo.save(book);
		log.info("Saved Book :" + savedBook);
		return savedBook;
	}

	@Override
	public void deleteBook(Integer bid) {
		Book book=findBookById(bid);
		brepo.deleteById(book.getBid());
	}

	@Override
	public Book findBookById(Integer bid) {
		// log.info("Book With ID :"+bid+" Details :"+book);
		return brepo.findById(bid)
				.orElseThrow(() -> new BookNotFoundException("Book With Given ID :" + bid + " Not Available"));
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> allBooks = brepo.findAll();
		log.info("All Books :" + allBooks);
		return allBooks;
	}

}
