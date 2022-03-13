
package com.team3;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener, KeyEventDispatcher {
    View view;
    DBService db;

    boolean actionPanelLoaded;

    Controller(DBService db) {
        this.db = db;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            // Added by Abubakar Qasim - Feb 24th, enable faster testing
            case KeyEvent.VK_ESCAPE:
                System.out.println("--Exiting--");
                System.exit(0);
                break;
            case KeyEvent.VK_F5:
                System.out.println("run");
                if (!actionPanelLoaded) {
                    view.playerEntry.updatePlayer();
                    view.loadActionPanel();
                }
                break;
        }
        return false;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    }

}