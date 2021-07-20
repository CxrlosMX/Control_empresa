/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_empleados;

import clase_padre.Empleado;
import clases_hijas.Proveedor;
import clases_hijas.Secretaria;
import java.util.ArrayList;
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
public class ControlEmpleados {

    private ArrayList<Empleado> listaEmpleados;
    private int contador;

    public ControlEmpleados() {
        contador = -1;
        listaEmpleados = new ArrayList<Empleado>();
    }

    //Metodo para rellenar Empleados
    public Empleado rellenarDatos(int i) {
        Empleado e = null;
        String nombre = JOptionPane.showInputDialog(null, "Introduce el Nombre " + ((i == 1) ? "del Proveedor" : "de la Secretaria"), "Introduciendo Nombre", 1);
        String apellido = JOptionPane.showInputDialog(null, "Introduce el Apellido " + ((i == 1) ? "del Proveedor" : "de la secretaria"), "Introduciendo Apellido", 1);
        double sueldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el sueldo " + ((i == 1) ? "del proveedor" : "de la secretaria"), "Introduciendo Apellido", 1));
        if (i == 1) {//Si i==1 sera para Proveedor
            String auto = JOptionPane.showInputDialog(null, "Introduce tu Vehiculo", "Introduciendo Vehiculo", 1);
            int n_clientes = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de clientes", "Introduciendo Clientes", 1));
            e = new Proveedor(auto, n_clientes, nombre, apellido, sueldo);
        } else { //Secretaria
             boolean ingles=false;
            String area=JOptionPane.showInputDialog(null,"Introduce el area de trabajo","introduciendo Area",1);
            String vIngles=JOptionPane.showInputDialog(null,"Domina el lenguaje Ingles","Verificando Idioma",1);
           if(vIngles.equalsIgnoreCase("NO")){
           ingles=false;
           }
           e=new Secretaria(area, ingles, nombre, apellido, sueldo);
        
        }
        return e;
    }

//Metodo para registrar un Empleado
    public void addEmpleado(Empleado e, int i) {
        listaEmpleados.add(e);
        //Si i==1 sera para Proveedor y 2 sera para secretaria
        JOptionPane.showMessageDialog(null, (i == 1) ? "Proveedor agregado correctamente" : "Secretaria agregada correctamente", "Empleado Agregado", 1);
        contador++;
    }

    //Metodo psa verificar si la lista esta vacia
    public boolean noEstaVacia() {
        return (contador != -1);
    }
}
