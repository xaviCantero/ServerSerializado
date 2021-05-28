package ar.org.casa.java.serializado.server;


import java.io.Serializable;
//La clase del objeto que voy a transportar debe implementar la interface Serializable
//para poder transportar en un fichero
public class Persona implements Serializable{
    
    //con este atributo certificamos que sea la misma clase 
    private static final long serialVersionUID = 16342342684L;
    
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", apellido: "+apellido+", edad: "+edad;
    }
    
    
}
