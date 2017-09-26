/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import primerproyectoprogramado.AplSystem;

/**
 *
 * @author Eduardo
 */
public class Sala {
    private String id;
    private String ubicacion;
    private int maxCapacidad;
    private ArrayList<String> recursos;
    private boolean estado;
    private int calificacion;
    private int cantidad_calificaciones;
    private int cantidad_reservas;
    private ArrayList<Horario> horarios;
    
    /**
     * Constructor si hay recursos
     * @param id
     * @param ubicacion
     * @param maxCapacidad
     * @param recursos
     * @param estado
     * @param calificacion
     * @param horarios 
     */
    public Sala(String id,String ubicacion,int maxCapacidad,ArrayList<String> recursos,boolean estado,int calificacion,ArrayList<Horario> horarios){
        setId(id);
        setUbicacion(ubicacion);
        setMaxCapacidad(maxCapacidad);
        setRecursos(recursos);
        setEstado(estado);
        setCalificacion(calificacion);
        setHorarios(horarios);
        this.cantidad_calificaciones = 0;
    }
    
    /**
     * Constructor si no hay recursos
     * @param id
     * @param ubicacion
     * @param maxCapacidad
     * @param estado
     * @param calificacion
     * @param horarios 
     */
    public Sala(String id,String ubicacion,int maxCapacidad,boolean estado,int calificacion,ArrayList<Horario> horarios){
        setId(id);
        setUbicacion(ubicacion);
        setMaxCapacidad(maxCapacidad);
        setEstado(estado);
        setCalificacion(calificacion);
        setHorarios(horarios);
    }

    /**
     * Convierte los objetos a string
     * @return Los objetos en una cadena de string
     */
    @Override
    public String toString(){
        String msg="";
        msg+="ID: "+getId()+"\n";
        msg+="Ubicación: "+getUbicacion()+"\n";
        msg+="Capacidad: "+getMaxCapacidad()+"\n";
        if(!getRecursos().isEmpty()){
            msg+="Recursos: ";
            for(String s: getRecursos()){
                msg+=s+" ";
            }
            msg += "\n";
        }
        else{
            msg+="La sala no cuenta con recursos\n";
        }
        if(estado){
            msg+="Estado: disponible\n";
        }
        else{
            msg+="Estado: no disponible\n";
        }
        msg+="Calificación: "+getCalificacion()+"\n";
        msg+="Horarios: ";
        for(Horario h: getHorarios()){
        msg+= h + " ";
        }
        ArrayList<Reserva> reservaTemp = AplSystem.getReservas();
        if(!reservaTemp.isEmpty()){
            msg+= "\n\n";
        for(Reserva r: reservaTemp){
            if(r.getSala().equals(this)){
                msg+= "Reserva:\n";
                if(r.getInicio().isAfter(LocalDateTime.now()) && r.getInicio().isBefore(LocalDateTime.now().plusWeeks(1))){
                    msg+= r.toString() + "\n";
                }
            }
        }
        }
        return msg;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the maxCapacidad
     */
    public int getMaxCapacidad() {
        return maxCapacidad;
    }

    /**
     * @param maxCapacidad the maxCapacidad to set
     */
    public void setMaxCapacidad(int maxCapacidad) {
        this.maxCapacidad = maxCapacidad;
    }

    /**
     * @return the recursos
     */
    public ArrayList<String> getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(ArrayList<String> recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the calificaion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificaion the calificaion to set
     */
    public void setCalificacion(int pCalificacion) {
        int temp = this.getCalificacion()*this.cantidad_calificaciones;
        temp += pCalificacion;
        this.cantidad_calificaciones++;
        this.calificacion = temp/cantidad_calificaciones;
    }
    
    /**
     * @return cantidad de reservas
     */
    public int getCantidadReservas() {
        return cantidad_reservas;
    }

    /**
     * Increments the cantidad_reservas counter
     */
    public void agregarReserva() {
        this.cantidad_reservas++;
    }
    
    /**
     * @return the horarios
     */
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }
    /**
     * Metodo que determina si dos salas cuentan con las mismas caracteristicas
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
		
		Sala e = (Sala) O;
		return this.getId().equals(e.getId());
	}
}
