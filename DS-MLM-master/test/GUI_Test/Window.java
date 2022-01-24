/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Window extends JFrame{
    private JButton newUser, getData, setData, delUser, display, getRev, setFee, save, exit;
    
    public Window(){
        setTitle("Dream Corporation");
        newUser = new JButton("Create new user");
        getData = new JButton("Retrieve the data of a user");
        setData = new JButton("Update the data of a user");
        delUser = new JButton("Delete a user");
        display = new JButton("View the tree of the hierachy");
        getRev = new JButton("Get the revenue of each generation");
        setFee = new JButton("Change the registration fee");
        save = new JButton("Save the directory of data");
        setLayout(new FlowLayout());
        add(newUser);
        add(getData);
        add(setData);
        add(delUser);
        add(display);
        add(getRev);
        add(setFee);
        add(save);
        
        handler action = new handler();
    }
    
    private class handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==newUser)
            {}
        }
        
    }
}
