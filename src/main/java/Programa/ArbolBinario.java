package Programa;

import Programa.NodoArbol;
import java.util.Scanner;

public class ArbolBinario {
    NodoArbol raiz = null, aux, padre;
    int info;
    static Scanner entrada = new Scanner(System.in);

    public void agregar() {
        try {
            System.out.println("\nTeclee el nodo a ingresar\n *El nodo debe ser un número entero");
            info = Integer.parseInt(entrada.nextLine());

            NodoArbol nuevo = new NodoArbol();
            nuevo.dato = info;

            if (raiz == null) {
                raiz = nuevo;
                System.out.println("\nNODO '" + info + "' INGRESADO");
            } else {

                aux = raiz;

                while (true) {
                    if (aux.dato == info) { //Evita datos repetidos y termina el ciclo
                        System.out.println("\nERROR\nEl nodo a ingresar ya se encuentra en el árbol");
                        return;
                    } else {
                        padre = aux;

                        if (info < aux.dato) { //Izquierda, menor a la raiz del �rbol o sub�rbol
                            aux = aux.izquierda;
                            if (aux == null) { //La posición del hijo no está ocupada
                                padre.izquierda = nuevo;
                                System.out.println("\nNODO '" + info + "' INGRESADO");
                                return;
                            }
                        } else { //Derecha, mayor a la raiz del árbol o subárbol						
                            aux = aux.derecha;
                            if (aux == null) { //La posición del hijo no está ocupada
                                padre.derecha = nuevo;
                                System.out.println("\nNODO '" + info + "' INGRESADO");
                                return;
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException e) {

        } catch (NumberFormatException e) {
            System.out.println("\nERROR\nEl árbol solo trabaja con n�meros enteros");
        }

    } //Fin de método agregar

    public void buscar() {
        try {
            System.out.println("\nTeclee el nodo a buscar");
            info = Integer.parseInt(entrada.nextLine());

            aux = raiz;

            if (aux.dato == info) {
                System.out.println("NODO ENCONTRADO");
            } else {
                while (true) { //Se realiza retorno cuando se encuentra el dato o el auxiliar no tiene valor
                    if (info < aux.dato) { //búsqueda en subárbol izquierdo
                        aux = aux.izquierda;
                        if (aux == null) {
                            System.out.println("NODO NO ENCONTRADO");
                            return;
                        }
                    } else { //búsqueda en subárbol derecho
                        aux = aux.derecha;
                        if (aux == null) {
                            System.out.println("NODO NO ENCONTRADO");
                            return;
                        }
                    }
                    if (aux.dato == info) {
                        System.out.println("NODO ENCONTRADO");
                        return;
                    }
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("\nERROR\nEl árbol solo trabaja con n�meros enteros");
        } catch (NullPointerException e) {

        }
    }//Fin método buscar

    public void preOrden(NodoArbol raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " "); //PreOrden imprimirá primero la raíz para cualquier subárbol en un método recursivo
            preOrden(raiz.izquierda);
            preOrden(raiz.derecha);
        }

    }//Fin método preOrden

    public void enOrden(NodoArbol raiz) {
        if (raiz != null) {
            enOrden(raiz.izquierda);
            System.out.print(raiz.dato + " "); //EnOrden imprimirá la raíz en medio de los demas nodos para cualquier subárbol en un método recursivo
            enOrden(raiz.derecha);
        }

    }//Fin método enOrden

    public void postOrden(NodoArbol raiz) {
        if (raiz != null) {
            postOrden(raiz.izquierda);
            postOrden(raiz.derecha);
            System.out.print(raiz.dato + " "); //PostOrden imprimirá la raíz al final de cualquier subárbol en un método recursivo
        }

    }//Fin método postOrden

    public void eliminar(int info) {
        Boolean izq = false;

        aux = raiz;
        padre = raiz;

        /*
        Primero buscamos el nodo que contiene el objeto que se quiere eliminar
         */
        while (aux.dato != info) {
            padre = aux;
            /*
            Recorremos el arbol moviendonos a la izquierda
            si el objeto buscado es menor al nodo actual
            
            y nos recorremos a la derecha en caso de que
            el objeto buscado sea mayor al del nodo actual
             */
            if (info < aux.dato) {
                
                izq = true;
                aux = aux.izquierda;
            } else {
                izq = false;
                aux = aux.derecha;
            }
            if (aux == null) {
                System.out.println("EL NODO A ELIMINAR NO EXISTE");
                return;
            }
        }
        /*Una vez que encontramos el nodo, identificamos si entra en alguno de los
          tres posibles casos
        1. El nodo no tiene hijos
        2. El nodo tiene un hijo
        3. El nodo tiene dos hijos
         */

        if (aux.izquierda == null && aux.derecha == null) {
            //Ningún hijo
            System.out.println("Nodo sin hijos");
            if (aux == raiz) {// Cuando el nodo es igual a la raiz
                raiz = null;
            } else {
                //Dependiendo de los resultados obtenidos arrba
                //Se borrara el nodo izquierdo o derecho 
                /*
                Si el nodo auxiliar se encuentra a la izquierda
                del nodo padre, entonces se elimina el nodo de la izquierda
                del nodo padre
                En caso contrario, se elimina el nodo derecho del nodo padre
                */
                if (izq == true) {
                    padre.izquierda = null;
                    System.out.println("NODO '" + info + "' ELIMINADO");
                } else {
                    padre.derecha = null;
                    System.out.println("NODO '" + info + "' ELIMINADO");
                }
            }
        } else {
            /*Determinamos si alguno de los dos nodos dentro de aux */
            if ((aux.izquierda != null && aux.derecha == null) || (aux.izquierda == null && aux.derecha != null)) {
                //El nodo tiene un hijo
                System.out.println("Nodo con un hijo");
                //se utiliza el metodo unHIjo para eliminar dicho nodo
                unHijo(padre, aux, izq);
                System.out.println("NODO '" + info + "' ELIMINADO");
            } else {//Nodo con dos hijos
                System.out.println("Nodo con dos hijos");
                NodoArbol reemplazo = encontrarReemplazo(aux);
                if (aux == raiz) {
                    raiz = reemplazo;
                } else {
                    if (izq == true) {
                        padre.izquierda = reemplazo;
                    } else {
                        padre.derecha = reemplazo;
                    }
                    reemplazo.izquierda = aux.izquierda;
                }
                System.out.println("NODO '" + info + "' ELIMINADO");
            }
        }
    }

    public void unHijo(NodoArbol padre, NodoArbol aux, boolean izq) {
        if (aux.derecha == null) {
            if (aux == raiz) {
                /*
                recorremos el valor de la izquierda hasta la raiz
                Ya que se identifico que el nodo aux es el nodo raiz
                */
                raiz = aux.izquierda;
            } else {
                /*
                Identificamos si el nodo aux se encuentra a la izquierda
                o a la derecha del nodo padre, y recorremos el valor
                requerido
                
                El nodo aux solo tiene un hijo, porlo que este ocupara
                su lugar una vez que el nodo aux se elimine
                */
                if (izq == true) {
                    // Padre = nodo que contiene el nodo aux
                    padre.izquierda = aux.izquierda;
                } else {
                    padre.derecha = aux.izquierda;
                }
            }
         /*
            Se repite el mismo proceso, pero ahora considerando que el nodo
            izquierdo es nulo, es decir, el hijo de nuestro nodo aux se encuentra
            en el lado derecho
            */
        } else {
            if (aux.izquierda == null) {
                if (aux == raiz) {
                    raiz = aux.derecha;
                } else {
                    if (izq == true) {
                        padre.izquierda = aux.derecha;
                    } else {
                        padre.derecha = aux.derecha;
                    }
                }
            }
        }
    }
    
    public NodoArbol encontrarReemplazo(NodoArbol aux) {
        NodoArbol nvoPadre = aux;
        NodoArbol reemplaza = aux;
        NodoArbol auxiliar = aux.derecha;

        while (auxiliar != null) {
            nvoPadre = reemplaza;
            reemplaza = auxiliar;
            auxiliar = auxiliar.izquierda;
        }
        if (reemplaza != aux.derecha) {
            nvoPadre.izquierda = reemplaza.derecha;
            reemplaza.derecha = aux.derecha;
        }
        System.out.println("Vaor del reemplazo:"+reemplaza.dato);
        return reemplaza;
    }

}
