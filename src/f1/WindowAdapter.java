package f1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alejavilas92
 */
public class WindowAdapter implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int answer = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(answer == JOptionPane.YES_OPTION){
            e.getWindow().dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
