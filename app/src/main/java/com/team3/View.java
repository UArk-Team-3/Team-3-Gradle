package com.team3;

import javax.swing.JFrame;
import java.awt.KeyboardFocusManager;

public class View {
    JFrame jFrame;

    PlayerEntry playerEntry;

    View(Controller controller) {
        // Define member variables
        this.jFrame = new JFrame();

        // Add key listener
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(controller);

        // Create application window
        this.jFrame.setTitle("Placeholder Title");
        this.jFrame.setSize(750, 750);
        this.jFrame.setResizable(false);
        this.jFrame.setFocusable(true);
        this.jFrame.setVisible(true);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load player entry screen
        this.playerEntry = new PlayerEntry(this.jFrame);        
    }

    public void loadActionScreen()
    {
        act_screen.start();
    }
}