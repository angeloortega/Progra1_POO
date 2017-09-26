/*
 *
 *
 *
 */
package clases;

import java.time.LocalTime;

/**
 *
 * @author Eduardo
 */
public class Horario {
    private String identficador;
    private String diaSemana;
    private int horaInicio;
    private int horaFin;
    
    /**
     * Constructor
     * @param diaSemana
     * @param horaInicio
     * @param horaFin 
     */
    public Horario(String pIdentificador,String diaSemana,int horaInicio,int horaFin){
        setIdentificador(pIdentificador);
        setDiaSemana(diaSemana);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
    }
    
    /**
     * Es el metodo que convierte toda la lista a string
     * @return todos los valores de la lista en string
     */
    public String toString(){
        String msg="";
        msg+=getIdentificador()+": ";
        if(getIdentificador().contains("Diurno")){
            msg += "7:30 a.m - 4:00 p.m";
        }
        else{
            msg += "6:00 p.m - 10:00 p.m";
        }
        return msg;
    }

    /**
     * @param diaSemana the dia de semana to set
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana=diaSemana;
    }

    /**
     * @return the diaSemana
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * @return the horaInicio
     */
    public int getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public int getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }
    /**
     * 
     * @param id 
     */
    public void setIdentificador(String id){
        this.identficador = id;
    }
    /**
     * 
     * @return identificador
     */
    public String getIdentificador(){
        return identficador;
    }
    /**
     * Method which returns the initial time as a LocalTime
     * @return 
     */
    public LocalTime horaInicioToLocalTime(){
        String hora = Integer.toString(horaInicio/100);
        if(hora.length() < 2){
            hora = "0" + hora;
        }
        String minutos = Integer.toString(horaInicio%100);
        if(minutos.length() < 2){
            minutos = "0" + minutos;
        }
        String time = hora + ":" + minutos;
        LocalTime final_time = LocalTime.parse(time);
        return final_time;
    }
    /**
     * Method which returns the final time as a LocalTime
     * @return 
     */
    public LocalTime horaFinToLocalTime(){
        String hora = Integer.toString(horaFin/100);
        if(hora.length() < 2){
            hora = "0" + hora;
        }
        String minutos = Integer.toString(horaFin%100);
        if(minutos.length() < 2){
            minutos = "0" + minutos;
        }
        String time = hora + ":" + minutos;
        LocalTime final_time = LocalTime.parse(time);
        return final_time;
    }
}