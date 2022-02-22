package src.main;

import src.main.models.Game;
import src.main.models.Team;

public class Main {
    static Game game;

    public static void main(String[] args) {
        Team home = new Team("GRYFFINDOR", "Oliver", "Harry", new String[] {"Angelina", "Ginny", "Katie"});

        Team away = new Team("SLYTHERIN", "Vincent", "Draco", new String[] {"Bridget", "Harper", "Malcom"});

        // Test with creating game
        Game game1 = new Game (home, away);
        Game game2 = new Game (home, away);
        Game game3 = new Game (home, away);

        System.out.println(Game.getGameCount());
    }

}
