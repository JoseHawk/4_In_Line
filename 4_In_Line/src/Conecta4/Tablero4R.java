package Conecta4;

//Paquetes necesarios que importar
import java.util.ArrayList;
import java.io.*;

/**Clase heredada de TableroGeneral para representar tableros de 4 en raya.
 */
public class Tablero4R extends TableroGeneral implements Serializable{

    /**Constructor por defecto
     */
    Tablero4R(){}

    /**Constructor que recibe como argumento el numero de filas y de columnas. Llama al constructor de la clase
     * padre.
     * @param filas que contendra el tablero
     * @param columnas que contendra el tablero
     */
    Tablero4R(int filas, int columnas){

        super(filas,columnas);

    }//Final del constructor


  /**Metodo para devolver el tablero
   *
   * @return tablero que representa el tablero de 4 en raya
   */
  public ArrayList<ArrayList<Integer>> devolverTablero(){

      return tablero;

  }//Final del metodo devolverTablero

  /**Metodo que comprueba si hay tablas, es decir, si el tablero esta lleno y ninguno de los jugadores ha ganado
   *
   * @return tablas que indica si ha habido empate o no
   */
  public boolean comprobarTablas(){

      boolean tablas=true;

      //Se recorre el tablero
      for(int i=0; i < tablero.size();i++){
          tablero.get(i);
          for(int j=0; j < tablero.get(i).size();j++){
              //Si el valor obtenido de la fila y de la columna es igual a 0, tablas cambia de valor
              if(tablero.get(i).get(j).intValue()==0){
                    tablas=false;
              }
          }
      }

      return tablas;

  }//Final del metodo comprobarTablas

  /**Metodo que comprueba si una columna esta llena o no
   *
   * @param columna a comprobar
   * @return true o false segun este llena o no
   */
  public boolean comprobarColumna(int columna){

       if(tablero.get(0).get(columna)==0){
           return false;
       }else{
           return true;
       }

  }//Final del metodo comprobarColumna

  /**Metodo para colocar una ficha de un jugador en una columna determinada
   *
   * @param columna donde colocar la ficha
   * @param color jugador que coloca ficha
   */
  public void colocarFicha(int columna, int color){

      int j=0;
      
        //Recorremos las filas desde la ultima a la primera
        for(j=tablero.size()-1; j>=0; j--){
            //Accedemos a la fila y a la posicion de la columna que hemos pasado como argumento
            //Si es igual a cero (o sea, no hay ninguna ficha), ponemos la nueva ficha y terminamos el bucle
            if(tablero.get(j).get(columna).intValue()==0){
                 asignarFicha(j,columna, new Integer(color));
                 break;
            }

        }

  }//Final del metodo colocarFicha

