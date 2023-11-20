package com.smruti.service;

import java.util.List;

import com.smruti.binding.BookInfo;
import com.smruti.entity.Book;

public interface BookService {

	public boolean addBook(BookInfo bookinfo);
	public List<Book> getBook();
	public Book getBookById(Integer bookId);
	public boolean updateBook(Integer bookId, Double price);
	public boolean deleteBook(Integer bookId);
	public void updateAll(Integer bookId, Book bookAll );
}
