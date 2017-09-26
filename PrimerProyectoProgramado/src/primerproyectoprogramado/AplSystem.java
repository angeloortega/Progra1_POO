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
import clases.Reserva;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.util.Locale.forLanguageTag;
/**
 *
 * @author Angelo PC
 */
public class AplSystem {
    private static String adminPassword;
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Sala> salas = new ArrayList<>();
    private static ArrayList<String> carreras = new ArrayList<>();
    private static ArrayList<Horario> horarios = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    private static Estudiante sesionActiva = null; //Para tener control del usuario que utiliza la aplicación actualmente
    
    public static void setAdminPassword(String newPassword){
    adminPassword = newPassword;
    }
    
    /**
     * gets time templates using an ID array and comparing
     * @param IDs
     * @return 
     */
    public static ArrayList<Horario> getHorariosByID(ArrayList<String>IDs){
        ArrayList<Horario> rHorarios = new ArrayList<>();
        for(String s: IDs){
            for(Horario h: getHorarios()){
                if(h.getIdentificador().equals(s)){
                    rHorarios.add(h);
                }
            }
        }
        return rHorarios;
    }
    /**
     * returns the time template identificators
     * @return 
     */
    public static ArrayList<String> getIDHorarios(){
        ArrayList<String> rHorarios = new ArrayList<>();
        for(Horario h: getHorarios()){
            rHorarios.add(h.getIdentificador());
        }
        return rHorarios;
    }
    public static void setHorarios(ArrayList<Horario> pHorarios){
        horarios = pHorarios;
    }
    /**
     * return the currently active session
     * @return 
     */
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
    /**
     * sets the career array
     * @param pCarreras 
     */
    public static void setCarreras(ArrayList<String> pCarreras){
        carreras = pCarreras;
    }
    /**
     * returns an array containing Student object instances
     * @return 
     */
    public static ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    /**
     * sets the student array
     * @param pEstudiantes 
     */
    public static void setEstudiantes(ArrayList<Estudiante> pEstudiantes){
        estudiantes = pEstudiantes;
    }
    /**
     * 
     * @return reservation array
     */
    public static ArrayList<Reserva> getReservas(){
        return reservas;
    }
    /**
     * sets the reservation array
     * @param pReservas 
     */
    public static void setReservas(ArrayList<Reserva> pReservas){
        reservas = pReservas;
    }
    /**
     * Adds a reservation to the reservation array
     * @param pReserva 
     */
    public static void agregarReserva(Reserva pReserva){
        reservas.add(pReserva);
        guardarXML(salas,"salasDB");
        guardarXML(estudiantes,"estudiantesDB");
        guardarXML(reservas,"reservasDB");
    }
    /**
     * Gets a student by ID
     * @param pCarnet
     * @return 
     */
    public static Estudiante getEstudiante(String pCarnet){
        for (Estudiante s : estudiantes) {
            if(pCarnet.equals(s.getCarne())){
            return s;
            }
        }
        return null;
    }
    /**
     * Gets the room array
     * @return 
     */
    public static ArrayList<Sala> getSalas(){
        return salas;
    }
    /**
     * Sets the room array to pSala
     * @param pSala 
     */
    public static void setSalas(ArrayList<Sala> pSala){
        salas = pSala;
    }
   
   /**
    * Gets a room object instance by id
    * @param pId
    * @return 
    */
    public static Sala getSala(String pId){
        for (Sala s : salas) {
            if(pId.equals(s.getId())){
            return s;
            }
        }
        return null;
    }
    /**
     * Returns the time template array
     * @return 
     */
    public static ArrayList<Horario> getHorarios(){
        return horarios;
    }
    /**
     * Gets a list of student IDs
     * @return 
     */
    public static ArrayList<String> getListaCarnets(){
        ArrayList<String> temp = new ArrayList<>();
        String carnet;
        for (Estudiante s : estudiantes) {
            carnet = s.getCarne();
            temp.add(carnet);
        }
        return temp;
    }
    /**
     * Gets a list of room IDs
     * @return 
     */
    public static ArrayList<String> getListaIDs(){
        ArrayList<String> temp = new ArrayList<>();
        String id;
        for (Sala s : salas) {
            id = s.getId();
            temp.add(id);
        }
        return temp;
    }
    /**
     * adds a student to the student array
     * @param estudiante
     * @return 
     */
    public static boolean añadirEstudiante(Estudiante estudiante){
        
        if(getListaCarnets().contains(estudiante.getCarne())){
        return false;
        }
        estudiantes.add(estudiante);
        return true;
    }
    /**
     * adds a room to the room Array
     * @param sala
     * @return 
     */
    public static boolean añadirSala(Sala sala){
        if(salaExiste(sala.getId())){
        return false;
        }
        salas.add(sala);
        return true;
    }
    /**
     * Determines if a room exists
     * @param id
     * @return 
     */
    public static boolean salaExiste(String id){
    return getListaIDs().contains(id);
    }
 
