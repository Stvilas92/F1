/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author alejavilas92
 */
public class KeyHandler extends KeyAdapter {

    JFrame f;

    public KeyHandler(JFrame f) {
        this.f = f;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'm') {
            f.dispose();
        }
    }
}
