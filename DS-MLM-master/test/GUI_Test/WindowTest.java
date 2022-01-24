/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Test;

import Main.AdminPanel;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class WindowTest {
    public static void main(String[] args){
        AdminPanel test = new AdminPanel();
        //test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.setLocationRelativeTo(null);
        //test.setSize(300,300);
        //test.setResizable(false);
        test.setVisible(true);
        //test.setLayout(new FlowLayout());
        /*test.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override 
            public void windowOpened(WindowEvent e) {}
            @Override 
            public void windowClosed(WindowEvent e) {}
            @Override 
            public void windowIconified(WindowEvent e) {}
            @Override 
            public void windowDeiconified(WindowEvent e) {}
            @Override 
            public void windowActivated(WindowEvent e) {}
            @Override 
            public void windowDeactivated(WindowEvent e) {}
        });*/
    }
}
