/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.logging.Level;


public class Principal {
    
    private Traductor traductor;
    private ArbolBinario arbol;

    public Principal(){
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
    
    public void simon(){
        crearArbol();
        arbol.preOrden(arbol.raiz);
        System.out.println(arbol.raiz.derecha.dato.toString());
        System.out.println(arbol.raiz.derecha.izquierda.dato.toString());
        System.out.println(arbol.raiz.derecha.izquierda.derecha.dato.toString());
        System.out.println(arbol.raiz.derecha.izquierda.derecha.izquierda.dato.toString());
    }
    public void buscarLetra(){
        
    }
  

}
