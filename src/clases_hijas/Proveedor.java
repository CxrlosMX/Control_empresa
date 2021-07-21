/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_hijas;

import clase_padre.Empleado;
import javax.swing.JOptionPane;
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
public class Proveedor extends Empleado implements Metodos {

    private static String COCHE_DEF = "Bocho";

    //Atributos propios
    private String auto;
    private int n_clientes;

    public Proveedor(String auto, int n_clientes, String nombre, String apellido, double sueldo) {
        super(nombre, apellido, sueldo);
        verificarVehiculo(auto);
        this.n_clientes = n_clientes;
        plusSueldo();
    }

    //Crearemos un metodo para verificar si el auto del proveedor se encuentra registrado en el sistema de la empresa
    private void verificarVehiculo(String coche) {
        String[] v = Metodos.coches;
        boolean encontrado = false;
        for (int i = 0; i < v.length && !encontrado; i++) {
            if (coche.equalsIgnoreCase(v[i])) {
                this.auto = coche;
                encontrado = true;
            }
        }
        if (!encontrado) {
            this.auto = COCHE_DEF;
        }
    }

    //Metodos get y set
    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public int getN_clientes() {
        return n_clientes;
    }

    public void setN_clientes(int n_clientes) {
        this.n_clientes = n_clientes;
    }

    //Pedir cambio de Vehiculo
    public void cambioVehiculo() {
        int n = Metodos.numeroAletatorio(Metodos.coches.length - 1, 0);
        JOptionPane.showMessageDialog(null, "Vehiculo Cambiado: \n" + Metodos.coches[n], "Vehiculo Nuevo", 1);
        setAuto(Metodos.coches[n]);
    }

    //Metodo que sube el sueldo
    @Override
    public void plusSueldo() {
        if (this.n_clientes > 5) {
            double n = super.getSueldo() * 0.20;
            JOptionPane.showMessageDialog(null, "PLUS aplicado al proveedor", "Plus agregado", 1);
            super.setSueldo(super.getSueldo() + n);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAuto: " + auto + "\nNumero de Clientes: " + n_clientes;
    }

}
