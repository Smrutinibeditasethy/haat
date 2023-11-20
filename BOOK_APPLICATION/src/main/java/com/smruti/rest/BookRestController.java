package com.smruti.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smruti.binding.BookInfo;
import com.smruti.entity.Book;
import com.smruti.service.BookService;

@RestController
public class BookRestController {
  
Logger logger =  LoggerFactory.getLogger(BookRestController.class);

	@Autowired
	private BookService service;
	
	@PostMapping("/addbook")
	public ResponseEntity<String> addBook(@RequestBody BookInfo bookinfo){
		logger.info("The data is being entered");
		boolean addBook = service.addBook(bookinfo);
		

		if (addBook) {
			logger.info("The data is saved successfully");
			return new ResponseEntity<String>("Book saved successfully", HttpStatus.CREATED);	
		}else {
			logger.warn("The data is not saved");
			return new ResponseEntity<String>("Book failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook(){
		logger.info("Getting the information of all the books");
		List<Book> books = service.getBook();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer bookId){
        logger.info("GET Request: Getting book with ID " + bookId);
		Book bookById = service.getBookById(bookId);
		 logger.info("GET Request: The task is completed");
		return ResponseEntity.ok(bookById);
		
	}
	
	@PutMapping("/book/{bookId}/{price}")
	public ResponseEntity<String> updateBook(@PathVariable Integer bookId,  @PathVariable Double price){
		logger.info("The updation has started");
		boolean updateBook = service.updateBook(bookId, price);
		
		if (updateBook) {
			logger.info("The data is being updated");
			return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
		}else {
			logger.warn("The data is not updated");
			return new ResponseEntity<>("Book failed to update", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/book/{bookId}")
	public ResponseEntity<String> updateAll(@PathVariable Integer bookId, @RequestBody Book bookAll){
		logger.info("The updation has started");
		 service.updateAll(bookId, bookAll);
		 logger.info("The data is being updated");
			return new ResponseEntity<String>("Book updated successfully", HttpStatus.OK);
		
	}
	
	
	
	
	
		@DeleteMapping("book/{bookId}")
		public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
			logger.warn("The data is being deleted" );
			boolean deleteBook2 = service.deleteBook(bookId);
			
			if (deleteBook2) {
				logger.warn("The data is  deleted" );
				return new ResponseEntity<String>("Book deleted sucessfully", HttpStatus.OK);
			}else {
				logger.warn("The data is not deleted" );
				return new ResponseEntity<String>("Book are not unable to delete", HttpStatus.BAD_REQUEST);
			}
		
		
		
	}
	
}
