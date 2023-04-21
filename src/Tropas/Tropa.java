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
     protected double vida; 
    protected boolean isHostil; // false=tropas del usuario / true = tropas del enemigo para evitar que se ataquen asímmismas


    public Tropa(double vida, boolean isHostil) {
        this.vida = vida;
        this.isHostil = isHostil;
    }

    public double getVida() {
        return vida;
    }

    public boolean isHostil() {
        return isHostil;
    }

         protected void atacar(Tropa tropa, double danno) throws Errores{ //ingresa la tropa que va a atacar
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
}
