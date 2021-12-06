
package Programa;

public class Elemento {
   private int frecuencia;
   private String letra;
   private String morse;

    public Elemento(int frecuencia, String letra, String morse) {
        this.frecuencia = frecuencia;
        this.letra = letra;
        this.morse = morse;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
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
