package main;

import controllers.DayCare;
import models.*;
import utils.*;

public class Driver {
    // creates dayCare object
    private DayCare dayCare = new DayCare();
    
    public static void main(String[] args) {
        
        new Driver();
        
    }
    
    public Driver() {
        
        //TODO - load all data
        
        runMenu();
    }
    //----------------------------------------------------------------------------
    // Private methods for displaying the menu and processing the selected options
    //----------------------------------------------------------------------------
    
    
    private int mainMenu() {
        
        //TODO write menu that user will see
        return ScannerInput.readNextInt("""
                    --------Pet Day Care-------
                    |   1) Pets Menu          |
                    |                         |
                    |   2) Reports Menu       |
                    |-------------------------|
                    |   3) Search Pets        |
                    |                         |
                    |   4) Count Pets         |
                    |-------------------------|
                    |   5) Save Pets          |
                    |   6) Load Pets          |
                    |-------------------------|
                    |   0) Exit               |
                    ---------------------------
                    ==>> """);
        }
        
        private void runMenu() {
            
            int option = mainMenu();
            while (option != 0){
                
                switch (option){
                    case 1 -> petsMenu();
                    case 2 -> reportsMenu();
                    case 3 -> searchPets();
                    case 4 -> countPets();
                    case 5 -> savePets();
                    case 6 -> loadPets();
                    default -> System.out.println("Invalid option entered: " + option);
                }
                ScannerInput.readNextLine("\nPress enter key to continue...");
                
                option = mainMenu();
            }
            exitApp();
            
        }
        
        private void exitApp() {
            
            System.out.println("Exiting....");
            System.exit(0);
        }
        
        //todo update methods counting methods
        
        
        //---------------------
        //  General Menu Items
        //---------------------
        
