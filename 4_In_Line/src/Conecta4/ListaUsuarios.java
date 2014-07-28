package Conecta4;

//Paquetes necesarios que importar
import java.util.*;
import java.io.*;

/**Clase utilizada para crear listas de usuarios que contendra como claves de busqueda sus nicks
 */
public class ListaUsuarios implements Serializable{

    /**Dato miembro: HashMap que contiene una lista de usuarios donde las claves seran los nicks y los valores
     * los usuarios
     */
    private HashMap <String, Usuario> listaUsuarios;

    /**Constructor de la clase que crea una lista de usuarios.
     */
    ListaUsuarios(){

        listaUsuarios=new HashMap<String,Usuario>();

    }//Final del constructor

    /**Metodo que devuelve la lista de usuarios
     *
     * @return listaUsuarios que representa a la lista de usuarios
     */
    public HashMap devolverHashMap(){
        return listaUsuarios;
    }

    /**Metodo utilizado para mostrar los usuarios de una lista
     *
     * @return lista que contiene los nicks de todos los usuarios
     */
    public String mostrarListaUsuarios(){

        String lista="";
        //Accedemos a las claves de la lista de usuarios
        Set claves=listaUsuarios.keySet();
        //Creamos un iterador para el conjunto de claves
        Iterator iterador=claves.iterator();

        //Mientras el iterador tenga elementos que mostrar
        while(iterador.hasNext()){

            //Accedemos al nick y lo aniadimos a la lista donde se mostraran
            String nick=(String)iterador.next();
            lista=lista+"\n"+nick;

        }

        return lista;

    }//Final del metodo mostrarListaUsuarios

    /**Metodo utilizado para comprobar si existe algun usuario con el nick pasado como argumento
     *
     * @param nick del usuario pasado como argumento
     * @return repetido que indica si se encuentra el nick en la lista o no
     */
    public boolean comprobarNick(String nick){

        boolean repetido=false;
        String nickAlmacenado;

        //Accedemos a las claves de la lista de usuarios
        Set claves=listaUsuarios.keySet();
        //Creamos un iterador para el conjunto de claves
        Iterator iterador=claves.iterator();

        //Mientras el iterador tenga elementos que mostrar
        while(iterador.hasNext()){

            //Accedemos al nick y comprobamos si es igual al pasado como argumento
            nickAlmacenado=(String)iterador.next();
            if(nick.equals(nickAlmacenado)){
                repetido=true;
            }
        }

        return repetido;

    }//Final del metodo comprobaNick

    /**Metodo utilizado para comprobar si un usuario existe pasado su nick y contrasenia como argumentos
     *
     * @param nick del usuario
     * @param contrasenia del usuario
     * @return encontrado que muestra si existe el usuario
     */
    public boolean comprobarUsuario(String nick, String contrasenia){

        boolean encontrado=false;
        String nickAlmacenado;
        Usuario usuario;

        //Accedemos al conjunto de clave-valor de cada uno de los elementos de la lista de usuarios
        Set entradas=listaUsuarios.entrySet();
        //Creamos un iterador para recorrer a este conjunto
        Iterator iterador=entradas.iterator();

        //Mientras el iterador tenga elementos que mostrar
        while(iterador.hasNext()){

            //Accedemos a cada uno de sus elementos
            Map.Entry entrada=(Map.Entry)iterador.next();
            //Accedemos al nick del usuario (clave)
            nickAlmacenado=(String)entrada.getKey();
            //Accedemos al usuario (valor)
            usuario=(Usuario)entrada.getValue();

            //Comprobamos el nick y la contrasenia a la cual accedemos a partir del valor
            if(nick.equals(nickAlmacenado)==true && usuario.devolverContrasenia().equals(contrasenia)==true){
                encontrado=true;
            }
        }

        return encontrado;

    }//Final del metodo comprobarContrasenia

    /**Metodo utilizado para devolver un usuario pasando su nick como argumento
     *
     * @param nick del usuario
     * @return usuario cuyo nick es el pasado como argumento
     */
    public Usuario devolverUsuario(String nick){

        Usuario usuario=listaUsuarios.get(nick);

        return usuario;

    }//Final del metodo devolverUsuario

