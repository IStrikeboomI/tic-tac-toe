package Strikeboom.tictactoe;

import Strikeboom.tictactoe.gui.Gui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(Gui::new);
    }
}