        //----------------------
        //  Option 1 - Pet Menu
        //----------------------
        private void petsMenu(){
            int option = ScannerInput.readNextInt("""
                    ----------Pets Menu--------
                    |   1) Add a Pet          |
                    |   2) Update a Pet       |
                    |   3) Delete a Pet       |
                    |   4) List all Pets      |
                    |-------------------------|
                    |  0) return to main menu |
                    ---------------------------
                    ==>> """);
                
                switch (option) {
                    case 1 -> addPet();
                    case 2 -> updatePet();
                    case 3 -> deletePet();
                    case 4 -> listPets();
                    case 0 -> runMenu();
                    default -> System.out.println("Invalid option entered: " + option);
                }
            }
            private void addPet(){
                
                boolean isAdded = false;
                
                int option = ScannerInput.readNextInt("""
                    ----------Add Pet----------
                    |   1) Add Dog            |
                    |   2) Add Cat            |
                    ---------------------------
                    ==>> """);
                    
                    switch(option){
                        case 1 -> {
                            String name = ScannerInput.readNextLine("Enter the name of the dog: ");
                            String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                            int age = ScannerInput.readNextInt("Enter age: ");
                            String breed = ScannerInput.readNextLine("Enter breed: ");
                            // creates a boolean array to store true and false values for days attending
                            boolean[] daysAttending = new boolean[5];
                            // creates a String array dayNames to store the days of the week to be printed when asking the user to if the pet is attending.
                            String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                            /* for loop asking the user to input Y or N to confirm if a pet is or isn't attending the kennel on a certain day.
                            char input uses ScannerInput to read the input from the user.
                            dayNames[i] is used to update the day of the week from the array each time the code loops.
                            daysAttending[i] stores the input converted to a boolean using the YNtoBoolean method from the Utilities class at the current array index */
                            for (int i = 0; i < 5; i++){
                                char input = ScannerInput.readNextChar("Is the dog in the kennel on " + dayNames[i] + "? (Y/N): ");
                                daysAttending[i] = Utilities.YNtoBoolean(input);
                            }
                            char sex = ScannerInput.readNextChar("Is the dog male or female? (M/F): ");
                            char input = ScannerInput.readNextChar("Is the dog a dangerous bread? (Y/N): ");
                            boolean dangerousBreed = Utilities.YNtoBoolean(input);
                            input = ScannerInput.readNextChar("Is the dog neutered? (Y/N): ");
                            boolean neutered = Utilities.YNtoBoolean(input);
                            // sets boolean isAdded to the return value of the addPet method in dayCare.
                            isAdded = dayCare.addPet(new Dog(name, owner, age, daysAttending, sex, breed, dangerousBreed, neutered));
                        }
                        case 2 ->{
                            String name = ScannerInput.readNextLine("Enter the name of the cat: ");
                            String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                            int age = ScannerInput.readNextInt("Enter age: ");
                            
                            boolean[] daysAttending = new boolean[5];
                            String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                            for (int i = 0; i < 5; i++){
                                char input = ScannerInput.readNextChar("Is the cat in the kennel on " + dayNames[i] + "? (Y/N): ");
                                daysAttending[i] = utils.Utilities.YNtoBoolean(input);
                            }
                            char sex = ScannerInput.readNextChar("Is the cat male or female? (M/F): ");
                            char input = ScannerInput.readNextChar("Is the cat an indoor cat? (Y/N): ");
                            boolean indoorCat = utils.Utilities.YNtoBoolean(input);
                            String favouriteToy = ScannerInput.readNextLine("Favourite toy: ");
                            isAdded = dayCare.addPet(new Cat(name, owner, age, daysAttending, sex, indoorCat, favouriteToy));
                        }
                        default -> System.out.println("Invalid option entered: " + option);
                        
                    }
                    // if the return value of addPet from the DayCare class is true prints the below string.
                    if (isAdded){
                        System.out.println("Pet successfully added");
                    }
                    // if the return value of addPet from the DayCare class is not true prints the below string. 
                    else{
                        System.out.println("No pet added");
                    }
                }
                private void updatePet(){
                    if (dayCare.numberOfPets() > 0) {
                        boolean isUpdated = false;
                        int option = ScannerInput.readNextInt("""
                    ---------Pet Update-----------
                    |   1) Update a Dog          |
                    |   2) Update a Cat          |
                    ------------------------------
                    ==>> """);
                            
                            switch (option){
                                case 1 -> {
                                    listDogs();
                                    if(dayCare.numberOfDogs() > 0) {
                                        int idToUpdate = ScannerInput.readNextInt("Enter the ID of the pet to update ==> ");
                                        if(!dayCare.isValidId(idToUpdate)) {
                                            String name = ScannerInput.readNextLine("Enter the name of the dog: ");
                                            String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                                            int age = ScannerInput.readNextInt("Enter age: ");
                                            String breed = ScannerInput.readNextLine("Enter breed: ");
                                            
                                            boolean[] daysAttending = new boolean[5];
                                            String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                                            for (int i = 0; i < 5; i++){
                                                char input = ScannerInput.readNextChar("Is the dog in the kennel on " + dayNames[i] + "? (Y/N): ");
                                                daysAttending[i] = utils.Utilities.YNtoBoolean(input);
                                            }
                                            char sex = ScannerInput.readNextChar("Is the dog male or female? (M/F): ");
                                            char input = ScannerInput.readNextChar("Is the dog a dangerous breae? (Y/N): ");
                                            boolean dangerousBreed = utils.Utilities.YNtoBoolean(input);
                                            input = ScannerInput.readNextChar("Is the dog neutered? (Y/N): ");
                                            boolean neutered = utils.Utilities.YNtoBoolean(input);
                                            isUpdated = dayCare.updateDog(idToUpdate, new Dog(name, owner, age, daysAttending, sex, breed, dangerousBreed, neutered));
                                        }
                                    }
                                }
                                case 2 -> {
                                    listCats();
                                    if(dayCare.numberOfCats() > 0){
                                        int idToUpdate = ScannerInput.readNextInt("Enter the ID of the pet to update ==> ");
                                        if(!dayCare.isValidId(idToUpdate)) {
                                            String name = ScannerInput.readNextLine("Enter the name of the cat: ");
                                            String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                                            int age = ScannerInput.readNextInt("Enter age: ");
                                            
                                            boolean[] daysAttending = new boolean[5];
                                            String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                                            for (int i = 0; i < 5; i++){
                                                char input = ScannerInput.readNextChar("Is the cat in the kennel on " + dayNames[i] + "? (Y/N): ");
                                                daysAttending[i] = utils.Utilities.YNtoBoolean(input);
                                            }
                                            char sex = ScannerInput.readNextChar("Is the cat male or female? (M/F): ");
                                            char input = ScannerInput.readNextChar("Is the cat an indoor cat? (Y/N): ");
                                            boolean indoorCat = utils.Utilities.YNtoBoolean(input);
                                            String favouriteToy = ScannerInput.readNextLine("Favourite toy: ");
                                            isUpdated = dayCare.updateCat(idToUpdate, new Cat(name, owner, age, daysAttending, sex, indoorCat, favouriteToy));
                                        }
                                    }
                                }
                                default -> System.out.println("Invalid option entered: " + option);
                            }
                            if (isUpdated) {
                                System.out.println("Pet Updated Successfully");
                            } else {
                                System.out.println("No pet Updated");
                            }
                        }
                        else{
                            System.out.println("No pets added yet");
                        }
                    }
                    
