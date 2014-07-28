package Conecta4;

//Paquetes que importar necesarios
import java.util.ArrayList;
import java.io.*;

/**Clase abstracta destinada a la creacion de tableros generales de los que se podran heredar distintos tableros especificos
 * para distintos juegos. No permite la creacion de objetos en esta clase.
 */
abstract public class TableroGeneral implements Serializable{

  /**Dato miembro: tablero que representa el tablero de juego
   */
  protected ArrayList<ArrayList<Integer>> tablero;

  /**Constructor por defecto.
   */
  TableroGeneral(){}

  /**Constructor que recibe como argumento el numero de filas y columnas para crear un tablero de dichas dimensiones.
   *
   * @param filas que contendra el tablero
   * @param columnas que contendra el tablero
   */
  TableroGeneral(int filas, int columnas){

    tablero=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i < filas; i++){
            ArrayList nuevaFila=new ArrayList<Integer>();
            for(int j=0; j < columnas; j++){
              nuevaFila.add(new Integer(0));
            }
            tablero.add(nuevaFila);
        }

  }//Final del constructor

  /**Metodo auxiliar utilizado para mostrar el tablero
   */
  public void mostrarTablero(){

        for(int i=0; i < tablero.size(); i++){
            ArrayList<Integer> fila=tablero.get(i);
            for(int j=0; j < fila.size(); j++){
              System.out.print(fila.get(j)+" ");
            }
            System.out.println("\n");
        }

  }//Final del metodo mostrarTablero

  /**Metodo utilizado para vaciar el tablero de cualquier ficha
   */
  public void limpiarTablero(){

      for(int i=0; i < tablero.size();i++){
          tablero.get(i);
          for(int j=0; j < tablero.get(i).size();j++){
              tablero.get(i).set(j,new Integer(0));
          }
      }
      
  }//Final del metodo limpiarTablero

  /**Metodo para devolver una ficha en una fila y columna determinadas
   *
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @return ficha a devolver
   */
  public int posicionFicha (int fila, int columna){

      int ficha=tablero.get(fila).get(columna).intValue();

      return ficha;

  }//Final del metodo posicionFicha


  /**Metodo para asignar una ficha en una fila y columna determinadas
   *
   * @param fila donde se colocara la ficha
   * @param columna donde se colocara la ficha
   * @param ficha que sera colocada en esa posicion
   */
  public void asignarFicha(int fila, int columna, int ficha){

      tablero.get(fila).set(columna,ficha);

  }//Final del metodo asignarFicha

  /**Metodo que devuelve el numero de filas del tablero
   *
   * @return numeroFilas numero de filas del tablero
   */
  public int calcularNumeroFilas(){

      int numeroFilas=tablero.size();

      return numeroFilas;

  }//Final del metodo calcularNumerFilas

  /**Metodo que devuelve el numero de columnas del tablero
   *
   * @return numeroColumnas numero de columnas del tablero
   */
  public int calcularNumeroColumnas(){

      int numeroColumnas=0;
      int numeroFilas=calcularNumeroFilas();
      int totalCasillas=0;

      //Recorremos las filas y columnas aniadiendo a cada casilla un incremento
      for(int i=0; i < tablero.size(); i++){
          tablero.get(i);
          for(int j=0; j < tablero.get(i).size(); j++){
              totalCasillas++;
          }
      }

      //Se divide el numero total de casillas entre el numero de filas para obtener las columnas
      numeroColumnas=totalCasillas/numeroFilas;

      return numeroColumnas;

  }//Final del metodo calcularNumeroColumnas


}//Final de la clase Tablero