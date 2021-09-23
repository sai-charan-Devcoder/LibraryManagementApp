package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.dao.BookDAO;
import com.mvc.dao.FormDAO;
import com.mvc.entity.Book;
import com.mvc.entity.User;


@Controller
public class FormController {
	
	@Autowired
	private FormDAO formDao;
	
	@Autowired
	private BookDAO bookDao;
	
	@GetMapping("/")
	public String formPage()
	{
		return "form";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user)
	{
		System.out.println("Inside Login");
		boolean result=formDao.isUserExist(user);
		if(result)
		{
			return "home";
		}
		else
		{
			return "error";
		}
	}
	
	@PostMapping("/book")
	public String addBook(@ModelAttribute Book book )
	{
		System.out.println("inside addbook");
		bookDao.insert(book);
		return "home";
		
	}
	//public String deleteBook(@ModelAttribute Book book)
	
	@PostMapping("/delete")
	public String deleteBook(@RequestParam("title") String title)
	{
		System.out.println("inside delete");
		System.out.println(title);
		//System.out.println(book.getId());
		boolean result=bookDao.isBookExist(title);
		
		if(result)
		{
			
		
			List<Book> books=bookDao.fetchAll();
			//Long id;
			Book book1=new Book();
			for(Book book: books)
			{
				if(book.getTitle().equals(title))
				{
					System.out.println(book.getId());
					//id=book.getId();
					System.out.println(book.getTitle());
					book1.setId(book.getId());
					
				}
				
			}
			
			
			book1.setTitle(title);
			bookDao.delete(book1);
			return "home";
		}
		else
		{
			return "errorbook";
		}
		
		
	}
	
//	@RequestMapping(value = "/showing", method = RequestMethod.GET)
//	public ModelAndView listBooks()
//	{
//		List<Book> books=bookDao.fetchAll();
//		List<String> list = new ArrayList<String>();
//		for(Book book: books)
//		{
//			list.add(book.getTitle());
//		}
//		System.out.println("Inside show books");
//		for(String str:list)
//		{
//			System.out.println(str);
//		}
//		//input.addAttribute("books",book.getTitle());
//		
//		//return "home";
//		ModelAndView model = new ModelAndView("home");
//        model.addObject("lists",list);
//
//        return model;
//	}
	
	
//	@GetMapping("/showing")
//	public String listBooks(Model input)
//	{
//		List<Book> books=bookDao.fetchAll();
//		List<String> list = new ArrayList<String>();
//		for(Book book: books)
//		{
//			list.add(book.getTitle());
//		}
//		System.out.println("Inside show books");
//		for(String str:list)
//		{
//			System.out.println(str);
//		}
//		//input.addAttribute("books",book.getTitle());
//		
//		//return "home";
////		ModelAndView model = new ModelAndView("home");
////        model.addObject("lists",list);
//		input.addAttribute("list",list);
//        return "home";
//	}
	
	
	@PostMapping("/show")
	public String listBooks(Model input)
	{
		List<Book> books=bookDao.fetchAll();
		List<String> titleList = new ArrayList<String>();
		List<Long> idList=new ArrayList<Long>();
		for(Book book: books)
		{
			titleList.add(book.getTitle());
			idList.add(book.getId());
			
		}
		
	//	String listOfBooks="";
		System.out.println("Inside show books");
		for(String str:titleList)
		{
			System.out.println(str);
			//listOfBooks = listOfBooks + System.lineSeparator() + str;
		}
		//System.out.println(listOfBooks);
		input.addAttribute("titles",titleList);
		input.addAttribute("ids", idList);
		return "home";
	}
	
	
	

	@PostMapping("/error")
	public String error()
	{
		System.out.println("Inside error page");
		
		return "redirect:/";
	}
	@PostMapping("/errorbook")
	public String errorBook()
	{
		System.out.println("Inside errorbook page");
		
		return "home";
	}
	
	
	@PostMapping("/logout")
	public String logout()
	{
		
		
		return "redirect:/";
	}
	
	
}
