/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primerproyectoprogramado;
import clases.Estudiante;
import clases.Horario;
import clases.Reserva;
import clases.Sala;
import interfaz.VentanaPrincipal;
import java.util.ArrayList;
/**
 *
 * @author Angelo PC
 */
public class PrimerProyectoProgramado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        AplSystem.setAdminPassword("%admin");
        try{
        AplSystem.setHorarios((ArrayList<Horario>) AplSystem.leerXML("horariosDB"));
        }
        catch(Exception e){
        System.out.println(e);}
        try{
        AplSystem.setCarreras((ArrayList<String>) AplSystem.leerXML("carrerasDB"));
        }
        catch(Exception e){
        System.out.println(e);}
        try{
        AplSystem.setEstudiantes((ArrayList<Estudiante>) AplSystem.leerXML("estudiantesDB"));
        for(Estudiante e: AplSystem.getEstudiantes()){
            e.resetReservas();
        }
        }
        catch(Exception e){
        System.out.println(e);}
        try{
        AplSystem.setSalas((ArrayList<Sala>) AplSystem.leerXML("salasDB"));
        }
        catch(Exception e){
        System.out.println(e);}
        try{
        AplSystem.setReservas((ArrayList<Reserva>) AplSystem.leerXML("reservasDB"));
        }
        catch(Exception e){
        System.out.println(e);}
        VentanaPrincipal mainWindow = new VentanaPrincipal();
        mainWindow.show(true);
    }
}
    
