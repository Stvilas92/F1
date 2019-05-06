package f1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MainView extends JFrame implements ActionListener, MouseListener {

    private JLabel lblBackground;
    private JButton btnGrandPrix, btnRiders, btnTeams, btnStats;
    private Dimension screenSize;
    private GeneralPanel infoPanel;

    private enum PanelType {
        GRAND_PRIX, RIDERS, STATS, TEAMS
    };

    public MainView() {
        super("F1 DATA");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Background Label
        lblBackground = new JLabel(new ImageIcon("src/Images/MainBackground.jpg"));
        //lblBackground.setBounds(0, 0, screenSize.width, screenSize.height);
        this.setContentPane(lblBackground);

        //btnGrandPrix
        btnGrandPrix = new JButton("Grand Prix");
        makeButtons(btnGrandPrix, 0);

        //btnRiders
        btnRiders = new JButton("Riders");
        makeButtons(btnRiders, 1);

        //btnTeams
        btnTeams = new JButton("Teams");
        makeButtons(btnTeams, 2);

        //btnStats
        btnStats = new JButton("Stats");
        makeButtons(btnStats, 3);

        //panel
        infoPanel = new GeneralPanel();
        this.add(infoPanel);

        this.setResizable(false);
        infoPanel.setVisible(true);
    }

    /**
     * Set button configuration
     *
     * @param jButton Button to configure
     * @param index Number of button, this calculate the button position
     */
    public void makeButtons(JButton jButton, int index) {
        jButton.setBounds(screenSize.width / 10, (screenSize.width / 25) + (index * screenSize.height / 5), screenSize.width / 6, screenSize.height / 10);
        jButton.setForeground(Color.white);
        jButton.setBackground(new Color(145, 190, 225));
        jButton.setFont(new Font("Arial", Font.BOLD, 30));
        jButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(34, 111, 169)));
        jButton.addMouseListener(this);
        this.add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(226, 240, 247));

        if (e.getSource() == btnGrandPrix) {
            infoPanel.makePanel(0);
            infoPanel.repaint();
        }

        if (e.getSource() == btnRiders) {
            infoPanel.makePanel(1);
            infoPanel.repaint();
        }

        if (e.getSource() == btnStats) {
            infoPanel.makePanel(2);
            infoPanel.repaint();
        }

        if (e.getSource() == btnTeams) {
            infoPanel.makePanel(3);
            infoPanel.repaint();
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(190, 226, 246));
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(182, 226, 246));
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(182, 226, 246));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(145, 190, 225));
    }

}