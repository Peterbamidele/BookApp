package com.booklibaray.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageLinks {
    private String smallThumbnail;
    private String thumbnail;
}
