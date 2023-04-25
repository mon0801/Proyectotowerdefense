/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafoDeAtaque;
import Tropas.Arquero;
import Tropas.Caballero;
import Tropas.Castillo;
import Tropas.Mago;
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
    Tropa [] listaTropas; 
    double [][] matrizAdyacencia; 
    private int cantidad = 0;
    public GrafoDeAtaque(int vertices ) {
        this.vertices = vertices;
        this.listaTropas = new Tropa[vertices];
        this.cantidad  = 0;
        this.matrizAdyacencia = new double[vertices][vertices];  
        inicializar_grafo();
    }
    private void insertar(Tropa tropa){ //Método privado porque solo se va a usar en inicializar grafo
        listaTropas[cantidad] = tropa;
        cantidad++;
    }
    private void nuevoArco(Tropa atacante, Tropa atacada, double danno){//Método privado porque solo se va a usar en inicializar grafo
        for(int i = 0; i < cantidad; i++){
            Tropa buscadaAtacante = listaTropas[i];
            if(buscadaAtacante.getNombre().equals(atacante.getNombre())){//Encuentra la tropa que va a atacar
                for(int j = 0; j<cantidad; j++){
                    Tropa buscadaAtacada = listaTropas[j];
                    if(buscadaAtacada.getNombre().equals(atacada.getNombre())){
                        matrizAdyacencia[i][j] = danno;
                    }
                }
            }
        }
    }
    public double getdanno(Tropa atacante, Tropa atacada){ //El único método publico para poder obtener el daño
        double danno = 0;
        for(int i = 0; i < cantidad; i++){
            Tropa buscadaAtacante = listaTropas[i];
            if(buscadaAtacante.getNombre().equals(atacante.getNombre())){//Encuentra la tropa que va a atacar
                for(int j = 0; j<cantidad; j++){
                    Tropa buscadaAtacada = listaTropas[j];
                    if(buscadaAtacada.getNombre().equals(atacada.getNombre())){
                        danno = matrizAdyacencia[i][j] ;
                    }
                
                }
            }
        }
        return danno;
    }
    
    private void inicializar_grafo(){//Método privado porque solo se va a usar una vez dentro del constructor
        Castillo castillo = new Castillo(10, true); //No importa la vida que tengan aquí porque estos no van a ser los que van a pelear
        Arquero arquero = new Arquero(10, true);
        Caballero caballero = new Caballero(10,true);
        Mago mago = new Mago(10, true);
        
        insertar(castillo);
        insertar(arquero);
        insertar(caballero);
        insertar(mago);
        //Cuando el castillo ataca le hace 0 de daño a todos
        nuevoArco(castillo, castillo, 0);
        nuevoArco(castillo, arquero, 0);
        nuevoArco(castillo, caballero, 0);
        nuevoArco(castillo, mago, 0);
        //Cuando el arquero ataca
        nuevoArco(arquero, castillo, 1); //Le hace 1 de daño al castillo
        nuevoArco(arquero, arquero, 1);
        nuevoArco(arquero, caballero, 1);
        nuevoArco(arquero, mago, 2); //Le hace más daño al mago
        //Cuando ataca el caballero
        nuevoArco(caballero, castillo, 2); //Le hace 2 de daño al castillo
        nuevoArco(caballero, arquero, 2); //le hace más daño al arquero
        nuevoArco(caballero, caballero, 1);
        nuevoArco(caballero, mago, 1);
        //Cuando ataca el mago
        nuevoArco(mago, castillo, 1.5);
        nuevoArco(mago, arquero, 1);
        nuevoArco(mago, caballero, 2);
        nuevoArco(mago, mago, 1);
    }
    
    
    
     
    
    
}