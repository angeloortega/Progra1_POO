/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Eduardo
 */
public class Correo {
    private String emisor;
    private String contraseña;
    private ArrayList<String> receptores;
    private String texto;
    private String asunto;
    private final Properties propiedades=new Properties();
    private Session session;
    
    /**
     * Constructor
     * @param emisor
     * @param contraseña
     * @param receptores
     * @param asunto
     * @param texto 
     */
    public Correo(String emisor,String contraseña,ArrayList<String> receptores,String asunto,String texto){
        this.emisor=emisor;
        this.receptores=receptores;
        this.contraseña=contraseña;
        this.texto=texto;
        this.asunto=asunto;
    }
    
    /**
     * Es el metodo encargado de enviar el correo
     * @throws MessagingException 
     */
    public void sendCorreo() throws MessagingException{
        
        propiedades.put("mail.smtp.host","smtp.gmail.com"); //selecciona la plataforma de correo a usar
        propiedades.put("mail.smtp.starttls.enable","true");
        propiedades.put("mail.smtp.auth","true");
        
        session=Session.getDefaultInstance(propiedades);
    
        MimeMessage mensaje=new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(emisor)); //pone el emisor
        for(String i:receptores){
            mensaje.addRecipient(Message.RecipientType.TO,new InternetAddress(i)); //añade receptores
        }
        mensaje.setSubject(asunto);
        mensaje.setText(texto);
        
        Transport enviando=session.getTransport("smtp");
        enviando.connect("smtp.gmail.com",587, emisor, contraseña); //se inicia la sesion
        enviando.sendMessage(mensaje,mensaje.getAllRecipients());
        enviando.close();
    }
}