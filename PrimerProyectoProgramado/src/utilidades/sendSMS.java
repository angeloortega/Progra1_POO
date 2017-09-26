package utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
public class sendSMS {
    private String message;
    private String number;
    
    /**
     * Constructor
     * @param message
     * @param numbers 
     */
    public sendSMS(String message,String number){
         this.message= "&message=" + message;
         this.number = "&numbers=506" + number;
    }
    
    /**
     * Envia un sms utilizando una aplicacion de un pagina de internet
     * @return 
     */
    public String sendSms() {
        try {
            // Construct data
            String apiKey = "apikey=" + "DjQOj13oeW0-7RHcXHjAZxVaeO1ojTfmex8eZsJYMB";
            String sender = "&sender=" + "angelo";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + this.number + this.message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
        }
    }
}