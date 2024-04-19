package model;

public class Profesor {
    private String nombre;
    private String apellido;
    private String cedula;
    private char sexo;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private Type type; // Nuevo campo para el tipo de profesor

    public Profesor(String nombre, String apellido, String cedula, char sexo, String fechaNacimiento, String direccion, String telefono, Type type) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.type = type; // Establecer el tipo de profesor
    }

    // Métodos getter y setter para el tipo de profesor
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion(){
        return direccion;
    
    }

    public String getTelefono(){
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula(){
        return cedula;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
