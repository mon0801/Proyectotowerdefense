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
public class Castillo extends Tropa{

    public Castillo(double vida, boolean isHostil) {
        super(vida, isHostil);
    }
     @Override
    protected void atacar(Tropa tropa, double danno) throws Errores{
       throw new Errores("El castillo no ataca a nínguna tropa");
    }
}
