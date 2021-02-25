package com.example.musicapp;

public class AlbumObject {
    int Image;
    String Name;
    String Description;

    public AlbumObject(int image, String name, String description) {
        Image = image;
        Name = name;
        Description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
