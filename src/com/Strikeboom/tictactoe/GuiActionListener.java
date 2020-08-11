package com.Strikeboom.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //gets button
         JButton button = (JButton) e.getSource();

         //the only way to differntiate the buttons is through positions
        switch (button.getY()) {
            case 20:
                switch (button.getX()) {
                    //button 1
                    case 20:
                        checkandrun(0);
                    break;
                    //button 2
                    case 120:
                        checkandrun(1);
                        break;
                    //button 3
                    case 220:
                        checkandrun(2);
                        break;
                }
                break;

            case 120:

                switch (button.getX()) {
                    //button 4
                    case 20:
                        checkandrun(3);
                        break;
                    //button 5
                    case 120:
                        checkandrun(4);
                        break;
                    //button 6
                    case 220:
                        checkandrun(5);
                        break;
                }
                break;

            case 220:
                switch (button.getX()) {
                    //button 7
                    case 20:
                        checkandrun(6);
                        break;
                    //button 8
                    case 120:
                        checkandrun(7);

                        break;
                    //button 9
                    case 220:
                        checkandrun(8);
                        break;
                }
                break;
        }
    }
    private static void checkandrun(int index) {
        if (Gui.playerturn &&!Gui.gameended&&Gui.buttonstates[index] == null) {
            Gui.checkandrun(index,true);
            PseudoAi.PsuedoAi();
        }
    }
}
