package Conecta4;

//Paquetes necesarios que importar
import java.util.ArrayList;
import java.io.*;

/**Clase dedica a la creacion del objeto que representa la IA de la maquina, asi como su dificultad
 */
public class MinMax implements Serializable{

    /**Dato miembro: profundidadMaxima que representa el grado de dificultad, ya que son los niveles de
     * exploracion del metodo minmax
     */
    private int profundidadMaxima;
    /**Dato miembro: mejorColumna donde se almacena la mejor columna donde puede echar ficha la maquina tras
     * evaluar el tablero
     */
    private int mejorColumna=0;

    /**Constructor de la clase que recibe como argumento la profundidad maxima, que correspondera al grado
     * de dificultad
     * @param profundidadMaxima grado de dificultad de la maquina al ser el numero de niveles de exploracion
     */
    MinMax(int profundidadMaxima){

        this.profundidadMaxima=profundidadMaxima;
        
    }//Final del constructor


    /**Metodo utilizado para obtener todos los tableros posibles para un jugador tras colocar ficha
     *
     * @param tablero a partir del cual queremos ver los tableros posibles que pueden surgir de el al echar ficha
     * @param jugador que echara ficha
     * @return tablerosPosibles arrayList que contiene todos los tableros posibles para el jugador tras echar ficha
     */
    public ArrayList<Tablero4R> listaTablerosPosibles(Tablero4R tablero, int jugador){

        //Filas del tablero original
        int filas=tablero.calcularNumeroFilas();
        //Columnas del tablero original
        int columnas=tablero.calcularNumeroColumnas();
        //ArrayList que almacenara los posibles tableros que puedan darse
        ArrayList<Tablero4R> tablerosPosibles=new ArrayList<Tablero4R>();
       
        //Recorremos todas las columnas, comprobando si se puede echar ficha.
        //En caso de ser posible, colocamos la ficha y guardamos el posible tablero
        for(int j=0; j<columnas; j++){
            boolean columnaLlena=tablero.comprobarColumna(j);
            if(columnaLlena==false){
                //ArrayList al que se le asignaran los posibles tableros
                Tablero4R posibleTablero=new Tablero4R(filas,columnas);
                posibleTablero.copiarTablero(tablero);
                posibleTablero.colocarFicha(j,jugador);
                tablerosPosibles.add(posibleTablero);
            }
        }

        return tablerosPosibles;

    }//Final del metodo listaTablerosPosibles

    /**Metodo para obtener las posiciones de las columnas donde es posible echar ficha
     *
     * @param tablero a partir del cual queremos comprobar en que columnas se puede echar
     * @param jugador que echara ficha
     * @return tablerosPosibles arrayList que contiene las posiciones de las columnas posibles
     */
    public ArrayList<Integer> listaColumnasPosibles(Tablero4R tablero, int jugador){

        //ArrayList que almacenara los posibles tableros que puedan darse
        ArrayList<Integer> tablerosPosibles=new ArrayList<Integer>();
        //Variable que almacena el numero de columnas del array pasado como argumento
        int columnas=tablero.calcularNumeroColumnas();

        //Recorremos todas las columnas, comprobando si se puede echar ficha.
        //En caso de ser posible, colocamos la ficha y guardamos la posicion
        for(int j=0; j<columnas; j++){
            boolean posibilidadColocarFicha=tablero.comprobarColumna(j);
            if(posibilidadColocarFicha==false){
                tablerosPosibles.add(j);
            }
        }

        return tablerosPosibles;

    }//Final del metodo listaColumnasPosibles


