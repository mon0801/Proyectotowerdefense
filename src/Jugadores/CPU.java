/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugadores;

/**
 *
 * @author Monserrat Najera
 */
public class CPU  extends Jugador{
  
    public CPU(String nombre) {
        super(nombre, true);
    }

    @Override
    public void elegirTropas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void siguienteOleada() {
        castillo.setVida(10);
        castillo.setIsHostil(this.isHostil); //la diferencia es que el CPU tiene si es hostil

    }
}