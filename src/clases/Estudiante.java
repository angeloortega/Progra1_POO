/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
    }
    
    /**
     * Para imprimir
     * @return Los datos de un estudiante
     */
    public String toString(){
        String msg="";
        msg+="Nombre: "+getNombre()+"\n";
        msg+="Carné: "+getCarne()+"\n";
        msg+="Carrera: "+getCarrera()+"\n";
        msg+="Correo: "+getCorreo()+"\n";
        msg+="Número: "+getNumero()+"\n";
        msg+="Calificación: "+getCalificacion();
        return msg;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the carne
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
}
