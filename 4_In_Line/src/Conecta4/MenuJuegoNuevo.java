package Conecta4;

//Paquetes necesarios que importar
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**Clase destinada a la creacion del nuevo juego de tal forma que se cree el juego en si y su interfaz
 */
public class MenuJuegoNuevo extends javax.swing.JFrame implements Serializable{

    /**Dato miembro: filas que contendra el tablero
     */
    private static int filas;
    /**Dato miembro: columnas que contendra el tablero
     */
    private static int columnas;
    /**Dato miembro: nick del usuario
     */
    private String nick;
    /**Dato miembro: contrasenia del usuario
     */
    private String contrasenia;
    /**Dato miembro: colorJugador que representa el color de las fichas del jugador.
     * Por defecto en negro
     */
    private Color colorJugador=Color.BLACK;
    /**Dato miembro: colorMaquina que representa el color de las fichas del rival.
     * Por defecto en blanco
     */
    private Color colorMaquina=Color.WHITE;
    /**Dato miembro: rival contra el que se enfrentara el usuario (maquina u otro jugador).
     * Por defecto la maquina
     */
    private int rival=0;
    /**Dato miembro: profundidadMaxima que representa el grado de dificultad de la IA.
     * Por defecto en facil
     */
    private int profundidadMaxima=2;
    /**Dato miembro: menuPrincipal que hace referencia al menu principal del juego
     */
    private MenuPrincipal menuPrincipal;
    /**Dato miembro: juegoNuevoInterfaz que hace referencia a la interfaz grafica del juego que vamos a crear
     */
    private JuegoNuevoInterfaz juegoNuevoInterfaz;
    /**Dato miembro: juegoNuevo que hace referencia al juego que vamos a crear
     */
    private JuegoNuevo juegoNuevo;
    /**Dato miembro: usuario que hace referencia al usuario que jugara la partida
     */
    private Usuario usuario;

    /**Metodo que devuelve las filas
     *
     * @return filas que contendra el tablero
     */
    public static int devolverFilas(){
        return filas;
    }

    /**Metodo que devuelve las columnas
     *
     * @return columnas que contendra el tablero
     */
    public static int devolverColumnas(){
        return columnas;
    }

    /**Constructor de la clase que recibe como argumento los objetos de las diversas clases con las que guarda relacion
     * y que contiene los componentes de la interfaz grafica
     * @param menuPrincipal que hace referencia al menu principal del juego
     * @param juegoNuevoInterfaz que hace referencia a la interfaz grafica del juego que vamos a crear
     * @param juegoNuevo que hace referencia al juego que vamos a crear
     */
    public MenuJuegoNuevo(MenuPrincipal menuPrincipal, JuegoNuevoInterfaz juegoNuevoInterfaz, JuegoNuevo juegoNuevo) {

        initComponents();
        this.menuPrincipal=menuPrincipal;
        this.juegoNuevoInterfaz=juegoNuevoInterfaz;
        this.juegoNuevo=juegoNuevo;
    
    }//Final del constructor

