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
    public double calculateWeeklyFee(int numOfDaysInKennel){
        if (indoorCat){
            return numOfDaysInKennel * 25 + 5;
        }
        else return numOfDaysInKennel * 20;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Indoor Cat= " + Utilities.booleanToYN(indoorCat) + ", favouriteToy= " + favouriteToy;
    }
    
}
