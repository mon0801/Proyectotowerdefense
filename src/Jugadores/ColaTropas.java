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
public class ColaTropas {
  private NodoTropa frente; 
    private NodoTropa fin; 
    public ColaTropas() {
        frente = fin = null;
    }

    public void insertar(Tropa nuevaTropa){
        NodoTropa nuevoNodo = new NodoTropa(nuevaTropa);
        if(colaVacia()){
            frente =nuevoNodo;
        }else{
            fin.setSiguiente(nuevoNodo);
        }
        fin.setSiguiente(nuevoNodo);
        System.out.println("Tropa insertada a la lista");
    }
    public Tropa eliminar(){
        Tropa tropaEliminada = null;
        if(!colaVacia()){ //Si la cola no está vacía
            tropaEliminada = frente.getTropa();
            frente = frente.getSiguiente();
        }
        return tropaEliminada;
    }
    public Tropa obtenerFrente(){
        return frente.getTropa();
    }
    public boolean colaVacia(){
        return (frente ==null); //si es nulo retorna true, de lo contrario retorna false
    }   
}
