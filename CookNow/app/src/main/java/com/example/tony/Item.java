package com.example.tony;

import java.util.ArrayList;

/**
 * Created by munkhbayarganbileg on 5/29/16.
 */
public class Item {
    public String title,image;
    public int year;
    public double rate;
    private ArrayList<String> genre;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public Item(){

    }

    public void setTitle(String theTitle) {
        title = theTitle;
    }
}
