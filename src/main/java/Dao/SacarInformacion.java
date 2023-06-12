/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author picperru
 */
public class SacarInformacion {

    /**
     * Identificador de la conexion
     */
    private Connection con;
    /**
     * Identificador del modelo
     */
    private Modelo modelo = new Modelo();
    /**
     * Identificadores de los clientes todos sus datos
     */
    private String DNI;
    private String id_mer;
    private String id_parque;
    private String id_caja;
    private String id_evento;
    private String num_pulsera;
    private String nombre;
    private String apellidos;
    private String alergias;
    private String edad;
    /**
     * Identificadores de los eventos todos sus datos
     */
    private String ID_EVENTO;//podria aprovechar las variables de arriba para esto pero meh
    private String ID_PARQUE_;
    private String DNI_ORGANIZADOR;
    private String TIPO;
    private String N__ASISTENTES;
    private String PRECIO;
    private String DURACION;
    private String FECHA;
    private String N__PULSERA;

    /**
     * Devuelve todos los datos de todos los clientes de la base de datos para su posterior tratamiento
     * @return clientes
     * @author RubenPico
     */
    public ArrayList<String[]> clientes() {
        ArrayList<String[]> Clientes = new ArrayList<>();
        con = modelo.getConnection();
        String sql = "select * from cliente";
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String[] Cliente = new String[10];
                DNI = res.getString("DNI");
                id_mer = res.getString("ID_MER");
                id_parque = res.getString("ID_PARQUE_");
                id_caja = res.getString("ID_CAJ");
                id_evento = res.getString("ID_EVENTO");
                num_pulsera = res.getString("N__PULSERA");
                nombre = res.getString("NOMBRE");
                apellidos = res.getString("APELLIDO");
                alergias = res.getString("ALERGIAS");
                edad = res.getString("EDAD");
                Cliente[0] = DNI;
                Cliente[1] = id_mer;
                Cliente[2] = id_parque;
                Cliente[3] = id_caja;
                Cliente[4] = id_evento;
                Cliente[5] = num_pulsera;
                Cliente[6] = nombre;
                Cliente[7] = apellidos;
                Cliente[8] = alergias;
                Cliente[9] = edad;
                Clientes.add(Cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SacarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Clientes;
    }
    /**
     * Devuelve todos los datos de todos los eventos de la base de datos para su posterior tratamiento
     * @return clientes
     * @author RubenPico
     */
    public ArrayList<String[]> eventos() {
        ArrayList<String[]> eventos = new ArrayList<>();
        con = modelo.getConnection();
        String sql = "select * from evento";
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String[] evento = new String[9];
                ID_EVENTO = res.getString("ID_EVENTO");
                ID_PARQUE_ = res.getString("ID_PARQUE_");
                DNI_ORGANIZADOR = res.getString("DNI_ORGANIZADOR");
                TIPO = res.getString("TIPO");
                N__ASISTENTES = res.getString("N__ASISTENTES");
                PRECIO = res.getString("PRECIO");
                DURACION = res.getString("DURACION");
                FECHA = res.getString("FECHA");
                N__PULSERA = res.getString("N__PULSERA");
                evento[0] = ID_EVENTO;
                evento[1] = ID_PARQUE_;
                evento[2] = DNI_ORGANIZADOR;
                evento[3] = TIPO;
                evento[4] = N__ASISTENTES;
                evento[5] = PRECIO;
                evento[6] = DURACION;
                evento[7] = FECHA;
                evento[8] = N__PULSERA;
                eventos.add(evento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SacarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }

    /**
     * Realiza una insert de los clientes en la BD
     * @author RubenPico
     * @param dni
     * @param mer
     * @param parque
     * @param caja
     * @param evento
     * @param numeropulsera
     * @param nombre
     * @param apellido
     * @param alergias
     * @param edad
     * @return un 0 si ha fallado la operacion y un uno si ha funcionado
     */
    public int meterResultados(String dni, int mer, int parque, int caja, int evento, int numeropulsera, String nombre, String apellido, String alergias, int edad) {
        int rese = 0;
        con = modelo.getConnection();
        String sql = "insert into cliente (DNI, ID_MER, ID_PARQUE_, ID_CAJ, ID_EVENTO, N__PULSERA , NOMBRE, APELLIDO, ALERGIAS, EDAD)"
                + " values ('" + dni + "'," + mer + "," + parque + "," + caja + "," + evento + "," + numeropulsera + ",'" + nombre + "','" + apellido + "','" + alergias + "'," + edad + ");";
        try {
            Statement st = con.createStatement();
            int res = st.executeUpdate(sql);
            if (res > 0) {
                rese = 1;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rese;
    }
    /**
     * BUsca y saca la informacion de un cliente concreta siendo buscado por su dni
     * @author RubenPico
     * @param dni
     * @return Cliente buscado
     */
     public ArrayList<String[]> buscarClientes(String dni) {
        ArrayList<String[]> Clientes = new ArrayList<>();
        con = modelo.getConnection();
        String sql = "select * from cliente where DNI like '"+dni+"';";
        try {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                String[] Cliente = new String[10];
                DNI = res.getString("DNI");
                id_mer = res.getString("ID_MER");
                id_parque = res.getString("ID_PARQUE_");
                id_caja = res.getString("ID_CAJ");
                id_evento = res.getString("ID_EVENTO");
                num_pulsera = res.getString("N__PULSERA");
                nombre = res.getString("NOMBRE");
                apellidos = res.getString("APELLIDO");
                alergias = res.getString("ALERGIAS");
                edad = res.getString("EDAD");
                Cliente[0] = DNI;
                Cliente[1] = id_mer;
                Cliente[2] = id_parque;
                Cliente[3] = id_caja;
                Cliente[4] = id_evento;
                Cliente[5] = num_pulsera;
                Cliente[6] = nombre;
                Cliente[7] = apellidos;
                Cliente[8] = alergias;
                Cliente[9] = edad;
                Clientes.add(Cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SacarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Clientes;
    }

}
