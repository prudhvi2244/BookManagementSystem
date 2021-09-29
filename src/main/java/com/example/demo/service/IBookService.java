package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

public interface IBookService {
	
	Book saveBook(Book book);
	Book findBookById(Integer bid);
	List<Book> getAllBooks();
	void deleteBook(Integer bid);

}
