package ar.org.casa.java.serializado.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//primero iniciar la clase ServerSerializado y luego la clase ClienteSerializado
public class ServerSerializado {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9000);){
            
            while(true){
                System.out.println("Esperando conexion de cliente...");
            try (
                    Socket so = ss.accept();
                    ObjectInputStream in = new ObjectInputStream(so.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
                    
                    ){
                    System.out.println("Se conecto: "+so.getInetAddress());
                try{
                    Persona persona = (Persona) in.readObject();
                    out.writeUTF("Se recibio el objeto");
                    out.writeObject(persona.toString());
                    System.out.println(persona);
                }catch(ClassCastException e){out.writeUTF("error clase incorrecta");}
                
            } catch (Exception e) {e.printStackTrace();}
            }//while
        } catch (Exception e) {e.printStackTrace();}
    }
}
