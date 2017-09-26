/*
*
*
*
 */
package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import primerproyectoprogramado.AplSystem;

/**
 *
 * @author Eduardo
 */
public class Estudiante {

    private String nombre;
    private String carne;
    private String carrera;
    private String correo;
    private int calificacion;
    private String numero;
    private int cantidad_reservas_semana;
    private ArrayList<Incidente> incidentes;
    
    /**
     * Constructor
     * @param pnombre
     * @param pcarne
     * @param pcarrera
     * @param pcorreo
     * @param pnumero
     * @param pcalificacion 
     */
    public Estudiante(String pnombre,String pcarne,String pcarrera,String pcorreo,String pnumero,int pcalificacion){
        setNumero(pnumero);
        setCarne(pcarne);
        setNombre(pnombre);
        setCarrera(pcarrera);
        setCorreo(pcorreo);
        setCalificacion(pcalificacion);
        resetReservas();
        incidentes = new ArrayList<>();
    }
    
    /**
     * Para imprimir un estudiante
     * @return Los datos de un estudiante
     */
    public String toString(){
        String msg="";
        msg+="Nombre: "+getNombre()+"\n";
        msg+="Carné: "+getCarne()+"\n";
        msg+="Carrera: "+getCarrera()+"\n";
        msg+="Correo: "+getCorreo()+"\n";
        msg+="Número: "+getNumero()+"\n";
        msg+="Calificación: "+getCalificacion() + "\n";
        if(!incidentes.isEmpty()){
        msg+="Incidentes: \n";
        for(Incidente i: incidentes){
            msg += i.toString() + "\n";
        }
        }
        return msg;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @return the nombre
     */
    public int getCantidadSemanal() {
        return cantidad_reservas_semana;
    }
    
    /**
     * @return the carnet
     */
    public String getCarne() {
        return carne;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param carne the carne to set
     */
    public void setCarne(String carne) {
        this.carne = carne;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * inserta la cantidad de reservas
     * @param num 
     */
    public void setCantidadReservasSemana(int num){
        this.cantidad_reservas_semana = num;
    }
    /**
     * Metodo para obtener el numero de dia actual
     * @return numero de dia
     */
    private int getDia(){
        Calendar calendario;
	calendario = Calendar.getInstance();
	return calendario.get(Calendar.DAY_OF_WEEK);
	}
    /**
     * Coloca el contador de reservas semanales en 0
     */
    public void resetReservas(){
        int dia = getDia();
        if(dia==1){
            setCantidadReservasSemana(0);
        }
    }
    
    /**
     * Incrementa la cantidad de reservas semanales.
     */
    
    public void agregarReserva(){
        this.cantidad_reservas_semana++;
    }
    
    /**
     * 
     * @param index 
     */
    
    public void agregarIncidente(int index){
        Incidente iTemp = new Incidente(LocalDateTime.now(), "", 0);
        switch(index){
            case 0:
                this.setCalificacion(calificacion - 15);
                iTemp = new Incidente(LocalDateTime.now(),"Sala Reservada No Utilizada", 15);
                break;
            case 1:
                this.setCalificacion(calificacion - 10);
                iTemp = new Incidente(LocalDateTime.now(),"Exceso de Ruido", 10);
                break;
            case 2:
                this.setCalificacion(calificacion - 7);
                iTemp = new Incidente(LocalDateTime.now(),"Basura y Desorden", 5);
                break;
            default:
                break;
        }
        this.incidentes.add(iTemp);
        AplSystem.guardarXML(AplSystem.getEstudiantes(), "estudiantesDB");
    }
    
    public Incidente getUltimoIncidente(){
        Incidente iTemp = incidentes.get(cantidadIncidentes() - 1);
        return iTemp;
    }
    
    public int cantidadIncidentes(){
        return this.incidentes.size();
    }
    /**
     * Metodo que determina si dos estudiantes cuentan con las mismas caracteristicas
     * @param O
     * @return boolean con el resultado
     */
    @Override
    public boolean equals(Object O){
		
		if(this == O){
			return true;
		}
		if(O == null){
			return false;
		}
		if(this.getClass() != O.getClass()){
			return false;
		}
		
		Estudiante e = (Estudiante) O;
		return this.getCarne().equals(e.getCarne());
	}
}