    /**Metodo para devolver el juego nuevo
     *
     * @return juegoNuevo que representa el nuevo juego
     */
    public JuegoNuevo devolverJuegoNuevo(){
        return juegoNuevo;
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto_rival = new javax.swing.JLabel();
        opcionRival_Amigo = new javax.swing.JCheckBox();
        opcionRival_Maquina = new javax.swing.JCheckBox();
        texto_tamanio = new javax.swing.JLabel();
        texto_usuario = new javax.swing.JLabel();
        texto_colorFicha = new javax.swing.JLabel();
        boton_colorFicha_azul = new javax.swing.JButton();
        boton_aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto_filas = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto_columnas = new javax.swing.JTextPane();
        boton_colorFicha_Rojo = new javax.swing.JButton();
        boton_colorFicha_amarillo = new javax.swing.JButton();
        boton_colorFicha_verde = new javax.swing.JButton();
        boton_colorFicha_negro = new javax.swing.JButton();
        boton_colorFicha_blanco = new javax.swing.JButton();
        boton_colorFicha_naranja = new javax.swing.JButton();
        boton_colorFicha_rosa = new javax.swing.JButton();
        campo_usuario = new javax.swing.JTextField();
        campo_contrasenia = new javax.swing.JPasswordField();
        texto_dificultad = new javax.swing.JLabel();
        boton_dificultadFacil = new javax.swing.JButton();
        boton_dificultadMedia = new javax.swing.JButton();
        boton_dificultadAvanzada = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        texto_listaUsuarios = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texto_rival.setText("Rival:");

        opcionRival_Amigo.setText("Un amigo");
        opcionRival_Amigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionRival_AmigoActionPerformed(evt);
            }
        });

        opcionRival_Maquina.setText("La maquina");
        opcionRival_Maquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionRival_MaquinaActionPerformed(evt);
            }
        });

        texto_tamanio.setText("Tamanio (Filas y columnas):");

        texto_usuario.setText("Usuario (Nick y contrasenia):");

        texto_colorFicha.setText("Color de la ficha:");

        boton_colorFicha_azul.setText("Azul");
        boton_colorFicha_azul.setToolTipText("Azul");
        boton_colorFicha_azul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_azulMouseClicked(evt);
            }
        });

        boton_aceptar.setBackground(new java.awt.Color(0, 204, 255));
        boton_aceptar.setForeground(new java.awt.Color(102, 0, 102));
        boton_aceptar.setText("ACEPTAR");
        boton_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_aceptarMouseClicked(evt);
            }
        });

        texto_filas.setText("7");
        jScrollPane1.setViewportView(texto_filas);

        texto_columnas.setText("7");
        jScrollPane2.setViewportView(texto_columnas);

        boton_colorFicha_Rojo.setText("Rojo");
        boton_colorFicha_Rojo.setToolTipText("Rojo");
        boton_colorFicha_Rojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_RojoMouseClicked(evt);
            }
        });

        boton_colorFicha_amarillo.setText("Amarillo");
        boton_colorFicha_amarillo.setToolTipText("Amarillo");
        boton_colorFicha_amarillo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_amarilloMouseClicked(evt);
            }
        });

        boton_colorFicha_verde.setText("Verde");
        boton_colorFicha_verde.setToolTipText("Verde");
        boton_colorFicha_verde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_verdeMouseClicked(evt);
            }
        });

        boton_colorFicha_negro.setText("Negro");
        boton_colorFicha_negro.setToolTipText("Negro");
        boton_colorFicha_negro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_negroMouseClicked(evt);
            }
        });

        boton_colorFicha_blanco.setText("Blanco");
        boton_colorFicha_blanco.setToolTipText("Blanco");
        boton_colorFicha_blanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_blancoMouseClicked(evt);
            }
        });

        boton_colorFicha_naranja.setText("Naranja");
        boton_colorFicha_naranja.setToolTipText("Naranja");
        boton_colorFicha_naranja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_naranjaMouseClicked(evt);
            }
        });

        boton_colorFicha_rosa.setText("Rosa");
        boton_colorFicha_rosa.setToolTipText("Rosa");
        boton_colorFicha_rosa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_colorFicha_rosaMouseClicked(evt);
            }
        });

        campo_usuario.setToolTipText("Usuario");

        campo_contrasenia.setToolTipText("Contrasenia");

        texto_dificultad.setText("Dificultad:");

        boton_dificultadFacil.setText("Facil");
        boton_dificultadFacil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_dificultadFacilMouseClicked(evt);
            }
        });

        boton_dificultadMedia.setText("Media");
        boton_dificultadMedia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_dificultadMediaMouseClicked(evt);
            }
        });

        boton_dificultadAvanzada.setText("Avanzada");
        boton_dificultadAvanzada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_dificultadAvanzadaMouseClicked(evt);
            }
        });

        texto_listaUsuarios.setColumns(20);
        texto_listaUsuarios.setRows(5);
        jScrollPane3.setViewportView(texto_listaUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_dificultad)
                    .addComponent(texto_usuario)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto_colorFicha)
                                    .addComponent(texto_tamanio)
                                    .addComponent(texto_rival)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(opcionRival_Amigo)
                                        .addGap(26, 26, 26)
                                        .addComponent(opcionRival_Maquina))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campo_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(campo_contrasenia, 0, 0, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(boton_dificultadFacil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_colorFicha_negro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_colorFicha_azul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(boton_colorFicha_Rojo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(boton_colorFicha_blanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(boton_colorFicha_naranja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(boton_colorFicha_amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(boton_dificultadMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_dificultadAvanzada)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton_colorFicha_rosa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_colorFicha_verde))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(texto_rival)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcionRival_Amigo)
                    .addComponent(opcionRival_Maquina))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_tamanio)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_usuario)
                            .addComponent(boton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_colorFicha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campo_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_colorFicha_azul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_colorFicha_negro)
                        .addGap(18, 18, 18)
                        .addComponent(texto_dificultad))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_colorFicha_Rojo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_colorFicha_blanco))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_colorFicha_verde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_colorFicha_rosa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_colorFicha_amarillo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_colorFicha_naranja)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_dificultadFacil)
                    .addComponent(boton_dificultadAvanzada)
                    .addComponent(boton_dificultadMedia))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**Metodo de interaccion sobre el boton rival amigo. Selecciona a un amigo como rival.
     *
     * @param evt evento ActionEvent
     */
    private void opcionRival_AmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionRival_AmigoActionPerformed
        
        rival=1;
        opcionRival_Maquina.setSelected(false);
    }//GEN-LAST:event_opcionRival_AmigoActionPerformed

    /**Metodo de interaccion sobre el boton rival maquina. Selecciona a la maquina como rival
     *
     * @param evt evento ActionEvent
     */
    private void opcionRival_MaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionRival_MaquinaActionPerformed
        
        rival=0;
        opcionRival_Amigo.setSelected(false);
    }//GEN-LAST:event_opcionRival_MaquinaActionPerformed

    /**Metodo de interaccion sobre el boton aceptar. Crea el nuevo juego, asi como su interfaz grafica con los datos
     * pasados
     * @param evt evento MouseEvent
     */
    private void boton_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_aceptarMouseClicked

        //Accedemos a lo escrito sobre los campos de filas, columnas, nick y contrasenia
        filas=Integer.parseInt(texto_filas.getText());
        columnas=Integer.parseInt(texto_columnas.getText());
        nick=campo_usuario.getText();
        contrasenia=campo_contrasenia.getText();

        //Comprobamos si existe el usuario
        boolean usuarioExistente=this.menuPrincipal.devolverListaUsuarios().comprobarUsuario(nick, contrasenia);

        //Comprobamos que el numero de filas y columnas sea correcto
        if(filas<6 || columnas<6){
            JOptionPane.showMessageDialog(null,"Filas y/o columnas insuficientes. Tamanio minimo: 6");
        }else{
            if(usuarioExistente==false){
                JOptionPane.showMessageDialog(null,"El usuario no existe");
            }else{

                //Procedemos a acceder al usuario, asi como crear la interfaz del juego y el juego en si
                usuario=this.menuPrincipal.devolverListaUsuarios().devolverUsuario(nick);
                juegoNuevoInterfaz=new JuegoNuevoInterfaz(filas,columnas,colorJugador,colorMaquina,this.menuPrincipal,this);
                juegoNuevo=new JuegoNuevo(filas,columnas,usuario,rival,profundidadMaxima,this.menuPrincipal,this);
                juegoNuevoInterfaz.setVisible(true);
                juegoNuevoInterfaz.setResizable(false);
                juegoNuevoInterfaz.setDefaultCloseOperation(MenuJuegoNuevo.DISPOSE_ON_CLOSE);
                this.menuPrincipal.devolverJuegoNuevo().setVisible(false);
                this.menuPrincipal.devolverMenuCargarJuego().setVisible(true);
                this.menuPrincipal.devolverUsuario().setVisible(false);
                this.menuPrincipal.devolverMenuEstadisticas().setVisible(false);
                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(true);
                setVisible(false);
            }
            
        }

    }//GEN-LAST:event_boton_aceptarMouseClicked

    /**Metodo de interaccion sobre el boton color de ficha Azul. Cambia el color de tu ficha a azul.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_azulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_azulMouseClicked
        
        colorJugador=Color.BLUE;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_azulMouseClicked

    /**Metodo de interaccion sobre el boton color de ficha Rojo. Cambia el color de tu ficha a rojo.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_RojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_RojoMouseClicked
        
        colorJugador=Color.RED;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_RojoMouseClicked


    /**Metodo de interaccion sobre el boton color de ficha Amarillo. Cambia el color de tu ficha a amarillo.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_amarilloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_amarilloMouseClicked
        
        colorJugador=Color.YELLOW;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_amarilloMouseClicked


    /**Metodo de interaccion sobre el boton color de ficha Verde. Cambia el color de tu ficha a verde.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_verdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_verdeMouseClicked
        
        colorJugador=Color.GREEN;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_verdeMouseClicked

    /**Metodo de interaccion sobre el boton color de ficha Negro. Cambia el color de tu ficha a negro.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_negroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_negroMouseClicked
        
        colorJugador=Color.BLACK;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_negroMouseClicked

    /**Metodo de interaccion sobre el boton color de ficha Blanco. Cambia el color de tu ficha a blanco.
     * Cambia el color de la ficha rival a negro para que no coincida.
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_blancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_blancoMouseClicked
        
        colorJugador=Color.WHITE;
        colorMaquina=Color.BLACK;
    }//GEN-LAST:event_boton_colorFicha_blancoMouseClicked

    /**Metodo de interaccion sobre el boton color de ficha Naranja. Cambia el color de tu ficha a naranja.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_naranjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_naranjaMouseClicked
        
        colorJugador=Color.ORANGE;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_naranjaMouseClicked

    /**Metodo de interaccion sobre el boton color de ficha Rosa. Cambia el color de tu ficha a rosa.
     *
     * @param evt evento MouseEvent
     */
    private void boton_colorFicha_rosaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_colorFicha_rosaMouseClicked
        
        colorJugador=Color.PINK;
        colorMaquina=Color.WHITE;
    }//GEN-LAST:event_boton_colorFicha_rosaMouseClicked

    /**Metodo de interaccion sobre el boton de dificultad Facil. Cambia la dificultad a facil.
     *
     * @param evt evento MouseEvent
     */
    private void boton_dificultadFacilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_dificultadFacilMouseClicked
        
        profundidadMaxima=2;
    }//GEN-LAST:event_boton_dificultadFacilMouseClicked

    /**Metodo de interaccion sobre el boton de dificultad Media. Cambia la dificultad a media.
     *
     * @param evt evento MouseEvent
     */
    private void boton_dificultadMediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_dificultadMediaMouseClicked
        
        profundidadMaxima=3;
    }//GEN-LAST:event_boton_dificultadMediaMouseClicked

    /**Metodo de interaccion sobre el boton de dificultad Avanzada. Cambia la dificultad a avanzada.
     *
     * @param evt evento MouseEvent
     */
    private void boton_dificultadAvanzadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_dificultadAvanzadaMouseClicked
        
        profundidadMaxima=4;
    }//GEN-LAST:event_boton_dificultadAvanzadaMouseClicked

    /**Metodo para devolver el area de texto que muestra la lista de usuarios registrados
     *
     * @return texto_listaUsuarios que muestra en un area de texto la lista de usuarios
     */
    public javax.swing.JTextArea devolverAreaDeTexto(){
        return texto_listaUsuarios;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_colorFicha_Rojo;
    private javax.swing.JButton boton_colorFicha_amarillo;
    private javax.swing.JButton boton_colorFicha_azul;
    private javax.swing.JButton boton_colorFicha_blanco;
    private javax.swing.JButton boton_colorFicha_naranja;
    private javax.swing.JButton boton_colorFicha_negro;
    private javax.swing.JButton boton_colorFicha_rosa;
    private javax.swing.JButton boton_colorFicha_verde;
    private javax.swing.JButton boton_dificultadAvanzada;
    private javax.swing.JButton boton_dificultadFacil;
    private javax.swing.JButton boton_dificultadMedia;
    private javax.swing.JPasswordField campo_contrasenia;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox opcionRival_Amigo;
    private javax.swing.JCheckBox opcionRival_Maquina;
    private javax.swing.JLabel texto_colorFicha;
    private javax.swing.JTextPane texto_columnas;
    private javax.swing.JLabel texto_dificultad;
    private javax.swing.JTextPane texto_filas;
    private javax.swing.JTextArea texto_listaUsuarios;
    private javax.swing.JLabel texto_rival;
    private javax.swing.JLabel texto_tamanio;
    private javax.swing.JLabel texto_usuario;
    // End of variables declaration//GEN-END:variables

}