    /**Metodo utilizado para mostrar los datos de todos los usuarios
     *
     * @return datosUsuario lista con todos los datos de los usuarios a excepcion de sus contrasenias
     */
    public String mostrarDatosUsuarios(){

        Usuario usuario;
        String clave;
        String datosUsuario="";

        //Accedemos al conjunto de claves de la lista de usuarios
        Set claves=listaUsuarios.keySet();
        //Creamos un iterador para recorrer dicho conjunto
        Iterator iterador=claves.iterator();

        //Mientras el iterador tenga elementos que mostrar
        while(iterador.hasNext()){

            //Accedemos a su clave
            clave=(String)iterador.next();
            //A partir de la clave obtenemos el usuario
            usuario=listaUsuarios.get(clave);
            //Aniadimos sus datos a la lista que sera mostrada
            datosUsuario=datosUsuario+usuario.toString()+"\n--------"+"\n";
        }

        return datosUsuario;

    }//Final del metodo mostrarDatosUsuarios

    /**Metodo utilizado para reiniciar todas las estadisticas de los usuarios
     */
    public void reiniciarDatosUsuarios(){

        Usuario usuario;
        String clave;

        //Accedemos al conjunto de claves de la lista de usuarios
        Set claves=listaUsuarios.keySet();
        //Creamos un iterador para recorrer dicho conjunto
        Iterator iterador=claves.iterator();

        //Mientras el iterador tenga elementos que mostrar
        while(iterador.hasNext()){

            //Accedemos a la clave
            clave=(String)iterador.next();
            //A partir de la clave obtenemos el usuario
            usuario=listaUsuarios.get(clave);
            //Reiniciamos sus estadisticas
            usuario.reiniciarEstadisticas();
        }

    }//Final del metodo reiniciarDatosUsuarios

    /**Metodo utilizado para guardar la lista de usuarios a un archivo que sera cargado posteriormente
     */
    public void guardarListaUsuarios(){

        FileOutputStream archivo=null;
        ObjectOutputStream flujo=null;
        Usuario usuario;

        //Se crean los elementos necesarios
        try{

            archivo=new FileOutputStream("listaUsuarios");
            flujo=new ObjectOutputStream(archivo);

        }catch(IOException e){
            System.exit(0);
        }

        //Accedemos al conjunto de claves de la lista de usuarios
        Set claves=listaUsuarios.keySet();
        //Creamos un iterador para recorrer dicho conjunto
        Iterator iterador=claves.iterator();

        //Mientras el iterador tenga elementos que mostrar
        while(iterador.hasNext()){

            //Accedemos a la clave
            String clave=(String)iterador.next();
            //A partir de la clave accedemos al usuario
            usuario=listaUsuarios.get(clave);
            //Se escribe el objeto
            try{
                flujo.writeObject(usuario);
            }catch(IOException e){
                 System.exit(0);
            }
        }

        // Se cierra el flujo
        try{
            flujo.close();
        }catch(IOException e){
            System.exit(0);
        }

    }//Final del metodo guardarListaUsuarios

    /**Metodo para cargar la lista de usuarios guardada con anterioridad
     */
    public void cargarListaUsuarios(){

        FileInputStream archivo=null;
        ObjectInputStream flujo=null;
        Usuario usuario;

        // Se crean los elementos necesarios
        try{

            archivo=new FileInputStream("listaUsuarios");
            flujo=new ObjectInputStream(archivo);
            
            
        }catch(IOException e){
             System.exit(0);
        }

        // Ahora se leen los objetos y se almacenan en el HashMap
        listaUsuarios=new HashMap<String,Usuario>();

        try{

            //Mientras queden elementos por leer
            while((usuario=(Usuario)flujo.readObject()) != null){
            // Almacena el objeto leido
                String nick=usuario.devolverNick();
                listaUsuarios.put(nick,usuario);
            }
        }catch(EOFException e){
        }catch(ClassNotFoundException e){
            System.exit(0);
        }catch(IOException e){
            System.exit(0);
        }

        // Se cierra el flujo
        try{
            flujo.close();
        }catch(IOException e){
            System.exit(0);
        }

        
    }//Final del metodo cargarListaUsuarios


}//Final de la clase ListaUsuarios
