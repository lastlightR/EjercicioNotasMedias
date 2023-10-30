/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notasmedias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robyn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //FileInputStream in = null;
        //FileOutputStream out = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        try {
            //in = new FileInputStream("src/notasmedias/alumnosNotas.txt");
            //out = new FileOutputStream("src/notasmedias/alumnosMedias.txt");
            fw = new FileWriter("src/notasmedias/alumnosMedias.txt");
            bw = new BufferedWriter(fw);
            FileReader fr = new FileReader("src/notasmedias/alumnosNotas.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String reading;
            String[] data; //each index here will be the name and the three grades respectively
            
            String name;
            double mean = 0;
            int control;
            
            if (br.ready()){
                do {
                    reading = br.readLine();
                    if (reading != null) {
                        data = reading.split(":");
                        name = data[0];
                        mean = (Double.parseDouble(data[1]) + Double.parseDouble(data[2]) + Double.parseDouble(data[3]))/3;
                        fw.write(name + " = " + mean + "\n");
                    }
                } while (reading != null);
                fw.close();
                System.out.println("Archivo creado.");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero " + fw + " no existe.");
        } catch (IOException ex) {
            System.out.println("Error I/O: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
