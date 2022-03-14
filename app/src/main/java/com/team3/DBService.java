//---------------------------------------------------------------------------------------|
/**
 *  University of Arkansas | Software Engineering (Spring 2022) | Mr. Strother | Team 3
 *  Change Date: February 13th, 2022 (Henry Schmidt)
 *  DBService Class: Control our connection with the PostgreSQL database and passes
 *  information to the classes that need it 
 */

//---------------------------------------------------------------------------------------|

package com.team3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBService {

    private final String url = "jdbc:postgresql://ec2-35-175-68-90.compute-1.amazonaws.com:5432/da1l74klnmbaus?password=d0c5b2a8fb21acb46bd2f2046696c971d61b24a42206531ddfcb6552e5eb4e76&sslmode=require&user=ujdocfowronvnp";
    private final String user = "ujdocfowronvnp";
    private final String password = "d0c5b2a8fb21acb46bd2f2046696c971d61b24a42206531ddfcb6552e5eb4e76";
    public static Connection conn;

    DBService() {
        conn = null;
    }

    private Connection getConnection() {
       
        conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void test() {
        getConnection();
    }

    // Test returning query results to print in the terminal
    public void testQuery() {
        try {
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT first_name, last_name FROM player");

            while (rs.next()) {
                System.out.print(rs.getString("first_name") + " ");
                System.out.println(rs.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute testQuery\n");
            System.out.println(e.getMessage());
        }
    }

        // Add team color to the database. Execute once.
        public void addColorColumn() {
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("ALTER TABLE player ADD team_color varchar(5);");
            } catch (SQLException e) {
                System.out.println("Failed to execute addColorColumn\n");
                System.out.println(e.getMessage());
            }
        }

    //Creating a player in the database
    //Use SQL commands to modifiy the database with these methods
    public void create_player(int id, String first_name, String last_name, String codename, String team_color){
        try {
            if (!conn.isClosed()) {
                Statement st = conn.createStatement();

                // Revisit later and use PreparedStatement instead. Safer and more modular
                String create_command = "INSERT INTO player VALUES ('" + id + "', '" + first_name + "', '" + last_name + "', '" + codename + "', '" + team_color + "');";
                st.executeUpdate(create_command);
            } else {
                System.out.println("Can't execute create_player without a connection.\n");
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute create_player\n");
            System.out.println(e.getMessage());
        }
    }

    //Removing a player in the Database
    public void remove_player(int id){
        try {
            if (!conn.isClosed()) {
                Statement st = conn.createStatement();
                
                // Revisit later and use PreparedStatement instead. Safer and more modular
                String remove_command = "DELETE FROM player WHERE id = '" + id + "';";
                st.executeUpdate(remove_command);
            } else {
                System.out.println("Can't execute remove_player without a connection.\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Modifing a player in the Database
    public void modify_player(int id, String first_name, String last_name, String codename, String team_color){
        try {
            if (!conn.isClosed()) {
                Statement st = conn.createStatement();
                
                // Revisit later and use PreparedStatement instead. Safer and more modular
                String modify_command = "UPDATE player SET first_name = '" + first_name + "', last_name = '" + last_name + "', codename = '" + codename + "', team_color = '" + team_color + "' WHERE id = '" + id + "';";
                st.executeUpdate(modify_command);
            } else {
                System.out.println("Can't execute modify_player without a connection.\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
