public class Pokemon {


    private String species;
    private int attack;
    private int defense;
    private int speed;

    public Pokemon(String species) { //constructor to initialize the input
        this.species = species; //assigns the private string species to be = the parameter species
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }



    public void setSpecies(String pokeName) { //sets name of species
        species = pokeName;
    }

    public String getSpecies() { //another class can get species name from this method
        return species;
    }


    public void setAttack(int newAttack) { //sets the attack stat for an individual pokemon
        attack = newAttack;
    }

    public int getAttack() { //another class can get attack from this method
        return attack;
    }

    public void setDefense(int newDefense) { //sets the defense stat for an individual pokemon
        defense = newDefense;
    }

    public int getDefense() { //another class can get defense from this method
        return defense;
    }

    public void setSpeed(int newSpeed) { //sets the speed stat for an individual pokemon
        speed = newSpeed;
    }

    public int getSpeed() { //another class can get speed from this method
        return speed;
    }










}
