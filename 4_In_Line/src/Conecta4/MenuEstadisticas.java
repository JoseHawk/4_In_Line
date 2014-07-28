package Conecta4;

//Paquete necesario que importar
import javax.swing.JOptionPane;

/**Clase dedicada a las estadisticas de los usuarios (partidas ganadas, perdidas y jugadas)
 */
public class MenuEstadisticas extends javax.swing.JFrame {

    /**Dato miembro: menuPrincipal que hace referencia al menu principal del juego
     */
    private MenuPrincipal menuPrincipal;
    /**Dato miembro: nick del usuario
     */
    private String nick;
    /**Dato miembro: contrasenia del usuario
     */
    private String contrasenia;

    /**Constructor de la clase que contiene los componentes de la interfaz grafica asi como la referencia del menu
     * principal
     * @param menuPrincipal que hace referencia al menu principal del juego
     */
    public MenuEstadisticas(MenuPrincipal menuPrincipal) {

        initComponents();
        this.menuPrincipal=menuPrincipal;

    }//Final del constructor

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto_usuarios = new javax.swing.JTextArea();
        texto_datosUsuarios = new javax.swing.JLabel();
        texto_datosUsuarioConcreto = new javax.swing.JLabel();
        texto_reiniciciarEstadisticas = new javax.swing.JLabel();
        boton_reiniciarEstadisticas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTexto_usuarioConcreto = new javax.swing.JTextArea();
        campo_usuario = new javax.swing.JTextField();
        campo_contrasenia = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boton_aceptar = new javax.swing.JButton();
        boton_mostrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campo_NombreAdministrador = new javax.swing.JTextField();
        campo_ContraseniaAdministrador = new javax.swing.JPasswordField();
        boton_reiniciarTodasEstadisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTexto_usuarios.setColumns(20);
        areaTexto_usuarios.setRows(5);
        jScrollPane1.setViewportView(areaTexto_usuarios);

        texto_datosUsuarios.setText("Datos usuarios:");

        texto_datosUsuarioConcreto.setText("Datos usuario concreto");

        texto_reiniciciarEstadisticas.setText("Reiniciar estadisticas jugador:");

