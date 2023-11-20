package com.smruti.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.smruti.binding.Book;

@Service
public class RestTemplateService {
RestTemplate rt =new RestTemplate();

public String getBook() {
	String getBook="http://localhost:8080/books";
  ResponseEntity<String> response = rt.getForEntity(getBook, String.class);
 return response.getBody();
	
	}
public String addBook(Book book) {
	 String createBook="http://localhost:8080/addbook";
	 ResponseEntity<String> response = rt.postForEntity(createBook, book, String.class);
	 return response.getBody();
}

public String getBookById(Integer bookId) {
	String getBookById="http://localhost:8080/book/" +bookId;
   ResponseEntity<String> response = rt.getForEntity(getBookById, String.class);
   return response.getBody();
  
}

public String updateBook( Integer bookId, Book updateBook) {
	String updateBookall="http://localhost:8080/book/" +bookId;
       rt.put(updateBookall, updateBook);
       return "Book updated successfully";
       
   }

public String deleteBook(Integer bookId) {
	String deleteBook="http://localhost:8080/book/" +bookId;
   rt.delete(deleteBook);
  return "Book deleted successfully";
}








}
