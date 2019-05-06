/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author alejavilas92
 */
public class RidersPanel extends JPanel {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JLabel lblHeaderName, lblHeaderNumber, lblHeaderCountry, lblHeaderTeam, lblHeaderAge;
    JList<String> riders, ridersCountry, ridersTeam;
    JList<Integer> ridersNumber, ridersAge;
    String[] ridersNames, ridersCountries, ridersTeams;
    Integer[] ridersNumbers, ridersAges;
    Rider[] rider;

    int jListStartY;

    Color[] ridersColors = {Color.cyan, Color.cyan, Color.red, Color.red,
        new Color(78, 37, 213), new Color(78, 37, 213), Color.orange, Color.orange,
        Color.yellow, Color.yellow, Color.gray, Color.gray,
        Color.pink, Color.pink, Color.MAGENTA, Color.MAGENTA, Color.blue,
        Color.blue, new Color(206, 249, 247), new Color(206, 249, 247)};

    public RidersPanel() {
        super();
        this.setLayout(null);
        this.setBounds(0, 0, (int) (screenSize.width / 1.65), screenSize.height - (screenSize.height / 8));
        this.jListStartY = screenSize.height / 35;
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(34, 111, 169)));
        DataWorker dataWorker = new DataWorker();
        this.rider = dataWorker.getRiders();
            
        ridersNames = new String[rider.length];
        ridersTeams = new String[rider.length];
        ridersCountries = new String[rider.length];
        ridersAges = new Integer[rider.length];
        ridersNumbers = new Integer[rider.length];
        
        for (int i = 0; i < rider.length; i++) {
            ridersNames[i] = rider[i].getName();
            ridersTeams[i] = rider[i].getTeam();
            ridersCountries[i] = rider[i].getCountry();
            ridersAges[i] = rider[i].getNumber();
            ridersNumbers[i] = rider[i].getAge();
        }

        //JLabel colors drivers
        for (int i = 0; i < ridersColors.length; i++) {
            JLabel lbl = new JLabel();
            lbl.setBounds(0, jListStartY + (i * screenSize.height / 23), screenSize.width / 30, screenSize.height / 23);
            lbl.setOpaque(true);
            lbl.setBackground(ridersColors[i]);
            this.add(lbl);
        }

        //JList riders
        riders = new JList<>( ridersNames);
        listMaker(riders, screenSize.width / 10, 20 * (screenSize.height / 23), screenSize.width / 30, jListStartY);

        //JList riders numbers
        ridersNumber = new JList<>(ridersNumbers);
        listMaker(ridersNumber, screenSize.width / 10 , 20 * (screenSize.height / 23), screenSize.width / 30 + riders.getWidth(), jListStartY);

        //JList riders countries
        ridersCountry = new JList<>(ridersCountries);
        listMaker(ridersCountry, screenSize.width / 10 , 20 * (screenSize.height / 23), screenSize.width / 30 + riders.getWidth() + ridersNumber.getWidth(), jListStartY);

        //JList riders teams
        ridersTeam = new JList<>( ridersTeams);
        listMaker(ridersTeam, screenSize.width / 5, 20 * (screenSize.height / 23), screenSize.width / 30  + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth(), jListStartY);

        //JList riders ages
        ridersAge = new JList<>(ridersAges);
        listMaker(ridersAge, screenSize.width / 10 , 20 * (screenSize.height / 23), screenSize.width / 30 + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth() + ridersTeam.getWidth(), jListStartY);

        //JLabels header
        lblHeaderName = new JLabel();
        lblHeaderNumber = new JLabel();
        lblHeaderCountry = new JLabel();
        lblHeaderTeam = new JLabel();
        lblHeaderAge = new JLabel();
        labelMaker(lblHeaderName, "Name", screenSize.width / 30);
        labelMaker(lblHeaderNumber, "Number", screenSize.width / 30 + riders.getWidth());
        labelMaker(lblHeaderCountry, "Country", screenSize.width / 30 + riders.getWidth() + ridersNumber.getWidth());
        labelMaker(lblHeaderTeam, "Team", screenSize.width / 30 + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth());
        labelMaker(lblHeaderAge, "Age", screenSize.width / 30 + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth() + ridersTeam.getWidth());

        //Adding items
        this.add(lblHeaderName);
        this.add(lblHeaderNumber);
        this.add(lblHeaderCountry);
        this.add(lblHeaderTeam);
        this.add(lblHeaderAge);
        this.add(riders);
        this.add(ridersAge);
        this.add(ridersCountry);
        this.add(ridersNumber);
        this.add(ridersTeam);
    }

    /**
     * Set header labels configuration
     *
     * @param lbl labelo to configure
     * @param text text of the label
     * @param previousWidth previous label width on header, summed to his x
     * location.
     */
    public void labelMaker(JLabel lbl, String text, int previousWidth) {
        lbl.setOpaque(true);
        lbl.setText(text);
        lbl.setBounds(previousWidth, 0, screenSize.width / 20, screenSize.height / 25);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        lbl.setBackground(Color.WHITE);
    }

    public void listMaker(JList list, int width, int height, int x, int y) {
        list.setBounds(x, y, width, height);
        list.setFixedCellHeight(screenSize.height / 23);
        list.setFixedCellWidth(width);
        list.setVisibleRowCount(20);
    }

}
