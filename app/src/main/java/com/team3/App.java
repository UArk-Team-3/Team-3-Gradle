/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.team3;

import java.net.SocketException;

import com.team3.splashScreen.splashScreen;

public class App {

    public static void main(String[] args) {
        splashScreen splashScr = new splashScreen();
        splashScr.start();
        DBService db = new DBService();
        Controller controller = new Controller(db);
        View view = new View(controller);
        controller.setView(view);
        db.test();

        
        
        //db.create_player(21, "lukas", "vaughan", "SwagBunny777", "red");
        //db.create_player(14, "John", "Smith", "KebabsYourUncle", "red");
        //db.create_player(22, "Tony", "Stark", "Iron Man", "blue");
        //db.create_player(2, "Mega", "Mind", "BluesClues", "blue");
        //db.remove_player(1);
        //db.remove_player(2);
        //db.remove_player(21);
        //db.remove_player(14);
        //db.remove_player(22);

        // Selects first_name and last_name from "player" table and prints them

        // db.testQuery();

        try {
            DatagramServer server = new DatagramServer(7501, 7500);
        } catch (Exception exception) {
            System.out.println("[-] Datagram server has encountered an exception:");
            exception.printStackTrace();
        }
    }
}
