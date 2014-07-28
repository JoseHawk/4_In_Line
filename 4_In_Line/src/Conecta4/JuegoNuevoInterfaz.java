package Conecta4;

//Paquetes necesarios que importar

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JButton;

/**Clase que muestra la interfaz grafica de un tablero y donde vamos a interaccionar con la mecanica del juego
 */
public class JuegoNuevoInterfaz extends JFrame implements ActionListener, Serializable {

    //Datos miembro utilizados en el actionPerformed: No son declarados en el propio metodo puesto que
    //cada vez que pinchamos sobre un boton es como si ejecutasemos un nuevo metodo, por lo que los valores
    //de las variables no se modifican

    /**Dato miembro: victoria1 utilizado para indicar si ha habido victoria por parte del jugador
     */
    private boolean victoria1=false;
    /**Dato miembro: victoria2 utilizado para indicar si ha habido victoria por parte de la maquina
     */
    private boolean victoria2=false;
    /**Dato miembro: tablas utilizado para indicar si ha habido empate
     */
    private boolean tablas=false;
    /**Dato miembro: mejorColumna donde se va almacenando el valor de la mejor columna donde la maquina echara ficha
     */
    private int mejorColumna;
    /**Dato miembro: contadodorJugadas donde se iran contando el numero de jugadas realizadas por jugador y maquina
     */
    private int contadorJugadas;

    //Datos miembro utilizados en el constructor

    /**Dato miembro: colorJugador que almacena el color utilizado para las fichas del jugador
     */
    private Color colorJugador;
    /**Dato miembro: colorMaquina que almacena el color utilizado para las fichas de la maquina
     */
    private Color colorMaquina;
    /**Dato miembro: menuPrincipal que hace referencia al menu principal del programa
     */
    private MenuPrincipal menuPrincipal;
    /**Dato miembro: menuJuegoNuevo que hace referencia al menu donde creamos el nuevo juego
     */
    private MenuJuegoNuevo menuJuegoNuevo;
    /**Dato miembro: filas que constituyen el tablero grafico
     */
    private int filas=MenuJuegoNuevo.devolverFilas();
    /**Dato miembro: columnas que constituyen el tablero grafico
     */
    private int columnas=MenuJuegoNuevo.devolverColumnas();

    /**Dato miembro: boton que representa una posicion en una fila y columna determinadas
     */
    JButton boton[][]=new JButton[filas][columnas];

    /**Constructor de la clase que creara el nuevo tablero grafico de juego
     *
     * @param filas filas que constituyen el tablero grafico
     * @param columnas columnas que constituyen el tablero grafico
     * @param colorJugador almacena el color utilizado para las fichas del jugador
     * @param colorMaquina almacena el color utilizado para las fichas de la maquina
     * @param menuPrincipal hace referencia al menu principal del programa
     * @param menuJuegoNuevo hace referencia al menu donde creamos el nuevo juego
     */
    JuegoNuevoInterfaz(int filas, int columnas, Color colorJugador, Color colorMaquina,MenuPrincipal menuPrincipal, MenuJuegoNuevo menuJuegoNuevo){

        this.menuJuegoNuevo=menuJuegoNuevo;
        this.menuPrincipal=menuPrincipal;

        this.colorJugador=colorJugador;
        this.colorMaquina=colorMaquina;

        this.filas=filas;
        this.columnas=columnas;

        //Creamos el panel de juego
        JPanel principal=new JPanel();
        principal.setLayout(new GridLayout(filas,columnas));

        //Creamos tantos botones como numeros de filas y columnas y les agregaremos el metodo actionListener para
        //interaccionar con ellos
         for(int i=0;i<filas;i++)
            {
             for(int j=0;j<columnas;j++)
             {

                boton[i][j]=new JButton();
                boton[i][j].addActionListener(this);
                boton[i][j].setBackground(Color.GRAY);
                principal.add(boton[i][j]);
             }
            
            add(principal,"Center");
         }

             setLocation(170,25);
             setSize (600,600);
             setResizable(false);
             setVisible(true);

    }//Final del constructor

