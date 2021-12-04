
package Programa;

import java.io.IOException;

public class EspañolMorse {
//    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "--.--", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
//    String[] palabras= {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] morse; 
    private String[] letras; //equivalente a el vector palabras que esta comentado.
    private Lector lector;
    String traduccion = "";
    
    public EspañolMorse() throws IOException{
        lector=new Lector();
        morse=lector.getMorse();
        letras=lector.getLetras();
    }

    public String traducirEspañol(String dato){
        traduccion = "";
        String[] palabra;
        palabra = dato.split(" ");

        for(int i=0; i <palabra.length; i++) {
            for(int j=0; j <morse.length; j++) {
                if(palabra[i].equals(morse[j])) {
                        traduccion = traduccion + letras[j] + " ";
                }
            }
        }   
        return traduccion;
    }
    
    
    public String traducirMorse (String dato) {
        traduccion = "";
        String mayusculas="";
        String letra="";  
        mayusculas=dato.toUpperCase();
        
        for(int i=1;i<=dato.length();i++){
            letra=mayusculas.substring(i-1,i);
            for(int j=0;j<letras.length;j++){
                if(letra.equals(letras[j])){
                   traduccion=traduccion+morse[j];
                }
            }
        }
        return traduccion;
    }
}

