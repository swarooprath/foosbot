package com.example.appengine.demos.springboot;

import java.sql.*;

public class DbManager {

    public static boolean getConnection() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        String dbName = "foosbotDB";
        String serverip="srfoosbot.database.windows.net";
        String serverport="1433";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
        Statement stmt = null;
        ResultSet result = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String databaseUserName = "foosbot";
        String databasePassword = "vdnF8BfD2ObOfzo7";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
            stmt = conn.createStatement();
            result = null;
            String pa,us;
            result = stmt.executeQuery("select * from visits ");

            while (result.next()) {
                us=result.getString("first_name");
                pa = result.getString("last_name");
                System.out.println(us+"  "+pa);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}