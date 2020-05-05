package Clases;

import java.io.Serializable;

public class Profesor implements Serializable {

    private static final long SerialVersionUID = 3L;

    //Atributos de la clase
    private int id;
    private String nombre;
    private String sexo;

    //Constructor
    public Profesor(){}

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    //ToString
    @Override
    public String toString() {
        return "PROFESOR\n" +
                "id: " + id + '\n' +
                "Nombre: " + nombre + '\n' +
                "Sexo: " + sexo;
    }
}