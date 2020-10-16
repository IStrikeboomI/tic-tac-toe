package Strikeboom.tictactoe.gui;

import Strikeboom.tictactoe.logic.PseudoAi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        checkandrun(((IndexedButton)e.getSource()).getNum());
    }
    private void checkandrun(int index) {
        if (Gui.playerturn &&!Gui.gameended&&Gui.buttonstates[index] == null) {
            Gui.checkandrun(index,true);
            PseudoAi.PsuedoAi();
        }
    }
}
