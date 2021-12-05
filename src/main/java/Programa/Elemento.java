
package Programa;

public class Elemento {
   private float frecuencia;
   private String letra;
   private String morse;

    public Elemento(float frecuencia, String letra, String morse) {
        this.frecuencia = frecuencia;
        this.letra = letra;
        this.morse = morse;
    }

    public float getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(float frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }

    @Override
    public String toString() {
        return "Elemento{" + "frecuencia=" + frecuencia + ", letra=" + letra + ", morse=" + morse + '}';
    }
   
}
