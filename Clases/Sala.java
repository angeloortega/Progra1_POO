/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra1;

/**
 *
 * @author Eduardo
 */
public class Sala {
    private String id;
    private String ubicacion;
    private int maxCapacidad;
    private String recursos="";
    private boolean estado;
    private int calificacion;
    private Horarios horarios;
    
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
    public Sala(String id,String ubicacion,int maxCapacidad,String recursos,boolean estado,int calificacion,Horarios horarios){
        setId(id);
        setUbicacion(ubicacion);
        setMaxCapacidad(maxCapacidad);
        setRecursos(recursos);
        setEstado(estado);
        setCalificacion(calificacion);
        setHorarios(horarios);
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
    public Sala(String id,String ubicacion,int maxCapacidad,boolean estado,int calificacion,Horarios horarios){
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
    public String toString(){
        String msg="";
        msg+="ID: "+getId()+"\n";
        msg+="Ubicación: "+getUbicacion()+"\n";
        msg+="Capacidad: "+getMaxCapacidad()+"\n";
        if(!"".equals(getRecursos()))
            msg+="Recursos: "+getRecursos()+"\n";
        if(estado==true)
            msg+="Estado: disponible\n";
        else
            msg+="Estado: no disponible\n";
        msg+="Calificación: "+getCalificacion()+"\n";
        msg+="Horarios: "+getHorarios();
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
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(String recursos) {
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
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the horarios
     */
    public Horarios getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }
    
    
    
}
