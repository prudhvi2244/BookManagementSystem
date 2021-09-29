package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.IBookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/book")
@Api(value = "Book Rest Controller",description = "REST API's Related To Book Entity")
public class BookController {
	
	@Autowired
	private IBookService bservice;
	
	
	@PostMapping(value = "/saveBook")
	@ApiOperation(value = "This Method is for save operation,Provide Book Details and this method returns Saved Book Object")
	public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book)
	{
		Book savedBook=bservice.saveBook(book);
		return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{bid}")
	@ApiOperation(value = "Get Single Book object By Prividing Book ID as input")
	public ResponseEntity<Book> getBookById(@PathVariable Integer bid)
	{
		Book book=bservice.findBookById(bid);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping(value = "/allBooks")
	@ApiOperation(value = "Get All Book Objects in the form of List")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> allBooks=bservice.getAllBooks();
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{bid}")
	@ApiOperation(value = "Delete Book object By Prividing Book ID as input")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer bid)
	{
		bservice.deleteBook(bid);
		String msg="Book With ID :"+bid+" Deleted Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
