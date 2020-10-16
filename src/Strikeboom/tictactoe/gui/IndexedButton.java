package Strikeboom.tictactoe.gui;

import javax.swing.*;

public class IndexedButton extends JButton {
    int num;
    public IndexedButton(int num) {
        this.num = num;
        addActionListener(new GuiActionListener());
    }

    public int getNum() {
        return num;
    }
}
