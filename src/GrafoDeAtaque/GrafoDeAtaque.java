/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafoDeAtaque;
import Tropas.Tropa;
/**
 *
 * @author Monserrat Najera
 */
public class GrafoDeAtaque {
  //Este es el grafo que contiene la lógica de ataque de cada tropa

    /*         |Castillo    |   Arquero |   Caballero   |   Mago    |
    Castillo   |     0      |     0     |       0       |    0      |
    Arquero    |     1      |     1     |       1       |    2      |
    Caballero  |     2      |     2     |       1       |     1     |
    Mago       |     1.5    |     1     |       2       |     1     |
    -----------------------------------------------------------------
    */

   int vertices; 

    ListaAdyacencia listaAdyacencia; 
    double [][] matrizAdyacencia; 

    public GrafoDeAtaque() {
        this.vertices = 0;
        this.listaAdyacencia = new ListaAdyacencia();
        this.vertices++;
        this.matrizAdyacencia = new double[vertices][vertices];   
    }
    public void insertar(Tropa tropa){
        if(listaAdyacencia.buscar(tropa) ==null){ //Si no existe el nodo 
            listaAdyacencia.insertar(tropa);
        }
        System.out.println("El nodo ya se encuentra insertado en el grafo");
    }
    public void nuevoArco(Tropa atacante, Tropa atacada, double danno){
        for(int i = 0; i < vertices; i++){

            for(int j = 0; j<vertices; j++){


            }
        }
    }
  
}
