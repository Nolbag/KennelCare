package models;

import java.util.Arrays;
import utils.Utilities;

public class Pet {
    private int id = 1000;
    private String name = "truncates to 30 chars";
    private String owner = "truncates to 20 chars";
    private int age = 1;
    private boolean[] daysAttending = {false, false, false, false, false};
    private char sex= 'f';
    private static int nextId = 1000;
    
    public Pet(String name, String owner, int age, boolean[] daysAttending, char sex) {
        this.id = nextId++;
        this.name = Utilities.truncateString(name, 30);
        this.owner = Utilities.truncateString(owner, 20);
        this.age = age;
        this.daysAttending = daysAttending;
        this.sex = sex;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (Utilities.validStringlength(name, 30)){
            this.name = name;
        }
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        if (Utilities.validStringlength(owner, 20)){
            this.owner = owner;
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String toString() {
        return "Pet id = " + id + ", name = " + name + ", owner = " + owner + ", age = " + age + ", days attending = "
        + Arrays.toString(daysAttending) + ", sex = " + sex;
    }
    
    public boolean[] getDaysAttending() {
        return daysAttending;
    }
    
    public void setDaysAttending(boolean[] daysAttending) {
        this.daysAttending = daysAttending;
    }
    
    public char getSex() {
        return sex;
    }
    
    public void setSex(char sex) {
        this.sex = sex;
    }
    
    public void checkIn(int dayIndex){
        // if valid dayIndex >=0 <= 5 
        //  assign that element of the array to true
        if (Utilities.validRange(dayIndex, 0, 4)){
            daysAttending[dayIndex] = true;
        }
    }
    
    public void checkOut(int dayIndex){
        // if valid dayIndex >=0 <= 5 
        //  assign that element of the array to false
        if (Utilities.validRange(dayIndex, 0, 4)){
            daysAttending[dayIndex] = false;
        }
        
    }
    public int numOfDaysInKennel(){
        // iterates through array
        // Adds 1 to a variable if the element of the array is true
        // returns variable
        int numOfDaysInKennel = 0;
        for (boolean day: daysAttending) {
            if (day) {
                numOfDaysInKennel++;
            }
        }
        return numOfDaysInKennel;
    }
    public double calculateWeeklyFee(int numberOfDaysInKennel){
        double weeklyFee=0;
        return weeklyFee;
    }
    
}
