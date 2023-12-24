package com.example.indiasateliteweather;

public class DataModel {

   private String imageUrl;
    private String description;
    String name;

    public DataModel(String imageUrl, String name, String description) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.description=description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
