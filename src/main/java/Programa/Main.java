
package Programa;
import java.io.IOException;

public class Main {
    
    private Traductor traductor;
    private ArbolBinario arbol;

    public Main() throws IOException {
       traductor = new Traductor();
       arbol= new ArbolBinario();
    }

    
    public static void main(String[] args) throws IOException {
        Traductor traduccion = new Traductor();
        String palabras = "";
//        palabras = traduccion.traducirMorse("HOLA MUNDO");		
//        System.out.println(palabras);
        palabras = traduccion.traducirEspañol(".... --- .-.. .-");	
        System.out.println(palabras);
    }
    
    
//    public static void main(String[] args) throws IOException {
//         Lector lector= new Lector();
//         lector.obtenerDatos();
//         lector.crearArregloLetras();
//         lector.crearArregloMorse();
//         lector.imprimirArreglos();
//    }

}
