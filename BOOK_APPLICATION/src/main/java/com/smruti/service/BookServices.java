package com.smruti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smruti.binding.BookInfo;
import com.smruti.entity.Book;
import com.smruti.repository.BookRepository;

@Service
public class BookServices implements BookService {

	@Autowired
	private BookRepository bookrepo;
	
	
	@Override
	public boolean addBook(BookInfo bookinfo) {
		Book book = new Book();
		BeanUtils.copyProperties(bookinfo, book);
		Book save = bookrepo.save(book);
		return save.getBookId() != null?true: false;
	}

	@Override
	public List<Book> getBook() {
		return bookrepo.findAll();
	}
	

	@Override
	public boolean updateBook(Integer bookId, Double price) {

		Optional<Book> findById = bookrepo.findById(bookId);
		
		if (findById.isPresent()) {
			Book book = findById.get();
			book.setBookPrice(price);
			bookrepo.save(book);
			return true;
		}
		
		return false;
	}
	
	@Override
	public void updateAll(Integer bookId, Book bookAll) {
		Book book2 = bookrepo.findById(bookId).get();
			BeanUtils.copyProperties(bookAll, book2);
			bookrepo.save(book2);
	
		
	}

	@Override
	public boolean deleteBook(Integer bookId) {
		try {
			bookrepo.deleteById(bookId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Book getBookById(Integer bookId) {
		Book book = bookrepo.findById(bookId).get();
		return book;

	}


}
