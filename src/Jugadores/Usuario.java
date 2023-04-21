/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugadores;

/**
 *
 * @author Monserrat Najera
 */
public class Usuario extends Jugador {

    public Usuario(String nombre) {
        super(nombre,false);
    }

    @Override
    public void elegirTropas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody   
    }

    @Override
    public void siguienteOleada() {
      castillo.setVida(10);
        castillo.setIsHostil(this.isHostil); //El usuario por defecto no es hostil esto siempre será falso por como lo definimos en el constructor
    }
    }

