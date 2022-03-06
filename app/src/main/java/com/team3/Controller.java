
package com.team3;
import java.awt.event.MouseListener;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Controller implements MouseListener, KeyListener{

    Controller(){

    }

    //------------------------------------------------------------|
    // Required interface methods
    //------------------------------------------------------------|
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch (e.getKeyCode()) {
            // Added by Abubakar Qasim - Feb 24th, enable faster testing
            case KeyEvent.VK_ESCAPE:
                System.out.println("--Exiting--");
                System.exit(0);
                break;

            // Added by pjrios
            case KeyEvent.VK_F5:
                System.out.println("--Opening action screen--");
                act_screen.start();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}