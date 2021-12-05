
package Programa;
import java.io.IOException;

public class Main {
    
    private Traductor traductor;
    private ArbolBinario arbol;

    public Main() throws IOException {
       traductor = new Traductor();
       arbol= new ArbolBinario();
    }

    public void crearArbol(){
      Elemento raiz;
      Elemento[] v= traductor.getObjetos();
      raiz=new Elemento(1000,".","-");
      arbol.agregar(raiz);
      boolean centinela=false;
      for(int i=0;i<v.length;i++){
        arbol.agregar(v[i]);
      }
    }
    
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.crearArbol();
        m.arbol.preOrden(m.arbol.raiz);
//        System.out.println(""+m.arbol.raiz.derecha.dato.toString());
//        System.out.println(""+m.arbol.raiz.derecha.izquierda.dato.toString());
//        System.out.println(""+m.arbol.raiz.derecha.izquierda.derecha.dato.toString());
//        System.out.println(""+m.arbol.raiz.derecha.izquierda.derecha.izquierda.dato.toString());
    }
  
    
//    public static void main(String[] args) throws IOException {
//        Traductor traduccion = new Traductor();
//        String palabras = "";
////        palabras = traduccion.traducirMorse("HOLA MUNDO");		
////        System.out.println(palabras);
//        palabras = traduccion.traducirEspañol(".... --- .-.. .-");	
//        System.out.println(palabras);
//    }
////    
//    
//    public static void main(String[] args) throws IOException {
//         Lector lector= new Lector();
//         lector.obtenerDatos();
//         lector.crearArregloLetras();
//         lector.crearArregloMorse();
//         lector.imprimirArreglos();
//    }

}
