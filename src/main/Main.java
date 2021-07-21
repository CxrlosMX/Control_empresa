/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clase_padre.Empleado;
import clases_hijas.Proveedor;
import clases_hijas.Secretaria;
import gestion_empleados.ControlEmpleados;
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
public class Main {

    public static void main(String[] args) {
        //Realizar Menu 
        //Instance of para iniciar sesion
        int op = 0, op2 = 0;
        String folio;
        //Instanciamos nuestra clase donde tenemos nuestra lista de Empleados
        ControlEmpleados controlEmpleados = new ControlEmpleados();
        Empleado em;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "             LCNetworks System\n"
                        + "1.-Iniciar Sesión\n"
                        + "2.-Registrarse\n"
                        + "3.-Salir\n¿Qué desea realizar?", "VENTANA INICIO", 3));
                switch (op) {
                    case 1: {
                        //Menu para iniciar Sesión
                        if (controlEmpleados.noEstaVacia()) {
                            folio = JOptionPane.showInputDialog(null, "Introduce tu Folio de Empleado", "Introduciendo Folio", 1);
                            em = controlEmpleados.iniciarSesion(folio);
                            if (em != null) {
                                op2 = 0;
                                if (em instanceof Proveedor) { //Si el Empleado es de Tipo Proveedor

                                    JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + em.getNombre(), "Bienvenido :)", 1);
                                    do {
                                        try {
                                            //1.-Mi informacion
                                            //2.-Mi Sueldo
                                            //3.-Pedir cambio de Vehiculo
                                            op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "MI INFORMACIÓN\n"
                                                    + "1.-Consultar Información\n"
                                                    + "2.-Consultar Sueldo\n"
                                                    + "3.-Solicitar Cambio de Vehiculo\n"
                                                    + "4.-Cerrar Sesión\n", "Proveedor: " + em.getNombre(), 3));
                                            switch (op2) {
                                                case 1: {
                                                    JOptionPane.showMessageDialog(null, em, "Mi Información", 1);
                                                    break;
                                                }
                                                case 2: {
                                                    JOptionPane.showMessageDialog(null, "Sueldo: " + em.getSueldo() + "$", "Mi Sueldo", 1);
                                                    break;
                                                }
                                                case 3: {
                                                    Proveedor p = (Proveedor) em;
                                                    p.cambioVehiculo();
                                                    em = p;
                                                    break;
                                                }
                                                case 4: {
                                                    JOptionPane.showMessageDialog(null, "Cerrando Sesión", "Hasta Pronto " + em.getNombre(), 1);

                                                    break;
                                                }
                                                default: {
                                                    JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Opción Erronea", 0);
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
                                        }

                                    } while (op2 != 4);

                                } else {//Para tipo Secretaria
                                    op2 = 0;
                                    JOptionPane.showMessageDialog(null, "Bienvenida de nuevo " + em.getNombre(), "Bienvenida :)", 1);
                                    do {
                                        try {
                                            op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "MI INFORMACIÓN\n"
                                                    + "1.-Consultar Información\n"
                                                    + "2.-Consultar Sueldo\n"
                                                    + "3.-Cambiar de Área\n"
                                                    + "4.-Cerrar Sesión\n", "Secretaria: " + em.getNombre(), 3));
                                            switch (op2) {
                                                case 1: {
                                                    JOptionPane.showMessageDialog(null, em, "Mi Información", 1);
                                                    break;
                                                }
                                                case 2: {
                                                    JOptionPane.showMessageDialog(null, "Sueldo: " + em.getSueldo() + "$", "Mi Sueldo", 1);
                                                    break;
                                                }
                                                case 3: {
                                                    Secretaria s = (Secretaria) em;
                                                    String area = JOptionPane.showInputDialog(null, "Introduce la nueva área ", "Introduciendo nueva area", 1);
                                                    s.setArea(area);
                                                  //  JOptionPane
                                                    em = s;
                                                    break;
                                                }
                                                case 4: {
                                                    JOptionPane.showMessageDialog(null, "Cerrando Sesión", "Hasta Pronto " + em.getNombre(), 1);
                                                    break;
                                                }
                                                default: {
                                                    JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Opción Erronea", 0);
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
                                        }

                                    } while (op2 != 4);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Ningun Empleado Encontrado con ese Folio"
                                        + "\n1.-Verifique que el folio introducido sea correcto "
                                        + "\n2.-Si el Problema persiste comuniquese con servicios-9535561233", "Folio No encontrado", 1);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "El registro de Empleados se encuentra vacio", "Registro Vacio", 1);
                        }

                        break;
                    }
                    case 2: {
                        op2 = 0;
                        do {
                            try {
                                op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "REGISTRAR\n"
                                        + "1.-Proveedor\n"
                                        + "2.-Secretaria\n"
                                        + "3.-Salir al menu principal\nElija una opción", "Registrando", 3));
                                switch (op2) {
                                    case 1: {//Proveedor
                                        em = controlEmpleados.rellenarDatos(1);
                                        controlEmpleados.addEmpleado(em, 1);

                                        break;
                                    }
                                    case 2: {//Secretaria
                                        em = controlEmpleados.rellenarDatos(2);
                                        controlEmpleados.addEmpleado(em, 2);
                                        break;
                                    }
                                    case 3: {
                                        JOptionPane.showMessageDialog(null, "Saliendo al menu principal", "Saliendo", 1);
                                        break;
                                    }
                                    default: {
                                        JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "Opción Erronea", 0);
                                        break;
                                    }
                                }

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
                            }

                        } while (op2 != 3);

                        break;
                    }
                    case 3: {
                        JOptionPane.showMessageDialog(null, "Cerrando Programa", "Saliendo ", 1);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Opción Erronea", 0);
                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
            }

        } while (op != 3);

    }

}
