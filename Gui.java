package com.Strikeboom.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui {
    static JFrame frame;
    protected static String Text = "Your Turn!";
    protected static JLabel label;
    protected static JLabel endlabel;

    protected static boolean playerturn = true;
    protected static boolean gameended = false;

    protected static ArrayList<JButton> buttons = new ArrayList<JButton>();
    protected static ArrayList<JLabel> boardlabels = new ArrayList<JLabel>();
    protected static String buttonstate1,buttonstate2, buttonstate3, buttonstate4, buttonstate5, buttonstate6, buttonstate7, buttonstate8, buttonstate9;
    protected static String[] buttonstates = {buttonstate1, buttonstate2, buttonstate3, buttonstate4, buttonstate5, buttonstate6, buttonstate7, buttonstate8, buttonstate9};
    protected Gui() {
        frame = new JFrame("Tic-Tac-Toe");

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                //draws lines
                super.paintComponent(g);
                g.drawLine(80,0,80,270);
                g.drawLine(190,0,190,270);
                g.drawLine(0,80,270,80);
                g.drawLine(0,190,270,190);
            }
        };
        panel.setLayout(new GroupLayout(panel));

        label = new JLabel(Text);
        label.setSize(100,10);
        label.setLocation(110,280);
        label.setFont(label.getFont().deriveFont(Font.BOLD));

        endlabel = new JLabel();
        endlabel.setFont(endlabel.getFont().deriveFont(Font.BOLD,50f));

        panel.add(label);

        //creates and positions buttons
        for (short i = 0; i <300;i += 100) {
            for (short y = 0;y<300;y += 100) {
                    JButton button = new JButton();
                    panel.add(button);
                    button.setBounds(y +20 ,i+20,30,30);
                    button.addActionListener(new GuiActionListener());
                    buttons.add(button);
                    JLabel templabel = new JLabel();
                    templabel.setBounds(y +23,i+13,50,50);
                    templabel.setFont(templabel.getFont().deriveFont(45f));
                    panel.add(templabel);
                    boardlabels.add(templabel);
            }
        }

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(290, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    protected static void updatelabel() {
        if (Gui.Text.equals("Your Turn!")) {
            Gui.Text = "Opponent's Turn!";
            label.setLocation(87,280);
        } else {
            Gui.Text = "Your Turn!";
            label.setLocation(110,280);
        }
        label.setText(Text);
        label.setSize(label.getPreferredSize());
    }
    protected static void ongameend(int typeofend) {
            //makes a new background to remove everything
            JPanel newpanel = new JPanel(null);
            frame.setContentPane(newpanel);
            newpanel.revalidate();
            newpanel.repaint();
            Gui.gameended = true;
            /*
            0 is a tie
            1 is a win
            2 is a loss
            */
            switch (typeofend) {
                case 0:
                    if (endlabel.getText() != null) {
                        endlabel.setText("Tie!");
                    }
                    endlabel.setBounds(85,100,400,100);
                break;
                case 1:
                    endlabel.setText("You Won!");
                    endlabel.setBounds(20,100,400,100);
                break;
                case 2:
                    endlabel.setText("You Lost!");
                    endlabel.setBounds(20,100,400,100);

                break;
            }
            newpanel.add(endlabel);
        }

}
