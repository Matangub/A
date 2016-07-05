package com.company;

/**
 * Created by matan on 6/17/16.
 */

import java.sql.*;

public class Sql {

    private String url;
    private String driver;
    private String dbName;
    private String userName;
    private String password;
    private Statement st;
    private Connection conn;

    public Sql(String dbname, String username, String password){
        this.url = "jdbc:mysql://localhost:3306/";
        this.dbName = dbname;
        this.driver = "com.mysql.jdbc.Driver";
        this.userName = username;
        this.password = password;
        this.conn = null;

    }

    public void connect() {
        try {
            Class.forName(this.driver).newInstance();
            this.conn = DriverManager.getConnection(this.url+this.dbName,this.userName,this.password);
            this.st = conn.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printData(String preFix, ResultSet data, String columns) {
        try {
            while (data.next()) {
                System.out.println(preFix + " " + data.getString(columns));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDB() {
        return this.dbName;
    }

    public ResultSet Execute(String query) {
        try {
            return this.st.executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {

        try {

            this.conn.close();
        }
        catch(Exception e) {

            e.printStackTrace();
        }
    }
}
