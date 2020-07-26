package com.Strikeboom.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiActionListener implements ActionListener {
    private static JButton button;
    @Override
    public void actionPerformed(ActionEvent e) {
        button = (JButton) e.getSource();

        switch (button.getY()) {
            case 20:
                //button 1
                if (button.getX() == 20) {
                    checkandrun(1);
                }
                //button 2
                else if (button.getX() == 120) {
                    checkandrun(2);
                }
                //button 3
                else {
                    checkandrun(3);
                }
                break;

            case 120:
                //button 4
                if (button.getX() == 20) {
                    checkandrun(4);
                }
                //button 5
                else if (button.getX() == 120) {
                    checkandrun(5);
                }
                //button 6
                else {
                    checkandrun(6);
                }
                break;

            case 220:
                //button 7
                if (button.getX() == 20) {
                    checkandrun(7);
                }
                //button 8
                else if (button.getX() == 120) {
                    checkandrun(8);
                }
                //button 9
                else {
                    checkandrun(9);
                }
                break;
        }
    }
    private static void checkandrun(int index) {
        if (Gui.playerturn &&!Gui.gameended&&Gui.buttonstates[index - 1] == null) {
            Gui.buttonstates[index - 1] = "X";
            Gui.boardlabels.get(index -1).setText(Gui.buttonstates[index - 1]);
            Gui.boardlabels.get(index -1 ).setForeground(new Color(255, 56, 69));
            Gui.updatelabel();
            Gui.playerturn = false;
            Gui.buttons.get(index -1).setLocation(-29,-29);
            CheckForWin.checkforwins();
            Gui.buttons.get(index - 1).removeActionListener(new GuiActionListener());
            PseudoAi.PsuedoAi();
        }
    }
}
