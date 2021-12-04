/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lector {
    private String[] morse;
    private String[] letras;
    private ArrayList<String> apoyoMorse;
    private ArrayList<String> apoyoLetras;
    
    public Lector() throws IOException{
         apoyoMorse= new ArrayList();
         apoyoLetras= new ArrayList();
         obtenerDatos();
         morse=crearArregloMorse();
         letras=crearArregloLetras();
    } 
     
    public void obtenerDatos () throws IOException{
        String archivo="D:\\Itiel\\5to_Semestre\\Algoritmos y estructuras de datos\\Laboratorio\\ProyectoFinal\\src\\main\\java\\Archivos\\codigoMorse.txt";
        File f=new File(archivo);
        BufferedReader br;
        try{
           br = new BufferedReader(new FileReader(f));
           String lineaTexto="";
           while((lineaTexto=br.readLine())!=null){
                 String[] palabras = lineaTexto.split(" ");
                 apoyoMorse.add(palabras[1]);
                 apoyoLetras.add(palabras[0]);
           }
        }catch (FileNotFoundException ex) {
               Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] crearArregloLetras (){
        String[] aux= new String[apoyoLetras.size()];
        for(int i=0;i<apoyoLetras.size();i++){
            aux[i]=apoyoLetras.get(i);
        }
        return aux;
    }
    
    public String[] crearArregloMorse (){
        String[] aux= new String[apoyoMorse.size()];
        for(int i=0;i<apoyoMorse.size();i++){
            aux[i]=apoyoMorse.get(i);
        }
        return aux;
    }

    public String[] getMorse() {
        return morse;
    }

    public void setMorse(String[] morse) {
        this.morse = morse;
    }

    public String[] getLetras() {
        return letras;
    }

    public void setLetras(String[] letras) {
        this.letras = letras;
    }
    
}
