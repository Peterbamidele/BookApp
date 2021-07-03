package com.booklibaray.service;

import com.booklibaray.exceptions.BookNotFoundException;
import com.booklibaray.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Book findBookById(String id) throws BookNotFoundException {
        String URI = "https://www.googleapis.com/books/v1/volumes/" + id;
        ResponseEntity<SearchResult> apiResponseResponseEntity =
                restTemplate.getForEntity(URI, SearchResult.class);
        SearchResult searchResult = apiResponseResponseEntity.getBody();
        if (searchResult == null){
            throw new BookNotFoundException("No book with that ID found. Search for a valid book");
        }
        String bookId = searchResult.getId();
        VolumeInfo volumeInfo = searchResult.getVolumeInfo();
        String title = volumeInfo.getTitle();
        String description = volumeInfo.getDescription();
        ImageLinks imageLinks = volumeInfo.getImageLinks();
        String smallThumbnails = imageLinks.getSmallThumbnail();
        String thunbnails = imageLinks.getThumbnail();
        String previewlinks = volumeInfo.getPreviewsLink();
        String publisher = volumeInfo.getPublisher();
        List<String> authors = volumeInfo.getAuthors();
        Book book = new Book();
        book.setId(bookId);
        book.setAuthor(authors);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setPreviewLink(previewlinks);
        book.setDescription(description);
        book.setSmallImage(smallThumbnails);
        book.setImage(thunbnails);
        return book;

    }

    public List<Book> search(String searchSentence) {
        searchSentence = searchSentence.replaceAll("", "");
        final String URL = "https://www.googleapis.com/books/v1/volumes/" + searchSentence;
        ResponseEntity<ApiResponse> apiResponseResponseEntity = restTemplate.getForEntity(URL, ApiResponse.class);
        ApiResponse apiResponse = apiResponseResponseEntity.getBody();
        System.out.println(apiResponse);
        assert apiResponse != null;
        return apiResponse.getItems().stream().map(
                searchResultResult -> {
                    Book book = new Book();
                    String id = searchResultResult.getId();
                    VolumeInfo volumeInfo = searchResultResult.getVolumeInfo();
                    String title = volumeInfo.getTitle();
                    String publisher = volumeInfo.getPublisher();
                    List<String> author = volumeInfo.getAuthors();
                    String previewLink = volumeInfo.getPreviewsLink();
                    String description = volumeInfo.getDescription();
                    ImageLinks imageLinks = volumeInfo.getImageLinks();
                    String smallImage = imageLinks.getSmallThumbnail();
                    String image = imageLinks.getThumbnail();
                    book.setId(id);
                    book.setDescription(description);
                    book.setImage(image);
                    book.setPreviewLink(previewLink);
                    book.setPublisher(publisher);
                    book.setSmallImage(smallImage);
                    book.setTitle(title);
                    book.setAuthor(author);
                    return book;
                }
        ).collect(Collectors.toList());
    }
}
