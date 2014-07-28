package Conecta4;

//Paquetes necesarios que importar
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**Clase utilizada para la creacion de un juego nuevo, que contendra su correspondiente tablero y su correspondiente minmax
 */
 public class JuegoNuevo implements Serializable{

    /**Dato miembro: Filas que contendra el tablero
     */
    private int filas;
    /**Dato miembro: Columnas que contendra el tablero
     */
    private int columnas;
    /**Dato miembro: Rival que indicara si se trata de otro jugador o la maquina
     */
    private int rival;
    /**Dato miembro: Objeto de la clase Tablero4R que representara al tablero de juego
     */
    private Tablero4R tablero;
    /**Dato miembro: Objeto de la clase MinMax que representara la IA de la maquina en caso de tratarse el rival
     * de esta, asi como su dificultad
     */
    private MinMax minMax;
    /**Dato miembro: Dificultad de la IA
     */
    private int profundidadMaxima;
    /**Dato miembro: Usuario que juega
     */
    private Usuario usuario;

    /**Constructor de la clase que almacenara los datos miembro de la clase. Asi pues tambien crea el objeto de la clase
     * Tablero4R y MinMax
     * @param filas Filas que contendra el tablero
     * @param columnas Columnas que contendra el tablero
     * @param usuario Usuario que juega
     * @param rival Rival que indicara si se trata de otro jugador o la maquina
     * @param profundidadMaxima Dificultad de la IA
     * @param menuPrincipal Menu principal del programa
     * @param menuJuegoNuevo Menu de creacion del juego nuevo
     */
    JuegoNuevo(int filas, int columnas, Usuario usuario, int rival, int profundidadMaxima, MenuPrincipal menuPrincipal, MenuJuegoNuevo menuJuegoNuevo){

        this.tablero=new Tablero4R(filas,columnas);
        this.minMax=new MinMax(profundidadMaxima);
        this.filas=filas;
        this.columnas=columnas;
        this.usuario=usuario;
        this.rival=rival;
        this.profundidadMaxima=profundidadMaxima;

    }//Final del constructor

    /**Metodo que devuelve las filas
     *
     * @return filas que contendra el tablero
     */
    public int devolverFilas(){
        return filas;
    }

    /**Metodo que devuelve las columnas
     *
     * @return columnas que contendra el tablero
     */
    public int devolverColumnas(){
        return columnas;
    }

    /**Metodo que devuelve el tablero
     *
     * @return tablero que representa el tablero de 4 en raya
     */
    public Tablero4R devolverTablero4R(){
        return tablero;
    }

    /**Metodo que devuelve el minmax
     *
     * @return minMax que representa la IA de la maquina asi como su dificultad
     */
    public MinMax devolverMinMax(){
        return minMax;
    }

    /**Metodo que devuelve el usuario
     *
     * @return usuario que juega
     */
    public Usuario devolverUsuario(){
        return usuario;
    }

    /**Metodo que devuelve el rival
     *
     * @return rival contra el que nos enfrentamos
     */
    public int devolverRival(){
        return rival;
    }

    /**Metodo que devuelve la profundidad maxima
     *
     * @return profundidadMaxima o dificultad de la maquina
     */
    public int devolverProfundidadMaxima(){
        return profundidadMaxima;
    }

    /**Metodo utilizado para guardar una partida que posteriormente sera cargada
     */
    public void guardarTablero(){

        JFileChooser ruta= new JFileChooser();
        ObjectOutputStream objetoSalida;
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("*.FP", "FP");

        ruta.setFileFilter(filtro);
        //Mostramos la ruta donde se quiere guardar
        int seleccion=ruta.showSaveDialog(null);
        //Si es correcto
        if (seleccion==JFileChooser.APPROVE_OPTION){

            File fichero= ruta.getSelectedFile();
            String archivo= fichero.getPath();
            archivo= archivo+".FP";
            
            try {

                objetoSalida= new ObjectOutputStream(new FileOutputStream(archivo));
                //Escribimos en el archivo el objeto
                objetoSalida.writeObject(this);
                objetoSalida.close();
                fichero.createNewFile();

            }catch (IOException e) {
                System.exit(0);
            }
        }

    }//Final del metodo guardarTablero

    /**Metodo utilizado para cargar una partida
     *
     * @return juegoNuevo partida cargada
     */
    public JuegoNuevo cargarTablero(){

        JuegoNuevo juegoNuevo= null;

        ObjectInputStream objetoEntrada= null;
        JFileChooser ruta= new JFileChooser();
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("*.FP", "FP");

        ruta.setFileFilter(filtro);
        //Pedimos la ruta del archivo que se quiere cargar
        int seleccion= ruta.showOpenDialog(null);
        //Si es correcto
        if (seleccion == JFileChooser.APPROVE_OPTION){

            File fichero= ruta.getSelectedFile();
            String archivo= fichero.getPath();

            try {

                objetoEntrada = new ObjectInputStream(new FileInputStream(archivo));
                //Guardamos el contenido en un objeto JuegoNuevo tras leerlo
                JuegoNuevo nuevoJuego= (JuegoNuevo)objetoEntrada.readObject();
                objetoEntrada.close();

            } catch (ClassNotFoundException ex) {
            } catch (IOException ex) {
                System.exit(0);
            }
        }

        return juegoNuevo;

    }//Final del metodo cargarTablero


}//Final de la clase JuegoNuevo
