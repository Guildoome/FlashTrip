package com.example.a34011_73_07.flashtrip;

public class Game {
    private String name;
    private int imageSource;

    public Game (int imageSource) {
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }
}