package com.example.musicapp;

public class AlbumObject {
    int Image;
    String Name;
    String Description;
    int NumberOfSongs;

    public AlbumObject(int image, String name, String description, int numberOfSongs) {
        Image = image;
        Name = name;
        Description = description;
        NumberOfSongs = numberOfSongs;
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

    public int getNumberOfSongs() {
        return NumberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        NumberOfSongs = numberOfSongs;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
