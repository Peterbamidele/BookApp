package com.booklibaray.search;

import com.booklibaray.model.Book;

import java.util.List;

public class BookService {
    Book findBookById(String id) throws BookNotFoundException;
    List<Book> search(String searchSentence);

}
