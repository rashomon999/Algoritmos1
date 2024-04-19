package model;

public class Universidad {
    private Profesor[] profesores;
    private int numProfesores;

    
    public Universidad() {
        this.profesores = new Profesor[50];
        this.numProfesores = 0;
    }
    
    public String registrarProfesor(String nombre, String apellido, String cedula, char sexo, String fechaNacimiento, String direccion, String telefono, Type type) {
        String message = "Profesor exitosamente registrado";
        Profesor objProfesor = searchProfesor(cedula);
        if (objProfesor == null) {
            if (numProfesores < profesores.length) {
                profesores[numProfesores++] = new Profesor(nombre, apellido, cedula, sexo, fechaNacimiento, direccion, telefono, type);
            } else {
                message = "No se pueden registrar más profesores. La lista está llena.";
            }   
        }else{
            message = "error el profesor ya exite";
        }
        return message;
    }
    

    public Profesor searchProfesor(String cedula){
        Profesor buscado = null;
        for (int i=0; i<numProfesores; i++){
            if (profesores[i].getCedula().equals(cedula)){
                buscado = profesores[i];
            }
        }
        return buscado;
    }

    
    public String[] nombreProfesores(){
        String[] nombres = new String[numProfesores]; // Crear un arreglo con el tamaño adecuado
    
        for (int i = 0; i < numProfesores; i++){
            nombres[i] = profesores[i].getNombre(); // Asignar el nombre del profesor en el índice correspondiente
        }
        return nombres;
    }

    public String[] apellidosProfesores(){
        String[] apellidos = new String[numProfesores]; // Crear un arreglo con el tamaño adecuado
    
        for (int i = 0; i < numProfesores; i++){
            apellidos[i] = profesores[i].getApellido(); // Asignar el nombre del profesor en el índice correspondiente
        }
        return apellidos;
    }

    public String[] cedulasProfesores(){
        String[] cedulas = new String[numProfesores]; // Crear un arreglo con el tamaño adecuado
    
        for (int i = 0; i < numProfesores; i++){
            cedulas[i] = profesores[i].getCedula(); // Asignar el nombre del profesor en el índice correspondiente
        }
        return cedulas;
    }

    public String actualizarDireccionProfesor(String cedula, String nuevaDireccion) {
        String message = "Dirección del profesor actualizada exitosamente";
        Profesor objProfesor = searchProfesor(cedula);
        if (objProfesor != null) {
            objProfesor.setDireccion(nuevaDireccion);
        } else {
            message = "No se encontró ningún profesor con la cédula proporcionada.";
        }
        return message;
    }

    public int numeroHombres(){
        int hombres = 0; // Inicializamos la variable hombres a 0
        for (int i = 0; i < numProfesores; i++){
            if (profesores[i].getSexo() == 'M') { // Usamos 'M' en lugar de "M" para comparar caracteres
                hombres++;
            } 
        }
        return hombres; // Retornamos el número de hombres contados
    }

    public int numeroMujeres(){
        int mujeres = 0; // Inicializamos la variable hombres a 0
        for (int i = 0; i < numProfesores; i++){
            if (profesores[i].getSexo() == 'F') { // Usamos 'M' en lugar de "M" para comparar caracteres
                mujeres++;
            } 
        }
        return mujeres; // Retornamos el número de hombres contados
    }

    public String eliminarProfesor(String cedula) {
        String mensaje = "Profesor eliminado exitosamente";
        boolean encontrado = false;
        for (int i = 0; i < numProfesores; i++) {
            if (profesores[i].getCedula().equals(cedula)) {
                // Desplazar los elementos hacia la izquierda para eliminar al profesor
                for (int j = i; j < numProfesores - 1; j++) { //j=i
                    profesores[j] = profesores[j + 1];
                }
                profesores[numProfesores - 1] = null; // Eliminar la última referencia
                numProfesores--; // Decrementar el contador de profesores
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            mensaje = "No se encontró ningún profesor con la cédula proporcionada.";
        }
        return mensaje;
    }

    public int numeroProfesoresPorTipo(Type tipo) {
        int count = 0;
        for (int i = 0; i < numProfesores; i++) {
            if (profesores[i].getType() == tipo) {
                count++;
            }
        }
        return count;
    }
}