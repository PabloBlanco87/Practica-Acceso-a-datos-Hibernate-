package Clases;

import java.io.Serializable;
import java.util.List;

public class Alumno implements Serializable {
    private static final long SerialVersionUID = 1L;

    // //Atributos de la clase
    private int id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    private List<Modulo> modulos;

    //Constructor
    public Alumno(){}

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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }


    //ToString
    @Override
    public String toString() {
        String modulosItems = "";
        for (int i = 0; i< modulos.size(); i++) {
            modulosItems += "\n- Nombre: "+modulos.get(i).getNombre()+" / "+
                    "Código: "+modulos.get(i).getCodigo()+" / "+
                    "id: "+modulos.get(i).getId();
        }
        return "ALUMNO\n" +
                "id: " + id + "\n" +
                "Nombre: " + nombre + '\n' +
                "Nacionalidad: " + nacionalidad + '\n' +
                "Edad: " + edad + '\n' +
                "Sexo: " + sexo + '\n' +
                "Módulos: " + modulosItems;
    }

}