                    private void deletePet(){
                        if (dayCare.numberOfPets() > 0) {
                            int option = ScannerInput.readNextInt("""
                    ---------Delete Pet---------
                    |   1) Delete pet by ID    |
                    |   2) Delete pet by index |
                    ---------------------------
                    ==>> """);
                                switch (option){
                                    case 1 -> {
                                        //prints a list of pets in the array.
                                        listPets();
                                        //enters if statement if the number of pets stored in the array list is greater than 0.
                                        if (dayCare.numberOfPets() > 0){
                                            //Reads the next int entered by the user and stores it in the variable idToDelete
                                            int idToDelete = ScannerInput.readNextInt("Enter ID of pet to be deleted ==> ");
                                            //Creates a variable Pet called petToDelete. calss the deletePetId method from DayCare and passes idToDelete
                                            Pet petToDelete = dayCare.deletePetId(idToDelete);
                                            //If petToDelete is not null prints the message to the terminal along with the toString of the pet deleted.
                                            if (petToDelete != null){
                                                System.out.println("Delete Successful! Deleted Pet: " + petToDelete.toString());
                                            }
                                            else {
                                                System.out.println("Delete NOT successful");
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        //prints a list of all pets in the array list
                                        listPets();
                                        if(dayCare.numberOfPets() > 0){
                                            int indexToDelete = ScannerInput.readNextInt("Enter Index of pet to delete ==>");
                                            Pet petToDelete = dayCare.deletePetIndex(indexToDelete);
                                            if (petToDelete != null){
                                                System.out.println("Delete Successful! Deleted Pet: " + petToDelete.toString());
                                            }
                                            else {
                                                System.out.println("Delete NOT sucessful");
                                            }
                                        }
                                    }
                                    default -> System.out.println("Invalid option entered: " + option);
                                }
                            }
                        }
                        //--------------------------
                        //  Option 2 - Reports Menu
                        //--------------------------
                        private void reportsMenu(){
                            if (dayCare.numberOfPets() > 0) {
                                int option = ScannerInput.readNextInt("""
                                    --------------------Reports Menu----------------
                                    |   1) List all pets                           |
                                    |   2) List all dogs                           |
                                    |   3) List all cats                           |
                                    |   4) List all dangerous dogs                 |
                                    |   5) List indoor cats                        |
                                    |   6) List all dogs older than a certain age  |
                                    |   7) List all cats by favourite toy          |
                                    |   8) List all neutered dogs                  |
                                    |   9) Produce weekly income report            |
                                    ------------------------------------------------
                                    ==>""");
                                    switch (option) {
                                        case 1 -> listPets();
                                        case 2 -> listDogs();
                                        case 3 -> listCats();
                                        case 4 -> listDangerousDogs();
                                        case 5 -> listIndoorCats();
                                        case 6 -> listDogsOverAge();
                                        case 7 -> listCatsByToy();
                                        case 8 -> listNeuteredDogs();
                                        case 9 -> weeklyIncome();
                                        default -> System.out.println("Invalid option entered: " + option);
                                    }
                                }
                                else System.out.println("Option Invalid - No pets stored");
                            }
                            
                            private void listPets(){
                                System.out.println("List of all Pets: ");
                                System.out.println(dayCare.listAllPets());
                            }
                            
                            private void listDogs(){
                                System.out.println("List of all Dogs: ");
                                System.out.println(dayCare.listAllDogs());
                            }
                            
                            private void listCats(){
                                System.out.println("List of all Cats: ");
                                System.out.println(dayCare.listAllCats());
                            }
                            
                            private void listDangerousDogs(){
                                System.out.println("List of Dangerous Dogs: ");
                                System.out.println(dayCare.listAllDangerousDogs());
                            }
                            
                            private void listIndoorCats(){
                                System.out.println("List of Indoor Cats: ");
                                System.out.println(dayCare.listAllIndoorCats());
                            }
                            
                            private void listDogsOverAge(){
                                int age = ScannerInput.readNextInt("Enter minimum age: ");
                                System.out.println("List of dogs older than " + age + "years old: ");
                                System.out.println(dayCare.listDogsOverAge(age));
                            }
                            private void listCatsByToy(){
                                String favouriteToy = ScannerInput.readNextLine("Enter favourite Toy: ");
                                System.out.println("List of cats with favourite toy" + favouriteToy + ": ");
                                System.out.println(dayCare.listCatsByToy(favouriteToy));
                            }
                            
                            private void listNeuteredDogs(){
                                System.out.println("List of NeuteredDogs: ");
                                System.out.println(dayCare.listAllNeuteredDogs());
                            }
                            
                            private void weeklyIncome(){
                                System.out.println("Weekly income is: €" + dayCare.getWeeklyIncome());
                            }
                            
                            
                            //---------------------
                            //  Option 3 - Search
                            //---------------------
                            // TODO search by different criteria i.e. look at the list methods and give options based on that.
                            private void searchPets(){
                                if (dayCare.numberOfPets() > 0) {
                                    int option = ScannerInput.readNextInt("""
                                        ---------------Pet Search------------------
                                        |   1) Search pets by Index               |
                                        |   2) Search pets by ID                  |
                                        |   3) Search pets by owner               |
                                        |   4) Search pets by owner, breed & age  |
                                        -------------------------------------------
                                        ==>> """);                                
                                        switch (option){
                                            case 1 -> searchByIndex();
                                            case 2 -> searchById();
                                            case 3 -> searchByOwner();
                                            case 4 -> searchByOwnerBreedAge();
                                            default -> System.out.println("Invalid option entered: " + option);
                                        }
                                    }
                                    else System.out.println("Option Invalid - No pets stored");
                                }
                                
                                private void searchByIndex(){
                                    int indexToGet = ScannerInput.readNextInt("Enter index: ");
                                    System.out.println(dayCare.getPetByIndex(indexToGet));
                                }
                                
                                private void searchById(){
                                    int idToGet = ScannerInput.readNextInt("Enter ID: ");
                                    System.out.println(dayCare.getPetById(idToGet));
                                }
                                
                                private void searchByOwner(){
                                    String ownerToSearch = ScannerInput.readNextLine("Enter owner: ");
                                    System.out.println(dayCare.getPetsByOwnersName(ownerToSearch));
                                }
                                
                                private void searchByOwnerBreedAge(){
                                    String ownerToSearch = ScannerInput.readNextLine("Enter owner: ");
                                    String breedToSearch = ScannerInput.readNextLine("Enter breed: ");
                                    int ageToSearch = ScannerInput.readNextInt("Enter age: ");
                                    System.out.println(dayCare.findDogByOwnerAndBreedAndAge(ownerToSearch, breedToSearch, ageToSearch));
                                }
                                
                                //---------------------
                                //  Option 3 - Count
                                //---------------------
                                private void countPets(){
                                    if (dayCare.numberOfPets() > 0) {
                                        int option = ScannerInput.readNextInt("""
                                        -----------------Count Pets----------------
                                        |   1) Average number of days per week    |
                                        |   2) Number of Pets                     |
                                        |   3) Number of Dogs                     |
                                        |   4) Number of Cats                     |
                                        |   5) Number of Dangerous Dogs           |
                                        |   6) Number of Indoor Cats              |          
                                        -------------------------------------------
                                        ==>> """);                                
                                            switch (option){
                                                case 1 -> averageNumOfDays();
                                                case 2 -> numOfPets();
                                                case 3 -> numOfDogs();
                                                case 4 -> numOfCats();
                                                case 5 -> numOfDangerousDogs();
                                                case 6 -> numOfIndoorCats();
                                                default -> System.out.println("Invalid option entered: " + option);
                                            }
                                        }
                                    }
                                    
                                    private void averageNumOfDays(){
                                        System.out.println(dayCare.getAverageNumDaysPerWeek() + " days");
                                    }
                                    
                                    private void numOfPets(){
                                        System.out.println(dayCare.numberOfPets() + " pets");
                                    }
                                    
                                    private void numOfDogs(){
                                        System.out.println(dayCare.numberOfDogs() + " dogs");
                                    }
                                    
                                    private void numOfCats(){
                                        System.out.println(dayCare.numberOfCats() + " cats");
                                    }
                                    
                                    private void numOfDangerousDogs(){
                                        System.out.println(dayCare.numberOfDangerousDogs() + " dangerous dogs");
                                    }
                                    
                                    private void numOfIndoorCats(){
                                        System.out.println(dayCare.numberOfIndoorCats());
                                    }
                                    
                                    //---------------------------------------
                                    //  Options 5 and 6 - Save and Load Pets
                                    //---------------------------------------
                                    
                                    private void savePets(){
                                        try {
                                            dayCare.save();
                                        } catch (Exception e){
                                            System.err.println("Error writing to file: " + e);
                                        }
                                    }
                                    
                                    private void loadPets(){
                                        try {
                                            dayCare.load();
                                        } catch (Exception e) {
                                            System.err.println("Error reading from file: " + e);
                                        }
                                    }
                                    
                                    //---------------------
                                    //  Helper Methods
                                    //---------------------
                                    
                                    //TODO- write any helper methods that are required
                                    
                                }
                                