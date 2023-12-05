/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notasmedias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
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
            
            //initializing BufferedWriter using a FileWriter with a new file to write on
            fw = new FileWriter("src/notasmedias/alumnosMedias.txt");
            bw = new BufferedWriter(fw);
            //reading the original file with FileReader and BufferedReader
            FileReader fr = new FileReader("src/notasmedias/alumnosNotas.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String reading;
            String[] data; //each index here will be the name and the three grades respectively
            
            String name;
            double mean = 0;
            
            if (br.ready()){
                do {
                    reading = br.readLine(); //saves each line of the file on each iteration
                    if (reading != null) {
                        data = reading.split(":"); //saves each part of the line on each index of data
                        name = data[0]; //first index will be the name
                        //calculating the mean with the remaining parts of the line
                        mean = (Double.parseDouble(data[1]) + Double.parseDouble(data[2]) + Double.parseDouble(data[3]))/3;
                        fw.write(name + " = " + mean + "\n"); //writes the mean associated with a name in the new file
                    }
                } while (reading != null); //reading ends once all lines have been processed
                fw.close(); //closes FileWriter so the file is created
                System.out.println("File created.");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file " + fw + " doesn't exist.");
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
