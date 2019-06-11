package f1.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.sound.midi.Soundbank;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alejavilas92
 */
public class ApiConnect {

    private final static String MR_DATA = "MRData";
    private final static String STANDINGS_TABLE = "StandingsTable";
    private final static String STANDINGS_LIST = "StandingsList";
    private final static String DRIVER_STANDING = "DriverStanding";
    private final static String USER_AGENT = "Mozilla/5.0";

    public static JSONArray getSeasonStats() throws JSONException,Exception{
            JSONObject json = getJSON(getAPIConnection("http://ergast.com/api/f1/current/driverStandings"));
            JSONObject mRData = json.getJSONObject(MR_DATA);
            JSONObject standingsTable = mRData.getJSONObject(STANDINGS_TABLE);
            JSONObject standingsList = standingsTable.getJSONObject(STANDINGS_LIST);
            JSONArray driverStanding = standingsList.getJSONArray(DRIVER_STANDING);
            return driverStanding;
    }

    public static String getAPIConnection(String urlString) {
        String response = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection hurlc = (HttpURLConnection) url.openConnection();
            hurlc.setRequestMethod("GET");
            hurlc.setRequestProperty("User-Agent", USER_AGENT);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(hurlc.getInputStream()))) {
                String inputLine;

                while ((inputLine = reader.readLine()) != null) {
                    response += inputLine;
                }
            } catch (IOException e) {
                System.out.println("Exception on connect with URL on Buffer Reader" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception on connect with URL on Buffer Reader" + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Exception on connect with URL " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception on connect with URL " + e.getMessage());
        }

        return response;
    }

    public static JSONObject getJSON(String xmlToJson) throws Exception{
        try {
            JSONObject jSONObject = XML.toJSONObject(xmlToJson);
            return jSONObject;
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument exception on JSONObject " + e.getMessage());
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("Unexpected exception on JSONObject " + e.getMessage());
            throw new Exception();
        }
    }
}
