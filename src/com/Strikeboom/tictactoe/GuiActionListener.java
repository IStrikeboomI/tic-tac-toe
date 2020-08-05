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

        switch (button.getY()) {
            case 20:
                //button 1
                if (button.getX() == 20) {
                    checkandrun(0);
                }
                //button 2
                else if (button.getX() == 120) {
                    checkandrun(1);
                }
                //button 3
                else {
                    checkandrun(2);
                }
                break;

            case 120:
                //button 4
                if (button.getX() == 20) {
                    checkandrun(3);
                }
                //button 5
                else if (button.getX() == 120) {
                    checkandrun(4);
                }
                //button 6
                else {
                    checkandrun(5);
                }
                break;

            case 220:
                //button 7
                if (button.getX() == 20) {
                    checkandrun(6);
                }
                //button 8
                else if (button.getX() == 120) {
                    checkandrun(7);
                }
                //button 9
                else {
                    checkandrun(8);
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
