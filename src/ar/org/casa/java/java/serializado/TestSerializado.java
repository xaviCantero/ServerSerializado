package ar.org.casa.java.java.serializado;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializado {
    public static void main(String[] args){
        
        //archivo vinario "datos.dat"
        File file = new File("datos.dat");
        
        //serializado tomamos el estado del objeto y lo ponemos es un stream
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file)){
        }){
            out.writeObject(new Personaa("Javier", "Cantero", 29));
            out.writeObject(new Personaa("Belen", "Lopez", 22));
            out.writeObject(new Personaa("Agustin", "Garcia", 35));
            out.writeObject(new Personaa("Jimena", "Lords", 39));
            out.writeObject(new Personaa("Ariel", "Canitas", 17));
        } catch (Exception e) {e.printStackTrace();}
        
        //deserializado, abrimos el archivo y leemos los elementos
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            //leemos el archivo hasta el final y lo controlamos con EOFException
            while(true){
            Personaa p = (Personaa) in.readObject();
            System.out.println(p);   
            }
        } catch(EOFException e) {System.out.println("Fin del archivo");
        
        } catch (Exception e) {e.printStackTrace();}
        
}
}
