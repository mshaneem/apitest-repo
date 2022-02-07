package com.shaneem.cbatestms.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shaneem.cbatestms.model.Books;

import com.shaneem.cbatestms.repo.bookrepo;
@RestController
public class BooksResource {
	
	private final bookrepo repo;
	@Autowired
	public BooksResource (bookrepo repo) {
		this.repo = repo;
	}
	
	@GetMapping("/books")
	public List<Books> getBooks(){
		return repo.findAll();
	}
	
	@GetMapping("/books/title/{title}")
	public Books getBookbyTitle(@PathVariable String title) {
	
		Optional<Books> book = repo.findByTitle(title);
		if (book.isPresent()) return book.get();
		return null;
	}
	
	@GetMapping("/books/isbn/{isbn}")
	public Books getBookbyISBN(@PathVariable String Isbn) {
		long isbn = Long.parseLong(Isbn);
		Optional<Books> book = repo.findByISBN(isbn);
		if (book.isPresent()) return book.get();
		return null;
	}
	@GetMapping("/books/author/{author}")
	public Books getBookbyAuthor(@PathVariable String author) {
	
		Optional<Books> book = repo.findByAuthor(author);
		if (book.isPresent()) return book.get();
		return null;
	}
	
}
