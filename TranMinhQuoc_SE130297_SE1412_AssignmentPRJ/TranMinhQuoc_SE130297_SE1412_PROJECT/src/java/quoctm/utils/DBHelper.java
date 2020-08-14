/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class DBHelper implements Serializable{
    public static Connection makeConnection() throws SQLException,NamingException{
        Context context = new InitialContext();
        Context tomcatContext = (Context)context.lookup("java:comp/env");
        DataSource ds = (DataSource)tomcatContext.lookup("SE130297");
        Connection con = ds.getConnection();
        return con;
        //++++ Buoc 1
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url ="jdbc:sqlserver://localhost:1433;databaseName=SE1412";
//        Connection con = DriverManager.getConnection(url, "sa", "123456");
//        return con;
        
    }
}
