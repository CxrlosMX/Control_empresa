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
        this.folio = generarFolio();
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
            } else {
                n = Metodos.numeroAletatorio(57, 48);
                s = (char) n; //Hacemos un casteo para realizar la conversion del valor numero a valor ACSII
                cadena += s;
            }

        }

        return cadena;
    }

    //Creamos los metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //Metodo para incrementar el sueldo
    public void plusSueldo() {
        
    }
    
    //Metodo para imprimir los atributos de la clase

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nFolio: " + folio + "\nSueldo: " + sueldo+"$";
    }
    

}
