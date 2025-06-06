package com.example.recipehubmaincontainer;

// PUBLIC_INTERFACE
public class Recipe {
    private String name;
    private String shortDescription;
    private String category;
    private String imageUrl;

    // PUBLIC_INTERFACE
    public Recipe(String name, String shortDescription, String category, String imageUrl) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    // PUBLIC_INTERFACE
    public String getName() {
        return name;
    }

    // PUBLIC_INTERFACE
    public String getShortDescription() {
        return shortDescription;
    }

    // PUBLIC_INTERFACE
    public String getCategory() {
        return category;
    }

    // PUBLIC_INTERFACE
    public String getImageUrl() {
        return imageUrl;
    }
}
