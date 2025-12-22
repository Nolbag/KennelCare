package models;

import utils.Utilities;

public class Dog extends Pet{
    private String breed = "(20 chars)";
    private boolean dangerousBreed = false;
    private boolean neutered = false;
    private static final float DANGEROUS_DAILY_RATE = 40;
    private static final float NONDANGEROUS_DAILY_RATE = 30;
    
    
    public Dog(String name, String owner, int age, boolean[] daysAttending, char sex, String breed,
        boolean dangerousBreed, boolean neutered) {
            super(name, owner, age, daysAttending, sex);
            this.breed = Utilities.truncateString(breed, 20);
            this.dangerousBreed = dangerousBreed;
            this.neutered = neutered;
        }
        
        public String getBreed() {
            return breed;
        }
        
        public void setBreed(String breed) {
            if (Utilities.validStringlength(breed, 20)){
                this.breed = breed;
            }
        }
        
        public boolean isDangerousBreed() {
            return dangerousBreed;
        }
        
        public void setDangerousBreed(boolean dangerousBreed) {
            this.dangerousBreed = dangerousBreed;
        }
        
        public boolean isNeutered() {
            return neutered;
        }
        
        public void setNeutered(boolean neutered) {
            this.neutered = neutered;
        }
        
        @Override
        public double calculateWeeklyFee(int numberOfDaysInKennel){
            if (dangerousBreed){
                return DANGEROUS_DAILY_RATE * numberOfDaysInKennel;
            }
            else return NONDANGEROUS_DAILY_RATE * numberOfDaysInKennel;
        }
        
        @Override
        public String toString() {
            return super.toString() + " breed = " + breed + ", dangerous breed= " + Utilities.booleanToYN(dangerousBreed) + ", neutered = " + Utilities.booleanToYN(neutered);
        }
        
        
    }
    