/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugadores;

import Tropas.Castillo;

/**
 *
 * @author Monserrat Najera
 */
public abstract class Jugador {
 public String nombre; //Usuario o CPU
    protected ColaTropas caminoUno; //Una lista por cada camino
    protected ColaTropas caminoDos; 
    protected Castillo castillo; 
    protected final boolean isHostil; 
    protected int maxTropas ;

    public Jugador(String nombre, boolean isHostil) {
        this.nombre = nombre; 
        this.caminoUno = new ColaTropas();
        this.caminoDos = new ColaTropas();
        this.castillo = new Castillo(0, false); //La vida empieza en 0 y no es hostil por defecto, en la función reiniciar debe cambiar esto
        this.isHostil = isHostil;
        this.maxTropas = 0;
    }
    protected void reiniciar(){
        castillo.setVida(10);
        castillo.setIsHostil(this.isHostil); //El usuario por defecto no es hostil esto siempre será falso por como lo definimos en el constructor
        //Limpia los caminos
        while(!caminoUno.colaVacia()){
            caminoUno.eliminar();
        }
        while(!caminoDos.colaVacia()){
            caminoDos.eliminar();
        }
    }
    public abstract void siguienteOleada(int numeroOleada); //Cada jugador tiene su forma de reestablecer valores
    
    public abstract void elegirTropas(); //Es abstracto para que el usuario tenga su forma de elegir tropas personalizadamente y el CPU de forma aleatoria

    public Castillo getCastillo() {
        return castillo;
    }

    public ColaTropas getCaminoUno() {
        return caminoUno;
    }

    public ColaTropas getCaminoDos() {
        return caminoDos;
    }
    
}