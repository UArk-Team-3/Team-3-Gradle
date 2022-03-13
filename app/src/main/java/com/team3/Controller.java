
package com.team3;

import java.awt.event.KeyListener;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller implements ActionListener, KeyListener {
    View view;
    DBService db;

    boolean actionPanelLoaded;

    Controller(DBService db) {
        this.db = db;
    }

    public void setView(View view)
    {
        this.view = view;
    }


    @Override
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            // Added by Abubakar Qasim - Feb 24th, enable faster testing
            case KeyEvent.VK_ESCAPE:
                System.out.println("--Exiting--");
                System.exit(0);
                break;
            case KeyEvent.VK_F5:
                if (!actionPanelLoaded)
                {
                    view.loadActionPanel();
                }
                break;

        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    }

    @Override
    public void keyPressed(KeyEvent event) {
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }
}