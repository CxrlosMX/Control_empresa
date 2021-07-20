/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_hijas;

import clase_padre.Empleado;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 19/07/2021
 *
 */
public class Secretaria extends Empleado {

    private String area;
    private boolean ingles;

    public Secretaria(String area, boolean ingles, String nombre, String apellido, double sueldo) {
        super(nombre, apellido, sueldo);
        this.area = area;
        plusSueldo();
        this.ingles = ingles;
    }

    //Métodos get y set
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isIngles() {
        return ingles;
    }

    public void setIngles(boolean ingles) {
        this.ingles = ingles;
    }

    //Metodo que sube el sueldo si la secretaria sabe ingles
    @Override
    public void plusSueldo() {
        if (this.ingles) {
            double n = super.getSueldo() * 0.30;
            JOptionPane.showMessageDialog(null, "PLUS aplicado 30%", "Plus aplicado", 1);
            super.setSueldo(super.getSueldo() * n);
        }
    }

    //Metodo para imprimir los atributos de la Secretaria
    @Override
    public String toString() {
        return super.toString() + "\nArea: " + area + ((this.ingles) ? "SI" : "NO"); //Utilizamos el operador ternario para imprimir si habla lenguaje Ingles o no
    }

}
