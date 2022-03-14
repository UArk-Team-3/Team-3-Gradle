
package com.team3;

import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;

public class Controller implements KeyEventDispatcher {
    DBService db;
    View view;

    boolean actionScreenLoaded;

    Controller(DBService db) {
        this.db = db;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            // Added by Abubakar Qasim - Feb 24th, enable faster testing
            case KeyEvent.VK_ESCAPE:
                System.out.println("--Exiting--");
                System.exit(0);
                break;

            // Added by pjrios
            case KeyEvent.VK_F5:
                if (!actionScreenLoaded)
                {
                    System.out.println("--Opening action screen--");
                    view.playerEntry.sortEntries();
                    view.loadActionScreen();
                    actionScreenLoaded = true;
                }
                break;
        }
        return false;
    }

}