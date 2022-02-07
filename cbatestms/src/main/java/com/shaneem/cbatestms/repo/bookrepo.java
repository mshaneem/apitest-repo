package com.shaneem.cbatestms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shaneem.cbatestms.model.Books;

public interface bookrepo extends JpaRepository <Books,Long> {
	
	@Query("select book from Books book where book.title=?1")
	Optional<Books> findByTitle(String title);
	
	@Query("select book from Books book where book.isbn=?1")
	Optional<Books> findByISBN(long isbn);
	
	@Query("select book from Books book where book.author=?1")
	Optional<Books> findByAuthor(String author);
}
