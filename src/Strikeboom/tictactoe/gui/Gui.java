package Strikeboom.tictactoe.gui;

import Strikeboom.tictactoe.logic.CheckForWin;
import Strikeboom.tictactoe.logic.EnumWinTypes;

import javax.swing.*;
import java.awt.*;


public final class Gui {
    private static int num = 0;
    private static JFrame frame;
    private static JLabel label;
    private static final JButton[] buttons = new JButton[9];
    private static final JLabel[] boardlabels = new JLabel[9];

    public static String[] buttonstates = new String[9];
    public static boolean playerturn = true;
    public static boolean gameended = false;

    public Gui() {
        frame = new JFrame("Tic-Tac-Toe");

        JPanel panel = new JPanel(null) {
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

        label = new JLabel();
        label.setBounds(110,280,100,15);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setText("Your Turn!");

        panel.add(label);

        //creates and positions buttons
        for (short i = 0; i <300;i += 100) {
            for (short y = 0;y<300;y += 100) {
                    JButton tempButton = new IndexedButton(num);
                    panel.add(tempButton);
                    tempButton.setBounds(y +20 ,i+20,30,30);
                    buttons[num] = tempButton;

                    JLabel templabel = new JLabel();
                    templabel.setBounds(y +23,i+13,50,50);
                    templabel.setFont(templabel.getFont().deriveFont(45f));
                    panel.add(templabel);
                    boardlabels[num] = templabel;
                    num++;
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
    public static void checkandrun(int index,boolean isPlayerturn) {
        buttons[index].setLocation(-29,-29);
        buttonstates[index] = isPlayerturn ? "X":"O";
        boardlabels[index].setText(Gui.buttonstates[index]);
        boardlabels[index].setForeground(isPlayerturn ? new Color(255, 56, 69): new Color(73, 90, 255));
        label.setText(isPlayerturn ?"Opponent's Turn!":"Your Turn!");
        label.setLocation(isPlayerturn ?new Point(87,280):new Point(110,280));
        CheckForWin.checkforwins();
        playerturn = !isPlayerturn;
    }
    public static void ongameend(EnumWinTypes WinType) {

           gameended = true;

            //makes the ending text
            JLabel endlabel = new JLabel();
            endlabel.setFont(endlabel.getFont().deriveFont(Font.BOLD,50f));
            endlabel.setBounds(20,100,400,100);
            //makes a new background to remove everything
            JPanel newpanel = new JPanel(null);
            frame.setContentPane(newpanel);
            newpanel.revalidate();
            newpanel.repaint();

            switch (WinType) {
                case TIE:
                    endlabel.setText("Tie!");
                    endlabel.setLocation(85,100);
                break;
                case WIN:
                    endlabel.setText("You Won!");
                break;
                case LOSS:
                    endlabel.setText("You Lost!");
                break;
            }
            newpanel.add(endlabel);
        }

}
