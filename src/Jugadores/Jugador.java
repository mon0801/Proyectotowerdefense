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
    protected boolean isHostil;
    protected int maxTropas;

    public Jugador(String nombre, boolean isHostil) {
        this.nombre = nombre;
        this.caminoUno = new ColaTropas();
        this.caminoDos = new ColaTropas();
        this.castillo = new Castillo(0, false); //La vida empieza en 0 y no es hostil por defecto, en la función reiniciar debe cambiar esto
        this.isHostil = isHostil;
        this.maxTropas = 0;
    }

    public abstract void siguienteOleada(); //Cada jugador tiene su forma de reestablecer valores

    public abstract void elegirTropas(); //Es abstracto para que el usuario tenga su forma de elegir tropas personalizadamente y el CPU de forma aleatoria   
}
