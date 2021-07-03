package com.booklibaray.service;

import com.booklibaray.exceptions.BookNotFoundException;
import com.booklibaray.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book findBookById(String id) throws BookNotFoundException;
    List<Book> search(String searchSentence);

}
