/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIew;

import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author picperru
 */
public class MenuPrincipalf extends javax.swing.JFrame {

    public DefaultTableModel modelo= new DefaultTableModel();
    
    public MenuPrincipalf() {
        initComponents();
        Tabla.setModel(modelo);
    }
    /**
     * Metodos de los botones y menus
     * @return lo que genere el eveto
     * @author RubenPico
     */
    public JMenuItem getCliente() {
        return Cliente;
    }

    public void setCliente(JMenuItem getCliente) {
        this.Cliente = getCliente;
    }

    public JMenuItem getEvento() {
        return Evento;
    }

    public void setEvento(JMenuItem getEvento) {
        this.Evento = getEvento;
    }

    public JMenuItem getSetCliente() {
        return setCliente;
    }

    public void setSetCliente(JMenuItem setCliente) {
        this.setCliente = setCliente;
    }

    public JMenuItem getSetMonitor() {
        return setMonitor;
    }

    public void setSetMonitor(JMenuItem setMonitor) {
        this.setMonitor = setMonitor;
    }

    public JMenuItem getBuscarCliente() {
        return BuscarCliente;
    }

    public void setBuscarCliente(JMenuItem BuscarCliente) {
        this.BuscarCliente = BuscarCliente;
    }
    
    
    
    /**
     * Recoge los datos de una pregunta cuyo texto es pasado
     * @author RubenPico
     * @param mensaje
     * @return lo que el usuario introduzca
     */
    public String obtenerEntrada(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }
    /**
     * Muestre un mensaje con el texto que se le pase
     * @author RubenPico
     * @param mensaje
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        Info = new javax.swing.JMenu();
        Cliente = new javax.swing.JMenuItem();
        BuscarCliente = new javax.swing.JMenuItem();
        Evento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        setCliente = new javax.swing.JMenuItem();
        setMonitor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.setEnabled(false);
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        Info.setText("Ver Información");

        Cliente.setText("Clientes");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        Info.add(Cliente);

        BuscarCliente.setText("Buscar Cliente");
        Info.add(BuscarCliente);

        Evento.setText("Eventos");
        Info.add(Evento);

        jMenuBar1.add(Info);

        jMenu2.setText("Meter Información");

        setCliente.setText("Cliente");
        jMenu2.add(setCliente);

        setMonitor.setText("Monitor");
        jMenu2.add(setMonitor);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ver inventario");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Opciones");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        
    }//GEN-LAST:event_ClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BuscarCliente;
    private javax.swing.JMenuItem Cliente;
    private javax.swing.JMenuItem Evento;
    private javax.swing.JMenu Info;
    private javax.swing.JTable Tabla;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem setCliente;
    private javax.swing.JMenuItem setMonitor;
    // End of variables declaration//GEN-END:variables
}
