package dao;

import java.sql.*;
import javax.swing.*;

public class JavaConnect {

    public static Connection ConnectDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:bd\\db.sqlite");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com o banco.");
            System.exit(0);
            return null;
        }
    }
}
