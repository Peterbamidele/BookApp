package com.booklibaray.search;

import com.booklibaray.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public interface BookServiceImpl implements BookService{
    @Autowired
    private RestTemplate restTemplate;

    public Book findBookByid(String id) throws BookNotFoundException{
        
    }






































































































































































}
