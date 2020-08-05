package com.Strikeboom.tictactoe;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PseudoAi {
    static Random random = new Random();
    private static int randslot;
    private static Timer timer = new Timer();

    protected static void PsuedoAi() {
        randslot = random.nextInt(8);
        if (!Gui.gameended) {
            timer.schedule(tt(), random.nextInt(1500) + 1000);
        }
    }
    private static TimerTask tt() {
        return new TimerTask() {
            @Override
            public void run() {
                boolean avalibleslot = true;

                while (Gui.buttonstates[randslot] != null&&!Gui.playerturn  && !Gui.gameended && avalibleslot) {
                    if (CheckForWin.checkfortie()) {
                        avalibleslot = false;
                        CheckForWin.checkforwins();
                    }
                    randslot = random.nextInt(8);
                }
                if (avalibleslot && Gui.buttonstates[randslot] == null && !Gui.playerturn&&!Gui.gameended) {
                    Gui.checkandrun(randslot,false);
                    timer.purge();
                }
            }
        };
    }
}
