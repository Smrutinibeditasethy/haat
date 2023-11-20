package com.smruti.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smruti.binding.Book;
import com.smruti.service.RestTemplateService;

@RestController
public class RestTemplateController {

	@Autowired
	private RestTemplateService sts;
	
	
	@PostMapping("/addbook")
	public String addBook(@RequestBody Book book) {
		 String createBook=sts.addBook(book);
		return createBook;
}
	
	@GetMapping("/books")
    public String getBook() {
	String getBook=sts.getBook();
   return getBook;
	}
	
	@GetMapping("/book/{bookId}")
	 public String getBookById(@PathVariable Integer bookId) {
			String getBookById=sts.getBookById(bookId);
	     return getBookById;
	   }
	
	@PutMapping("/book/{bookId}")
	 public String updateBook(@PathVariable Integer bookId,@RequestBody Book Book) {
			String updateBookall=sts.updateBook(bookId, Book);
		       return updateBookall;
		   }
		   
	@DeleteMapping("/book/{bookId}")
		   public String deleteBook(@PathVariable Integer bookId) {
				String deleteBook=sts.deleteBook(bookId);
		      return deleteBook;
		   }
	
}
