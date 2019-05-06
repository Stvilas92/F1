package f1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author alejavilas92
 */
public class CircuitPanel extends JPanel implements MouseListener {

    Dimension screenSize;
    JLabel lblCircuit, lblcircuitName, lblcircuitFans, lblcircuitKilometers, lblcircuitCity,lblTime;
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

    class TimerSwing extends JFrame implements ActionListener{
        
        public TimerSwing(JLabel lbl) {
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
