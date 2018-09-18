import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    String pokemonInRegion;
    String option;
    String pokemonSpecies = "";
    String pokemonOfInterest = "";
    boolean exitProgram = false;

    System.out.println("Welcome to your new PokeDex!");
    do {
        System.out.print("How many Pokemon are in your region?: ");
        pokemonInRegion = scnr.next(); //takes in the number of pokemon in the region input by user
        System.out.println();

        try { //try-catch if pokemon in region is not an number
            if (!(Character.isDigit(pokemonInRegion.charAt(0)))) {
                throw new Exception("That is not a valid choice. ");
            }

        }
        catch(Exception excptnum) {
            System.out.print(excptnum.getMessage());
            System.out.println("Try again.");
            System.out.println();
        }
    }
    while (!(Character.isDigit(pokemonInRegion.charAt(0))));


    int pokeInRegion = Integer.parseInt(pokemonInRegion);

    Pokedex pokedexSize = new Pokedex(pokeInRegion);

    System.out.println("Your new Pokedex can hold " + pokemonInRegion + " Pokemon. Let's start using it!");
    System.out.println();

    do {
        //menu:
        System.out.println("1. List Pokemon");
        System.out.println("2. Add Pokemon");
        System.out.println("3. Check a Pokemon's Stats");
        System.out.println("4. Evolve Pokemon");
        System.out.println("5. Sort Pokemon");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("What would you like to do? ");
        option = scnr.next(); //takes in user's option choice

        //try-catch statement for wrong option input
        try {
            if (!(Character.isDigit(option.charAt(0)))) {
                throw new Exception("That is not a valid choice. ");
            }
            int optionInt = Integer.parseInt(option);
            if ((optionInt < 1) || (optionInt > 6)) {
                System.out.println();
                throw new Exception("That is not a valid choice. ");
            }
        }
        catch (Exception excpt) {
            System.out.print(excpt.getMessage());
            System.out.println("Try again.");
            System.out.println();
        }
        //option number passes data to pokedex class
        switch (option) {
            case "1": // option 1- list pokemon
                pokedexSize.listPokemon();
                System.out.println();
                break;
            case "2": //option 2- add pokemon
                System.out.println();
                System.out.print("Please enter the Pokemon's Species: ");
                pokemonSpecies = scnr.next();
                pokedexSize.addPokemon(pokemonSpecies);
                System.out.println();
                break;
            case "3": //option 3- check stats
                System.out.println();
                System.out.print("Please enter the Pokemon of interest: ");
                pokemonOfInterest = scnr.next();
                pokedexSize.checkStats(pokemonOfInterest);
                break;
            case "4": //option 4- evolve pokemon
                System.out.println();
                System.out.print("Please enter the Pokemon of interest: ");
                pokemonOfInterest = scnr.next();
                pokedexSize.evolvePokemon(pokemonOfInterest);
                break;
            case "5": //option 5- list pokemon in alphabetical order
                System.out.println();
                pokedexSize.sortPokedex();
                System.out.println();
                break;
            case "6": //option 6- exit program
                exitProgram = true;
                break;
        }
    }
    while (exitProgram == false); //program will continue through until user chooses 6 to exit program


}


}
