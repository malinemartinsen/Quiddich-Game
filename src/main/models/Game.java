package src.main.models;

import java.security.KeyStore.Entry;
import java.util.HashMap;

public class Game {
    private HashMap<Team, Integer> scoreboard;
    private static int gameCount;


    // Constructor
    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    // Getters
    public Integer getScore(Team team) {
        return this.scoreboard.get(team);
    }

    public static int getGameCount() {
        return gameCount;
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream()
        .filter((key) -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);
    }

    // Setters
    public void setScore(Team team, Integer score) {
        this.scoreboard.put(team, score);
    }

    
}