    /**Metodo con el que interaccionaremos con el tablero al pinchar sobre los botones que representan las filas y columnas
     *
     * @param ae objeto de la clase ActionEvent
     */
    public void actionPerformed(ActionEvent ae){

     int posicionFicha=0;


     //Comprobamos si el rival es un amigo o la maquina
     if(this.menuJuegoNuevo.devolverJuegoNuevo().devolverRival()==1){
       //Mientras nadie haya ganado y no haya tablas
       if(victoria1==false && victoria2==false && tablas==false){

        //Recorremos el tablero
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                //Si pulsamos sobre algun boton
                 if (ae.getSource()==boton[i][j]){
                     //Comprobamos que se pueda colocar una ficha en esa columna
                     if(this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarColumna(j)==false){
                         //Como se va a realizar una jugada, sumamos uno a contadorJugadas
                         contadorJugadas++;
                         //Comprobamos a que jugador le toca
                         if(contadorJugadas%2==1){
                             //Colocamos ficha en el tablero
                             this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().colocarFicha(j,1);
                             //Determinamos en que fila se pone la ficha para el grafico
                             posicionFicha=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().determinarFila(j);

                             //Colocamos ficha en el grafico
                             pintarTablero();

                             //Comprobamos si ha habido victoria o tablas
                             victoria1=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarVictoria(posicionFicha,j,1);
                             if(victoria1==true){
                                JOptionPane.showMessageDialog(null,"****************************** Ha ganado el jugador 1 ******************************"+"\n"+"\n"+"_______________________________________________________________"+"\n__________________________11111111111__________________________"+"\n____________________11111111111111111111111____________________"+"\n________________111111111111111111111111111111_________________"+"\n_____________111111111111111111111111111111111111______________"+"\n____________111111111111111111111111111111111111111____________"+"\n__________11111111111111¶¶¶11111111¶¶¶¶1111111111111___________"+"\n_________11111111111111¶…..¶111111¶.…..¶11111111111111___________"+"\n________111111111111111¶…..¶111111¶……¶111111111111111__________"+"\n_______1111111111111111¶¶…¶¶11111¶¶….¶¶1111111111111111________"+"\n______11111111111111111¶¶¶¶¶¶11111¶¶¶¶¶¶11111111111111111______"+"\n____1111111111111111111¶¶¶¶¶¶11111¶¶¶¶¶¶1111111111111111111____"+"\n__111111111111110000011¶###¶1111111¶###¶111000011111111111111__"+"\n_11111111111110000000001¶#¶111111111¶#¶11000000001111111111111_"+"\n1111111111111111000001111111$$$$$$$1111111000001111111111111111"+"\n1111111111111111111111111111$$$$$$$1111111111111111111111111111"+"\n_11111111111111111111111111111$$$11111111111111111111111111111_"+"\n___111111111111111111111111111111111111111111111111111111111___"+"\n_______1111111111111111111111111111111111111111111111111_______"+"\n________1111111111111111111111111111111111111111111111_________"+"\n_________11111111111111111111111111111111111111111111__________"+"\n__________111111111111111111111111111111111111111111___________"+"\n_________4441111111111111111111111111111111111111114444________"+"\n_______44444441111111111111111111111111111111111144444444______"+"\n_____44444444444411111111111111111111111111111144444444444_____"+"\n____4444444444444444111111111111111111111144444444444444444____"+"\n___444444444444444444444444441111144444444444444444444444444___"+"\n___44444444444444444444444444______4444444444444444444444444___"+"\n_____444444444444444444________________44444444444444444444____"+"\n____________¯¯¯_________________________________¯¯¯¯¯_________");
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasGanadas();
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                                this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                                this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                                this.menuPrincipal.devolverUsuario().setVisible(true);
                                this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);
                             }
                             tablas=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarTablas();
                             if(tablas==true){
                                JOptionPane.showMessageDialog(null,"Tablas");
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                                this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                                this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                                this.menuPrincipal.devolverUsuario().setVisible(true);
                                this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);
                             }
                             break;

                         }else{
                             //Colocamos ficha en el tablero
                             this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().colocarFicha(j,2);
                             //Determinamos en que fila se pone la ficha para el grafico
                             posicionFicha=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().determinarFila(j);
                             
                             //Colocamos ficha en el grafico
                             pintarTablero();

                             //Comprobamos si ha habido victoria o tablas
                             victoria2=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarVictoria(posicionFicha,j,2);
                             if(victoria2==true){
                                JOptionPane.showMessageDialog(null,"****************************** Ha ganado el jugador 2 ******************************"+"\n"+"\n"+"_______________________________________________________________"+"\n__________________________11111111111__________________________"+"\n____________________11111111111111111111111____________________"+"\n________________111111111111111111111111111111_________________"+"\n_____________111111111111111111111111111111111111______________"+"\n____________111111111111111111111111111111111111111____________"+"\n__________11111111111111¶¶¶11111111¶¶¶¶1111111111111___________"+"\n_________11111111111111¶…..¶111111¶.…..¶11111111111111___________"+"\n________111111111111111¶…..¶111111¶……¶111111111111111__________"+"\n_______1111111111111111¶¶…¶¶11111¶¶….¶¶1111111111111111________"+"\n______11111111111111111¶¶¶¶¶¶11111¶¶¶¶¶¶11111111111111111______"+"\n____1111111111111111111¶¶¶¶¶¶11111¶¶¶¶¶¶1111111111111111111____"+"\n__111111111111110000011¶###¶1111111¶###¶111000011111111111111__"+"\n_11111111111110000000001¶#¶111111111¶#¶11000000001111111111111_"+"\n1111111111111111000001111111$$$$$$$1111111000001111111111111111"+"\n1111111111111111111111111111$$$$$$$1111111111111111111111111111"+"\n_11111111111111111111111111111$$$11111111111111111111111111111_"+"\n___111111111111111111111111111111111111111111111111111111111___"+"\n_______1111111111111111111111111111111111111111111111111_______"+"\n________1111111111111111111111111111111111111111111111_________"+"\n_________11111111111111111111111111111111111111111111__________"+"\n__________111111111111111111111111111111111111111111___________"+"\n_________4441111111111111111111111111111111111111114444________"+"\n_______44444441111111111111111111111111111111111144444444______"+"\n_____44444444444411111111111111111111111111111144444444444_____"+"\n____4444444444444444111111111111111111111144444444444444444____"+"\n___444444444444444444444444441111144444444444444444444444444___"+"\n___44444444444444444444444444______4444444444444444444444444___"+"\n_____444444444444444444________________44444444444444444444____"+"\n____________¯¯¯_________________________________¯¯¯¯¯_________");
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasPerdidas();
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                                this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                                this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                                this.menuPrincipal.devolverUsuario().setVisible(true);
                                this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);
                             }
                             tablas=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarTablas();
                             if(tablas==true){
                                JOptionPane.showMessageDialog(null,"Tablas");
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                                this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                                this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                                this.menuPrincipal.devolverUsuario().setVisible(true);
                                this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);
                              }
                             break;

                         }
                     }
                     
                 }

            }
        }

       }//Final del if que controla la victoria y las tablas
           
     }//Final del if que comprueba si el rival es un amigo
     if(this.menuJuegoNuevo.devolverJuegoNuevo().devolverRival()==0){
       //Mientras nadie haya ganado y no haya tablas
       if(victoria1==false && victoria2==false && tablas==false){
           
        
       //Comprobamos a quien corresponde el turno
        if(contadorJugadas%2==0){
         //Recorremos el tablero
         for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                //Si pulsamos sobre algun boton
                 if (ae.getSource()==boton[i][j]){
                         //Comprobamos que se pueda colocar una ficha en esa columna
                         if(this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarColumna(j)==false){
                             //Colocamos ficha en el tablero
                             this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().colocarFicha(j,1);
                             //Determinamos en que fila se pone la ficha para el grafico
                             posicionFicha=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().determinarFila(j);

                             //Colocamos ficha en el grafico
                             pintarTablero();

                             //Comprobamos si ha habido victoria o tablas
                             victoria1=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarVictoria(posicionFicha,j,1);
                             if(victoria1==true){
                                JOptionPane.showMessageDialog(null,"Gana el jugador");
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasGanadas();
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                                this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                                this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                                this.menuPrincipal.devolverUsuario().setVisible(true);
                                this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);
                             }
                             tablas=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarTablas();
                             if(tablas==true){
                                JOptionPane.showMessageDialog(null,"Tablas");
                                this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                                this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                                this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                                this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                                this.menuPrincipal.devolverUsuario().setVisible(true);
                                this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                                this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);
                             }
                             //Sumamos uno al contador de jugadas
                             contadorJugadas++;

                             break;
                         }
                 }
            }
         }

                         
        }else{//Turno maquina
            //Obtenemos la mejor columna mediante un metodo que se encarga de llamar al MinMax
            mejorColumna=this.menuJuegoNuevo.devolverJuegoNuevo().devolverMinMax().obtenerMejorColumna(0,this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R());

            //Colocamos ficha en el tablero
            this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().colocarFicha(mejorColumna,2);
            //Determinamos en que fila se pone la ficha para el grafico
            posicionFicha=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().determinarFila(mejorColumna);

            //Colocamos ficha en el grafico
            pintarTablero();

            //Comprobamos si ha habido victoria o tablas
            victoria1=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarVictoria(posicionFicha,mejorColumna,2);
                 if(victoria1==true){
                     JOptionPane.showMessageDialog(null,"Gana la maquina");
                     this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                     this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasPerdidas();
                     this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                     this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                     this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                     this.menuPrincipal.devolverUsuario().setVisible(true);
                     this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                     this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false); contadorJugadas=0;
                 }
            tablas=this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().comprobarTablas();
                  if(tablas==true){
                     JOptionPane.showMessageDialog(null,"Tablas");
                     this.menuJuegoNuevo.devolverJuegoNuevo().devolverUsuario().aumentarPartidasJugadas();
                     this.menuPrincipal.devolverListaUsuarios().guardarListaUsuarios();
                     this.menuPrincipal.devolverJuegoNuevo().setVisible(true);
                     this.menuPrincipal.devolverMenuCargarJuego().setVisible(false);
                     this.menuPrincipal.devolverUsuario().setVisible(true);
                     this.menuPrincipal.devolverMenuEstadisticas().setVisible(true);
                     this.menuPrincipal.devolverMenuGuardarJuego().setVisible(false);contadorJugadas=0;
                  }
            //Sumamos uno al contador de jugadas
            contadorJugadas++;
                    
        }

       }//Final del if que controla la victoria y las tablas

     }//Final del if que comprueba si el rival es la maquina
                        
    }//Final del metodo actionPerformed


    /**Metodo utilizado para pintar el tablero
    */
    public void pintarTablero(){

        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                //Si encuentra una ficha de la maquina, pinta el boton correspondiente con su color
                if(this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().posicionFicha(i,j) == 2){
                    boton[i][j].setBackground(this.colorMaquina);
                }else{
                    //Si encuentra una ficha del jugador, pinta el boton correspondiente con su color
                     if(this.menuJuegoNuevo.devolverJuegoNuevo().devolverTablero4R().posicionFicha(i,j) == 1)
                        boton[i][j].setBackground(this.colorJugador);
                }

            }
        }

    }//Final del metodo pintarTablero


}//Final de la clase JuegoNuevoInterfaz
