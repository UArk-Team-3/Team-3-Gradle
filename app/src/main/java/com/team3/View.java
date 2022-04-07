package com.team3;

import javax.swing.JFrame;
import java.awt.KeyboardFocusManager;
import java.util.ArrayList;

public class View {
    JFrame jFrame;
    act_screen act_screen;

    PlayerEntry playerEntry;

    // Player information and scores
    public static ArrayList<String> blueFirst = new ArrayList<>();
    public static ArrayList<String> blueLast = new ArrayList<>();
    public static ArrayList<String> blueCode = new ArrayList<>();
    public static int[] blueScores = new int[15];
    public static int blueScore = 0;
    public static ArrayList<String> redFirst = new ArrayList<>();
    public static ArrayList<String> redLast = new ArrayList<>();
    public static ArrayList<String> redCode = new ArrayList<>();
    public static int[] redScores = new int[15];
    public static int redScore = 0;

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
        this.act_screen = new act_screen();
        this.act_screen.start();
    }

    public void printValues(){

        for(int i = 0; i < blueFirst.size(); i++){
            System.out.println("First: " + blueFirst.get(i) + "Last: " + blueLast.get(i) + "Code: " + blueCode.get(i));
        }
        
        for(int i = 0; i < redFirst.size(); i++){
            System.out.println("First: " + redFirst.get(i) + "Last: " + redLast.get(i) + "Code: " + redCode.get(i));
        }
    }
}