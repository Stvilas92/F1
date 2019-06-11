/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import ApiObjects.StandDriver;
import f1.Api.ApiConnect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alejavilas92
 */
public class StatsDialog extends JDialog implements ActionListener {

    public static final int X_LABEL_STATS = 10;
    public static final int Y_LABEL_STATS = 10;

    Dimension screenSize;
    JLabel lblBackground;
    //DataViewer dataViewer;
    //JMenu components
    String[] menus = {"Campeonato", "Gran Premio"};
    String[][] subMenus = {{"Pilotos", "Constructores"}, {"Resultados"}};

    public StatsDialog() {
        super();
        this.setLayout(null);
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, (int) (screenSize.width / 1.65), screenSize.height - (screenSize.height / 8));
        this.setBackground(Color.white);
        this.setSize(screenSize.width, screenSize.height);
        //dataViewer = new DataViewer(this);
        //Background Label
        lblBackground = new JLabel(new ImageIcon("src/Images/MainBackground.jpg"));
        this.setContentPane(lblBackground);

        //JMenu Bar
        JMenuBar menu = new JMenuBar();
        menu.setName("Menu");

        for (int i = 0; i < menus.length; i++) {
            JMenu menuFile = new JMenu(menus[i]);
            for (int j = 0; j < subMenus[i].length; j++) {
                JMenuItem item = new JMenuItem(subMenus[i][j]);
                item.addActionListener(this);
                menuFile.add(item);
            }
            menu.add(menuFile);
        }
        this.setJMenuBar(menu);
        this.setVisible(true);

        //JPanel
        JPanel jpn = new JpnDrivers();
        this.add(jpn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(subMenus[0][0])) {
            //ApiConnect.getSeasonStats();
        } else if (e.getActionCommand().equals(subMenus[0][1])) {
            System.out.println("");
        }
    }

    private class JpnDrivers extends JPanel {

        public JpnDrivers() {
            super(null);
            this.setBounds(0, 0, screenSize.width, screenSize.height);

            try {
                JSONArray api = ApiConnect.getSeasonStats();

                for (int i = 0; i < api.length(); i++) {
                    StandDriver  standDriver = new StandDriver(api.getJSONObject(i));
                    JLabel lbl = new JLabel("" + standDriver.getPosition() + "     "+
                            standDriver.getDriver().getDriverID()+"    "+standDriver.getPoints());
                    lbl.setBounds(X_LABEL_STATS, Y_LABEL_STATS + (i * lbl.getPreferredSize().height + 5), lbl.getPreferredSize().width, lbl.getPreferredSize().height );
                    this.add(lbl);
                }
            } catch (JSONException e) {
                JOptionPane.showMessageDialog(null, "Error on reading data : " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unexpected error : " + e.getMessage());
            }

            this.setVisible(true);
        }
    }
}
