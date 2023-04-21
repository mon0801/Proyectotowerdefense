/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugadores;

import Tropas.Tropa;

/**
 *
 * @author Monserrat Najera
 */
public class ListaTropas {
   private NodoTropa cabeza; 

    public ListaTropas() {
        cabeza = null;
    }

    public void insertar(Tropa nuevaTropa){
        NodoTropa nuevoNodo = new NodoTropa(nuevaTropa);
        if(cabeza!=null){ //Si no es la primera vez que se inserta 
            nuevoNodo.setSiguiente(cabeza); //Los va haciento una fila
        }
        cabeza = nuevoNodo; //Es importante actualizar la cabeza para que vayan agregandose más
        System.out.println("Tropa insertada a la lista");
    }
    public void eliminar(Tropa tropa){
        NodoTropa actual, anterior;
        actual = cabeza;
        anterior = null;

        while(actual !=null && !(actual.getTropa() == tropa)){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if(actual!=null){ //Si el ciclo terminó porque lo encontró y no porque ya llegó al final de la lista
            if(actual==cabeza){
                cabeza = actual.getSiguiente(); //Si el actual fuera la cabeza, la cabeza pasa a ser el siguiente y de esta forma se pierde el actual
            }else{
                anterior.setSiguiente(actual.getSiguiente());
            }
        }

    }


    public NodoTropa getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoTropa cabeza) {
        this.cabeza = cabeza;
    }
  
}