    /**
     * Recieves and object and saves it as an xml file
     * @param O
     * @param nombre 
     */
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
    
    /**
     * Reads a file with xml extension and turns it into an Object
     * @param pNombreArchivo
     * @return Parsed xml object
     */
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
    /**
     * Method which returns which rooms are available given a set of characteristics
     * @param dateAndTime
     * @param time
     * @param recursos
     * @param capacity
     * @return 
     */
    public static ArrayList<Sala> BuscarSalas(LocalDateTime dateAndTime, LocalTime time,ArrayList<String> recursos,int capacity){
        ArrayList<Sala> salas_disponibles = new ArrayList<>();
        ArrayList<Sala> salas_candidatas = new ArrayList<>();
        boolean contiene_recursos;
        boolean contiene_dia;
        boolean contiene_hora;
        boolean no_reservado;
        for(Sala sala: getSalas()){
            contiene_recursos = true;
            if(capacity <= sala.getMaxCapacidad()){
            for(String recurso: recursos){
                if(!sala.getRecursos().contains(recurso)){
                contiene_recursos = false;
                break;
                }
            }
            if(contiene_recursos){
                salas_candidatas.add(sala);
            }
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", forLanguageTag("en"));
        for(Sala candidata: salas_candidatas){
            contiene_dia = false;
            no_reservado = true;
            contiene_hora = false;
            for(Horario horario: candidata.getHorarios()){
                if(DayOfWeek.from(formatter.parse(horario.getDiaSemana())).equals(dateAndTime.getDayOfWeek())){
                    contiene_dia = true;
                }
                LocalTime horaSeleccionada = dateAndTime.toLocalTime();
                LocalTime horaInicio = horario.horaInicioToLocalTime();
                if(dateAndTime.toLocalTime().isAfter(horario.horaInicioToLocalTime()) || dateAndTime.toLocalTime().equals(horario.horaInicioToLocalTime())){
                    if(time.isBefore(horario.horaFinToLocalTime()) || time.equals(horario.horaFinToLocalTime())){
                        contiene_hora = true;
                    }
                }
            }
            Sala s_temp;
            for(Reserva reserva: reservas){
                s_temp = reserva.getSala();
                if(s_temp.equals(candidata)){
                if(reserva.getInicio().equals(dateAndTime) ||  reserva.getFin().equals(dateAndTime.withMinute(time.getMinute()).withHour(time.getHour()))){
                    no_reservado = false;
                    break;
                }
                if((reserva.getInicio().isAfter(dateAndTime) && reserva.getFin().isBefore(dateAndTime))){
                    no_reservado = false;
                    break;
                    }
                if(((reserva.getFin().isAfter(dateAndTime.withMinute(time.getMinute()).withHour(time.getHour()))) &&(reserva.getInicio().isBefore(dateAndTime.withMinute(time.getMinute()).withHour(time.getHour()))))){
                    no_reservado = false;
                    break;
                }
                if(reserva.getInicio().isAfter(dateAndTime) && reserva.getFin().equals(dateAndTime.withMinute(time.getMinute()).withHour(time.getHour()))){
                    no_reservado = false;
                    break;
                }
                if((reserva.getInicio().isBefore(dateAndTime) && reserva.getFin().isAfter(dateAndTime))){
                    no_reservado = false;
                    break;
                    }
                if((reserva.getInicio().isAfter(dateAndTime) && reserva.getFin().isBefore(dateAndTime.withMinute(time.getMinute()).withHour(time.getHour())))){
                    no_reservado = false;
                    break;
                    }
                }
            }
                
            if(no_reservado && contiene_dia && contiene_hora){
                salas_disponibles.add(candidata);
            }
        }
        return salas_disponibles;
    }
}
