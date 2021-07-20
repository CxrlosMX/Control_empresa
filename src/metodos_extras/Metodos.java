/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_extras;

/**
 *
 * @author CxrlosMX
 */
public interface Metodos {
    
    //Método que nos genera un numero aleatorio
    public static int numeroAletatorio(int max, int min) {
        int n = (int) Math.floor(Math.random() * (max - min + 1)) + min;
        return n;
    }
    
    //Crearemos un arreglo de vehiculos de la empresa
   public static String coches[]={"Tsuru","Jetta","Sentra","Pointer"};
}
