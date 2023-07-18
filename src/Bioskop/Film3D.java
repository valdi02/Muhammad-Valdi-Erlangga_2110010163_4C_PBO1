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
public class Film3D extends Movie {
    private boolean isGlassesNeeded;

    public Film3D(String title, int durationInMinutes, String genre, boolean isGlassesNeeded) {
        super(title, durationInMinutes, genre);
        this.isGlassesNeeded = isGlassesNeeded;
    }

    public boolean isGlassesNeeded() {
        return isGlassesNeeded;
    }

    @Override
    public String toString() {
        return super.toString() + "\n3D Glasses Needed: " + isGlassesNeeded;
    }
}

