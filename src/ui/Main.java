package ui;

import java.util.Scanner;
import model.Type; 
import model.Universidad;

public class Main {

    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear una instancia de la universidad
        Universidad objUniversidad = new Universidad();
        
        boolean desicion = false;
        while(!desicion){
            int menu = menu();
            //String[] nombre = new String[50];
            String message;
            switch (menu) {
                case 1:
                // Agregar profesor
                    message = addProfesor(objUniversidad);
                    System.out.println(message);
                    break;
                case 2:
                    mostrarProfesores(objUniversidad);
                    break;
                case 3:
                    message = cambioDireccion(objUniversidad);
                    System.out.println(message);
                    break;
                case 4:
                    profesoresHombres(objUniversidad);
                    break;
                case 5:
                    profesoresMujeres(objUniversidad);
                    break;
                case 6:
                    eliminarProfesor(objUniversidad);
                    break;
                default:
                    desicion = true;
                    break;
            }
        }

        // Otros registros y operaciones
    }

    public static int menu(){
        System.out.println("ingrese la opcion deseada: \n1. Agregar profesor \n2.datos principales de profesores.\n3.Actualizar dirección \n4. numero profesores hombres \n5. numero profesores mujer \n6.eliminar profesor \n7.salir");
        int desicion = lector.nextInt();

        return desicion;
    }

    public static String addProfesor(Universidad objUniversidad){
        String name;
        String lastName;
        String cedula;
        String message;
        char sexo;
        String fechaNacimiento;
        String direccion;
        String telefono;
        Type type;
        // Registrar profesores
        lector.nextLine();

        System.out.println("ingrese el nombre del profesor uno: ");
        name = lector.nextLine();


        System.out.println("ingrese el apellido del profesor: ");
        lastName = lector.nextLine();

        System.out.println("ingrese el numero de su cedula");
        cedula = lector.nextLine();

        System.out.println("ingrese el sexo del profesor(F/M): ");
        sexo = lector.next().charAt(0);

        lector.nextLine();

        System.out.println("ingrese la fecha de nacimiento");
        fechaNacimiento = lector.nextLine();

        System.out.println("ingrese la dirección: ");
        direccion = lector.nextLine();

        System.out.println("ingrese el telefono: ");
        telefono = lector.nextLine();

        System.out.println("Ingrese el tipo de profesor (LENGUAS/NUMEROS):");
        String tipoStr = lector.nextLine().toUpperCase();
        
        // Verifica si el tipo ingresado es válido
        if (tipoStr.equals("LENGUAS")) {
            type = Type.LENGUAS;
        } else if (tipoStr.equals("NUMEROS")) {
            type = Type.NUMEROS;
        } else {
            System.out.println("Tipo de profesor no válido. Se asignará por defecto LENGUAS.");
            type = Type.LENGUAS; // Asigna LENGUAS por defecto
        }
        
        message = objUniversidad.registrarProfesor(name, lastName, cedula, sexo, fechaNacimiento, direccion, telefono, type);

        return message;
    }

    public static void mostrarProfesores(Universidad objUniversidad) {
        String[] nombres = objUniversidad.nombreProfesores();
        String[] apellidos = objUniversidad.apellidosProfesores();
        String[] cedulas = objUniversidad.cedulasProfesores();

        System.out.println("nombre, apellido");
        for (int i = 0; i < nombres.length; i++) {
            String nombreProfesor = nombres[i];
            String apellidoProfesor = apellidos[i];
            String cedulaProfesor =  cedulas[i];

            System.out.println(nombreProfesor + "  " + apellidoProfesor + " " + cedulaProfesor);
        }
    }

    public static String cambioDireccion(Universidad objUniversidad){
        lector.nextLine();
        System.out.println("ingrese su cedula: ");
        String cedula = lector.nextLine();
        System.out.println("ingrese su nueva dirección: ");
        String direccion = lector.nextLine();

        String message = objUniversidad.actualizarDireccionProfesor(cedula, direccion);

        return message;
    }

    public static void profesoresHombres(Universidad objUniversidad){
        int message = objUniversidad.numeroHombres();
        System.out.println("el numero de profesores es "+ message);
    }

    public static void profesoresMujeres(Universidad objUniversidad){
        int message = objUniversidad.numeroMujeres();
        System.out.println("el numero de profesores es "+ message);
    }

    public static void eliminarProfesor(Universidad objUniversidad) {
        lector.nextLine();
        System.out.println("Ingrese la cédula del profesor que desea eliminar:");
        String cedula = lector.nextLine();
    
        String mensaje = objUniversidad.eliminarProfesor(cedula);
        System.out.println(mensaje);
    }
}