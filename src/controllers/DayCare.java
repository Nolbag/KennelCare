package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.*;
import utils.*;


public class DayCare {
    
    
    private ArrayList<Pet> pets;
    private String name;
    private int maxNumberOfPets;
    public DayCare() {
        pets = new ArrayList<>();
    }
    //TODO create constructor initialise the kennel name and to instantiate the pets list
    public DayCare(ArrayList<Pet> pets, String name) {
        this.pets = pets;
        this.name = Utilities.truncateString(name, 20);
    }
    
    
    public ArrayList<Pet> getPetsArray() {
        return pets;
    }
    
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if(Utilities.validStringlength(name, 20)){
            this.name=name;
        }
    }
    
    public int getMaxNumberOfPets() {
        return maxNumberOfPets;
    }
    
    public void setMaxNumberOfPets(int maxNumberOfPets) {
        this.maxNumberOfPets = maxNumberOfPets;
    }
    //TODO - CRUD Methods
    
    /**
    * This method stores a pet object in the ArrayList. 
    * @param pet models.Pet object being added to the ArrayList
    * @return True if pet added to the ArrayList
    */
    public boolean addPet(Pet pet) {
        //Adds a pet to the array list. Returns true if successful
        return pets.add(pet);
    }
    
    // TODO Reporting Methods
    /**
    * This method builds and returns a String of all pets in the ArrayList.
    * For each pet stored, the index of it's position in the ArrayList is included. 
    * If no Pets are stored in the ArrayList, the string "No Pets in Kennel" is returned.
    * @return A String containing all pets in the ArrayList or "No Pets in Kennel", if empty.
    */
    public String listAllPets() {
        String listPets = "";
        /* Uses a for each loop to scan through the array list adding the index and 
        pet to String details of each pet to String listPets.*/
        for(Pet pet: pets) {
            listPets += pets.indexOf(pet) + pet.toString() + "\n";
        }
        // If the String listPets is empty returns No Pets in Kennel
        if (listPets.isEmpty()) {
            return "No Pets in Kennel";
        }
        //returns the String
        else return listPets;
    }
    
    /** 
    * This method builds and returns a String of all cats in the ArrayList.
    * For each Cat stored, the index of it's position in the ArrayList is included.
    * If no Cats are stored in the ArrayList, the string "No cats are in the kennel" is returned.
    * @return A String containing all cats in the ArrayList or "No cats are in the kennel".
    */
    public String listAllCats() {
        String listCats = "";
        
        // Uses a for each loop to scan through the array list.
        for(Pet pet: pets) {
            // If a pet at the index checked uses the Cat class adds the index and toString for the cat to String listCats
            if (pet instanceof Cat) {
                listCats += pets.indexOf(pet) + ": " + pet.toString() + "\n";
            }
        }
        // If listCats is empty returns No cats are in the kennel
        if (listCats.isEmpty()){
            return "No cats are in the kennel";
        }
        else return listCats;
    }
    
    /** 
    * This method builds and returns a String of all dogs in the ArrayList.
    * For each Dog stored, the index of it's position in the ArrayList is included.
    * If no Dogs are stored in the ArrayList, the string "No dogs are in the kennel" is returned.
    * @return A String containing all cats in the ArrayList or "No dogs are in the kennel".
    */
    public String listAllDogs() {
        String listDogs = "";
        
        // Uses a for each loop to scan through the array list.
        for(Pet pet: pets) {
            // If a pet at the index checked uses the Dog class adds the index and toString for the dog to String listDogs
            if (pet instanceof Dog) {
                listDogs += pets.indexOf(pet) + ": " + pet.toString()+ "\n";
            }
        }
        // If listDogs is empty returns No dogs are in the kennel
        if (listDogs.isEmpty()){
            return "No dogs are in the kennel";
        }
        else return listDogs;
    }
    
    /** 
    * This method builds and returns a String of all dangerous dogs in the ArrayList.
    * For each Dog stored, the index of it's position in the ArrayList is included.
    * If no dangerous dogs are stored in the ArrayList, the string "No dangerous dogs are in the kennel" is returned.
    * @return A String containing all cats in the ArrayList or "No dangerous dogs are in the kennel".
    */
    public String listAllDangerousDogs(){
        String listDangerDogs = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet: pets) {
            // Uses instance of to cast to Dog.
            if (pet instanceof Dog){
                // tells Java I know this object is a Dog and to treat it as such.
                Dog dog = (Dog) pet;
                // Uses isDangerousBreed method in Dog to create a string of all objects with a boolean of true.
                if (dog.isDangerousBreed()){
                    listDangerDogs+= pets.indexOf(pet) + ": " + dog.toString() + "\n";
                }
            }
        }
        // If none are found returns a string stating this.
        if(listDangerDogs.isEmpty()){
            return "No dangerous dogs are in the kennel";
        }
        // Otherwise returns the string of dangerous dogs.
        return listDangerDogs;
    }
    
    /** 
    * This method builds and returns a String of all neutered dogs in the ArrayList.
    * For each Dog stored, the index of it's position in the ArrayList is included.
    * If no neutered dogs are stored in the ArrayList, the string "No neutered dogs are in the kennel" is returned.
    * @return A String containing all cats in the ArrayList or "No neutered dogs are in the kennel".
    */
    public String listAllNeuteredDogs(){
        String listNeuteredDogs = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet: pets) {
            // Uses instance of to cast to Dog.
            if (pet instanceof Dog){
                // tells Java I know this object is a Dog and to treat it as such.
                Dog dog = (Dog) pet;
                // Uses isNeutered method in Dog to create a string of all objects with a boolean of true.
                if (dog.isNeutered()){
                    listNeuteredDogs+= pets.indexOf(pet) + ": " + dog.toString() + "\n";
                }
            }
        }
        // If none are found returns a string stating this.
        if(listNeuteredDogs.isEmpty()){
            return "No neutered dogs are in the kennel";
        }
        // Otherwise returns the string of neutered dogs.
        return listNeuteredDogs;
    }
    
    /** 
    * This method builds and returns a String of all indoor cats in the ArrayList.
    * For each Cat stored, the index of it's position in the ArrayList is included.
    * If no indoor cats are stored in the ArrayList, the string "No indoor cats are in the kennel" is returned.
    * @return A String containing all cats in the ArrayList or "No indoor cats are in the kennel".
    */
    public String listAllIndoorCats(){
        String listIndoorCats = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet: pets) {
            // Uses instance of to cast to Cat.
            if (pet instanceof Cat){
                // tells Java I know this object is a Cat and to treat it as such.
                Cat cat = (Cat) pet;
                // Uses isIndoorCat method in Cat to create a string of all objects with a boolean of true.
                if (cat.isIndoorCat()){
                    listIndoorCats+= pets.indexOf(pet) + ": " + cat.toString() + "\n";
                }
            }
        }
        // If none are found returns a string stating this.
        if (listIndoorCats.isEmpty()){
            return "No indoor cats are in the kennel";
        }
        // Otherwise returns the string of Indoor Cats.
        return listIndoorCats;
    }
    
    /** 
    * This method builds and returns a String of all cats in the ArrayList with the specified favouriteToy (passed as a parameter).
    * For each Cat stored, the index of it's position in the ArrayList is included.
    * If no Cats are stored in the ArrayList with the passed favouriteToy, the string "No cat's favourite toy is " + favouriteToy is returned.
    * @param favouriteToy Name of cat toy
    * @return A String containing all cats in the ArrayList with variable matching favouriteToy or "No cat's favourite toy is " + favouriteToy.
    */
    public String listCatsByToy(String favouriteToy){
        // Creates a new string lowerFavouriteToy to convert the passed String to lower case using toLowerCase() method from String.
        String lowerFavouriteToy = favouriteToy.toLowerCase();
        String listCatsByToy = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet : pets) {
            // Uses instance of to cast to Cat
            if (pet instanceof Cat){
                // tells Java to treat the pet as a Cat and access methods from that class.
                Cat cat = (Cat) pet;
                // Then if lowerFavouriteToy matches the Favourite Toy, converted to lower case using toLowerCase, stored for that position in the array List
                if (cat.getFavouriteToy().toLowerCase().equals(lowerFavouriteToy)){
                    // adds the index and toString for that cat to String listCatsByToy and returns the string once the loop is finished.
                    listCatsByToy += pets.indexOf(pet) + ": " + pet.toString();
                }
            }
        }
        // If listCatsByToy is empty returns a String stating No cat's favourite toy is and the favourireToy string it was passed.
        if (listCatsByToy.isEmpty()){
            return "No cat's favourite toy is " + favouriteToy;
        }
        return listCatsByToy;
    }
    
    /** 
    * This method builds and returns a String of all cats in the ArrayList with the specified petOwner (passed as a parameter).
    * For each Pet stored, the index of it's position in the ArrayList is included.
    * If no Pets are stored in the ArrayList meet this condition, the string "No Pet with owner " + petOwner is returned.
    * @param petOwner name of pet owner
    * @return A String containing all pets with the passed petOwner or "No Pet with owner " + petOwner
    */
    public String listAllPetsByOwner(String petOwner){
        // Creates a new string lowerPetOwner to convert the passed String to lower case using toLowerCase() method from String.
        String lowerPetOwner = petOwner.toLowerCase();
        String listPetsByOwner = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet: pets){
            // If the String lowerPetOwner equals the stored variable petOwner, converted to lower case using toLowerCase, at any index
            if (pet.getOwner().toLowerCase().equals(lowerPetOwner)){
                // adds the index and toString of that position to the String listPetsByOwner and returns listPetsByOwner.
                listPetsByOwner += petOwner + "owns: " + pets.indexOf(pet) + pet.toString() + "\n";
            }
        }
        // If listPetsByOwner is Empty returns No Pet with owner and the passed String petOwner.
        if (listPetsByOwner.isEmpty()){
            return "No Pet with owner " + petOwner;
        }
        return listPetsByOwner;
    }
    
    /** 
    * This method takes in a number and builds and returns a String of all pets in the ArrayList where numOFDaysInKennel is greater than or equal to the number taken in.
    * For each Pet stored in the ArrayList that meets this condition, the index of it's position in the ArrayList is included.
    * If no Pets are stored in the ArrayList meet this condition, the string "No Pet stays longer than " + numDays + " days."
    * @param numDays A number representing the minimum number of days the pet must have stayed in the kennel.
    * @return A String containing all pets staying more than the int passed to the method or "No Pet stays longer than " + numDays + " days."
    */
    public String listAllPetsThatStayMoreThanDays(int numDays){
        String listPets = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet: pets){
            // Uses an if statement to Check if the number of days a pet is staying in the kennel is greater than or equal to the passed int numDays.
            if(pet.numOfDaysInKennel() >= numDays){
                // Adds the index and toString of each pet that matches that check to String listPets and returns it.
                listPets += pets.indexOf(pet) + ": " + pet.toString() + "\n";
            }
        }
        // If listPets is empty returns a string stating no pets stayed longer than the passed int numDays.
        if (listPets.isEmpty()){
            return "No Pet stays longer than " + numDays + " days.";
        }
        return listPets;
    }
    
    /** 
    * This method takes in a number and builds and returns a String of all dogs in the ArrayList where age is greater than to the number taken in.
    * For each Pet stored in the ArrayList that meets this condition, the index of it's position in the ArrayList is included.
    * If no Pets are stored in the ArrayList meet this condition, the string "No Pet older than " + minAge + " years old."
    * @param minAge A number representing the minimum number of age of dogs to be stored in the ArrayList.
    * @return A String containing all dogs with age greater than the int passed to the method or "No Pet older than " + minAge + " years old."
    */
    public String listDogsOverAge(int minAge){
        String listDogsOverAge = "";
        
        // Uses a for each loop to traverse the array list.
        for(Pet pet: pets){
            if(pet instanceof Dog){
                // Casts pet to the Dog class.
                // Tells Java that to treat the pet as using the Dog class.
                Dog dog = (Dog) pet;
                // If the stored int age for a dog in the array list is greater than the minAge int passed to the method
                if(dog.getAge() > minAge){
                    // adds the index and toString for that position in the array to String listDogsOverAge and returns it once the loop finishes.
                    listDogsOverAge += pets.indexOf(pet) + ": " + pet.toString() + "\n"; 
                }
            }
        }
        // If listDogsOverAge is empty returns a String saying no pets are older than the passed int minAge.
        if (listDogsOverAge.isEmpty()){
            return "No Pet older than " + minAge + " years old.";
        }
        return listDogsOverAge;
    }
    
    // TODO number methods
    /** 
    * This method returns the number of pet objects stored in the ArrayList.
    * @return An int value representing the number of pet objects in the ArrayList.
    */
    public int numberOfPets(){
        // Returns the size of the array list
        return pets.size();
    }
    
    /** 
    * This method returns the number of cat objects stored in the ArrayList.
    * @return An int value representing the number of cat objects in the ArrayList.
    */
    public int numberOfCats(){
        int num = 0;
        // Traverses the array list and adds 1 to num when ever a cat is found.
        for (Pet pet: pets){
            if (pet instanceof Cat){
                num++;
            }
        }
        // Once the loop is finished returns the total.
        return num;
    }
    
    /** 
    * This method returns the number of dog objects stored in the ArrayList.
    * @return An int value representing the number of dog objects in the ArrayList.
    */
    public int numberOfDogs(){
        int num = 0;
        // Traverses the array list and adds 1 to num when ever a dog is found.
        for (Pet pet: pets){
            if (pet instanceof Dog){
                num++;
            }
        }
        // Once the loop is finished returns the total.
        return num;
    }
    
    /** 
    * This method returns the number of cat objects, where dangerousBreed is true, stored in the ArrayList.
    * @return An int value representing the number of dog objects, where dangerousBreed is true, in the ArrayList.
    */
    public int numberOfDangerousDogs(){
        // Set num to 0 as a count for dangerous dogs.
        int num = 0;
        // Uses a for each loop to traverse the array list.
        for (Pet pet: pets){
            // Checks if each pet is a dog.
            if (pet instanceof Dog){
                // Casts to Dog to use methods from that class.
                Dog dog = (Dog) pet;
                // Checks if dangerousBreed is true.
                if (dog.isDangerousBreed()){
                    // Adds 1 to num each time it's true and then returns the total
                    num++;
                }
            } 
        }
        return num;
    }
    
    /** 
    * This method returns the number of cat objects, where indoorCat is true, stored in the ArrayList.
    * @return An int value representing the number of dog objects, where indoorCat is true, in the ArrayList.
    */
    public int numberOfIndoorCats(){
        // Set num to 0 as a count for indoor cats.
        int num = 0;
        // Uses a for each loop to traverse the array list.
        for (Pet pet: pets){
            // Checks if each pet is a cat.
            if (pet instanceof Cat){
                // Casts to Cat to use methods from that class.
                Cat cat = (Cat) pet;
                // Checks if indoorCat is true.
                if(cat.isIndoorCat()){
                    // Adds 1 to num each time it's true and then returns the total
                    num++;
                }
            }
        }
        return num;
    }
    
    //TODO validation method below:
    //the following is isValidId can be updated
    //to suit your code - checks is the id already there in the list
    /** 
    * This method takes in an number and checks if a Pet object in the ArrayList contains that value in the id variable
    * @param id A number representing the id value to be checked.
    * @return Returns false if the number passed to the method exists in the id variable of a Pet object in the ArrayList.
    */
    public boolean isValidId(int id) {
        for (Pet p : pets) {
            if (p.getId() == id)
                return false;
        }
        return true;
    }
    
    //TODO get Pets methods
    /** 
    * Get a Pet object at a specific index location.
    * If the index location is not valid, return null.
    * @param indexToGet Index of the model.Pet object in the ArrayList.
    * @return The Pet object or null if no object is at the index location.
    */
    public Pet getPetByIndex(int indexToGet){
        // Uses an if statement and isValidIndex method from the Utilities class to check the passed int indexToGet is valid in the array list.
        if(Utilities.isValidIndex(pets, indexToGet)) {
            // returns the pet stored at that index.
            return pets.get(indexToGet);
        }
        // If it's not a valid index returns null
        else return null;
    }
    
    /** 
    * This method takes in an number and gets the Pet object in the ArrayList that contains the value in the id variable
    * If no Pet object in the ArrayList contains the value passed in it's id variable , return null.
    * @param idToGet id of the model.Pet object in the ArrayList.
    * @return The Pet object or null if no object contains the passed number in it's id variable.
    */
    public Pet getPetById(int idToGet){
        // Uses a for each loop to traverse the array list and search for the id passed to it.
        for (Pet pet: pets) {
            // Uses the getId method from Pet to search the array for the id it was passed.
            if (pet.getId() == idToGet){
                // Returns the pet found at that ID.
                return pet;
            }
        }
        // If the ID is not valid null is returned instead.
        return null;
    }
    
    
    //TODO - delete methods
    /** 
    * This method takes in an number and deletes the Pet object in the ArrayList that contains the value in the id variable
    * If no Pet object in the ArrayList contains the value passed in it's id variable , return null.
    * @param idToDelete id of the model.Pet object in the ArrayList.
    * @return The deleted Pet object or null if no object contains the passed number in it's id variable.
    */
    public Pet deletePetId(int idToDelete){
        // Uses a for each loop to traverse the array list and search for the id passed to it.
        for (Pet pet: pets) {
            // Uses the getId method from Pet to search the array for the id it was passed.
            if (pet.getId() == idToDelete){
                // Deletes the pet found at that id and returns the pet that was deleted.
                pets.remove(pet);
                return pet;
            }
        }
        // If the ID is not valid null is returned instead.
        return null;
    }
    
    /** 
    * Delete a model.Pet from the ArrayList, if it exists, at the index passed as a parameter.
    * @param indexToDelete Index of the model.Pet object in the ArrayList.
    * @return The deleted Pet object or null if no object is at the index location.
    */
    public Pet deletePetIndex(int indexToDelete){
        // Uses an if statement and isValidIndex method from the Utilities class to check the passed int indexToGet is valid in the array list.
        if (Utilities.isValidIndex(pets, indexToDelete)){
            // Uses the array list method remove to remove the pet at that index. Also returns the pet that was deleted.
            return pets.remove(indexToDelete);
        }
        // If it's not a valid index returns null
        else return null;
    }
    
    //TODO - update methods
    
    /** 
    * Update a models.Dog in the ArrayList with the contents passed in the models.Dog object parameter 
    * if it's id variable matches the idToUpdate variable passed by the method, returns True
    * If no dog in the ArrayList has that id variable returns False.
    * @param idToUpdate id of the model.Dog object in the ArrayList.
    * @param updateDetails Update details for cat.
    * @return The status of the update, True or False.
    */
    public boolean updateDog(int idToUpdate, Dog updateDetails){
        
        Pet foundPet = getPetById(idToUpdate);
        
        // Uses a for loop to scan through the Array List
        for (int i = 0; i < pets.size(); i++){
            // if the ID provided matches i AND the pet at i is a dog
            if ((pets.get(i).getId() == idToUpdate) && (pets.get(i) instanceof Dog)){
                /* sets the details of the dog found to the new details provided.
                Uses get methods to obtain the spefcific variable required to update the field.*/
                foundPet.setName(updateDetails.getName());
                foundPet.setOwner(updateDetails.getOwner());
                foundPet.setAge(updateDetails.getAge());
                foundPet.setDaysAttending(updateDetails.getDaysAttending());
                foundPet.setSex(updateDetails.getSex());
                // For subclass specific field tells Java to use methods found in Dog class.
                ((Dog) foundPet).setBreed(updateDetails.getBreed());
                ((Dog) foundPet).setDangerousBreed(updateDetails.isDangerousBreed());
                ((Dog) foundPet).setNeutered(updateDetails.isNeutered());
                return true;
            }
        }
        // Otherwise returns false
        return false;
    }
    
    /** 
    * Update a models.Cat in the ArrayList with the contents passed in the models.Cat object parameter 
    * if it's id variable matches the idToUpdate variable passed by the method, returns True
    * If no cat in the ArrayList has that id variable returns False.
    * @param idToUpdate id of the model.Cat object in the ArrayList.
    * @param updateDetails Update details for cat.
    * @return The status of the update, True or False.
    */
    public boolean updateCat(int idToUpdate, Cat updateDetails){
        
        Pet foundPet = getPetById(idToUpdate);
        
        // Uses a for loop to scan through the Array List
        for (int i = 0; i < pets.size(); i++){
            // if the ID provided matches i AND the pet at i is a cat
            if ((pets.get(i).getId() == idToUpdate) && (pets.get(i) instanceof Cat)){
                // sets the details of the cat found to the new details provided
                foundPet.setName(updateDetails.getName());
                foundPet.setOwner(updateDetails.getOwner());
                foundPet.setAge(updateDetails.getAge());
                foundPet.setDaysAttending(updateDetails.getDaysAttending());
                foundPet.setSex(updateDetails.getSex());
                ((Cat) foundPet).setIndoorCat(updateDetails.isIndoorCat());
                ((Cat) foundPet).setFavouriteToy(updateDetails.getFavouriteToy());
                return true;
            }
        }
        // Otherwise returns false.
        return false;
    }
    
    /** 
    * This method returns the weekly income based on the pets stored in the ArrayList.
    * @return Weekly income to two decimal places, or 0.0 if no pets exist.
    */
    public double getWeeklyIncome(){
        double weeklyIncome = 0.0;
        // Calulates the weekly income based on the pets in the array list based on the number of days spent in the kennel
        for (Pet pet : pets){
            // Because of polymorphism each pet is calculated at the approriate rate based on their class
            weeklyIncome += pet.calculateWeeklyFee(pet.numOfDaysInKennel());
        }
        return Utilities.toTwoDecimalPlaces(weeklyIncome);
    }
    
    /** 
    * This method returns the average number of days of all pets in the ArrayList spent at the kennel.
    * @return Average number of days pets spent in the kennel, or 0.0 if no pets exist.
    */
    public double getAverageNumDaysPerWeek(){
        // Returns 0 if the pets array list is empty.
        if(pets.isEmpty())
            return 0.0;
        double averageDays;
        double totalDays = 0.0;
        // the for each loop calculates the total number of days pets in the array list spent in the kennel.
        for (Pet pet : pets){
            totalDays += pet.numOfDaysInKennel();
        }
        // That number is then divided by the number of pets in the array list and that value is returned.
        averageDays = totalDays/pets.size();
        return averageDays;
    }
    
    /** 
    * This method returns a String of pet objects containing a petOwner variable that matches the String passed to the method.
    * Returns "No Pets for " + petOwner if no pet object contain a matching petOwner variable.
    * @param petOwner String to be checked against petOwner variable of Pet objects.
    * @return A String containing all Pet objects with a petOwner variable matching the String passed to the method, or
    * return "No Pets for " + petOwner if the String is empty.
    */
    public String getPetsByOwnersName(String petOwner){
        // Creates a new string lowerPetOwner to convert the passed String to lower case using toLowerCase() method from String.
        String lowerPetOwner = petOwner.toLowerCase();
        String listPetsByOwner = "";
        // Uses a for each loop to check if the lowerPetOwner String matches the Owner String stored in the array list.
        for (Pet pet : pets){
            if (pet.getOwner().toLowerCase().equals(lowerPetOwner)){
                // If these match adds the index and to string of the pet to the String listPetsByOwner and returns listPetsByOwner.
                listPetsByOwner+=pets.indexOf(pet) + ": " + pet.toString() + "\n";
            }
        }
        // If listPetsByOwner is empty passes a string saying the owner has no pets in the kennel
        if (listPetsByOwner.isEmpty()){
            return "No Pets for " + petOwner;
        }
        return listPetsByOwner;
    }
    
    /** 
    * This method returns a dog object containing variables that match the parameters passed by the method
    * If no dog objects match the parameters passed by the method returns null.
    * @param petOwner String to be checked against petOwner variable of dog objects.
    * @param breed String to be checked against breed variable of dog objects.
    * @param age int to check against the age variable of dog objects.
    * @return dog object with petOwner, breed and age variables matching the parameters passed to the method, or
    * return null.
    */
    public Pet findDogByOwnerAndBreedAndAge(String petOwner, String breed, int age){
        // Creates two strings to convert the Strings passed by the method to lower case
        String lowerPetOwner = petOwner.toLowerCase();
        String lowerBreed = breed.toLowerCase();
        // Uses a for each loop to scan through the array list.
        for(Pet pet : pets){
            // If the pet found at any given index is of the class Dog
            if (pet instanceof Dog){
                Dog dog = (Dog) pet;
                // checks the owner and breed converted to lower case and age.
                if ((dog.getOwner().toLowerCase().equals(lowerPetOwner)) && (dog.getBreed().toLowerCase().equals(lowerBreed)) && (dog.getAge() == age)){
                    // If these variables all match returns pet.
                    return pet;
                }
            }
        }
        // Otherwise returns null
        return null;
    }
    
    /** 
    * This method returns a pet object with a name that matches the String petName passed by the method.
    * If no pet object matches null is returned
    * @param petName name of pet to be found in the ArrayList.
    * @return Pet with name that matches String passed by the method. If no pet in the ArrayList matches return null.
    */
    public Pet getPet(String petName){
        // Creates a string lowerPetName to convert the passed String petName to lower case.
        String lowerPetName = petName.toLowerCase();
        // Uses a for each loop to scan the array list.
        for(Pet pet : pets){
            // If lowerPetName equals the stored variable name, converted to lower case using toLowerCase() String method, returns the pet.
            if(pet.getName().toLowerCase().equals(lowerPetName))
                return pet;
        }
        // Otherwise returns null
        return null;
    }
    
    // TODO Persistence methods
    /**
    * The load method uses the XStream component to read all the product objects from the Pets.xml
    * file stored on the hard disk.  The read pets are loaded into the pets ArrayList
    *
    * @throws Exception  An exception is thrown if an error occurred during the load e.g. a missing file.
    */
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //Sets classes to be included in serialisation
        Class<?>[] classes = new Class[] { Cat.class, Dog.class, Pet.class};
        
        // Sets up the xstream object, security and above classes.
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        
        // Does the serialisation in denoting load, taking in data. file name hard coded to Pets.xml
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("Pets.xml"));
        pets = (ArrayList<Pet>) in.readObject();
        in.close();
    }
    
    /**
    * The save method uses the XStream component to write all the product objects in the pets ArrayList
    * to the Pets.xml file stored on the hard disk.
    *
    * @throws Exception  An exception is thrown if an error occurred during the save e.g. drive is full.
    */
    public void save() throws Exception {
        // Sets up the xstream object
        XStream xstream = new XStream(new DomDriver());
        // Writes the data, out denoting save, to the hard coded Pets.xml file.
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Pets.xml"));
        out.writeObject(pets);
        out.close();
    }
}