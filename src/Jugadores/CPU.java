/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jugadores;

import Tropas.Arquero;
import Tropas.Caballero;
import Tropas.EnumTropas;
import Tropas.Mago;
import Tropas.Tropa;
import java.util.Random;

/**
 *
 * @author Monserrat Najera
 */
public class CPU  extends Jugador{
  
 Random random ;
    
    public CPU(String nombre) {
        super(nombre, true);
        random = new Random();
    }
    
     /*
    *Inserta las tropas aletoriamente seleccionadas en un camino aleatoriamente seleccionado
    */

    @Override
    public void elegirTropas() { 
       
        for(int i = 0; i<maxTropas; i++){
           ColaTropas caminoSeleccionado = elegirCamino();
           Tropa tropa = elegirTropa();
           System.out.println("CPU Selecciona: "+tropa);
           caminoSeleccionado.insertar(tropa);
        }
    }
    private ColaTropas elegirCamino(){
        ColaTropas cola; 
        
        int numero = random.nextInt(2) + 1;
        if(numero==1){
            cola = caminoUno;
        }else{
            cola = caminoDos;
        }
        return cola;
    }
    private Tropa elegirTropa(){
        Tropa tropa;
        int totalTropas = EnumTropas.values().length;
        // Generar un número aleatorio entre 1 y cantidadTropas (inclusive)
        int numero = random.nextInt(totalTropas-1) + 1;// El +1 Es porque no puede seleccionar el castillo
        EnumTropas seleccionada = EnumTropas.values()[numero];
        switch (seleccionada) {
            case ARQUERO:
                tropa = new Arquero(10, this.isHostil);
                break;
            case CABALLERO:
                tropa = new Caballero(10, this.isHostil);
                break;
            case MAGO:
                tropa = new Mago(10, this.isHostil);
                break;
            default:
                System.out.println("No se puede elegir el castillo como atacante");
                throw new AssertionError();
        }
        return tropa;
    }

    @Override
    public void siguienteOleada(int numeroOleada) {
        reiniciar();        
        maxTropas = (numeroOleada + 4)-1; //El CPU tiene una tropa menos
    }
   

 
    
}