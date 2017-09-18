/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerproyectoprogramado;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import clases.Estudiante;
import clases.Horario;
import clases.Sala;
import clases.Participante;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Angelo PC
 */
public class AplSystem {
    private static String adminPassword;
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<String> carreras = new ArrayList<>();
    private static Estudiante sesionActiva = null; //Para tener control del usuario que utiliza la aplicación actualmente
    public static void setAdminPassword(String newPassword){
    adminPassword = newPassword;
    }
    
    public static Estudiante getSesionActiva(){
        return sesionActiva;
    }
  
    public static void setSesionActiva(Estudiante estudiante){
        sesionActiva = estudiante;
    }
    public static String getAdminPassword(){
    return adminPassword;
    }
    public static ArrayList<String> getCarreras(){
        return carreras;
    }
    public static void agregarCarreras(){
    carreras.add("Administración de Empresas");
    carreras.add("Enseñanza de la Matemática con Entornos Tecnológicos");
    carreras.add("Gestión en Turismo Sostenible");
    carreras.add("Ingeniería en Biotecnología");
    carreras.add("Ingeniería en Computación");
    carreras.add("Ingeniería en Diseño Industrial");
    carreras.add("Administración de Tecnología de Información");
    carreras.add("Ingeniería Agrícola");
    carreras.add("Ingeniería Ambiental");
    carreras.add("Ingeniería Agronegocios");
    carreras.add("Ingeniería en Computadores");
    carreras.add("Ingeniería en Construcción");
    carreras.add("Ingeniería en Electrónica");
    carreras.add("Ingeniería en Producción Industrial");
    carreras.add("Ingeniería en Seguridad Laboral e Higiene Ambiental");
    carreras.add("Ingeniería Física");
    carreras.add("Ingeniería Forestal");
    carreras.add("Ingeniería Mecatrónica");
    carreras.add("Ingeniería en Mantenimiento Industrial");
    carreras.add("Ingeniería en Materiales");
    }
    public static ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    public static void setEstudiantes(ArrayList<Estudiante> pEstudiantes){
        estudiantes = pEstudiantes;
    }
   
    public static Estudiante getEstudiante(String pCarnet){
        for (Estudiante s : estudiantes) {
            if(pCarnet.equals(s.getCarne())){
            return s;
            }
        }
        return null;
    }
    public static ArrayList<String> getListaCarnets(){
        ArrayList<String> temp = new ArrayList<>();
        String carnet;
        for (Estudiante s : estudiantes) {
            carnet = s.getCarne();
            temp.add(carnet);
        }
        return temp;
    }
    public static boolean añadirEstudiante(Estudiante estudiante){
        
        if(getListaCarnets().contains(estudiante.getCarne())){
        return false;
        }
        estudiantes.add(estudiante);
        return true;
    }
    
    public static void guardarXML(Object O, String nombre)
    {
    XStream xstream = new XStream();
    XStream.setupDefaultSecurity(xstream); //Metodo necesario para seguridad
    String xml = xstream.toXML(O);
    try{
    PrintWriter writer = new PrintWriter(nombre + ".xml", "UTF-8");
    writer.println(xml);
    writer.close();
    } catch (IOException e) {
       System.out.println("Ocurrió un error al guardar el archivo");
    }
    }
    
    public static Object leerXML(String pNombreArchivo)
    {
        String nombreArchivo = pNombreArchivo + ".xml";
        String xml = "";
        String line; 
        try {
            StringBuilder auxXml = new StringBuilder();
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                auxXml.append(line);
            }
            // Se cierra el archivo despues de leerse
            bufferedReader.close();
            xml = auxXml.toString();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                nombreArchivo + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + nombreArchivo + "'");
        }
    XStream xstream = new XStream();
    XStream.setupDefaultSecurity(xstream);
    xstream.allowTypesByWildcard(new String[] {
    Estudiante.class.getPackage().getName()+".*"});
    Object newObject =(Object) xstream.fromXML(xml);
    return newObject;
    }
}
