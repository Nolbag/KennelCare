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
        this.name = name;
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
        this.name = name;
    }
    public int getMaxNumberOfPets() {
        return maxNumberOfPets;
    }
    public void setMaxNumberOfPets(int maxNumberOfPets) {
        this.maxNumberOfPets = maxNumberOfPets;
    }
    //TODO - CRUD Methods
    
    /*Adds a pet to the array list. Returns true if successful */
    public boolean addPet(Pet pet) {
        return pets.add(pet);
    }
    
    // TODO Reporting Methods
    /* Uses a for each loop to scan through the array list adding the inde and pet to String details of each pet to String str and then returns it.
    If the String str is empty returns No Pets in Kennel */
    public String listAllPets() {
        String str = "";
        for(Pet pet: pets) {
            str += pets.indexOf(pet) + pet.toString() + "\n";
        }
        if (str.isEmpty()) {
            return "No Pets in Kennel";
        }
        else return str;
    }
    
    /* Uses a for each loop to scan through the array list.
    If a pet at the index checked is uses the Cat class adds the inde and to String for the cat to String str and returns str.
    If str is empty returns No cats are in the kennel */
    public String listAllCats() {
        String str = "";
        
        for(Pet pet: pets) {
            if (pet instanceof Cat) {
                str += pets.indexOf(pet) + ": " + pet.toString() + "\n";
            }
        }
        if (str.isEmpty()){
            return "No cats are in the kennel";
        }
        else return str;
    }
    /* Uses a for each loop to scan through the array list.
    If a pet at the index checked is uses the Dog class adds the inde and to String for the cat to String str and returns str.
    If str is empty returns No cats are in the kennel */
    public String listAllDogs() {
        String str = "";
        
        for(Pet pet: pets) {
            if (pet instanceof Dog) {
                str += pets.indexOf(pet) + ": " + pet.toString()+ "\n";
            }
        }
        if (str.isEmpty()){
            return "No dogs are in the kennel";
        }
        else return str;
    }
    /*Uses a for each loop to traverse the array list.
    Uses intance of to cast to Dog.
    tells Java I know this variable is a Dog and to treat it as such.
    Uses isDangerousBreed method in Dog to create a string of all objects with a boolean of true.
    Creates a string based on all objects found.
    If none are found returns a string stating this.
    Otherwise returns the string of dangerous dogs.
    */
    public String listAllDangerousDogs(){
        String str = "";
        
        for(Pet pet: pets) {
            if (pet instanceof Dog){
                Dog dog = (Dog) pet;
                if (dog.isDangerousBreed()){
                    str+= pets.indexOf(pet) + ": " + dog.toString() + "\n";
                }
            }
        }
        if(str.isEmpty()){
            return "No dangerous dogs are in the kennel";
        }
        return str;
    }
    /*Uses a for each loop to traverse the array list.
    Uses intance of to cast to Dog.
    tells Java I know this variable is a Dog and to treat it as such.
    Uses isNeutered method in Dog to create a string of all objects with a boolean of true.
    Creates a string based on all objects found.
    If none are found returns a string stating this.
    Otherwise returns the string of neutered dogs.
    */
    public String listAllNeuteredDogs(){
        String str = "";
        
        for(Pet pet: pets) {
            if (pet instanceof Dog){
                Dog dog = (Dog) pet;
                if (dog.isNeutered()){
                    str+= pets.indexOf(pet) + ": " + dog.toString() + "\n";
                }
            }
        }
        if(str.isEmpty()){
            return "No dangerous dogs are in the kennel";
        }
        return str;
    }
    
    /*Uses a for each loop to traverse the array list.
    Uses intance of to cast to Cat.
    tells Java I know this variable is a Cat and to treat it as such.
    Uses isIndoorCat method in Cat to create a string of all objects with a boolean of true.
    Creates a string based on all objects found.
    If none are found returns a string stating this.
    Otherwise returns the string of Indoor Cats.
    */
    public String listAllIndoorCats(){
        String str = "";
        
        for(Pet pet: pets) {
            if (pet instanceof Cat){
                Cat cat = (Cat) pet;
                if (cat.isIndoorCat()){
                    str+= pets.indexOf(pet) + ": " + cat.toString() + "\n";
                }
            }
        }
        if (str.isEmpty()){
            return "No indoor cats are in the kennel";
        }
        return str;
    }
    
    /* Creates a new string lowerFavouriteToy to convert the passed String to lower case using toLowerCase() method from String.
    Uses a for each loop to traverse the array list.
    Uses instance of to cast to Cat
    tells Java to treat the pet as a Cat and access methods from that class.
    Then if lowerFavouriteToy matches the Favourite Toy, converted to lower case using toLowerCase, stored for that position in the array List
    adds the index and toString for that cat to String str and returns the string once the loop is finished.
    If str is empty returns a String stating No cat's favourite toy is and the favourireToy string it was passed. */
    public String listCatsByToy(String favouriteToy){
        String lowerFavouriteToy = favouriteToy.toLowerCase();
        String str = "";
        
        for(Pet pet : pets) {
            if (pet instanceof Cat){
                Cat cat = (Cat) pet;
                if (cat.getFavouriteToy().toLowerCase().equals(lowerFavouriteToy)){
                    str += pets.indexOf(pet) + ": " + pet.toString();
                }
            }
        }
        if (str.isEmpty()){
            return "No cat's favourite toy is " + favouriteToy;
        }
        return str;
    }
    
    /* Creates a new string lowerPetOwner to convert the passed String to lower case using toLowerCase() method from String.
    Uses a for each loop to traverse the array list.
    If the String lowerPetOwner equals the stored variable petOwner, converted to lower case using toLowerCase, at any index
    adds the index and toString of that position to the String str and returns str.
    IF str is Empty returns No Pet with owner and the passed String petOwner. */
    public String listAllPetsByOwner(String petOwner){
        String lowerPetOwner = petOwner.toLowerCase();
        String str = "";
        
        for(Pet pet: pets){
            if (pet.getOwner().toLowerCase().equals(lowerPetOwner)){
                str += petOwner + "owns: " + pets.indexOf(pet) + pet.toString() + "\n";
            }
        }
        if (str.isEmpty()){
            return "No Pet with owner " + petOwner;
        }
        return str;
    }

    /*Uses a for each loop to traverse the array list.
    Uses an if statement to Check if the number of days a pet is staying in the kennel is greater than or equal to the passed int numDays.
    Adds the index and toString of each pet that matches that check to String str and returns it.
    If str is empty returns a string stating no pets stayed longer than the passed int numDays.*/
    public String listAllPetsThatStayMoreThanDays(int numDays){
        String str = "";
        
        for(Pet pet: pets){
            if(pet.numOfDaysInKennel() >= numDays){
                str += pets.indexOf(pet) + ": " + pet.toString() + "\n";
            }
        }
        if (str.isEmpty()){
            return "No Pet stays longer than " + numDays + " days.";
        }
        return str;
    }

    /*Uses a for each loop to traverse the array list.
    Casts pet to the Dog class.
    Tells Java that to treat the pet as using the Dog class.
    If the stored int age for a dog in the array list is greater than the minAge int passed to the method
    adds the index and toString for that position in the array to String str and returns it once the loop finishes.
    If str is empty returns a String saying no pets are older than the passed int minAge. */
    public String listDogsOverAge(int minAge){
        String str = "";
        
        for(Pet pet: pets){
            if(pet instanceof Dog){
                Dog dog =(Dog) pet;
                if(dog.getAge() > minAge){
                    str += pets.indexOf(pet) + ": " + pet.toString() + "\n"; 
                }
            }
            if (str.isEmpty()){
                return "No Pet older than " + minAge + " years old.";
            }
        }
        return str;
    }
    
    // TODO number methods
    /*Returns the size of the array list */
    public int numberOfPets(){
        return pets.size();
    }
    
    /* Traverses the array list and adds 1 to num when ever a cat is found. Once the loop is finished returns the total. */
    public int numberOfCats(){
        int num = 0;
        for (Pet pet: pets){
            if (pet instanceof Cat){
                num++;
            }
        }
        return num;
    }
    
    /* Traverses the array list and adds 1 to num when ever a dog is found. Once the loop is finished returns the total. */
    public int numberOfDogs(){
        int num = 0;
        for (Pet pet: pets){
            if (pet instanceof Dog){
                num++;
            }
        }
        return num;
    }
    /* Set num to 0 as a count for dangerous dogs.
    Uses a for each loop to traverse the array list.
    Checks if each pet is a dog.
    Casts to Dog to use methods from that class.
    Checks if dangerousBreed is true.
    Adds 1 to num each time it's true and then returns the total */
    public int numberOfDangerousDogs(){
        int num = 0;
        for (Pet pet: pets){
            if (pet instanceof Dog){
                Dog dog = (Dog) pet;
                if (dog.isDangerousBreed()){
                    num++;
                }
            } 
        }
        return num;
    }
    /* Set num to 0 as a count for indoor cats.
    Uses a for each loop to traverse the array list.
    Checks if each pet is a cat.
    Casts to Cat to use methods from that class.
    Checks if indoorCat is true.
    Adds 1 to num each time it's true and then returns the total */
    public int numberOfIndoorCats(){
        int num = 0;
        for (Pet pet: pets){
            if (pet instanceof Cat){
                Cat cat = (Cat) pet;
                if(cat.isIndoorCat()){
                    num++;
                }
            }
        }
        return num;
    }
    
    //TODO validation method below:
    //the following is isValidId can be updated
    //to suit your code - checks is the id already there in the list
    public boolean isValidId(int id) {
        for (Pet p : pets) {
            if (p.getId() == id)
                return false;
        }
        return true;
    }
    
    //TODO get Pets methods
    /* Uses an if statement and isValidIndex method from the Utilities class 
    to check the passed int indexToGet is valid in the array list.
    returns the pet stored at that index.
    If it's not a valid index returns null*/
    public Pet getPetByIndex(int indexToGet){
        if(Utilities.isValidIndex(pets, indexToGet)) {
            return pets.get(indexToGet);
        }
        else return null;
    }
    
    /*Uses a for each loop to traverse the array list and search for the id passed to it.
    Uses the getId method from Pet to search the array for the id it was passed.
    Returns the pet found at that ID.
    If the index is not valid null is returned instead.*/
    public Pet getPetById(int idToGet){
        if (!isValidId(idToGet)){
            for (Pet pet: pets) {
                if (pet.getId() == idToGet){
                    return pet;
                }
            }
        }
        return null;
    }
    
    //TODO - delete methods
    /*Uses a for each loop to traverse the array list and search for the id passed to it.
    Uses the getId method from Pet to search the array for the id it was passed.
    Deletes the pet found at that id and returns the pet that was deleted.
    If the index is not valid null is returned instead.*/
    public Pet deletePetId(int idToDelete){
        if(!isValidId(idToDelete)){
            for (Pet pet: pets) {
                if (pet.getId() == idToDelete){
                    pets.remove(pet);
                    return pet;
                }
            }
        }
        return null;
    }

    /* Uses an if statement and isValidIndex method from the Utilities class 
    to check the passed int indexToGet is valid in the array list.
    Uses the array list method remove to remove the pet at that index
    Also returns the pet that was deleted.
    If it's not a valid index returns null*/
    public Pet deletePetIndex(int indexToDelete){
        if (Utilities.isValidIndex(pets, indexToDelete)){
            return pets.remove(indexToDelete);
        }
        else return null;
    }
    
    //TODO - update methods
    
    /* Uses a for loop to scan through the Array List if the ID provided matches i 
    AND the pet at i is a dog sets the details of the dog found to the new details provided7
    Otherwise returns false*/
    public boolean updateDog(int idToUpdate, Dog updateDetails){
        
        Pet foundPet = getPetById(idToUpdate);
        
        for (int i = 0; i < pets.size(); i++){
            if ((pets.get(i).getId() == idToUpdate) && (pets.get(i) instanceof Dog)){
                foundPet.setName(updateDetails.getName());
                foundPet.setOwner(updateDetails.getOwner());
                foundPet.setAge(updateDetails.getAge());
                foundPet.setDaysAttending(updateDetails.getDaysAttending());
                foundPet.setSex(updateDetails.getSex());
                ((Dog) foundPet).setBreed(updateDetails.getBreed());
                ((Dog) foundPet).setDangerousBreed(updateDetails.isDangerousBreed());
                ((Dog) foundPet).setNeutered(updateDetails.isNeutered());
                return true;
            }
        }
        return false;
    }
    /* Uses a for loop to scan through the Array List if the ID provided matches i 
    AND the pet at i is a cat sets the details of the cat found to the new details provided
    Otherwise returns false.*/
    public boolean updateCat(int idToUpdate, Cat updateDetails){
        
        Pet foundPet = getPetById(idToUpdate);
        
        for (int i = 0; i < pets.size(); i++){
            if ((pets.get(i).getId() == idToUpdate) && (pets.get(i) instanceof Cat)){
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
        return false;
    }
    /* Calulates the weekly income based on the pets in the array list based on the number of days spent in the kennel
    Because of polymorphism each pet is calculated at the approriate rate based on their class */
    public double getWeeklyIncome(){
        double weeklyIncome = 0.0;
        for (Pet pet : pets){
            weeklyIncome += pet.calculateWeeklyFee(pet.numOfDaysInKennel());
        }
        return Utilities.toTwoDecimalPlaces(weeklyIncome);
    }
    
    /* Returns 0 if the pets array list is empty.
    the for each loop calculates the total number of days pets in the array list spent in the kennel.
    That number is then divided by the number of pets in the array list and that value is returned. */
    public double getAverageNumDaysPerWeek(){
        if(pets.isEmpty())
            return 0.0;
        double averageDays;
        double totalDays = 0.0;
        for (Pet pet : pets){
            totalDays += pet.numOfDaysInKennel();
        }
        averageDays = totalDays/pets.size();
        return averageDays;
    }
    
    /* Creates a new string lowerPetOwner to convert the passed String to lower case using toLowerCase() method from String.
    Uses a for each loop to check if the lowerPetOwner String matches the Owner String stored in the array list.
    If these match adds the index and to string of the pet to the String str and returns str.
    If str is empty passes a string saying the owner has no pets in the kennel */
    public String getPetsByOwnersName(String petOwner){
        String lowerPetOwner = petOwner.toLowerCase();
        String str = "";
        for (Pet pet : pets){
            if (pet.getOwner().toLowerCase().equals(lowerPetOwner)){
                str+=pets.indexOf(pet) + ": " + pet.toString() + "\n";
            }
            if (str.isEmpty()){
                return "No Pets for " + petOwner;
            }
        }
        return str;
    }
    
    /* Creates teo string to cover the passed Strings to lower case
    Uses a for each loop to scan through the array list. If the pet found at any given index is of the class Dog checks the owner and breed converted to lower case and age.
    If these variables all match returns pet. Otherwise returns null */
    public Pet findDogByOwnerAndBreedAndAge(String petOwner, String breed, int age){
        String lowerPetOwner = petOwner.toLowerCase();
        String lowerBreed = breed.toLowerCase();
        for(Pet pet : pets){
            if (pet instanceof Dog){
                Dog dog = (Dog) pet;
                if ((dog.getOwner().toLowerCase().equals(lowerPetOwner)) && (dog.getBreed().toLowerCase().equals(lowerBreed)) && (dog.getAge() == age)){
                    return pet;
                }
            }
        }
        return null;
    }
    
    /* Creates a string lowerPetName to convert the passed String petName to lower case.
    Uses a for each loop to scan the array list. If lowerPetName equals the stored variable name, converted to lower case using toLowerCase() String method, 
    returns the pet.
    Otherwise returns null */
    public Pet getPet(String petName){
        String lowerPetName = petName.toLowerCase();
        for(Pet pet : pets){
            if(pet.getName().toLowerCase().equals(lowerPetName))
                return pet;
        }
        return null;
    }
    
    // TODO Persistence methods
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
    
    public void save() throws Exception {
        // Sets up the xstream object
        XStream xstream = new XStream(new DomDriver());
        // Writes the data, out denoting save, to the hard coded Pets.xml file.
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Pets.xml"));
        out.writeObject(pets);
        out.close();
    }
}


