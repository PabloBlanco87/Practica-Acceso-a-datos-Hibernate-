import Clases.Alumno;
import Clases.Modulo;
import Clases.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HibernateMain {

    //Declaramos ruta del fichero
    private static final String PATH = "Ficheros\\";

    //Declaramos las interfaces de Hibernate
    private static Configuration cfg;
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction tx;

    //Declaramos los distintos objetos que vamos a necesitar
    private static List<Modulo> moduloLista;
    private static Profesor profesor;
    private static Alumno alumno;
    private static Modulo mod06;

    //Método main
    public static void main(String[] args) throws IOException {

        //Configuracion de Conexion y transaccion
        cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        //Query con las transacciones
        implantarProfesor();
        implantarModulo();
        implantarAlumno();
        //Hacemos efectiva la transacción, si falla, falla todo el bloque
        tx.commit();
        //Cerramos la sesión
        session.close();
        //Cerramos el SessionFactory
        sessionFactory.close();
    }

    //Creamos un objeto de cada clase Alumno, Profesor y Módulo (en este orden)
    private static void implantarAlumno() throws IOException {
        alumno = new Alumno();
        alumno.setNombre("Isaac Newton");
        alumno.setNacionalidad("Inglés");
        alumno.setEdad(32);
        alumno.setSexo("M");
        alumno.setModulos(moduloLista);
        session.save(alumno);
        fileOutputStream(alumno, "alumno");
    }

    private static void implantarProfesor() throws IOException {
        profesor = new Profesor();
        profesor.setNombre("Sócrates");
        profesor.setSexo("M");
        session.save(profesor);
        fileOutputStream(profesor, "profesor");
    }

    private static void implantarModulo() throws IOException {
        moduloLista = new ArrayList<Modulo>();
        mod06 = new Modulo();
        mod06.setNombre("Acceso a datos");
        mod06.setCodigo("M06");
        moduloLista.add(mod06);
        session.save(mod06);
        fileOutputStream(mod06, "modulo");
    }

    //Función que escribe el fichero binario; recibe como paramentro el objeto y el nombre del fichero
    private static <T> void fileOutputStream(T object, String nombreFichero) {
        File fichero = new File(PATH, nombreFichero);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fichero, false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectOutputStream);
        } catch (IOException e) {
            System.out.println("No se ha podido escribir el fichero");
        }
        fileReaderStream(object, nombreFichero);
    }

    //Función que lee el fichero binario; recibe como paramentro el objeto y el nombre del fichero
    private static <T> void fileReaderStream(T objeto, String nombreFichero) {
        File fichero = new File(PATH + nombreFichero);
        try {
            FileInputStream fileIn = new FileInputStream(fichero);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            T generico = (T) objectIn.readObject();
            objectIn.close();
            System.out.println(generico.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se ha podido leer el fichero");
        }
    }

}
