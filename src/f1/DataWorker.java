package f1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alejavilas92
 */
public class DataWorker {

    String pathRiders, pathTeams, pathGrandPrix;
    Scanner sc;
    public File ridersFile;

    public DataWorker() {
        //TODO acceder con resources
        pathRiders = DataWorker.class.getResource("/dataFiles/Riders").getPath();
        pathTeams = DataWorker.class.getResource("/dataFiles/Riders").getPath();
        pathGrandPrix = DataWorker.class.getResource("/dataFiles/CircuitsData").getPath();
    }

    public Circuit[] getCircuits() {
        Circuit[] circuits;
        String[] circuitsStats;
        String textFromFile = "";
        boolean newLine = true;

        try {
            sc = new Scanner(new File(pathGrandPrix));

            while (newLine) {
                try {
                    textFromFile += sc.nextLine();
                } catch (Exception e) {
                    newLine = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

        circuitsStats = textFromFile.split(";");
        circuits = new Circuit[circuitsStats.length];

        for (int i = 0; i < circuitsStats.length; i++) {
            String[] circuitsStr = circuitsStats[i].split(",");
            circuits[i] = (new Circuit(i, circuitsStr[0], circuitsStr[7], circuitsStr[1],
                    circuitsStr[11], circuitsStr[12], Double.parseDouble(circuitsStr[6]), Double.parseDouble(circuitsStr[3]),
                    Integer.parseInt(circuitsStr[2]), Integer.parseInt(circuitsStr[5]), Integer.parseInt(circuitsStr[8]),
                    Integer.parseInt(circuitsStr[9]), Integer.parseInt(circuitsStr[10]), Integer.parseInt(circuitsStr[4]),
                            Integer.parseInt(circuitsStr[13]),Integer.parseInt(circuitsStr[14])));
        }

        return circuits;
    }

    public Rider[] getRiders() {
        Rider[] riders;
        String ridersStr[];
        String textFromFile = "";
        boolean newLine = true;

        try {
            sc = new Scanner(new File(pathRiders));

            while (newLine) {
                try {
                    textFromFile += sc.nextLine();
                } catch (Exception e) {
                    newLine = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

        ridersStr = textFromFile.split(";");
        riders = new Rider[ridersStr.length];

        for (int i = 0; i < ridersStr.length; i++) {
            String[] riderStats = ridersStr[i].split(",");
            riders[i] = (new Rider(riderStats[0], riderStats[3], riderStats[2], Integer.parseInt(riderStats[1]), Integer.parseInt(riderStats[4])));
        }

        return riders;
    }
}
