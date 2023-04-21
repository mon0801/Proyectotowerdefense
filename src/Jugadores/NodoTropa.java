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
public class NodoTropa {
   private Tropa tropa;
    private NodoTropa siguiente; 

    public NodoTropa(Tropa tropa ) {
        this.tropa = tropa;
        this.siguiente = null;
    }

    public Tropa getTropa() {
        return tropa;
    }

    public void setTropa(Tropa tropa) {
        this.tropa = tropa;
    }

    public NodoTropa getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTropa siguiente) {
        this.siguiente = siguiente;
    } 
}
