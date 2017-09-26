/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;

/**
 *
 * @author Angelo PC
 */
public class Incidente {
    private LocalDateTime fechaIncidente;
    private String tipoIncidente;
    private int puntosSubstraidos;
    
    /**
     * Metodo constructor de un incidente
     * @param pFechaIncidente
     * @param pTipoIncidente
     * @param pPuntosSubstraidos 
     */
    public Incidente(LocalDateTime pFechaIncidente, String pTipoIncidente, int pPuntosSubstraidos){
        setFechaIncidente(pFechaIncidente);
        setTipoIncidente(pTipoIncidente);
        setPuntosSubstraidos(pPuntosSubstraidos);
    }
    /**
     * Convierte los objetos a string
     * @return Los objetos en una cadena de string
     */
    @Override
    public String toString(){
        String msg = "";
        msg += "Tipo de incidente: " + this.getTipoIncidente() + "\n";
        msg += "Fecha de incidente: " + this.getFechaIncidente() + "\n";
        msg += "Puntos substraidos: " + this.getPuntosSubstraidos() + "\n";
        return msg;
    }
    /**
     * 
     * @return fechaIncidente
     */
    public LocalDateTime getFechaIncidente() {
        return fechaIncidente;
    }

    public void setFechaIncidente(LocalDateTime fechaIncidente) {
        this.fechaIncidente = fechaIncidente;
    }
    /**
     * 
     * @return tipoIncidente
     */
    public String getTipoIncidente() {
        return tipoIncidente;
    }
    /**
     * 
     * @param tipoIncidente 
     */
    public void setTipoIncidente(String tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }
    /**
     * 
     * @return cantidad de puntos por substraer
     */
    public int getPuntosSubstraidos() {
        return puntosSubstraidos;
    }
    /**
     * 
     * @param puntosSubstraidos 
     */
    public void setPuntosSubstraidos(int puntosSubstraidos) {
        this.puntosSubstraidos = puntosSubstraidos;
    }
}
