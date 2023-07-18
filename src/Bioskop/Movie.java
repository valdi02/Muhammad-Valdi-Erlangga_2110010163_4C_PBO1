/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bioskop;

/**
 *
 * @author valdi
 */
public class Movie {
    private String title;
    private int durationInMinutes;
    private String genre;

    public Movie(String title, int durationInMinutes, String genre) {
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.genre = genre;
    }

    // Accessor methods
    public String getTitle() {
        return title;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    // Override toString memunculkan display movie
    @Override
    public String toString() {
        return "Title: " + title + "\nDuration: " + durationInMinutes + " minutes\nGenre: " + genre;
    }
}


