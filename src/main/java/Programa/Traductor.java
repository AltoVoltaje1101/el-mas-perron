
package Programa;
import java.io.IOException;

public class Traductor {

    public static void main(String[] args) throws IOException {
        EspañolMorse traduccion = new EspañolMorse();
        String palabras = "";
        palabras = traduccion.traducirMorse("HOLA MUNDO");		
        System.out.println(palabras);
//        palabras = traduccion.traducirEspañol(".... --- .-.. .-");	
//        System.out.println(palabras);
    }

}
