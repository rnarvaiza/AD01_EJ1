/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_ej1_narvaizarafael;
import java.io.*;

/**
 *
 * @author rnarvaiza
 */
public class AD01_EJ1_NarvaizaRafael {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here


        /**
         * Main class designed for call the designed methods in order to read & merge both files.
         * We'll use two instances of the same class to avoid misunderstandings between callings.
         */

        DataOutputStream archivo = null;
        Utiles utiles = new Utiles();
        Utiles utiles1 = new Utiles();

        /**
         * Initilization of variables.
         */

        String rutaEscritura = "c:\\Users\\s0ck3\\Documents\\NetBeansProjects\\AD01_EJ1_NarvaizaRafael\\src\\resources\\clientes_empresa.txt";
        String rutaLecturaUsuario = "c:\\Users\\s0ck3\\Documents\\NetBeansProjects\\AD01_EJ1_NarvaizaRafael\\src\\resources\\usuario.txt";
        String rutaLecturaServicio = "c:\\Users\\s0ck3\\Documents\\NetBeansProjects\\AD01_EJ1_NarvaizaRafael\\src\\resources\\servicio.txt";
        final String K_ESPACIO ="\n\n\n";

        /**
         * Calling method to set the path for the new file and its creation.
         */

        utiles.setRuta(rutaEscritura);
        utiles.creaFichero();
        System.out.println(utiles.creaFichero());

        /**
         * Calling method to set the path for reading.
         * First instance will set the first file to merge, then the second.
         */

        utiles.setRutaLectura(rutaLecturaUsuario);
        utiles.leeFichero();
        System.out.println(utiles.leeFichero());
        
        utiles1.setRutaLectura(rutaLecturaServicio);
        utiles1.leeFichero();
        System.out.println(utiles1.leeFichero());

        /**
         * Instance for writing the two different file readings.
         */

        try{
            archivo = new DataOutputStream(new FileOutputStream(rutaEscritura));
            archivo.writeUTF(utiles.leeFichero());
            archivo.writeUTF(K_ESPACIO);
            archivo.writeUTF(utiles1.leeFichero());
            archivo.close();
        }
        catch (FileNotFoundException fnfe){System.out.println(fnfe.getMessage());}
        catch (IOException ioe){System.out.println(ioe.getMessage());}
        catch (Exception e) {System.out.println(e.getMessage());}

        /**
         * Message to show throw shell that the merge was done.
         */


        try {
            utiles.setRutaLectura(rutaEscritura);
            if (utiles.leeFichero().equals("null")){
                
            }
            else {
                System.out.println("Ficheros concatenados correctamente");
                System.out.println("El contenido del fichero es: " + utiles.leeFichero());
            }
        }
        catch (Exception e){System.out.println(e.getMessage());}
        
    }
    
}
