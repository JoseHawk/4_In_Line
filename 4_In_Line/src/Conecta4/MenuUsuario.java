package Conecta4;

//Paquetes necesarios que importar
import javax.swing.*;
import java.io.*;

/**Clase destinada a la creacion de usuarios
 */
public class MenuUsuario extends javax.swing.JFrame implements Serializable{

    /**Dato miembro: nick del usuario
     */
    private String nick;
    /**Dato miembro: contrasenia del usuario
     */
    private String contrasenia;
    /**Dato miembro: menuPrincipal que representa el menu principal del juego
     */
    private MenuPrincipal menuPrincipal;

    /**Constructor de la clase que recibe como argumento el menu principal y contiene los componentes de la
     * interfaz grafica
     * @param menuPrincipal que representa el menu principal del juego
     */
    public MenuUsuario(MenuPrincipal menuPrincipal) {

        initComponents();
        this.menuPrincipal=menuPrincipal;

    }//Final del constructor

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto_nick = new javax.swing.JLabel();
        texto_contrasenia = new javax.swing.JLabel();
        entradaNick = new javax.swing.JTextField();
        entradaContrasenia = new javax.swing.JPasswordField();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texto_nick.setText("Nick");
        texto_nick.setToolTipText("Nick");

        texto_contrasenia.setText("Contrasenia:");
        texto_contrasenia.setToolTipText("Contrasenia");

        entradaNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaNickActionPerformed(evt);
            }
        });

        entradaContrasenia.setToolTipText("EntradaContrasenia");

        botonAceptar.setBackground(new java.awt.Color(153, 0, 153));
        botonAceptar.setForeground(new java.awt.Color(255, 0, 0));
        botonAceptar.setText("ACEPTAR");
        botonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(texto_contrasenia)
                    .addComponent(texto_nick)
                    .addComponent(entradaContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(entradaNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(texto_nick)
                        .addGap(18, 18, 18)
                        .addComponent(entradaNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(texto_contrasenia)
                        .addGap(26, 26, 26)
                        .addComponent(entradaContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaNickActionPerformed
        
    }//GEN-LAST:event_entradaNickActionPerformed

    /**Metodo de interaccion sobre el boton Aceptar. Crea un nuevo usuario
     *
     * @param evt evento ActionEvent
     */
    private void botonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAceptarMouseClicked

       //Accedemos a lo escrito en los campos correspondientes de nick y contrasenia
        nick=entradaNick.getText();
        contrasenia=entradaContrasenia.getText();

        //Si no existe ningun usuario con ese nick
        if(this.menuPrincipal.devolverListaUsuarios().comprobarNick(nick)==false){
            //Lo creamos y aniadimos a la lista
            Usuario usuario=new Usuario(nick,contrasenia);
            this.menuPrincipal.devolverListaUsuarios().devolverHashMap().put(nick,usuario);
            JOptionPane.showMessageDialog(null,"Usuario aniadido");
            //Guardamos la lista de usuarios
            this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
        }else{
            JOptionPane.showMessageDialog(null,"El usuario ya existe");
        }
        
        
    }//GEN-LAST:event_botonAceptarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JPasswordField entradaContrasenia;
    private javax.swing.JTextField entradaNick;
    private javax.swing.JLabel texto_contrasenia;
    private javax.swing.JLabel texto_nick;
    // End of variables declaration//GEN-END:variables

}
