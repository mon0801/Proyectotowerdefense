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
import javax.swing.JOptionPane;

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
        for(int i  = 0; i< maxTropas; i++){
            EnumTropas[] opciones = {EnumTropas.ARQUERO, EnumTropas.CABALLERO, EnumTropas.MAGO};
            EnumTropas seleccionTropa = (EnumTropas) JOptionPane.showInputDialog(null,
                        "Selecciona una tropa "+i+"/"+String.valueOf(maxTropas), "Selección de tropa",
                        JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]);
            
            String[] caminos = {"Camino 1", "Camino 2"};
            String seleccionCamino = (String) JOptionPane.showInputDialog(null,
                        "Seleccione el camino por el cuál enviará el "+String.valueOf(seleccionTropa), "Selección del camino",
                        JOptionPane.QUESTION_MESSAGE,null,caminos,caminos[0]);
            if(seleccionTropa !=null && seleccionCamino !=null){
                Tropa tropaCreada  = crearTropa(seleccionTropa);
                if(seleccionCamino.equalsIgnoreCase(caminos[0])){ //El jugador seleccionói el camino 1
                    caminoUno.insertar(tropaCreada);
                }else{
                    caminoDos.insertar(tropaCreada);
                } 
            }else{
                i--; //Vuelve a ejecutar la opción
                JOptionPane.showMessageDialog(null, "Error en la selección");
            }

        }
    }
    private Tropa crearTropa(EnumTropas seleccion){
        Tropa tropa;
        switch (seleccion) {
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
                throw new AssertionError();
            }
        return tropa;
    }

    @Override
    public void siguienteOleada(int numeroOleada) {
        reiniciar();
        maxTropas = numeroOleada + 4;
    }
    }

