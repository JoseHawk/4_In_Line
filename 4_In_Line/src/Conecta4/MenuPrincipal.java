package Conecta4;

//Paquetes necesarios que importar
import javax.swing.*;
import java.awt.AWTKeyStroke.*;
import java.io.*;

/**Clase que representa el menu principal del programa.
 */
public class MenuPrincipal extends javax.swing.JFrame implements Serializable{

    /**Dato miembro: menuPrincipal que representa el menu principal del programa
     */
    private MenuPrincipal menuPrincipal;
    /**Dato miembro: menuJuego que representa el menu de creacion de un nuevo juego
     */
    private MenuJuegoNuevo menuJuego;
    /**Dato miembro: listaUsuarios que representa la lista de usuarios
     */
    private ListaUsuarios listaUsuarios;
    /**Dato miembro: menuUsuario que representa el menu de creacion de usuarios
     */
    private MenuUsuario menuUsuario;
    /**Dato miembro: menuEstadisticas que representa el menu de estadisticas de los usuarios
     */
    private MenuEstadisticas menuEstadisticas;
    /**Dato miembro: juegoNuevo que representa a un juego nuevo
     */
    private JuegoNuevo juegoNuevo;
    /**Dato miembro: juegoNuevoInterfaz que representa la interfaz grafica de un juego nuevo
     */
    private JuegoNuevoInterfaz juegoNuevoInterfaz;
    

