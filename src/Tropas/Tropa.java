/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tropas;
import GUI.Errores;
/**
 *
 * @author Monserrat Najera
 */
public class Tropa {
    private double vida; 
    private boolean isHostil; // false=tropas del usuario / true = tropas del enemigo para evitar que se ataquen asímmismas
    private final EnumTropas nombre;

    public Tropa(EnumTropas nombre,double vida, boolean isHostil) {
        this.vida = vida;
        this.isHostil = isHostil;
        this.nombre = nombre;
    }
    
    public double getVida() {
        return vida;
    }

    public boolean isHostil() {
        return isHostil;
    }
    
    public void atacar(Tropa tropa, double danno) { //ingresa la tropa que va a atacar
        if(tropa.isHostil != this.isHostil){ //si son del equipo opuesto entonces atacará
           tropa.vida -= danno; //reduzco la vida
        }
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setIsHostil(boolean isHostil) {
        this.isHostil = isHostil;
    }

    public EnumTropas getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Tropa{" + "vida=" + vida + ", nombre=" + nombre + '}';
    }
    
    
    
    
    
}
