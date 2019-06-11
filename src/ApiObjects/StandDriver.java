package ApiObjects;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alejavilas92
 */
public class StandDriver {

    private static final String WINS_KEY = "wins";
    private static final String POSITION_TEXT_KEY = "positionText";
    private static final String POSITION_KEY = "position";
    private static final String POINTS_KEY = "points";
    private static final String CONSTRUCTOR_KEY = "Constructor";
    private static final String DRIVER_KEY = "Driver";
    private int positionText, position, points, wins;
    private Team team;
    private Driver driver;

    public StandDriver(JSONObject object) throws JSONException {
        wins = object.getInt(WINS_KEY);
        positionText = object.getInt(POSITION_TEXT_KEY);
        position = object.getInt(POSITION_KEY);
        points = object.getInt(POINTS_KEY);
        team = new Team(object.getJSONObject(CONSTRUCTOR_KEY));
        driver = new Driver(object.getJSONObject(DRIVER_KEY));
    }

    public StandDriver(int wins, int positionText, Team team, Driver driver, int position, int points) {
        this.wins = wins;
        this.positionText = positionText;
        this.position = position;
        this.points = points;
        this.team = team;
        this.driver = driver;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPositionText() {
        return positionText;
    }

    public void setPositionText(int positionText) {
        this.positionText = positionText;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
