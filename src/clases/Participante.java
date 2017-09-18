/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Curso
 */
public class Participante {
    private String correo;
    private String nombre;
    
    /**
     * Constructor
     * @param nombre
     * @param correo 
     */
    public Participante(String nombre,String correo){
        setCorreo(correo);
        setNombre(nombre);
    }
    
    /**
     * Convierte el objeto a string
     * @return Los datos de un participante
     */
    public String toString(){
        String msg="";
        msg+="Nombre: "+getNombre()+"\n";
        msg+="Correo: "+getCorreo();
        return msg;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
