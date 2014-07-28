package Conecta4;

/**Clase destinada a la creacion de usuarios.
 */
public class Usuario implements java.io.Serializable{

    /**Dato miembro: nick del usuario
     */
    private String nick;
    /**Dato miembro: contrasenia del usuario
     */
    private String contrasenia;
    /**Dato miembro: partidasGanadas por el usuario
     */
    private int partidasGanadas;
    /**Dato miembro: partidasPerdidas por el usuario
     */
    private int partidasPerdidas;
    /**Dato miembro: partidasJugadas por el usuario
     */
    private int partidasJugadas;

    /**Constructor que recibe como argumento el nick del usuario como su contrasenia. Inicializa sus estadisticas a 0
     *
     * @param nick del usuario
     * @param contrasenia del usuario
     */
    Usuario(String nick, String contrasenia){

        this.nick=nick;
        this.contrasenia=contrasenia;
        this.partidasGanadas=0;
        this.partidasPerdidas=0;
        this.partidasJugadas=0;

    }//Final del constructor

    /**Metodo para devolver el nick del usuario
     *
     * @return nick
     */
    public String devolverNick(){
        return nick;
    }

    /**Metodo para devolver la contrasenia del usuario
     *
     * @return contrasenia del usuario
     */
    public String devolverContrasenia(){
        return contrasenia;
    }

    /**Metodo para devolver el numero de partidas jugadas por el usuario
     *
     * @return partidasJugadas por el usuario
     */
    public int devolverPartidasJugadas(){
        return partidasJugadas;
    }

    /**Metodo para devolver el numero de partidas perdidas por el usuario
     *
     * @return partidasPerdidas por el usuario
     */
    public int devolverPartidasPerdidas(){
        return partidasPerdidas;
    }

    /**Metodo para devolver el numero de partidas ganadas por el usuario
     *
     * @return partidasGanadas por el usuario
     */
    public int devolverPartidasGanadas(){
        return partidasGanadas;
    }

    /**Metodo para aumentar en un 1 el numero de partidas jugadas por el usuario
     *
     */
    public void aumentarPartidasJugadas(){
        this.partidasJugadas=partidasJugadas+1;
    }

    /**Metodo para aumentar en un 1 el numero de partidas perdidas por el usuario
     *
     */
    public void aumentarPartidasPerdidas(){
        this.partidasPerdidas=partidasPerdidas+1;
    }

    /**Metodo para aumentar en un 1 el numero de partidas ganadas por el usuario
     *
     */
    public void aumentarPartidasGanadas(){
        this.partidasGanadas=partidasGanadas+1;
    }

    /**Metodo para asignar el numero de partidas jugadas por el usuario
     *
     */
    public void asignarPartidasJugadas(int partidasJugadas){
        this.partidasJugadas=partidasJugadas;
    }

    /**Metodo para asignar el numero de partidas perdidas por el usuario
     *
     */
    public void asignarPartidasPerdidas(int partidasPerdidas){
        this.partidasPerdidas=partidasPerdidas;
    }

    /**Metodo para asignar el numero de partidas ganadas por el usuario
     *
     */
    public void asignarPartidasGanadas(int partidasGanadas){
        this.partidasGanadas=partidasGanadas;
    }

    /**Metodo para poner a 0 las estadisticas del jugador
     */
    public void reiniciarEstadisticas(){

        partidasGanadas=0;
        partidasPerdidas=0;
        partidasJugadas=0;

    }//Final del metodo reiniciarEstadisticas

    /**Metodo para devolver los datos de un usuario a excepcion de su contrasenia
     *
     * @return nick, partidas ganadas, partidas perdidas, partidas jugadas
     */
    public String toString(){

    return "Nick: "+nick+"\nPartidas ganadas: "+partidasGanadas+"\nPartidas perdidas: "+partidasPerdidas+"\nPartidas totales: "+partidasJugadas+"\n";

    }//Final del metodo toString

}//Final de la clase Usuario
