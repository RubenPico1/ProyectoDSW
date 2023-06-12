/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.SacarInformacion;
import Model.Modelo;
import VIew.MenuPrincipalf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author picperru
 */
public class ControladorPrincipal implements ActionListener {

    private Modelo modelo;
    private MenuPrincipalf vista;
    private SacarInformacion Dao;
    /**
     * Informacion recuperada de la BD se almacena aqui
     */
    private ArrayList<String[]> clientesoEventos = new ArrayList<>();//variable reutilizada para recuperar datos de la BD
    /**
     * Nombres de las columnas de las tablas
     */
    private String[] nombresClientes = {"DNI", "ID_MER", "ID_PARQUE_", "ID_CAJ", "ID_EVENTO", "N__PULSERA", "NOMBRE", "APELLIDO", "ALERGIAS", "EDAD"};
    private String[] nombresEventos = {"ID_EVENTO", "ID_PARQUE_", "DNI_ORGANIZADOR", "TIPO", "N__ASISTENTES", "PRECIO", "DURACION", "FECHA", "	N__PULSERA"};

    /**
     * Devuelve todos los datos de todos los clientes de la base de datos para
     * su posterior tratamiento
     *
     * @author RubenPico
     */
    public ControladorPrincipal(Modelo modelo, MenuPrincipalf view, SacarInformacion dao) {
        this.modelo = modelo;
        this.Dao = dao;
        this.vista = view;
    }

    /**
     * Inicia la vista principal
     *
     * @author RubenPico
     */
    public void iniciarVista() {
        vista.setTitle("Principal");
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.setResizable(false);
        this.vista.getCliente().addActionListener(this);
        this.vista.getEvento().addActionListener(this);
        this.vista.getSetCliente().addActionListener(this);
        this.vista.getSetMonitor().addActionListener(this);
        this.vista.getBuscarCliente().addActionListener(this);
    }

    /**
     * Comprueba que elemento de la vista a ocasionado el evento, y realiza los
     * metodos del DAO
     *
     * @author RubenPico
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        while (vista.modelo.getRowCount() > 0) {
            vista.modelo.removeRow(0);
        }//no quita los nombres de la columnas
        if (evento.getSource() == vista.getCliente()) {//cuando se seleciona el boton de informacion de los clientes, se llama al metodo del dao para recuperar los clientes
            clientesoEventos = Dao.clientes();//se meten en una variable
            vista.modelo.setColumnIdentifiers(nombresClientes);
            meterenTabla();//y se ponen en la tabla
        } else if (evento.getSource() == vista.getEvento()) {
            clientesoEventos = Dao.eventos();//se meten los eventos en una mariable
            vista.modelo.setColumnIdentifiers(nombresEventos);
            meterenTabla();
        } else if (evento.getSource() == vista.getSetCliente()) {//lamadas consecuitavas a un metodo de JOptionpane para recoger datos y hacer la introduccion
            String DNI = vista.obtenerEntrada("Introduzca el dni del cliente");//cabe decir que las comprobaciones no estan realizadas, por lo que se puede introducir valores que haga que den error
            String ID_MER = vista.obtenerEntrada("Introduzca el ID_MER del cliente");
            String ID_PARQUE_ = vista.obtenerEntrada("Introduzca el ID_PARQUE_ del cliente");
            String ID_CAJ = vista.obtenerEntrada("Introduzca el ID_CAJ del cliente");
            String ID_EVENTO = vista.obtenerEntrada("Introduzca el ID_EVENTO del cliente");
            String N__PULSERA = vista.obtenerEntrada("Introduzca el N__PULSERA del cliente");
            String NOMBRE = vista.obtenerEntrada("Introduzca el NOMBRE del cliente");
            String APELLIDO = vista.obtenerEntrada("Introduzca el APELLIDO del cliente");
            String ALERGIAS = vista.obtenerEntrada("Introduzca el ALERGIAS del cliente");
            String EDAD = vista.obtenerEntrada("Introduzca el EDAD del cliente");
            int numero = Dao.meterResultados(DNI, Integer.parseInt(ID_MER), Integer.parseInt(ID_PARQUE_), Integer.parseInt(ID_CAJ), Integer.parseInt(ID_EVENTO), Integer.parseInt(N__PULSERA), NOMBRE, APELLIDO, ALERGIAS, Integer.parseInt(EDAD));
            if (numero == 1) {
                vista.mostrarMensaje("Cliente introducido correctamente");
            } else {
                vista.mostrarMensaje("Error al introducir cliente");
            }
        } else if (evento.getSource() == vista.getSetMonitor()) {

        } else if (evento.getSource() == vista.getBuscarCliente()) {
            String dni = vista.obtenerEntrada("Introduze el DNI del cliente que desea buscar");
            clientesoEventos = Dao.buscarClientes(dni);
            if (clientesoEventos.isEmpty()) {
                vista.mostrarMensaje("El dni que ha introducido no existe");
            } else {
                vista.modelo.setColumnIdentifiers(nombresClientes);
                meterenTabla();
            }
        }
    }

    /**
     * Mete los elementos en la tabla para su visualización
     *
     * @author RubenPico
     */
    private void meterenTabla() {
        for (String[] jugador : clientesoEventos) {
            vista.modelo.addRow(jugador);
        }
    }
}