    /**Metodo minmax que estudiara el tablero en distintos niveles de profundidad y devolvera un valor correspondiente
     * a la mejor jugada.
     * @param profundidadActual profundidad de la exploracion en la que nos encontramos
     * @param tablero que queremos que sea evaluado
     * @return valorMaximo/valorMinimo segun corresponda al jugador o a la maquina
     */
    public double metodoMinMax(int profundidadActual, Tablero4R tablero){

       //Variable auxiliar
       double valor=0;
       //Variable que contendra un valor muy negativo
       double valorMaximo=-500000000;
       //Variable que contendra un valor muy positivo
       double valorMinimo=500000000;
       //Variable para referirnos si se trata del jugador o de la maquina
       int turnoParticipantes=0;

       //Caso base: El valor de calcularFuncionEvaluacion es muy elevado, por tanto hay cuatro en raya.
       //Devolvemos el mayor valor segun sea la maquina o el jugador
       if(tablero.calcularFuncionEvaluacion()>=5000000){
           return 500000000;
       }else if(tablero.calcularFuncionEvaluacion()<=-5000000){
           return -500000000;

        //Caso base: La profundidad a la que nos encontramos es la maxima a la que llega el minMax
       }else if (profundidadActual==profundidadMaxima){
            return tablero.calcularFuncionEvaluacion();

        //Caso inductivo: No nos encontramos en la profundidad maxima
        }else{
            //ArrayList para llamar al metodo listaTablerosPosibles()
            ArrayList<Tablero4R> tablerosPosibles=new ArrayList<Tablero4R>();
            //ArrayList para llamar al metodo listaColumnasPosibles()
            ArrayList<Integer> columnasPosibles=new ArrayList<Integer>();

            //Comprobamos a quien corresponde el turno (impares: jugador, pares: maquina)
            if(profundidadActual%2==1){
                //Si es impar: Jugador
                turnoParticipantes=1;
            }
            if(profundidadActual%2==0){
                //Si es par: Maquina
                turnoParticipantes=2;
            }

            //Accedemos a todos los tableros a los que es posible colocar ficha
            tablerosPosibles= listaTablerosPosibles(tablero, turnoParticipantes);
            //Asi pues, tambien accedemos a esas mismas columnas
            columnasPosibles= listaColumnasPosibles(tablero, turnoParticipantes);
            //Para todos los tableros a los que es posible colocar ficha se realiza el metodo minMax
            for(int i=0; i<tablerosPosibles.size(); i++){
             //La variable valor obtiene el valor de llamarse a si misma con la profundidad aumentada en 1
             valor= metodoMinMax(profundidadActual+1, tablerosPosibles.get(i));

                //Si era el turno de la maquina:
                if(turnoParticipantes==2){
                   //Si el resultado es menor que el valor almacenado en valor
                    if(valorMaximo<valor){
                       valorMaximo=valor;
                       //Si la profundidad actual es 0, tomamos la mejor columna, ya que es la que nos interesa
                       if(profundidadActual==0){
                           mejorColumna=columnasPosibles.get(i);
                       }
                    }
                }

                //Si era el turno del jugador:
                else{
                    if(valorMinimo>valor){
                        valorMinimo=valor;


                    }

                }
            }

            if(turnoParticipantes==2){
                return valorMaximo;
            }else{
                return valorMinimo;
            }
  
        }
       
    }//Final del metodo minMax

    /**Metodo utilizado para llamar al metodo minMax y a partir de ahi obtener la mejor columna
     *
     * @param profundidadActual profundidad de la exploracion en la que nos encontramos
     * @param tablero que queremos que sea evaluado
     * @return mejorColumna que corresponde con la columna mas sensata donde la maquina puede echar ficha
     */
    public int obtenerMejorColumna(int profundidadActual, Tablero4R tablero){


        //Realizamos el metodo MinMax
        metodoMinMax(profundidadActual, tablero);

        //Devolvemos la mejor columna
        return mejorColumna;

    }//Final del metodo obtenerMejorColumna

    /**Metodo que devuelve la profundidadMaxima
     *
     * @return profundidadMaxima que corresponde con el nivel de dificultad
     */
    public int devolverProfundidadMaxima(){
        return profundidadMaxima;
    }



}//Final de la clase MinMax