    /**Constructor de la clase. Crea una nueva lista de usuarios, un nuevo menu de usuarios, un nuevo menu de
     * creacion de juego nuevo y un nuevo menu de estadisticas de usuarios.
     */
    public MenuPrincipal() {

        initComponents();

        listaUsuarios=new ListaUsuarios();
        //Cargamos la lista de usuarios
        listaUsuarios.cargarListaUsuarios();
        
        this.menuUsuario=new MenuUsuario(this);
        this.menuUsuario.pack();
        this.menuUsuario.setVisible(false);
        this.menuUsuario.setResizable(false);
        this.menuUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.menuJuego=new MenuJuegoNuevo(this,juegoNuevoInterfaz,juegoNuevo);
        this.menuJuego.pack();
        this.menuJuego.setVisible(false);
        this.menuJuego.setResizable(false);
        this.menuJuego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.menuEstadisticas=new MenuEstadisticas(this);
        this.menuEstadisticas.pack();
        this.menuEstadisticas.setVisible(false);
        this.menuEstadisticas.setResizable(false);
        this.menuEstadisticas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 

    }//Final del constructor

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        nuevoJuego = new javax.swing.JMenu();
        guardarJuego = new javax.swing.JMenu();
        cargarJuego = new javax.swing.JMenu();
        estadisticas = new javax.swing.JMenu();
        instrucciones = new javax.swing.JMenu();
        usuario = new javax.swing.JMenu();
        salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nuevoJuego.setMnemonic('N');
        nuevoJuego.setText("Juego nuevo");
        nuevoJuego.setToolTipText("Nuevo Juego");
        nuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                juegoNuevoMouseClicked(evt);
            }
        });
        jMenuBar1.add(nuevoJuego);

        guardarJuego.setMnemonic('G');
        guardarJuego.setText("Guardar Juego");
        guardarJuego.setToolTipText("Guardar Juego");
        guardarJuego.setVisible(false);
        guardarJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarJuegoMouseClicked(evt);
            }
        });
        jMenuBar1.add(guardarJuego);

        cargarJuego.setMnemonic('C');
        cargarJuego.setText("Cargar Juego");
        cargarJuego.setToolTipText("Cargar Juego");
        cargarJuego.setVisible(false);
        cargarJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarJuegoMouseClicked(evt);
            }
        });
        jMenuBar1.add(cargarJuego);

        estadisticas.setMnemonic('T');
        estadisticas.setText("Estadisticas");
        estadisticas.setToolTipText("Estadisticas");
        estadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estadisticasMouseClicked(evt);
            }
        });
        jMenuBar1.add(estadisticas);

        instrucciones.setMnemonic('I');
        instrucciones.setText("Instrucciones");
        instrucciones.setToolTipText("Instrucciones");
        instrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instruccionesMouseClicked(evt);
            }
        });
        jMenuBar1.add(instrucciones);

        usuario.setMnemonic('U');
        usuario.setText("Usuario");
        usuario.setToolTipText("Usuario");
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(usuario);

        salir.setMnemonic('S');
        salir.setText("Salir");
        salir.setToolTipText("Salida");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        jMenuBar1.add(salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**Metodo de interaccion sobre el boton Juego Nuevo. Muestra el menu de juego nuevo.
     *
     * @param evt evento MouseEvent
     */
    private void juegoNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameMouseClicked
        
        this.menuJuego.setVisible(true);
        //En el area de texto mostramos la lista de usuarios
        this.menuJuego.devolverAreaDeTexto().setText(listaUsuarios.mostrarListaUsuarios());

    }//GEN-LAST:event_newGameMouseClicked

    /**Metodo de interaccion sobre el boton Guardar Partida. Guarda la partida que se este jugando.
     *
     * @param evt evento MouseEvent
     */
    private void guardarJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveGameMouseClicked
        
        this.menuJuego.devolverJuegoNuevo().guardarTablero();
    }//GEN-LAST:event_saveGameMouseClicked

    /**Metodo de interaccion sobre el boton Cargar Partida. Carga una partida.
     *
     * @param evt evento MouseEvent
     */
    private void cargarJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadGameMouseClicked
        
        this.menuJuego.devolverJuegoNuevo().cargarTablero();
    }//GEN-LAST:event_loadGameMouseClicked

    /**Metodo de interaccion sobre el boton Menu Estadisticas. Muestra el menu de estadisticas de usuarios.
     *
     * @param evt evento MouseEvent
     */
    private void estadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stadisticsMouseClicked
        
        this.menuEstadisticas.setVisible(true);
    }//GEN-LAST:event_stadisticsMouseClicked

    /**Metodo de interaccion sobre el boton Instrucciones. Muestra en una ventana las instrucciones del juego.
     *
     * @param evt evento MouseEvent
     */
    private void instruccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructionsMouseClicked
        
          JDialog instrucciones=new JDialog();
          JTextArea explicacion=new JTextArea("Para ganar: conecta cuatro fichas en una columna, fila o diagonal");
          instrucciones.add(explicacion);
          instrucciones.pack();
          instrucciones.setVisible(true);
          instrucciones.setResizable(false);
          instrucciones.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_instructionsMouseClicked

    /**Metodo de interaccion sobre el boton Menu Usuario. Muestra el menu de usuarios.
     *
     * @param evt evento MouseEvent
     */
    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        
        this.menuUsuario.setVisible(true);
    }//GEN-LAST:event_userMouseClicked

    /**Metodo de interaccion sobre el boton Salir. Fuerza la salida del programa.
     *
     * @param evt evento MouseEvent
     */
    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    /**Metodo que devuelve la pestania del menu de guardar juego.
     *
     * @return guardarJuego opcion de la barra de menus
     */
    public javax.swing.JMenu devolverMenuGuardarJuego(){
        return guardarJuego;
    }

    /**Metodo que devuelve la pestania del menu de cargar juego.
     *
     * @return cargarJuego opcion de la barra de menus
     */
    public javax.swing.JMenu devolverMenuCargarJuego(){
        return cargarJuego;
    }


    /**Metodo que devuelve la pestania del menu de juego nuevo
     *
     * @return nuevoJuego opcion de la barra de menus
     */
    public javax.swing.JMenu devolverJuegoNuevo(){
        return nuevoJuego;
    }

    /**Metodo que devuelve la pestania del menu de estadisticas
     *
     * @return estadisticas ocpion de la barra de menus
     */
    public javax.swing.JMenu devolverMenuEstadisticas(){
        return estadisticas;
    }


    /**Metodo que devuelve la pestania del menu de usuario
     *
     * @return usuario opcion de la barra de menus
     */
    public javax.swing.JMenu devolverUsuario(){
        return usuario;
    }

    /**Metodo que devuelve el juego nuevo
     *
     * @return menuJuego que represeta el menu de juego nuevo
     */
    public MenuJuegoNuevo devolverMenuJuegoNuevo(){
        return menuJuego;
    }

    /**Metodo que devuelve el menu de usuarios
     *
     * @return menuUsuario que representa el menu de usuarios
     */
    public MenuUsuario devolverMenuUsuario(){
        return menuUsuario;
    }

    /**Metodo que devuelve la lista de usuarios
     *
     * @return listaUsuarios que representa la lista de usuarios
     */
    public ListaUsuarios devolverListaUsuarios(){
        return listaUsuarios;
    }


    /**Nos permite ejecutar el programa
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu salir;
    private javax.swing.JMenu instrucciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu cargarJuego;
    private javax.swing.JMenu nuevoJuego;
    private javax.swing.JMenu guardarJuego;
    private javax.swing.JMenu estadisticas;
    private javax.swing.JMenu usuario;
    // End of variables declaration//GEN-END:variables

}
