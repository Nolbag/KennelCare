package models;

import utils.Utilities;

public class Cat extends Pet{
    private boolean indoorCat = false;
    private String favouriteToy = "Unknown";
    
    
    
    public Cat(String name, String owner, int age, boolean[] daysAttending, char sex, boolean indoorCat, String favouriteToy) {
        super(name, owner, age,  daysAttending, sex);
        this.indoorCat = indoorCat;
        this.favouriteToy = favouriteToy;
    }
    
    public boolean isIndoorCat() {
        return indoorCat;
    }
    
    public void setIndoorCat(boolean indoorCat) {
        this.indoorCat = indoorCat;
    }
    
    public String getFavouriteToy() {
        return favouriteToy;
    }
    
    public void setFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
    }
    
    @Override
    // Overrides the method of the same name in the superclass
    public double calculateWeeklyFee(int numOfDaysInKennel){
        // If indoorCat is true calculates the weekly fee based on that rate
        if (indoorCat){
            return numOfDaysInKennel * (20 + 5);
        }
        // Otherwise uses the standard rate rate to calculate weekly fee
        else return numOfDaysInKennel * 20;
    }
    
    @Override
    // Overrides the method of the same name in the superclass
    public String toString() {
        // Returns the Superclass toString and adds the specific details relating to the subclass
        return super.toString() + " indoor cat= " + Utilities.booleanToYN(indoorCat) + ", favourite toy= " + favouriteToy;
    }
    
}
