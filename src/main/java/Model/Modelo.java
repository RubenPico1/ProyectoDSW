/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author picperru
 */
public class Modelo {

    private Connection connection;

    /**
     * Usados para la conexion con la BD
     */
    public static String url = "jdbc:mysql://localhost:3306/dws";
    private static String usuario = "root";
    private static String contra = "";
    public static Connection con;

    /**
     * Constructor que al crearse genera una conexion con la BD
     * @author RubenPico
     */
    public Modelo() {
        try {
            connection = DriverManager.getConnection(url, usuario, contra);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * devuleve una conexion la cual es creada con la BD
     * @return clientes
     * @author RubenPico
     */
    public Connection getConnection() {
        return connection;
    }
}
