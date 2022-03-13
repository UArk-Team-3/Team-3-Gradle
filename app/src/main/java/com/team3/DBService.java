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

    DBService() {

    }

    private Connection getConnection() {
       
        Connection conn = null;
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

    //Creating a player in the database
    //Use SQL commands to modifiy the database with these methods
    public void create_player(int id, String first_name, String last_name, String codename){
        try {
        Statement st = getConnection().createStatement();

        // Revisit later and use PreparedStatement instead. Safer and more modular
        String query = "INSERT INTO player VALUES ('" + id + "', '" + first_name + "', '" + last_name + "', '" + codename + "');";
        ResultSet rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Removing a player in the Database
    public void remove_player(int id){
        try {
            Statement st = getConnection().createStatement();
            
            // Revisit later and use PreparedStatement instead. Safer and more modular
            String query = "DELETE FROM player WHERE id = '" + id + "';";
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Modifing a player in the Database
    public void modify_player(int id, String first_name, String last_name, String codename){
        try {
            Statement st = getConnection().createStatement();
            
            // Revisit later and use PreparedStatement instead. Safer and more modular
            String query = "UPDATE player SET first_name = '" + first_name + "', last_name = '" + last_name + "', codename = '" + codename + "'  WHERE id = '" + id + "';";
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
