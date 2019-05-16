/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author alejavilas92
 */
public class RidersPanel extends JPanel implements ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JLabel lblHeaderName, lblHeaderNumber, lblHeaderCountry, lblHeaderTeam, lblHeaderAge, lblFilterTeam, lblFilterCountry;
    JList<String> riders, ridersCountry, ridersTeam;
    JList<String> ridersNumber, ridersAge;
    String[] ridersNames, ridersCountries, ridersTeams;
    String[] ridersNumbers, ridersAges;
    Rider[] rider;
    JComboBox<String> jcbCountries, jcbTeams;
    JButton btnFilter;

    int jListStartY;

    public RidersPanel() {
        super();
        this.setLayout(null);
        this.setBounds(0, 0, (int) (screenSize.width / 1.65), screenSize.height - (getYScreen(8)));
        this.jListStartY = screenSize.height / 5;
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(34, 111, 169)));
        DataWorker dataWorker = new DataWorker();
        this.rider = dataWorker.getRiders();

        ridersNames = new String[rider.length];
        ridersTeams = new String[rider.length];
        ridersCountries = new String[rider.length];
        ridersAges = new String[rider.length];
        ridersNumbers = new String[rider.length];

        for (int i = 0; i < rider.length; i++) {
            ridersNames[i] = rider[i].getName();
            ridersTeams[i] = rider[i].getTeam();
            ridersCountries[i] = rider[i].getCountry();
            ridersAges[i] = "" + rider[i].getNumber();
            ridersNumbers[i] = "" + rider[i].getAge();
        }

        //JButton
        btnFilter = new JButton("Filtrar");
        btnFilter.setBounds(getXScreen(2), getYScreen(50), getXScreen(20), getYScreen(50));
        btnFilter.addActionListener(this);

        //JList riders
        riders = new JList<>(ridersNames);
        listMaker(riders, getXScreen(10), getXScreen(30), jListStartY);

        //JList riders numbers
        ridersNumber = new JList<>(ridersNumbers);
        listMaker(ridersNumber, getXScreen(10), getXScreen(30) + riders.getWidth(), jListStartY);

        //JList riders countries
        ridersCountry = new JList<>(ridersCountries);
        listMaker(ridersCountry, getXScreen(10), getXScreen(30) + riders.getWidth() + ridersNumber.getWidth(), jListStartY);

        //JList riders teams
        ridersTeam = new JList<>(ridersTeams);
        listMaker(ridersTeam, getXScreen(5), getXScreen(30) + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth(), jListStartY);

        //JList riders ages
        ridersAge = new JList<>(ridersAges);
        listMaker(ridersAge, getXScreen(10), getXScreen(30) + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth() + ridersTeam.getWidth(), jListStartY);

        //JLabels header
        lblHeaderName = new JLabel();
        lblHeaderNumber = new JLabel();
        lblHeaderCountry = new JLabel();
        lblHeaderTeam = new JLabel();
        lblHeaderAge = new JLabel();
        labelHeaderMaker(lblHeaderName, "Name", getXScreen(30));
        labelHeaderMaker(lblHeaderNumber, "Number", getXScreen(30) + riders.getWidth());
        labelHeaderMaker(lblHeaderCountry, "Country", getXScreen(30) + riders.getWidth() + ridersNumber.getWidth());
        labelHeaderMaker(lblHeaderTeam, "Team", getXScreen(30) + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth());
        labelHeaderMaker(lblHeaderAge, "Age", getXScreen(30) + riders.getWidth() + ridersNumber.getWidth() + ridersCountry.getWidth() + ridersTeam.getWidth());

        //Jlabes filter
        lblFilterCountry = new JLabel("Filtrar por país");
        lblFilterTeam = new JLabel("Filtrar por equipo");
        lblFilterCountry.setBounds(getXScreen(50), getYScreen(50), getXScreen(10), getYScreen(50));
        lblFilterTeam.setBounds(getXScreen(50), getYScreen(50) * 2, getXScreen(10), getYScreen(50));

        //JComboBox
        jcbCountries = new JComboBox<>(deleteEquals(ridersCountries));
        jcbTeams = new JComboBox<>(deleteEquals(ridersTeams));
        jcbCountries.setBounds(getXScreen(10), getYScreen(50), getXScreen(10), getYScreen(50));
        jcbTeams.setBounds(getXScreen(10), getYScreen(50) * 2, getXScreen(10), getYScreen(50));

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
        this.add(lblFilterCountry);
        this.add(lblFilterTeam);
        this.add(jcbCountries);
        this.add(jcbTeams);
        this.add(btnFilter);
    }

    public String[] deleteEquals(String[] str) {
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            al.add(str[i]);
        }

        for (int i = al.size() - 1; i >= 0; i--) {
            for (int j = al.size() - 1; j >= 0; j--) {
                if (al.get(i).equals(al.get(j).trim()) && j != i) {
                    al.remove(j);
                    break;
                }
            }
        }

        String[] arrayRenturn = new String[al.size()];
        al.toArray(arrayRenturn);
        return arrayRenturn;
    }

    public int getXScreen(int percent) {
        return screenSize.width / percent;
    }

    public int getYScreen(int percent) {
        return screenSize.height / percent;
    }

    /**
     * Set header labels configuration
     *
     * @param lbl labelo to configure
     * @param text text of the label
     * @param previousWidth previous label width on header, summed to his x
     * location.
     */
    public void labelHeaderMaker(JLabel lbl, String text, int previousWidth) {
        lbl.setOpaque(true);
        lbl.setText(text);
        lbl.setBounds(previousWidth, jListStartY - getXScreen(30), getXScreen(20), getXScreen(30));
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        lbl.setBackground(Color.WHITE);
    }

    public void listMaker(JList list, int width, int x, int y) {
        list.setFixedCellHeight(getYScreen(30));
        list.setBounds(x, y, width, list.getFixedCellHeight() * 20);
        list.setFixedCellWidth(width);
        list.setVisibleRowCount(20);
    }

    public void update(String updateBy, String filter) {
        String[][] lists;
        int newSize = 0;
        if (updateBy.equals("Country")) {
            for (String country : ridersCountries) {
                if (country.equals(filter)) {
                    newSize++;
                }
            }

            lists = new String[5][newSize];
            int count = 0;
            for (int i = 0; i < ridersCountries.length && count < newSize; i++) {
                if (ridersCountries[i].equals(filter)) {
                    lists[0][count] = ridersNames[i];
                    lists[1][count] = ridersNumbers[i];
                    lists[2][count] = ridersCountries[i];
                    lists[3][count] = ridersTeams[i];
                    lists[4][count] = ridersAges[i];
                    count++;
                }
            }
        } else {
            for (String teams : ridersTeams) {
                if (teams.equals(filter)) {
                    newSize++;
                }
            }

            lists = new String[5][newSize];
            int count = 0;
            for (int i = 0; i < ridersTeams.length && count < newSize; i++) {
                if (ridersCountries[i].equals(filter)) {
                    lists[0][count] = ridersNames[i];
                    lists[1][count] = ridersNumbers[i];
                    lists[2][count] = ridersCountries[i];
                    lists[3][count] = ridersTeams[i];
                    lists[4][count] = ridersAges[i];
                    count++;
                }
            }
        }
        riders.removeAll();
        ridersNumber.removeAll();
        ridersCountry.removeAll();
        ridersTeam.removeAll();
        ridersAge.removeAll();

        for (int i = 0; i < newSize; i++) {
            riders.add(lists[0][i], new JLabel());
            ridersNumber.add(lists[1][i], new JLabel());
            ridersCountry.add(lists[2][i], new JLabel());
            ridersTeam.add(lists[3][i], new JLabel());
            ridersAge.add(lists[4][i], new JLabel());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFilter) {
            update("Country", jcbCountries.getItemAt(jcbCountries.getSelectedIndex()));
        }
    }
}
