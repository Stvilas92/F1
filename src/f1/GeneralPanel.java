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
public class GeneralPanel extends JPanel {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JLabel lblBackground;
    JPanel content;
    JList<String> riders;

    public GeneralPanel() {
        super();
        this.setLayout(null);
        this.setBackground(null);
        this.setOpaque(false);
        this.setBounds(screenSize.width / 3, (screenSize.height / 20), (int) (screenSize.width / 1.65), screenSize.height - (screenSize.height / 8));
        

        //Background label
        lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, (int) (screenSize.width / 1.65), screenSize.height - (screenSize.height / 8));

        this.add(lblBackground);
    }

    public void makePanel(int type) {
        switch (type) {
            case 0:
                this.remove(0);
                this.add(new CircuitPanel());
                this.setOpaque(true);
                break;

            case 1:
                this.remove(0);
                this.add(new RidersPanel());
                this.setOpaque(true);
                break;

            case 2:
                
                break;

            case 3:
                
                break;

            default:
                this.setOpaque(false);
                this.setBackground(null);
        }
    }
}
