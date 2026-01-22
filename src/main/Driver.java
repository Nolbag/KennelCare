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
                    // If an invalid option is entered prints the below String followed by the option entered
                    default -> System.out.println("Invalid option entered: " + option);
                }
            }
            private void addPet(){
                // Creates boolean isAdded and sets it to false as default.
                boolean isAdded = false;
                
                int option = ScannerInput.readNextInt("""
                    ----------Add Pet----------
                    |   1) Add Dog            |
                    |   2) Add Cat            |
                    ---------------------------
                    ==>> """);
                    
                    switch(option){
                        case 1 -> {
                            // Reads next String input by the user and stores it as name
                            String name = ScannerInput.readNextLine("Enter the name of the dog: ");
                            // Reads next String input by the user and stores it as owner
                            String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                            // Reads next int input by the user and stores it as age
                            int age = ScannerInput.readNextInt("Enter age: ");
                            // Reads next String input by the user and stores it as breed
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
                            // Reads next char input by the user and stores it as sex
                            char sex = ScannerInput.readNextChar("Is the dog male or female? (M/F): ");
                            // Reads next char input by the user and stores it as input
                            char input = ScannerInput.readNextChar("Is the dog a dangerous bread? (Y/N): ");
                            // Calls YNtoBoolean from Utilities class and pass char input. Stores returned boolean as dangerousBreed
                            boolean dangerousBreed = Utilities.YNtoBoolean(input);
                            // Reads next char input by the user and stores it as input
                            input = ScannerInput.readNextChar("Is the dog neutered? (Y/N): ");
                            // Calls YNtoBoolean from Utilities class and pass char input. Stores returned boolean as neutered
                            boolean neutered = Utilities.YNtoBoolean(input);
                            // Calls addPet from DayCare class and passes the variables obtained above. Stores returned value as boolean isAdded.
                            isAdded = dayCare.addPet(new Dog(name, owner, age, daysAttending, sex, breed, dangerousBreed, neutered));
                        }
                        case 2 ->{
                            // Reads next String input by the user and stores it as name
                            String name = ScannerInput.readNextLine("Enter the name of the cat: ");
                            // Reads next String input by the user and stores it as owner
                            String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                            // Reads next int input by the user and stores it as age
                            int age = ScannerInput.readNextInt("Enter age: ");
                            // creates a boolean array to store true and false values for days attending
                            boolean[] daysAttending = new boolean[5];
                            // creates a String array dayNames to store the days of the week to be printed when asking the user to if the pet is attending.
                            String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                            /* for loop asking the user to input Y or N to confirm if a pet is or isn't attending the kennel on a certain day.
                            char input uses ScannerInput to read the input from the user.
                            dayNames[i] is used to update the day of the week from the array each time the code loops.
                            daysAttending[i] stores the input converted to a boolean using the YNtoBoolean method from the Utilities class at the current array index */
                            for (int i = 0; i < 5; i++){
                                char input = ScannerInput.readNextChar("Is the cat in the kennel on " + dayNames[i] + "? (Y/N): ");
                                daysAttending[i] = utils.Utilities.YNtoBoolean(input);
                            }
                            // Reads next char input by the user and stores it as sex
                            char sex = ScannerInput.readNextChar("Is the cat male or female? (M/F): ");
                            // Reads next char input by the user and stores it as input
                            char input = ScannerInput.readNextChar("Is the cat an indoor cat? (Y/N): ");
                            // Calls YNtoBoolean from Utilities class and pass char input. Stores returned boolean as indoorCat
                            boolean indoorCat = utils.Utilities.YNtoBoolean(input);
                            // Calls and prints getCatToys from CatToyUtility class.
                            System.out.println(CatToyUtility.getCatToys());
                            // Reads next String input by the user and stores it as favouriteToy
                            String favouriteToy = ScannerInput.readNextLine("Enter a favourite toy from the above list: ");
                            // Calls addPet from DayCare class and passes the variables obtained above. Stores returned value as boolean isAdded.
                            isAdded = dayCare.addPet(new Cat(name, owner, age, daysAttending, sex, indoorCat, favouriteToy));
                        }
                        // If an invalid option is entered prints the below String followed by the option entered
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
                                    // Call the listDogs method
                                    listDogs();
                                    // If the number of dogs in the ArrayList is greater than 0 enters the if statement
                                    if(dayCare.numberOfDogs() > 0) {
                                        // Reads the next int input by the user and stores it as iDToUpdate
                                        int idToUpdate = ScannerInput.readNextInt("Enter the ID of the pet to update ==> ");
                                        // Reads next String input by the user and stores it as name
                                        String name = ScannerInput.readNextLine("Enter the name of the dog: ");
                                        // Reads next String input by the user and stores it as owner
                                        String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                                        // Reads next int input by the user and stores it as age
                                        int age = ScannerInput.readNextInt("Enter age: ");
                                        // Reads next String input by the user and stores it as breed
                                        String breed = ScannerInput.readNextLine("Enter breed: ");
                                        // creates a boolean array to store true and false values for days attending
                                        // creates a String array dayNames to store the days of the week to be printed when asking the user to if the pet is attending.
                                        boolean[] daysAttending = new boolean[5];
                                        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                                        /* for loop asking the user to input Y or N to confirm if a pet is or isn't attending the kennel on a certain day.
                                        char input uses ScannerInput to read the input from the user.
                                        dayNames[i] is used to update the day of the week from the array each time the code loops.
                                        daysAttending[i] stores the input converted to a boolean using the YNtoBoolean method from the Utilities class at the current array index */
                                        for (int i = 0; i < 5; i++){
                                            char input = ScannerInput.readNextChar("Is the dog in the kennel on " + dayNames[i] + "? (Y/N): ");
                                            daysAttending[i] = utils.Utilities.YNtoBoolean(input);
                                        }
                                        // Reads next char input by the user and stores it as sex
                                        char sex = ScannerInput.readNextChar("Is the dog male or female? (M/F): ");
                                        // Reads next char input by the user and stores it as input
                                        char input = ScannerInput.readNextChar("Is the dog a dangerous bread? (Y/N): ");
                                        // Calls YNtoBoolean from Utilities class and pass char input. Stores returned boolean as dangerousBreed
                                        boolean dangerousBreed = utils.Utilities.YNtoBoolean(input);
                                        // Reads next char input by the user and stores it as input
                                        input = ScannerInput.readNextChar("Is the dog neutered? (Y/N): ");
                                        // Calls YNtoBoolean from Utilities class and pass char input. Stores returned boolean as neutered
                                        boolean neutered = utils.Utilities.YNtoBoolean(input);
                                        // Calls updateDog from DayCare class and passes the variables obtained above. Stores returned value as boolean isUpdated.
                                        isUpdated = dayCare.updateDog(idToUpdate, new Dog(name, owner, age, daysAttending, sex, breed, dangerousBreed, neutered));
                                    }
                                }
                                case 2 -> {
                                    // Call the listCats method
                                    listCats();
                                    // If the number of cats in the ArrayList is greater than 0 enters the if statement
                                    if(dayCare.numberOfCats() > 0){
                                        // Reads the next int input by the user and stores it as iDToUpdate
                                        int idToUpdate = ScannerInput.readNextInt("Enter the ID of the pet to update ==> ");
                                        // Reads next String input by the user and stores it as name
                                        String name = ScannerInput.readNextLine("Enter the name of the cat: ");
                                        // Reads next String input by the user and stores it as owner
                                        String owner = ScannerInput.readNextLine("Enter the name of the owner: ");
                                        // Reads next int input by the user and stores it as age
                                        int age = ScannerInput.readNextInt("Enter age: ");
                                        // creates a boolean array to store true and false values for days attending
                                        boolean[] daysAttending = new boolean[5];
                                        // creates a String array dayNames to store the days of the week to be printed when asking the user to if the pet is attending.
                                        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                                        /* for loop asking the user to input Y or N to confirm if a pet is or isn't attending the kennel on a certain day.
                                        char input uses ScannerInput to read the input from the user.
                                        dayNames[i] is used to update the day of the week from the array each time the code loops.
                                        daysAttending[i] stores the input converted to a boolean using the YNtoBoolean method from the Utilities class at the current array index */
                                        for (int i = 0; i < 5; i++){
                                            char input = ScannerInput.readNextChar("Is the cat in the kennel on " + dayNames[i] + "? (Y/N): ");
                                            daysAttending[i] = utils.Utilities.YNtoBoolean(input);
                                        }
                                        // Reads next char input by the user and stores it as sex
                                        char sex = ScannerInput.readNextChar("Is the cat male or female? (M/F): ");
                                        // Reads next char input by the user and stores it as input
                                        char input = ScannerInput.readNextChar("Is the cat an indoor cat? (Y/N): ");
                                        // Calls YNtoBoolean from Utilities class and pass char input. Stores returned boolean as indoorCat
                                        boolean indoorCat = utils.Utilities.YNtoBoolean(input);
                                        // Calls and prints getCatToys from CatToyUtility class.
                                        System.out.println(CatToyUtility.getCatToys());
                                        // Reads next String input by the user and stores it as favouriteToy
                                        String favouriteToy = ScannerInput.readNextLine("Enter a favourite toy from the above list: ");
                                        // Calls updateCat from DayCare class and passes the variables obtained above. Stores returned value as boolean isUpdated.
                                        isUpdated = dayCare.updateCat(idToUpdate, new Cat(name, owner, age, daysAttending, sex, indoorCat, favouriteToy));
                                    }
                                }
                                // If an invalid option is entered prints the below String followed by the option entered
                                default -> System.out.println("Invalid option entered: " + option);
                            }
                            // If isUpdated is true enters the if statement and prints out a confirmation message
                            if (isUpdated) {
                                System.out.println("Pet Updated Successfully");
                            // Otherwise prints message stating no pet updated.
                            } else {
                                System.out.println("No pet Updated");
                            }
                        }
                        else{
                            // If the ArrayList is empty prints the below String
                            System.out.println("No pets added yet");
                        }
                    }
                    
                    private void deletePet(){
                        // Enters the if statement if there are pets in the ArrayList
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
                                            //Creates a variable Pet called petToDelete. Calls the deletePetId method from DayCare and passes idToDelete
                                            Pet petToDelete = dayCare.deletePetId(idToDelete);
                                            //If petToDelete is not null prints the message to the terminal along with the toString of the pet deleted.
                                            if (petToDelete != null){
                                                System.out.println("Delete Successful! Deleted Pet: " + petToDelete.toString());
                                            }
                                            // Otherwise prints the below message
                                            else {
                                                System.out.println("Delete NOT successful");
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        //prints a list of all pets in the array list
                                        listPets();
                                        // Enters the if statement if the number of pets in the ArrayList isn't zero.
                                        if(dayCare.numberOfPets() > 0){
                                            // Reads the next int input by the user and stores it as indexToDelete
                                            int indexToDelete = ScannerInput.readNextInt("Enter Index of pet to delete ==>");
                                            // Sets the pet object petToDelete to the value returned by deletePetIndex in the DayCare class.
                                            Pet petToDelete = dayCare.deletePetIndex(indexToDelete);
                                            // Enters the if statement if petToDelete is not empty
                                            if (petToDelete != null){
                                                // Prints confirmation message and toString for the pet deleted.
                                                System.out.println("Delete Successful! Deleted Pet: " + petToDelete.toString());
                                            }
                                            else {
                                                // Prints unsuccessful message if the if statement condition isn't met.
                                                System.out.println("Delete NOT successful");
                                            }
                                        }
                                    }
                                    // If an invalid option is entered prints the below String followed by the option entered
                                    default -> System.out.println("Invalid option entered: " + option);
                                }
                            }
                        }
                        //--------------------------
                        //  Option 2 - Reports Menu
                        //--------------------------
                        private void reportsMenu(){
                            //If the number of pets in the ArrayList if greater than zero enters the if statement
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
                                // If an invalid option is entered prints the below String followed by the option entered
                                else System.out.println("Option Invalid - No pets stored");
                            }
                            
                            private void listPets(){
                                System.out.println("List of all Pets: ");
                                // Calls listAllPets from DayCare class and prints the returned string.
                                System.out.println(dayCare.listAllPets());
                            }
                            
                            private void listDogs(){
                                System.out.println("List of all Dogs: ");
                                // Calls listAllDogs from DayCare class and prints the returned string.
                                System.out.println(dayCare.listAllDogs());
                            }
                            
                            private void listCats(){
                                System.out.println("List of all Cats: ");
                                // Calls listAllCats from DayCare class and prints the returned string.
                                System.out.println(dayCare.listAllCats());
                            }
                            
                            private void listDangerousDogs(){
                                System.out.println("List of Dangerous Dogs: ");
                                // Calls listAllDangerousDogs from DayCare class and prints the returned string.
                                System.out.println(dayCare.listAllDangerousDogs());
                            }
                            
                            private void listIndoorCats(){
                                System.out.println("List of Indoor Cats: ");
                                // Calls listAllIndoorCats from DayCare class and prints the returned string.
                                System.out.println(dayCare.listAllIndoorCats());
                            }
                            
                            private void listDogsOverAge(){
                                // Reads in an int from the user.
                                int age = ScannerInput.readNextInt("Enter minimum age: ");
                                System.out.println("List of dogs older than " + age + "years old: ");
                                // Calls listDogsOverAge from DayCare class, passes the int age and prints the String returned from the method.
                                System.out.println(dayCare.listDogsOverAge(age));
                            }
                            private void listCatsByToy(){
                                // Reads in a String from the user.
                                String favouriteToy = ScannerInput.readNextLine("Enter favourite Toy: ");
                                System.out.println("List of cats with favourite toy" + favouriteToy + ": ");
                                // Passes the String favouriteToy to the method listCatsByToy in DayCare class and prints the returned String.
                                System.out.println(dayCare.listCatsByToy(favouriteToy));
                            }
                            
                            private void listNeuteredDogs(){
                                System.out.println("List of NeuteredDogs: ");
                                // Calls listAllNeuteredDogs from DayCare class and prints the returned string.
                                System.out.println(dayCare.listAllNeuteredDogs());
                            }
                            
                            private void weeklyIncome(){
                                // Calls getWeeklyIncome from DayCare class and prints the below String followed by the returned value.
                                System.out.println("Weekly income is: €" + dayCare.getWeeklyIncome());
                            }
                            
                            
                            //---------------------
                            //  Option 3 - Search
                            //---------------------
                            // TODO search by different criteria i.e. look at the list methods and give options based on that.
                            private void searchPets(){
                                // If the number of pets in the ArrayList is greater than 0 enters the if statement
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
                                            // If an invalid option is entered prints the below String followed by the option entered
                                            default -> System.out.println("Invalid option entered: " + option);
                                        }
                                    }
                                    // If no pets are stored in the ArrayList prints the below String
                                    else System.out.println("Option Invalid - No pets stored");
                                }
                                
                                private void searchByIndex(){
                                    // Reads the next int entered by the user
                                    int indexToGet = ScannerInput.readNextInt("Enter index: ");
                                    // Calls getPetByIndex from DayCare class and passes int indexToGet. Prints the value returned.
                                    System.out.println(dayCare.getPetByIndex(indexToGet));
                                }
                                
                                private void searchById(){
                                    // Reads the next int entered by the user
                                    int idToGet = ScannerInput.readNextInt("Enter ID: ");
                                    // Calls getPetById from DayCare class and passes int idToGet. Prints the value returned.
                                    System.out.println(dayCare.getPetById(idToGet));
                                }
                                
                                private void searchByOwner(){
                                    // Reads the next String entered by the user
                                    String ownerToSearch = ScannerInput.readNextLine("Enter owner: ");
                                    // Calls getPetByOwnerName from DayCare class and passes int idToGet. Prints the value returned.
                                    System.out.println(dayCare.getPetsByOwnersName(ownerToSearch));
                                }
                                
                                private void searchByOwnerBreedAge(){
                                    // Reads the next String entered by the user and stores it in String ownerToSearch
                                    String ownerToSearch = ScannerInput.readNextLine("Enter owner: ");
                                    // Reads the next String entered by the user and stores it in String breedToSearch
                                    String breedToSearch = ScannerInput.readNextLine("Enter breed: ");
                                    // Reads the next int entered by the user and stores it in int ageToSearch
                                    int ageToSearch = ScannerInput.readNextInt("Enter age: ");
                                    // Passes the variables obtained above to the method findDogByOwnerAndBreedAndAge in the DayCare class and prints the returned value
                                    System.out.println(dayCare.findDogByOwnerAndBreedAndAge(ownerToSearch, breedToSearch, ageToSearch));
                                }
                                
                                //---------------------
                                //  Option 3 - Count
                                //---------------------
                                private void countPets(){
                                    // If the number of pets in the ArrayList is greater than 0 enters the if statement
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
                                                // If an invalid option is entered prints the below String followed by the option entered
                                                default -> System.out.println("Invalid option entered: " + option);
                                            }
                                        }
                                    }
                                    
                                    private void averageNumOfDays(){
                                        // Calls getAverageNumDaysPerWeek from the DayCare class and prints the returned value followed by the String below
                                        System.out.println(dayCare.getAverageNumDaysPerWeek() + " days");
                                    }
                                    
                                    private void numOfPets(){
                                        // Calls numberOfPets from the DayCare class and prints the returned value followed by the String below
                                        System.out.println(dayCare.numberOfPets() + " pets");
                                    }
                                    
                                    private void numOfDogs(){
                                        // Calls numberOfDogs from the DayCare class and prints the returned value followed by the String below
                                        System.out.println(dayCare.numberOfDogs() + " dogs");
                                    }
                                    
                                    private void numOfCats(){
                                        // Calls numOfCats from the DayCare class and prints the returned value followed by the String below
                                        System.out.println(dayCare.numberOfCats() + " cats");
                                    }
                                    
                                    private void numOfDangerousDogs(){
                                        // Calls numOfDangerousDogs from the DayCare class and prints the returned value followed by the String below
                                        System.out.println(dayCare.numberOfDangerousDogs() + " dangerous dogs");
                                    }
                                    
                                    private void numOfIndoorCats(){
                                        // Calls numOfIndoorCats from the DayCare class and prints the returned value followed by the String below
                                        System.out.println(dayCare.numberOfIndoorCats());
                                    }
                                    
                                    //---------------------------------------
                                    //  Options 5 and 6 - Save and Load Pets
                                    //---------------------------------------
                                    
                                    private void savePets(){
                                        try {
                                            // Calls save method from the DayCare class
                                            dayCare.save();
                                            // Catches and handles exceptions
                                        } catch (Exception e){
                                            //Prints error message
                                            System.err.println("Error writing to file: " + e);
                                        }
                                    }
                                    
                                    private void loadPets(){
                                        try {
                                            // Calls load method from the DayCare class
                                            dayCare.load();
                                            // Catches and handles exceptions
                                        } catch (Exception e) {
                                            //Prints error message
                                            System.err.println("Error reading from file: " + e);
                                        }
                                    }
                                    
                                    //---------------------
                                    //  Helper Methods
                                    //---------------------
                                    
                                    //TODO- write any helper methods that are required
                                    
                                }
                                