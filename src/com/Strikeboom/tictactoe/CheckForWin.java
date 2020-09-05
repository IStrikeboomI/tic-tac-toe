package com.Strikeboom.tictactoe;

public class CheckForWin {

    protected static void checkforwins() {
        //makes sure that game hasn't ended
        if (!Gui.gameended) {
            //horizontal
            for (int i = 1; i <= 9; i += 3) {
                if (userwin(i, i + 1, i + 2)) {
                    Gui.ongameend(EnumWinTypes.WIN);
                    return;
                }
                if (oppenentwin(i, i + 1, i + 2)) {
                    Gui.ongameend(EnumWinTypes.LOSS);
                    return;
                }
            }
            //vertical
            for (int i = 1; i <= 3; i++) {
                if (userwin(i, i + 3, i + 6)) {
                    Gui.ongameend(EnumWinTypes.WIN);
                    return;
                }
                if (oppenentwin(i, i + 3, i + 6)) {
                    Gui.ongameend(EnumWinTypes.LOSS);
                    return;
                }
            }
            //diagonal
            if (userwin(1, 5, 9) || userwin(3, 5, 7)) {
                Gui.ongameend(EnumWinTypes.WIN);
                return;
            }
            if (oppenentwin(1, 5, 9) || oppenentwin(3, 5, 7)) {
                Gui.ongameend(EnumWinTypes.LOSS);
                return;
            }
            //tie
            if (checkfortie()) {
                Gui.ongameend(EnumWinTypes.TIE);
            }
        }
    }

    protected static boolean checkfortie() {
        int i = 0;
        for (String label: Gui.buttonstates) {
            if (label != null) {
                i++;
            }
        }
        return i == 9;
    }
    private static boolean userwin(int index1,int index2,int index3) {
        if (Gui.buttonstates[index1 -1]==null||Gui.buttonstates[index2 -1]==null||Gui.buttonstates[index3 -1]==null || Gui.gameended) {
            return false;
        }
        return Gui.buttonstates[index1 -1].equals("X") && Gui.buttonstates[index2 -1].equals("X") && Gui.buttonstates[index3-1].equals("X");
    }
    private static boolean oppenentwin(int index1,int index2,int index3) {
        if (Gui.buttonstates[index1 -1]==null||Gui.buttonstates[index2 -1]==null||Gui.buttonstates[index3 -1]==null || Gui.gameended) {
            return false;
        }
        return Gui.buttonstates[index1 -1].equals("O") && Gui.buttonstates[index2 -1].equals("O") && Gui.buttonstates[index3-1].equals("O");
    }

}
