package com.booklibaray.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    private String title;
    private String description;
    private ImageLinks imageLinks;
    private  String previewsLink;
    private String publisher;
    private List<String> authors = new ArrayList<>();

}
