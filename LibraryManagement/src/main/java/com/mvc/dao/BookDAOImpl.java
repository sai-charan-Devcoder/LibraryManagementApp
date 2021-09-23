package com.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import com.mvc.entity.Book;


@Transactional
@Repository
public class BookDAOImpl implements BookDAO  {

	
	@Autowired
	private HibernateTemplate hibernateTemp;
	
	@Override
	public Long insert(Book book) {
		return (Long) hibernateTemp.save(book);
		
	}

	@Override
	public List<Book> fetchAll() {
		return hibernateTemp.loadAll(Book.class);
		
	}

	@Override
	public void delete(Book book) throws DataAccessException {
		
		//hibernateTemp.delete(book);
		//hibernateTemp.delete(book.getTitle(), book);
		//hibernateTemp.delete(title, title);
		//Employee e=(Employee)template.get(Employee.class,id);
		//Book b=(Book) hibernateTemp.get(Book.class, title);
		
		System.out.println(book.getId());
		System.out.println(book.getTitle());
		hibernateTemp.delete(book);
	}

	@Override
	public boolean isBookExist(String title) {
		String query="select count(*) from Book f where f.title=:myTitle";
		String[] paramName=new String[] {"myTitle"};
		//String s=String.valueOf(book.getId()); 
		//String s=Long.toString(book.getId());
		//System.out.println(s);
		String[] value=new String[] {title};
		List<?> result = hibernateTemp.findByNamedParam(query, paramName, value);
		System.out.println("inside isbookexist");
		System.out.println(result);
		Long count=(Long) result.get(0);
		System.out.println(count);
		if(count==0)
		{
			return false;
		}
		return true;
	
	}

	

}
