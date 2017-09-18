/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primerproyectoprogramado;
import clases.Estudiante;
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
        AplSystem.agregarCarreras();
        AplSystem.setAdminPassword("%admin");
        try{
        AplSystem.setEstudiantes((ArrayList<Estudiante>) AplSystem.leerXML("estudiantesDB"));}
        catch(Exception e){
        System.out.println(e);}
        VentanaPrincipal mainWindow = new VentanaPrincipal();
        mainWindow.show(true);
    }
}
    
