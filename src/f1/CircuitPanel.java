package f1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author alejavilas92
 */
public class CircuitPanel extends JPanel implements MouseListener {
    TimerSwing t;
    Dimension screenSize;
    JLabel lblCircuit, lblcircuitName, lblcircuitFans, lblcircuitKilometers, lblcircuitCity, lblTime,
            lblTimeTitle, lblAerodinamic, lblTireWear, lblGrip, lblEvelation, lblRaceKm, lblLaps,
            lblMaxSpeed, lblRightCurves, lblLeftCurves;
    int seconds, minutes, hours = 1;
    Circuit[] circuits;
    JButton btnBack, btnNext;
    int index = 0;

    public CircuitPanel() {
        super();
        this.setLayout(null);
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, (int) (screenSize.width / 1.65), screenSize.height - (screenSize.height / 8));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(34, 111, 169)));
        DataWorker dataWorker = new DataWorker();
        this.circuits = dataWorker.getCircuits();

        inicializateComponents(index);
    }

    private int calculateSeconds() {
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    private int getSecondsToGrandPrix(int dayGrandPrix, int mothsGrandPrix) {
        int dayActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int monthActual = Calendar.getInstance().get(Calendar.MONTH);

        if (mothsGrandPrix - monthActual < 0) {
            return 0;
        } else if (mothsGrandPrix - monthActual == 0) {
            return (dayGrandPrix - dayActual) * 86400;
        } else if (dayGrandPrix < dayActual) {
            return ((mothsGrandPrix - monthActual) * 2505600) + ((dayGrandPrix - dayActual) * 86400);
        } else {
            return ((mothsGrandPrix - monthActual) * 2505600) + ((31 - (dayActual - dayGrandPrix)) * 86400);
        }
    }

    private void inicializateComponents(int index) {
        //Lbl Circuit
        lblCircuit = new JLabel(circuits[index].getMap());
        lblCircuit.setBounds(5, 5, circuits[index].getMap().getIconWidth(), circuits[index].getMap().getIconHeight());
        lblCircuit.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(34, 111, 169)));

        //Button Back
        btnBack = new JButton("Previous");
        btnBack.setBounds(this.getX() + this.getWidth() / 30, (this.getY() + this.getHeight()) - (this.getHeight() / 18), this.getWidth() / 15, this.getHeight() / 25);
        btnBack.setForeground(Color.white);
        btnBack.setBackground(new Color(145, 190, 225));
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(34, 111, 169)));
        btnBack.addMouseListener(this);

        //Button Back
        btnNext = new JButton("Next");
        btnNext.setBounds((this.getX() + this.getWidth()) - (this.getWidth() / 10), (this.getY() + this.getHeight()) - (this.getHeight() / 18), this.getWidth() / 15, this.getHeight() / 25);
        btnNext.setForeground(Color.white);
        btnNext.setBackground(new Color(145, 190, 225));
        btnNext.setFont(new Font("Arial", Font.BOLD, 14));
        btnNext.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(34, 111, 169)));
        btnNext.addMouseListener(this);

        //Label Name
        lblcircuitName = new JLabel("Name : " + circuits[index].getName());
        labelMaker(lblcircuitName, screenSize.width / 50, (int) (screenSize.height / 2.3), screenSize.width / 5, screenSize.height / 25);

        //Label Fans Capacity
        lblcircuitFans = new JLabel("Fans capacity : " + circuits[index].getFansCapcity());
        labelMaker(lblcircuitFans, screenSize.width / 50, (int) (screenSize.height / 2.3) + screenSize.height / 25, screenSize.width / 5, screenSize.height / 25);

        //Label Kilometers
        lblcircuitKilometers = new JLabel("Kilometers : " + circuits[index].getLength());
        labelMaker(lblcircuitKilometers, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 2), screenSize.width / 5, screenSize.height / 25);

        //Label City
        lblcircuitCity = new JLabel("City : " + circuits[index].getCity());
        labelMaker(lblcircuitCity, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 3), screenSize.width / 5, screenSize.height / 25);

        //Label  aerodinamic charge
        lblAerodinamic = new JLabel("Carga aerodinámica : " + circuits[index].getAerodinamic());
        labelMaker(lblAerodinamic, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 4), screenSize.width / 5, screenSize.height / 25);

        //Label  tire wear
        lblTireWear = new JLabel("Desgaste de neumáticos : " + circuits[index].getTireWear());
        labelMaker(lblTireWear, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 5), screenSize.width / 5, screenSize.height / 25);

        //Label  grip
        lblGrip = new JLabel("Agarre : " + circuits[index].getGrip());
        labelMaker(lblGrip, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 6), screenSize.width / 5, screenSize.height / 25);

        //Label  elevation
        lblEvelation = new JLabel("Elevación : " + circuits[index].getElevation());
        labelMaker(lblEvelation, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 7), screenSize.width / 5, screenSize.height / 25);

        //Label race kilometers
        lblRaceKm = new JLabel("Distancia carrera : " + circuits[index].getRaceLentht());
        labelMaker(lblRaceKm, screenSize.width / 50, (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 8), screenSize.width / 5, screenSize.height / 25);

        //Label tie laps
        lblLaps = new JLabel("Vueltas : " + circuits[index].getLaps());
        labelMaker(lblLaps, (screenSize.width / 3), (int) (screenSize.height / 2.3), screenSize.width / 5, screenSize.height / 25);

        //Label  max speed
        lblMaxSpeed = new JLabel("Velocidad max : " + circuits[index].getSpeed());
        labelMaker(lblMaxSpeed, (screenSize.width / 3), (int) (screenSize.height / 2.3) + (screenSize.height / 25), screenSize.width / 5, screenSize.height / 25);

        //Label  rigth curves
        lblRightCurves = new JLabel("Curvas derecha : " + circuits[index].getRigthCurve());
        labelMaker(lblRightCurves, (screenSize.width / 3), (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 2), screenSize.width / 5, screenSize.height / 25);

        //Label date
        lblLeftCurves = new JLabel("Curvas izquierda : " + circuits[index].getLeftCurve());
        labelMaker(lblLeftCurves, (screenSize.width / 3), (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 3), screenSize.width / 5, screenSize.height / 25);

        //Label time title
        lblTimeTitle = new JLabel("TIME TO GRAND PRIX");
        labelMaker(lblTimeTitle, (screenSize.width / 3), (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 4), screenSize.width / 8, screenSize.height / 15);

        //Label timeback
        lblTime = new JLabel(hours + ":" + minutes + ":" + seconds);
        labelMaker(lblTime, (screenSize.width / 3), (int) (screenSize.height / 2.3) + (screenSize.height / 25 * 6), screenSize.width / 8, screenSize.height / 15);
        t = new TimerSwing(lblTime);
        //TODO aplicar cuenta atrás a cada circuito
        t.start(calculateSeconds());

        this.add(btnBack);
        this.add(btnNext);
        this.add(lblCircuit);
    }

    private void updateAllComponents() {
        //Map image
        lblCircuit.setIcon(circuits[index].getMap());

        //Label Name 
        lblcircuitName.setText("Name : " + circuits[index].getName());

        //Label Fans Capacity
        lblcircuitFans.setText("Fans capacity : " + circuits[index].getFansCapcity());

        //Label Kilometers
        lblcircuitKilometers.setText("Kilometers : " + circuits[index].getLength());

        //Label City
        lblcircuitCity.setText("City : " + circuits[index].getCity());

        //Label  aerodinamic charge
        lblAerodinamic.setText("Carga aerodinámica : " + circuits[index].getAerodinamic());

        //Label  tire wear
        lblTireWear.setText("Desgaste de neumáticos : " + circuits[index].getTireWear());

        //Label  grip
        lblGrip.setText("Agarre : " + circuits[index].getGrip());

        //Label  elevation
        lblEvelation.setText("Elevación : " + circuits[index].getElevation());

        //Label race kilometers
        lblRaceKm.setText("Distancia carrera : " + circuits[index].getRaceLentht());

        //Label tie laps
        lblLaps.setText("Vueltas : " + circuits[index].getLaps());

        //Label  max speed
        lblMaxSpeed.setText("Velocidad max : " + circuits[index].getSpeed());

        //Label  rigth curves
        lblRightCurves.setText("Curvas derecha : " + circuits[index].getRigthCurve());

        //Label date
        lblLeftCurves.setText("Curvas izquierda : " + circuits[index].getLeftCurve());

        t.stop();
        t.start(calculateSeconds());

    }

    /**
     *
     * @param lbl Label to configure
     * @param x X coordinate
     * @param y Y coordinate
     * @param width width of the label
     * @param height height of the label
     */
    public void labelMaker(JLabel lbl, int x, int y, int width, int height) {
        lbl.setOpaque(true);
        lbl.setBounds(x, y, width, height);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        lbl.setBackground(Color.WHITE);
        lbl.setForeground(Color.BLACK);
        this.add(lbl);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == btnNext) {
            if (index < circuits.length - 1) {
                index++;
            }
        } else if (index > 0) {
            index--;
        }
        updateAllComponents();
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(190, 226, 246));
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(182, 226, 246));
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(182, 226, 246));
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(new Color(145, 190, 225));
    }

    class TimerSwing extends JFrame implements ActionListener {

        private int timeSeconds;
        private Timer timer;
        private JLabel labelTime;

        public TimerSwing(JLabel labelTime) {
            timeSeconds = 0;
            timer = new Timer(1000, this);
            this.labelTime = labelTime;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (timeSeconds > 0) {
                timeSeconds--;
            } else {
                stop();
            }
            labelTime.setText(calculateTime(timeSeconds));
        }

        private String calculateTime(int timeSeconds) {
            if (timeSeconds > 0) {
                int hours = 0, minutes = 0, seconds = 0;
                if (timeSeconds < 60) {
                    seconds = timeSeconds;
                    minutes = 0;
                    hours = 0;
                } else if (timeSeconds < 3600) {
                    minutes = timeSeconds / 60;
                    seconds = timeSeconds - (minutes * 60);
                    hours = 0;
                } else {
                    hours = timeSeconds / 3600;
                    minutes = (timeSeconds - (hours * 60)) / 60;
                    seconds = timeSeconds - ((minutes * 60) + (hours * 3600));
                }

                if (seconds < 10 || minutes < 10 || hours < 10) {
                    String timeReturnString = "";
                    if (seconds < 10) {
                        timeReturnString = "" + hours + ":" + minutes + ": 0" + seconds;
                    }
                    if (minutes < 10) {
                        timeReturnString = "" + hours + ": 0" + minutes + ":" + seconds;
                    }
                    if (hours < 10) {
                        timeReturnString = "0" + hours + ":" + minutes + ":" + seconds;
                    }
                    return timeReturnString;
                } else {
                    return "" + hours + ":" + minutes + ":" + seconds;
                }

            } else {
                return "00:00:00";
            }
        }

        public void start(int secondsTo0) {
            timeSeconds = secondsTo0;
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        public int getTimeSeconds() {
            return timeSeconds;
        }
    }
}
