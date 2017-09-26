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
 * @author Angelo 
 */

public class Reserva {
    private Sala sala;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Estudiante estudiante;
    private ArrayList<Participante> participantes = new ArrayList<>();
    private String codigoReserva;
    private Horario horario;
    private boolean calificado;
    private String codigo;
    private int id;
    /**
     * Method which creates a reservation object
     * @param sala
     * @param estudiante
     * @param anio
     * @param mes
     * @param dia
     * @param horaInicio
     * @param minInicio
     * @param horaFin
     * @param minFin 
     */
    public Reserva(Sala sala,Estudiante estudiante,int anio,int mes,int dia,int horaInicio,int minInicio,int horaFin,int minFin){
        setSala(sala);
        setEstudiante(estudiante);
        setInicio(anio,mes,dia,horaInicio,minInicio);
        setFin(anio,mes,dia,horaFin,minFin);
        setId();
        this.calificado = false;
    }
    
    /**
     * Convierte los datos de la reserva en un string para ser impreso
     * @return msg
     */
    public String toString(){
        String msg="Sala: "+getSala().getId()+"\n"+
                   "Horario: "+getInicio()+"\n"+
                   " to "+getFin()+"\n"+
                   "Estudiante encargado: "+getEstudiante().getNombre()+"\n"+
                   "Participantes:\n";
        for(Participante i:participantes){
            msg+="\n"+i.toString()+"\n";
        }return msg;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    /**
     * checks if a reservation has been rated
     * @return 
     */
    public boolean isCalificado(){
        return this.calificado;
    }
    public boolean calificarSala(int calificacion, Sala pSala){
        if(this.calificado){
        return false;
        }
        pSala.setCalificacion(calificacion);
        this.calificado = true;
        AplSystem.guardarXML(AplSystem.getReservas(), "reservasDB");
        AplSystem.guardarXML(AplSystem.getSalas(), "salasDB");
        return true;
    }
    /**
     * @return the horario
     */
    public LocalDateTime getInicio() {
        return inicio;
    }

    /**
     * 
     * @param anio
     * @param mes
     * @param dia 
     * @param horaInicio 
     * @param minInicio 
     */
    public void setInicio(int anio,int mes,int dia,int horaInicio,int minInicio) {
        inicio=LocalDateTime.of(anio,mes,dia,horaInicio,minInicio);
    }

    /**
     * @return the horario
     */
    public LocalDateTime getFin() {
        return fin;
    }

    /**
     * 
     * @param anio
     * @param mes
     * @param dia 
     * @param hora 
     * @param min 
     */
    public void setFin(int anio,int mes,int dia,int hora,int min) {
        fin=LocalDateTime.of(anio,mes,dia,hora,min);
    }
    /**
     * @return the estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * @param participante the participante to add
     */
    public void addParticipante(Participante participante) {
        this.participantes.add(participante);
    }
    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the id
     */
    public void setId() {
        this.id = this.getSala().getCantidadReservas();
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }
}
