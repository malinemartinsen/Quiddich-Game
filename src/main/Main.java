package src.main;

import src.main.models.Game;
import src.main.models.Team;

public class Main {
    static Game game;

    public static void main(String[] args) {
        new Team("GRYFFINDOR", "Oliver", "Harry",
            new String[] {"Angelina", "Ginny", "Katie"});

        new Team("SLYTHERIN", "Vincent", "Draco",
            new String[] {"Bridget", "Harper", "Malcom"});
    }

}
