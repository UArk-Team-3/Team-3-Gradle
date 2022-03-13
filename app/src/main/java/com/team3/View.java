package com.team3;

import javax.swing.JFrame;
import java.awt.Container;

public class View {
    JFrame jFrame;
    Controller controller;

    PlayerEntry playerEntry;
    act_screen act_screen;

    Container playerEntryPanel;
    Container playerActionPanel;

    View(Controller controller) {
        // Define member variables
        this.jFrame = new JFrame();
        this.controller = controller;

        // Create application window
        this.jFrame.addKeyListener(controller);
        this.jFrame.setTitle("Placeholder Title");
        this.jFrame.setSize(750, 750);
        this.jFrame.setResizable(false);
        this.jFrame.setFocusable(true);
        this.jFrame.setVisible(true);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load player entry screen
        this.playerEntry = new PlayerEntry(this.jFrame, this.controller);
    }

    public void loadActionPanel()
    {
        this.playerEntryPanel = this.jFrame.getContentPane();
        this.jFrame.getContentPane().removeAll();
        this.act_screen = new act_screen(this.jFrame, this.controller);
    }
}
