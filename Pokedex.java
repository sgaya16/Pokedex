public class Pokedex { //implements PokedexInterface


    //private Pokemon species;
    private String species;
    private Pokemon[] PokedexArray;
    private int size = 0;
    private int numofPokemon;



    public Pokedex(int arraySize) { //takes in the # of pokemon in region from main and sets that # as the size of the PokedexArray
        size = arraySize;
        PokedexArray = new Pokemon[size];
    }

    public Pokedex(String pokeSpecies) { //takes in species name from main class
        this.species = pokeSpecies;
    }


    public String[] listPokemon() { //lists the pokemon that have been added to the Pokedex
        String[] pokemonList = new String[size];
        int i;

        if (numofPokemon == 0) { //returns null if there are no pokemon in the pokedex
            System.out.println("Empty");
            System.out.println();
            return null;
        }

        for (i = 0; i < numofPokemon; ++i) {
            if (PokedexArray[0] == null) { //returns null if the list of Pokemon is empty
                System.out.println("Empty");
                return null;
            }
            else if (PokedexArray[i] == null) {
                return null;
            }
            else {
                while (( i != (numofPokemon - 1))) { //if the pokedex array has values, pokemonList encodes them
                    pokemonList[i] = PokedexArray[i].getSpecies();
                    System.out.println((i + 1) + ". " + pokemonList[i]);
                    ++i;
                }
                if (i == (numofPokemon - 1)) {
                    pokemonList[i] = PokedexArray[i].getSpecies();
                    System.out.println((i + 1) + ". " + pokemonList[i]);
                }
            }
        }
        return pokemonList;
    }


    public boolean addPokemon(String species) { //adds a new pokemon to the pokedexarray
        Pokemon newPoke = new Pokemon(species); //creates a new object in the pokemon class constructor
        newPoke.setSpecies(species);
        String upperCase = species.toUpperCase();

        if (size == 0) {
            System.out.println("Max");
            return false;
        }
        if(numofPokemon == size){
            System.out.println("Max");
            return false;
        }

        for (int i = 0; i < size; ++i) {
            if (PokedexArray[i] == null) { //if the spot i in the array is empty, add the new pokemon
                PokedexArray[i] = newPoke;
                numofPokemon++;
                break;
            }
            if ((i == (size - 1)) && (PokedexArray[i] != null)) { //if the array is full & user tries to add another pokemon
                System.out.println("Max");
                return false;
            }
            else if (species.equalsIgnoreCase(PokedexArray[i].getSpecies())) { //if the userInput species is already in the array
                System.out.println("Duplicate");
                return false;
            }

        }
        return true;
    }


    public int[] checkStats(String species) {
        int[] checkStats = new int[3]; //assigns 3 indices for the 3 stats of the pokemon
        boolean foundPokemon = false;

        if (numofPokemon == 0) { //returns null if there are no pokemon in pokedex
            System.out.println("Missing");
            System.out.println();
            return null;
        }

        for (int i = 0; i < numofPokemon; ++i) {
            if (PokedexArray[0] == null) {
                System.out.println("Empty");
                System.out.println();
                return null;
            }
            if (PokedexArray[i] == null) { //returns null if pokemon of interest is not in the pokedex
                System.out.println("Missing");
                System.out.println();
                return null;
            }
            if (species.equals(PokedexArray[i].getSpecies())) {
                for (int j = 0; j < 3; ++j) {
                    if (j == 0) {
                        checkStats[j] = PokedexArray[i].getAttack(); //attack stat is assigned to i = 0
                    }
                    if (j == 1) {
                        checkStats[j] = PokedexArray[i].getDefense(); //defense stat is assigned to i = 1
                    }
                    if (j == 2) {
                        checkStats[j] = PokedexArray[i].getSpeed(); //pokeName.getSpeed(); //speed stat is assigned to i = 2
                    }
                }
                foundPokemon = true;
                break;
            }
        }

        if (foundPokemon == true) { //if the pokemon is in the pokedex, stats are printed out

            System.out.println("The stats for " + species + " are:"); //print out results
            System.out.println("Attack: " + checkStats[0]);
            System.out.println("Defense: " + checkStats[1]);
            System.out.println("Speed: " + checkStats[2]);
            System.out.println();

            return checkStats;
        }
        else { //otherwise, program returns missing
            System.out.println("Missing");
            System.out.println();
            return null;
        }

    }


    public void sortPokedex() { //sorts the pokemon names in alphabetical order
        int i;
        int j;
        Pokemon tempVar;

        //site where I found a way to approach the alphabetical order sorting:
        //https://www.sanfoundry.com/java-program-sort-names-alphabetical-order/

        for (i = 0; i < numofPokemon; i++) {
            if (PokedexArray[i] == null) { //if there is no pokemon, there is no output
                return;
            }
            for (j = i + 1; j < numofPokemon; j++) {
                if (PokedexArray[j] == null) { //if there is no letter at j, returns null
                    return;
                }
                //compares the letters of the 2 pokemon names while both are lowercase
                if ((PokedexArray[i].getSpecies().toLowerCase()).compareTo(PokedexArray[j].getSpecies().toLowerCase()) > 0) {
                    //if name at index i is greater than at index j, names switch places
                    tempVar = PokedexArray[i];
                    PokedexArray[i] = PokedexArray[j];
                    PokedexArray[j] = tempVar;
                }
            }
        }

    }


    public boolean evolvePokemon(String species) { //evolves pokemon by increasing stats
        boolean foundPokemon = false;

        if (numofPokemon == 0) { //if there are no pokemon, returns false
            System.out.println("Missing");
            System.out.println();
            return false;
        }

        for (int i = 0; i < numofPokemon; ++i) {
            if (PokedexArray[0] == null) { //if the array is null, prints "empty"
                System.out.println("Empty");
                System.out.println();
                return false;
            }
            if (PokedexArray[i] == null) {
                System.out.println("Missing");
                System.out.println();
                return false;
            }
            else if ((species.equals(PokedexArray[i].getSpecies()))) {
                //attack stat is doubled, defense is quadrupled, and speed is tripled through the use of a setter method
                int newAttack = PokedexArray[i].getAttack() * 2;
                int newDefense = PokedexArray[i].getDefense() * 4;
                int newSpeed = PokedexArray[i].getSpeed() * 3;

                PokedexArray[i].setAttack(newAttack);
                PokedexArray[i].setDefense(newDefense);
                PokedexArray[i].setSpeed(newSpeed);
                foundPokemon = true;
                break;
            }

        }

        if (foundPokemon == true) { //if the pokemon is in the pokedex, prints that the pokemon has evolved
            System.out.println(species + " has evolved!");
            System.out.println();
            return true;
        }
        else { //otherwise, prints missing
            System.out.println("Missing");
            System.out.println();
            return false;
        }

    }


}
