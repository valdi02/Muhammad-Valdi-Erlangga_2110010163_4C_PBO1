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
public class Ticket {
    private Movie movie;
    private String seatNumber;
    private double price;

    public Ticket(Movie movie, String seatNumber, double price) {
        this.movie = movie;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Accessor methods
    public Movie getMovie() {
        return movie;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    // Override toString method for displaying the ticket details
    @Override
    public String toString() {
        return "Movie: " + movie.getTitle() + "\nSeat Number: " + seatNumber + "\nPrice: $" + price;
    }
}
