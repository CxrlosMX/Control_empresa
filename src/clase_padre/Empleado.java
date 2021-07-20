/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_padre;

import metodos_extras.Metodos;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 19/07/2021
 *
 */
public class Empleado implements Metodos {

    private String nombre;
    private String apellido;
    private String folio;
    private double sueldo;

    //Constructor
    public Empleado(String nombre, String apellido, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    //El folio se asignara uno aleatorio
    private String generarFolio() {
        String cadena = "";
        char s;
        int n;
        //Math.floor(Math.random() * (MAX - MIN + 1)) + MIN;
        for (int i = 0; i < 4; i++) {
            n = Metodos.numeroAletatorio(2, 1);
            if (n == 1) { //Si el numero generado es 1 nos dara una letra mayuscula
                //Generamos un numero entre 65 y 90 que cada uno de esos numeros representa una letra en la tabla Acsii
                n = Metodos.numeroAletatorio(90, 65);
                s = (char) n;//Convertimos ese numero en 
                cadena += s;
            }

        }

        return cadena;
    }

}
