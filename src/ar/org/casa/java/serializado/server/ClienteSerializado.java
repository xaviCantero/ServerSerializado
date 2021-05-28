package ar.org.casa.java.serializado.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//primero iniciar la clase ServerSerializado y luego esta clase.
public class ClienteSerializado {
    public static void main(String[] args) {
        try (
                Socket so = new Socket("localhost", 9000);
                ObjectOutputStream out = new ObjectOutputStream(so.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(so.getInputStream());
                ){
            //enviamos el objeto
            out.writeObject(new Persona("Gaston", "Lozano", 3));
            //leemos lo recibido
            System.out.println(in.readUTF());
            
        } catch (Exception e) {e.printStackTrace();}
    }
}
