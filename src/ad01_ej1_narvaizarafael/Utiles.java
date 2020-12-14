/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_ej1_narvaizarafael;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rnarvaiza
 */
public class Utiles {

    /**
     * Initialize methods to create and read files.
     */

    File file = null;
    FileReader fr = null;
    BufferedReader br = null;

    /**
     * Variable declarations;
     */

    String ruta;
    String rutaLectura;

    
    
    
    public void setRuta(String ruta){
        this.ruta=ruta;
    }
    
    public void setRutaLectura(String rutaLectura){
        this.rutaLectura=rutaLectura;
    }


    /**
     * Simple method to create files.
     * @return an string with the status of the action.
     */

    public String creaFichero(){
        
        String message=(null);
        try{
            file = new File(ruta);

            if (file.createNewFile()){
                message = "Fichero creado";
               
            }
            else {
                message = "Fichero imposible de crear";
            }
        } catch(IOException ioe){
            ioe.getMessage();
        }
        

        return message;
      
    }

    /**
     * Simple method for reading files.
     * @return an string that it'll be writed on the outcoming file.
     * @throws IOException
     */
    public String leeFichero() throws IOException {
        String message=(null);
        try{
            file = new File(rutaLectura);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                message=linea;
            }
        }
        catch(FileNotFoundException fnfe){System.out.println(fnfe.getMessage());} 
        catch (Exception e){System.out.println(e.getMessage());}
        finally {
            try{
                if(null != fr){
                    fr.close();
                }
            }
            catch (Exception e) {System.out.println(e.getMessage());}
        }

        return message;
    }
    

    
    
} 
