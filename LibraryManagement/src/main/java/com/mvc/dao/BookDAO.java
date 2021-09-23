package com.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mvc.entity.Book;
import com.mvc.entity.User;

@Component
public interface BookDAO {
	public Long insert(Book book);
	public List<Book> fetchAll();
	public void delete(Book book);
	public boolean isBookExist(String title);
	
}
