package src.main.models;

import java.util.HashMap;

public class Game {
    private HashMap<Team, Integer> scoreboard;
    private static int gameCount;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;


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

    public static int getQuafflePoints() {
        return QUAFFLE_POINTS;
    }

    public HashMap<Team, Integer> getScoreboard() {
        return scoreboard;
    }

    public static int getSnitchPoints() {
        return SNITCH_POINTS;
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream()
        .filter((key) -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);
    }

    // Setters
    public void setScore(Team team, Integer score) {
        if (team == null) {
            throw new IllegalArgumentException("Cannot add null to the scoreboard.");
        }
        this.scoreboard.put(team, score);
    }

    // Testing

    // Test 1: Test if it can find the placeholder in each play
    // Step 1: A test that fails - this will be done for all tests, but is only here as a presentation for the first test.
    // public String getPlaceholder(String play) {
    //     return "hello";
    // }

    // Step 2: Code that works
    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }

    // Test 2: Test if it can replace the placeholder in each play
    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replace("<"+placeholder+">", value);
    }


    // Test 3: If the placeholder is <chaser>, test if a team's score updates by Quaffle points
    public void quaffleScore(Team team) {
        this.setScore(team, this.getScore(team) + QUAFFLE_POINTS);
    } 

    // Test 4: If the placeholder is <seeker>, test if a team's score updates by S
    public void catchSnitch(Team team) {
        this.setScore(team, this.getScore(team) + SNITCH_POINTS);
    }

    public Team getRandomTeam() {
        Object[] teams = scoreboard.keySet().toArray();
        return (Team)teams[random(teams.length)];
    }

    public int random(int range) {
        return (int) (Math.random() * range);
    }

    public String simulate(String play) {
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();

        if (placeholder.equals(Team.getPositionChaser())) {
            quaffleScore(team);
            return replacePlaceholder(play, placeholder, team.getChasers()[random(team.getChasers().length)]);
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team);
            return replacePlaceholder(play, placeholder, team.getSeeker());
        } else if (placeholder.equals(Team.getPositionKeeper())) {
            return replacePlaceholder(play, placeholder, team.getKeeper());
        } else {
            return "";
        }
        
    }
}