        boton_reiniciarEstadisticas.setText("Reiniciar");
        boton_reiniciarEstadisticas.setToolTipText("Reiniciar");
        boton_reiniciarEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_reiniciarEstadisticasMouseClicked(evt);
            }
        });

        areaTexto_usuarioConcreto.setColumns(20);
        areaTexto_usuarioConcreto.setRows(5);
        jScrollPane2.setViewportView(areaTexto_usuarioConcreto);

        jLabel1.setText("Nick:");

        jLabel2.setText("Contrasenia:");

        boton_aceptar.setText("Aceptar");
        boton_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_aceptarMouseClicked(evt);
            }
        });

        boton_mostrar.setText("Mostrar");
        boton_mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_mostrarMouseClicked(evt);
            }
        });

        jLabel3.setText("Reiniciar estadisticas usuarios");

        boton_reiniciarTodasEstadisticas.setText("Reiniciar todo");
        boton_reiniciarTodasEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_reiniciarTodasEstadisticasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(texto_datosUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(texto_datosUsuarioConcreto)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(boton_mostrar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campo_NombreAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campo_ContraseniaAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campo_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(campo_contrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                    .addGap(51, 51, 51))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(boton_aceptar)
                                    .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(texto_reiniciciarEstadisticas)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(52, 52, 52)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(boton_reiniciarEstadisticas)
                                .addGap(108, 108, 108))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(285, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(boton_reiniciarTodasEstadisticas)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_datosUsuarios)
                    .addComponent(texto_datosUsuarioConcreto, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addComponent(boton_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_mostrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_reiniciciarEstadisticas)
                        .addGap(18, 18, 18)
                        .addComponent(boton_reiniciarEstadisticas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_NombreAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo_ContraseniaAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_reiniciarTodasEstadisticas)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**Metodo de interaccion sobre el boton aceptar. Muestra las estadisticas del usuario cucyos datos han sido
     * escritos en los campos de contrasenia y nick
     * @param evt evento MouseEvent
     */
    private void boton_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceptarMouseClicked

        //Accedemos a lo escrito en los campos correspondientes de nick y contrasenia
        nick=campo_usuario.getText();
        contrasenia=campo_contrasenia.getText();

        //Comprobamos si existe usuario con dicha contrasenia y nick
        boolean usuarioExiste=this.menuPrincipal.devolverListaUsuarios().comprobarUsuario(nick, contrasenia);

        //En caso de que exista lo mostramos en la correspondiente area de texto
        if(usuarioExiste==true){

            Usuario usuario=this.menuPrincipal.devolverListaUsuarios().devolverUsuario(nick);
            areaTexto_usuarioConcreto.setText(usuario.toString());
        
        }
    }//GEN-LAST:event_boton_aceptarMouseClicked

    /**Metodo de interaccion sobre el boton mostrar. Muestra la estadisticas de todos los usarios
     *
     * @param evt evento MouseEvent
     */
    private void boton_mostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_mostrarMouseClicked
   
        areaTexto_usuarios.setText(this.menuPrincipal.devolverListaUsuarios().mostrarDatosUsuarios());
    }//GEN-LAST:event_boton_mostrarMouseClicked

    /**Metodo de interaccion sobre el boton reiniciar. Reinicia las estadisticas del usuario cuyos datos han sido
     * escritos sobre los campos de contrasenia y nick
     * @param evt evento MouseEvent
     */
    private void boton_reiniciarEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_reiniciarEstadisticasMouseClicked

        //Accedemos a lo escrito en los campos correspondientes al nombre y la contrasenia
        nick=campo_usuario.getText();
        contrasenia=campo_contrasenia.getText();

        //Comprobamos si existe algun usuario con dichos nombre y contrasenia
        boolean usuarioExiste=this.menuPrincipal.devolverListaUsuarios().comprobarUsuario(nick, contrasenia);

        //Si existe
        if(usuarioExiste==true){

            //Lanzamos un mensaje de advertencia
            Object[] opciones = {"Si","No"};
            int seleccion=JOptionPane.showOptionDialog(null,"¿Desea realmente reiniciar las estadisticas?","Reiniciar estadisticas",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);

            if(seleccion==0){
                //En caso de aceptar, se reinician sus estadisticas
                Usuario usuario=this.menuPrincipal.devolverListaUsuarios().devolverUsuario(nick);
                usuario.reiniciarEstadisticas();
                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
            }
        
        }
    }//GEN-LAST:event_boton_reiniciarEstadisticasMouseClicked

    private void boton_reiniciarTodasEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_reiniciarTodasEstadisticasMouseClicked

        //Accedemos a lo escrito en los campos correspondientes al nombre y la contrasenia del administrador
        nick=campo_NombreAdministrador.getText();
        contrasenia=campo_NombreAdministrador.getText();

        //Si los datos coinciden con los del administrador reiniciamos los datosd e todos los usuarios
        if(nick.equals("Admin") && contrasenia.equals("Admin")){
            this.menuPrincipal.devolverListaUsuarios().reiniciarDatosUsuarios();
        }else{
            JOptionPane.showMessageDialog(null,"No tiene los permisos necesarios para realizar esta operacion");
        }
    }//GEN-LAST:event_boton_reiniciarTodasEstadisticasMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto_usuarioConcreto;
    private javax.swing.JTextArea areaTexto_usuarios;
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_mostrar;
    private javax.swing.JButton boton_reiniciarEstadisticas;
    private javax.swing.JButton boton_reiniciarTodasEstadisticas;
    private javax.swing.JPasswordField campo_ContraseniaAdministrador;
    private javax.swing.JTextField campo_NombreAdministrador;
    private javax.swing.JPasswordField campo_contrasenia;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel texto_datosUsuarioConcreto;
    private javax.swing.JLabel texto_datosUsuarios;
    private javax.swing.JLabel texto_reiniciciarEstadisticas;
    // End of variables declaration//GEN-END:variables

}
