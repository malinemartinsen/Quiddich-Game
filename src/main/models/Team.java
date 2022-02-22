package src.main.models;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Set;

public class Team {
    // Fields
    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;
    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    // Constructor
    public Team(String house, String keeper, String seeker, String[] chaser) {
        if (house == null || keeper == null || seeker == null) {
            throw new IllegalArgumentException("Field values cannot be null.");
        }

        if (house.isBlank() || keeper.isBlank() || seeker.isBlank()) {
            throw new IllegalArgumentException("Fields values cannot be blank.");
        }

        if (chasers.length != 3) {
            throw new IllegalArgumentException("Must have three chasers.");
        }
        
        if (hasNull(chasers) || hasBlank(chasers)) {
            throw new IllegalArgumentException("Illegal elements");
        }

        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    // Copy Constructor
    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    // Getters
    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length);
    }
    public String getHouse() {
        return house;
    }
    public String getKeeper() {
        return keeper;
    }
    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }
    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }
    public String getSeeker() {
        return seeker;
    }
    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    // Setters
    public void setChasers(String[] chasers) {
        this.chasers = Arrays.copyOf(chasers, chasers.length);
        if (chasers.length != 3 || hasNull(chasers) || hasBlank(chasers)) {
            throw new IllegalArgumentException("Illegal chaser arguments");
        }
    }
    public void setHouse(String house) {
        checkParameter(house);
        this.house = house;
    }
    public void setKeeper(String keeper) {
        checkParameter(keeper);
        this.keeper = keeper;
    }
    public void setSeeker(String seeker) {
        checkParameter(seeker);
        this.seeker = seeker;

    }

    // Check if field is blank or null-function
    public void checkParameter(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank.");
        }
    }

    // Testing steps hasNull()

    // Step 1, test to make code fail
    // public static boolean hasNull(String[] array) {
    //     return false;
    // }

    // Step 2, create the easiest code to make it work
    // public static boolean hasNull(String[] array) {
    //     for (int i = 0; i < array.length; i++) {
    //         if (array[i] == null) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // Step 3, refactor code
    public static boolean hasNull(String[] array) {
        return Arrays.stream(array).anyMatch((element) -> element == null);
    }

    // Testing hasBlank()
    // Step 1, test to make code fail
    // public static boolean hasBlank(String[] array) {
    //     return false;
    // }

    // Step 2 and 3
    public static boolean hasBlank(String[] array) {
        return Arrays.stream(array).anyMatch((element) -> element.isBlank());
    }

    
    // toString()
    public String toString() {
        return  "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }
    
}