  /**Metodo para comprobar si ha habido una victoria vertical tras colocar ficha
   *
   * @param j fila donde se ha colocado
   * @param columna donde se ha echado
   * @param color jugador que echa la ficha
   * @return victoriaVertical indica si ha habido victoria vertical o no
   */
  public boolean victoriaVertical(int j, int columna, int color){

      //Partimos de que se ha colocado una ficha en una posicion de la fila determinada (j) y una columna
      //determinada (columna) para un jugador concreto (color).

      //Tenemos un contador para las fichas del jugador que se encuentren en contacto vertical. Empieza en 1
      //porque contamos con la que acabamos de poner
      int contadorFichasMismoColor=1;

      boolean victoriaVertical=false;

      int numeroFilas=calcularNumeroFilas();
      int numeroColumnas=calcularNumeroColumnas();

      //Comprobacion por arriba:
      boolean continuarArriba=false;
      //Primero comprobamos que la ficha que hay por encima es del mismo jugador y que no desborda
      if(j-1>=0 && tablero.get(j-1).get(columna).intValue()==color){
          contadorFichasMismoColor++;
          continuarArriba=true;
          if(continuarArriba==true){
              continuarArriba=false;
              if(j-2>=0 && tablero.get(j-2).get(columna).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarArriba=true;
                  if(continuarArriba==true){
                      continuarArriba=false;
                      if(j-3>=0 && tablero.get(j-3).get(columna).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }
          
      }

      //Comprobacion por abajo:
      boolean continuarAbajo=false;
      //Primero comprobamos que la ficha que hay por debajo es del mismo jugador y que no desborda
      if(j+1<numeroFilas && tablero.get(j+1).get(columna).intValue()==color){
          contadorFichasMismoColor++;
          continuarAbajo=true;
          if(continuarAbajo==true){
              continuarAbajo=false;
              if(j+2<numeroFilas && tablero.get(j+2).get(columna).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarAbajo=true;
                  if(continuarAbajo==true){
                      continuarAbajo=false;
                      if(j+3<numeroFilas && tablero.get(j+3).get(columna).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobamos si ha habido 4 en raya
      if(contadorFichasMismoColor>=4){
          victoriaVertical=true;
      }

      return victoriaVertical;

  }//Final del metodo victoriaVertical

   /**Metodo para comprobar si ha habido una victoria horizontal tras colocar ficha
   *
   * @param j fila donde se ha colocado
   * @param columna donde se ha echado
   * @param color jugador que echa la ficha
   * @return victoriaHorizontal indica si ha habido victoria horizontal o no
   */
  public boolean victoriaHorizontal(int j, int columna, int color){

      //Partimos de que se ha colocado una ficha en una posicion de la fila determinada (j) y una columna
      //determinada (columna) para un jugador concreto (color).

      //Tenemos un contador para las fichas del jugador que se encuentren en contacto horizontal. Empieza en 1
      //porque contamos con la que acabamos de poner
      int contadorFichasMismoColor=1;

      boolean victoriaHorizontal=false;

      int numeroFilas=calcularNumeroFilas();
      int numeroColumnas=calcularNumeroColumnas();

      //Comprobacion por la derecha:
      boolean continuarDerecha=false;
      //Primero comprobamos que la ficha que hay a la derecha es del mismo jugador y que no desborda
      if(columna+1<numeroColumnas && tablero.get(j).get(columna+1).intValue()==color){
          contadorFichasMismoColor++;
          continuarDerecha=true;
          if(continuarDerecha==true){
              continuarDerecha=false;
              if(columna+2<numeroColumnas && tablero.get(j).get(columna+2).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarDerecha=true;
                  if(continuarDerecha==true){
                      continuarDerecha=false;
                      if(columna+3<numeroColumnas && tablero.get(j).get(columna+3).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobacion por la izquierda:
      boolean continuarIzquierda=false;
      //Primero comprobamos que la ficha que hay por la izquierda es del mismo jugador y que no desborda
      if(columna-1>=0 && tablero.get(j).get(columna-1).intValue()==color){
          contadorFichasMismoColor++;
          continuarIzquierda=true;
          if(continuarIzquierda==true){
              continuarIzquierda=false;
              if(columna-2>=0 && tablero.get(j).get(columna-2).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarIzquierda=true;
                  if(continuarIzquierda==true){
                      continuarIzquierda=false;
                      if(columna-3>=0 && tablero.get(j).get(columna-3).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobamos si ha habido 4 en raya
      if(contadorFichasMismoColor>=4){
          victoriaHorizontal=true;
      }

      return victoriaHorizontal;

  }//Final del metodo victoriaHorizontal

   /**Metodo para comprobar si ha habido una victoria diagonal derecha tras colocar ficha
   *
   * @param j fila donde se ha colocado
   * @param columna donde se ha echado
   * @param color jugador que echa la ficha
   * @return victoriaDiagonalDerecha indica si ha habido victoria diagonal derecha o no
   */
  public boolean victoriaDiagonalDerecha(int j, int columna, int color){

      //Partimos de que se ha colocado una ficha en una posicion de la fila determinada (j) y una columna
      //determinada (columna) para un jugador concreto (color).

      //Tenemos un contador para las fichas del jugador que se encuentren en contacto diagonal contando
      //hacia la derecha. Empieza en 1 porque contamos con la que acabamos de poner

      int contadorFichasMismoColor=1;

      boolean victoriaDiagonalDerecha=false;

      int numeroFilas=calcularNumeroFilas();
      int numeroColumnas=calcularNumeroColumnas();

      //Comprobacion por arriba:
      boolean continuarDiagonalDerechaArriba=false;
  
      if(columna+1<numeroColumnas && j-1>=0 && tablero.get(j-1).get(columna+1).intValue()==color){
          contadorFichasMismoColor++;
          continuarDiagonalDerechaArriba=true;
          if(continuarDiagonalDerechaArriba==true){
              continuarDiagonalDerechaArriba=false;
              if(columna+2<numeroColumnas && j-2>=0 && tablero.get(j-2).get(columna+2).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarDiagonalDerechaArriba=true;
                  if(continuarDiagonalDerechaArriba==true){
                      continuarDiagonalDerechaArriba=false;
                      if(columna+3<numeroColumnas && j-3>=0 && tablero.get(j-3).get(columna+3).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobacion por abajo:
      boolean continuarDiagonalDerechaAbajo=false;
 
      if(j+1<numeroFilas && columna-1>=0 && tablero.get(j+1).get(columna-1).intValue()==color){
          contadorFichasMismoColor++;
          continuarDiagonalDerechaAbajo=true;
          if(continuarDiagonalDerechaAbajo==true){
              continuarDiagonalDerechaAbajo=false;
              if(j+2<numeroFilas && columna-2>=0 && tablero.get(j+2).get(columna-2).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarDiagonalDerechaAbajo=true;
                  if(continuarDiagonalDerechaAbajo==true){
                      continuarDiagonalDerechaAbajo=false;
                      if(j+3<numeroFilas && columna-3>=0 && tablero.get(j+3).get(columna-3).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobamos si ha habido 4 en raya
      if(contadorFichasMismoColor>=4){
          victoriaDiagonalDerecha=true;
      }

      return victoriaDiagonalDerecha;

  }//Final del metodo victoriaDiagonalDerecha

   /**Metodo para comprobar si ha habido una victoria diagonal izquierda tras colocar ficha
   *
   * @param j fila donde se ha colocado
   * @param columna donde se ha echado
   * @param color jugador que echa la ficha
   * @return victoriaDiagonalIzquierda indica si ha habido victoria diagonal izquierda o no
   */
  public boolean victoriaDiagonalIzquierda(int j, int columna, int color){

      //Partimos de que se ha colocado una ficha en una posicion de la fila determinada (j) y una columna
      //determinada (columna) para un jugador concreto (color).

      //Tenemos un contador para las fichas del jugador que se encuentren en contacto diagonal contando hacia la izquierda
      //Empieza en 1 porque contamos con la que acabamos de poner
      int contadorFichasMismoColor=1;

      boolean victoriaDiagonalIzquierda=false;

      int numeroFilas=calcularNumeroFilas();
      int numeroColumnas=calcularNumeroColumnas();

      //Comprobacion por arriba:
      boolean continuarDiagonalIzquierdaArriba=false;

      if(j-1>=0 && columna-1>=0 && tablero.get(j-1).get(columna-1).intValue()==color){
          contadorFichasMismoColor++;
          continuarDiagonalIzquierdaArriba=true;
          if(continuarDiagonalIzquierdaArriba==true){
              continuarDiagonalIzquierdaArriba=false;
              if(j-2>=0 && columna-2>=0 && tablero.get(j-2).get(columna-2).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarDiagonalIzquierdaArriba=true;
                  if(continuarDiagonalIzquierdaArriba==true){
                      continuarDiagonalIzquierdaArriba=false;
                      if(j-3>=0 && columna-3>=0 && tablero.get(j-3).get(columna-3).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobacion por abajo:
      boolean continuarDiagonalIzquierdaAbajo=false;

      if(j+1<numeroFilas && columna+1<numeroColumnas && tablero.get(j+1).get(columna+1).intValue()==color){
          contadorFichasMismoColor++;
          continuarDiagonalIzquierdaAbajo=true;
          if(continuarDiagonalIzquierdaAbajo==true){
              continuarDiagonalIzquierdaAbajo=false;
              if(j+2<numeroFilas && columna+2<numeroColumnas && tablero.get(j+2).get(columna+2).intValue()==color){
                  contadorFichasMismoColor++;
                  continuarDiagonalIzquierdaAbajo=true;
                  if(continuarDiagonalIzquierdaAbajo==true){
                      continuarDiagonalIzquierdaAbajo=false;
                      if(j+3<numeroFilas && columna+3<numeroColumnas && tablero.get(j+3).get(columna+3).intValue()==color){
                          contadorFichasMismoColor++;
                      }
                  }
              }
          }

      }

      //Comprobamos si ha habido 4 en raya
      if(contadorFichasMismoColor>=4){
          victoriaDiagonalIzquierda=true;
      }

      return victoriaDiagonalIzquierda;

  }//Final del metodo victoriaDiagonalIzquierda

   /**Metodo para comprobar si ha habido victoria tras colocar ficha. Llama a los metodos de comprobar victoria
   *por las distintas posiciones.
   * @param j fila donde se ha colocado
   * @param columna donde se ha echado
   * @param color jugador que echa la ficha
   * @return victoria indica si ha habido victoria por parte del jugador que echa la ficha
   */
  public boolean comprobarVictoria(int j, int columna, int color){

      boolean victoria=false;

      boolean victoriaVertical=victoriaVertical(j, columna, color);

      boolean victoriaHorizontal=victoriaHorizontal(j, columna, color);

      boolean victoriaDiagonalDerecha=victoriaDiagonalDerecha(j, columna, color);

      boolean victoriaDiagonalIzquierda=victoriaDiagonalIzquierda(j, columna, color);

      //Comprobamos que se haya dado al menos una condicion de victoria
      if(victoriaVertical==true || victoriaHorizontal==true || victoriaDiagonalDerecha==true || victoriaDiagonalIzquierda==true){
          victoria=true;
      }
      
      return victoria;

  }//Final del metodo comprobarVictoria

  /**Metodo utilizado para copiar un tablero a otro tablero
   *
   * @param tableroACopiar tablero que copiaremos
   */
  public void copiarTablero(Tablero4R tableroACopiar){

      for(int i=0; i < tablero.size();i++){
          tablero.get(i);
          for(int j=0; j < tablero.get(i).size();j++){
              //En esta variable guardamos el valor de la fila y la columna
              int fichaTableroACopiar=tableroACopiar.posicionFicha(i,j);
              //Se asigna dicho valor a nuestro tablero copiado.
              tablero.get(i).set(j,new Integer(fichaTableroACopiar));
          }
      }

  }//Final del metodo copiarTablero

  /**Metodo para determinar en que fila se coloca la ficha
   *
   * @param columna donde se ha colocado la ficha
   * @return posicion correspondiente a la fila y la columna tras colocar ficha
   */
  public int determinarFila(int columna){

      int fila=0;
      int posicion;

      //Recorremos las filas de abajo a arriba
      for(fila=tablero.size()-1; fila>=0; fila--){

          //Si encontramos un cero paramos
          if(tablero.get(fila).get(columna).intValue()==0)
          break;

      }

      //Por tanto, la ultima posicion donde había una ficha, era justamente la anterior
      posicion=fila+1;

      return posicion;

  }//Final del metodo determinarFila

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada a su derecha
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaDerecha(int fila, int columna, int color){

        boolean fichaIdentica=false;
        int numeroColumnas=calcularNumeroColumnas();

        if(columna+1<numeroColumnas && tablero.get(fila).get(columna+1).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaDerecha

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada a su izquierda
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaIzquierda(int fila, int columna, int color){

        boolean fichaIdentica=false;

        if(columna-1>=0 && tablero.get(fila).get(columna-1).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaIzquierda

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada arriba
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaArriba(int fila, int columna, int color){

        boolean fichaIdentica=false;

        if(fila-1>=0 && tablero.get(fila-1).get(columna).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaArriba

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada abajo
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaAbajo(int fila, int columna, int color){

        boolean fichaIdentica=false;
        int numeroFilas=calcularNumeroColumnas();

        if(fila+1<numeroFilas && tablero.get(fila+1).get(columna).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaAbajo

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada arriba y a la derecha
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaArribaDerecha(int fila, int columna, int color){

        boolean fichaIdentica=false;
        int numeroColumnas=calcularNumeroColumnas();

        if(fila-1>=0 && columna+1<numeroColumnas && tablero.get(fila-1).get(columna+1).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaArribaDerecha

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada arriba y a la izquierda
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaArribaIzquierda(int fila, int columna, int color){

        boolean fichaIdentica=false;

        if(fila-1>=0 && columna-1>=0 && tablero.get(fila-1).get(columna-1).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaArribaIzquierda

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada abajo y a la derecha
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaAbajoDerecha(int fila, int columna, int color){

        boolean fichaIdentica=false;
        int numeroColumnas=calcularNumeroColumnas();
        int numeroFilas=calcularNumeroFilas();

        if(fila+1<numeroFilas && columna+1<numeroColumnas && tablero.get(fila+1).get(columna+1).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaAbajoDerecha

  /**Metodo que tras pasar como argumento la fila, la columna y un jugador, indica si pertenece al mismo jugador
   * la situada abajo y a la izquierda
   * @param fila donde se encuentra la ficha
   * @param columna donde se encuentra la ficha
   * @param color jugador a comprobar
   * @return fichaIdentica que muestra si es o no igual
   */
  public boolean comprobarFichaAbajoIzquierda(int fila, int columna, int color){

        boolean fichaIdentica=false;
        int numeroFilas=calcularNumeroFilas();

        if(fila+1<numeroFilas && columna-1>=0 && tablero.get(fila+1).get(columna-1).intValue()==color){
           fichaIdentica=true;
        }

        return fichaIdentica;

    }//Final del metodo comprobarFichaDerecha


  /**Metodo utilizado para calcular la funcion de evaluacion. Es decir, se trata de un metodo que valora el tablero
   * en relacion a si es mas favorable o no
   * @return funcionEvaluacion valor de la funcion de evaluacion tras haber valorado el tablero.
   */
  public double calcularFuncionEvaluacion(){

        double jugador=0;
        double maquina=0;

      //PARA LA MAQUINA

      for(int i=0; i<tablero.size();i++){
          for(int j=0; j < tablero.get(i).size();j++){
              if(tablero.get(i).get(j)==2){

                  double contadorMejorMovimientoCasilla=0;

                  //Si encontramos una ficha comprobaremos las adyacentes y de ellas sus adyacentes hasta 3 veces
                  
                  //Comprobamos por arriba
                  double contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaArriba(i-k,j,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaArriba(i-k,j,2)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }


                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }

                  }//Final del bucle for

                  //Comprobamos por abajo
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaAbajo(i+k,j,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaAbajo(i+k,j,2)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }

                  }//Final del bucle for

                  //Comprobamos por la derecha
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaDerecha(i,j+k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaDerecha(i,j+k,2)==true){
                              contadorCasilla++;
                          }else{
                                //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                                contadorCasilla=0;
                                break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos por la izquierda
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaIzquierda(i,j-k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaIzquierda(i,j-k,2)==true){
                             contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                                  contadorCasilla=0;
                                  break;
                              
                          }
                      }


                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal superior derecha
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaArribaDerecha(i-k,j+k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaArribaDerecha(i-k,j+k,2)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                               contadorCasilla=0;
                               break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal superior izquierda
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaArribaIzquierda(i-k,j-k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaArribaIzquierda(i-k,j-k,2)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal inferior derecha
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaAbajoDerecha(i+k,j+k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaAbajoDerecha(i+k,j+k,2)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal inferior izquierda
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaAbajoIzquierda(i+k,j-k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha de la maquina, sumamos 1 al contador
                          if(comprobarFichaAbajoIzquierda(i+k,j-k,2)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha del jugador, ponemos a cero el contador y terminamos
                               contadorCasilla=0;
                               break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Evaluamos el contador segun el numero de fichas de la maquina seguidas
                  int valorMaquina=0;
                  if(contadorMejorMovimientoCasilla==4){
                      valorMaquina=50000000;
                  }else if(contadorMejorMovimientoCasilla==3){
                      valorMaquina=100;
                  }else if(contadorMejorMovimientoCasilla==2){
                      valorMaquina=20;
                  }else if(contadorMejorMovimientoCasilla==1){
                      valorMaquina=2;
                  }
                  //Sumamos a la maquina el contador con el mejor movimiento
                  maquina=maquina+valorMaquina;
              }
          }
      }

      //PARA EL JUGADOR

      for(int i=0; i<tablero.size();i++){
          for(int j=0; j < tablero.get(i).size();j++){
              if(tablero.get(i).get(j)==1){

                  double contadorMejorMovimientoCasilla=0;

                  //Si encontramos una ficha comprobaremos las adyacentes y de ellas sus adyacentes hasta 3 veces

                  double contadorCasilla=1;
                  //Comprobamos por arriba
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaArriba(i-k,j,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaArriba(i-k,j,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos por abajo
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaAbajo(i+k,j,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaAbajo(i+k,j,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                             
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos por la derecha
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaDerecha(i,j+k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                         //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaDerecha(i,j+k,1)==true){
                             contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                               contadorCasilla=0;
                               break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos por la izquierda
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaIzquierda(i,j-k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaIzquierda(i,j-k,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal superior derecha
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaArribaDerecha(i-k,j+k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaArribaDerecha(i-k,j+k,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal superior izquierda
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaArribaIzquierda(i-k,j-k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaArribaIzquierda(i-k,j-k,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                             
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Comprobamos diagonal inferior derecha
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaAbajoDerecha(i+k,j+k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaAbajoDerecha(i+k,j+k,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }


                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                  
                  }//Final del bucle for

                  //Comprobamos diagonal inferior izquierda
                  contadorCasilla=1;
                  for(int k=0;k<3;k++){

                      //Si la casilla esta vacia, sumamos cero al contador
                      if(comprobarFichaAbajoIzquierda(i+k,j-k,0)==true){
                          contadorCasilla=contadorCasilla+0;
                      }else{
                          //Si la casilla tiene una ficha del jugador, sumamos 1 al contador
                          if(comprobarFichaAbajoIzquierda(i+k,j-k,1)==true){
                              contadorCasilla++;
                          }else{
                              //Si la casilla tiene una ficha de la maquina, ponemos a cero el contador y terminamos
                              contadorCasilla=0;
                              break;
                              
                          }
                      }

                      //Si el contador tiene el mejor resultado, se guarda como mejor contador de la casilla
                      if(contadorCasilla>contadorMejorMovimientoCasilla){
                          contadorMejorMovimientoCasilla=contadorCasilla;
                      }
                      
                  }//Final del bucle for

                  //Evaluamos el contador segun el numero de fichas del jugador seguidas
                  int valorJugador=0;
                  if(contadorMejorMovimientoCasilla==4){
                      valorJugador=50000000;
                  }else if(contadorMejorMovimientoCasilla==3){
                      valorJugador=100;
                  }else if(contadorMejorMovimientoCasilla==2){
                      valorJugador=20;
                  }else if(contadorMejorMovimientoCasilla==1){
                      valorJugador=2;
                  }
                  //Sumamos a la maquina el contador con el mejor movimiento
                  jugador=jugador+valorJugador;
              }
          }
      }


      double funcionEvaluacion=maquina-jugador;

      return funcionEvaluacion;
    
  }//Final del metodo calcularFuncionEvaluacion


}//Final de la clase Tablero4R
