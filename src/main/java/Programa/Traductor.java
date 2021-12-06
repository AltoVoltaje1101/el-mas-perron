package Programa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Traductor {

    private Elemento[] objetos;
    private Lector lector;
    String traduccion = "";

    public Traductor() {
        lector = new Lector();
        objetos = lector.getObjetos();
    }

    public String traducirEspañol(String dato) {
        String[] palabra;
        palabra = dato.split(" ");

        for (int i = 0; i < palabra.length; i++) {
            for (int j = 0; j < objetos.length; j++) {
                if (palabra[i].equals(objetos[j].getMorse())) {
                    traduccion = traduccion + objetos[j].getLetra() + " ";
                }
            }
        }
        
        return traduccion;
    }

    public String traducirMorse(String dato) {
        String mayusculas = "";
        String letra = "";
        mayusculas = dato.toUpperCase();

        for (int i = 1; i <= dato.length(); i++) {
            letra = mayusculas.substring(i - 1, i);
            for (int j = 0; j < objetos.length; j++) {
                if (letra.equals(objetos[j].getLetra())) {
                    traduccion = traduccion + objetos[j].getMorse();
                }
            }
        }
        return traduccion;
    }

    public Elemento[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Elemento[] objetos) {
        this.objetos = objetos;
    }
    
    
}
