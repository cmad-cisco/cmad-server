package com.cisco.cmad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.cmad.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	public List<Book> findBySubject(String subject);
}
