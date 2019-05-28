package com.mng.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping(value="/hello")
	public String greeting() {
		return "Hello spring boot";
	}
	
	@RequestMapping(value="/book")
	public Book getBookDetails() {
		Book b = new Book();
		b.setCategory("java");
		b.setName("spring boot");
		return b;
	}
	
	@RequestMapping(value="/writer")
	public Writer getWriterDetails() {
		
		Writer wr = new Writer();
		wr.setId(101);
		wr.setName("jeamsgosling");
		
		Book b = new Book();
		b.setCategory("java");
		b.setName("spring boot");
		
		wr.setBook(b);
		
		return wr;
	}
}
