/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafoDeAtaque;
import Jugadores.NodoTropa;
import Tropas.Tropa;
/**
 *
 * @author Monserrat Najera
 */
public class ListaAdyacencia {
  private NodoTropa primero;
    public ListaAdyacencia() {
        primero = null;
    }
    public void insertar(Tropa tropa ){
        NodoTropa nuevoNodo = new NodoTropa(tropa);
        if(primero != null){
            nuevoNodo.setSiguiente(primero);
        }
        primero = nuevoNodo;
    }
    public Tropa buscar(Tropa tropa){
        NodoTropa aux= primero; 
        while(aux != null){
            if(tropa == aux.getTropa()){
                return tropa;
            }
            aux = aux.getSiguiente();
        }
        return null; //Porque no existe
    }   
}
