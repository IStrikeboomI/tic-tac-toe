package Strikeboom.tictactoe;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PseudoAi {
    private static final Random random = new Random();
    private static final Timer timer = new Timer();

    protected static void PsuedoAi() {
        if (!Gui.gameended) {
            /*does a timer to delay computer response because
             it makes it seems like the computer is trying to do something bigger */
            timer.schedule(tt(), random.nextInt(3000) + 500);
        }
    }
    //have to make a method to be able to cancel the timer
    private static TimerTask tt() {
        return new TimerTask() {
            @Override
            public void run() {
                int randslot = random.nextInt(8);
                boolean avalibleslot = true;
                //checks for any avalible slots
                while (Gui.buttonstates[randslot] != null&& !Gui.playerturn  && !Gui.gameended && avalibleslot) {
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
