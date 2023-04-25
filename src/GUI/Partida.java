/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GrafoDeAtaque.GrafoDeAtaque;
import Jugadores.CPU;
import Jugadores.Jugador;
import Jugadores.Usuario;
import Tropas.Castillo;
import Tropas.EnumTropas;
import Tropas.Tropa;

/**
 *
 * @author Jose Vergara
 */
  public class Partida {
    private int oleada; 
    private Jugador usuario; 
    private CPU cpu;
    private final GrafoDeAtaque grafoAtaques;

    public Partida() {
        usuario = new Usuario("Usuario");
        cpu = new CPU("CPU");
        oleada = 0;
        grafoAtaques = new  GrafoDeAtaque(EnumTropas.values().length);
    }

    public void iniciarOleada() {
        oleada++;
        usuario.siguienteOleada(oleada);
        cpu.siguienteOleada(oleada);
        usuario.elegirTropas();
        cpu.elegirTropas();
    }
    
    public String realizarAtaques(){
        Castillo castilloUsuario = usuario.getCastillo();
        Castillo castilloCpu = cpu.getCastillo();
        System.out.println("Ataques para la oleada "+oleada);
        do{
          

            Tropa[] frenteJugador =configurandoAtaquesJugador();
            Tropa[] frenteCpu  = configurandoAtaquesCpu();
            System.out.println("Camino Uno: "+ frenteJugador[0].toString()+" vs "+frenteCpu[0].toString());
            System.out.println("Camino dos: "+ frenteJugador[1].toString()+" vs "+ frenteCpu[1].toString());
            //Reducción de daño entre las tropas
            ejecutarDannos(frenteJugador, frenteCpu);
            purgarLista(frenteJugador, frenteCpu);
            System.out.println("Daño al castillo : "+String.valueOf(castilloCpu.getVida())+" || "+  String.valueOf(castilloCpu.getVida()));       


        }while(castilloCpu.getVida() > 0 && castilloUsuario.getVida() >0 ); //hasta que alguno de los dos pierda
        
        if( castilloUsuario.getVida() > 0){
            return "El ganador es "+usuario.nombre;
        }else{
            return "El ganador es "+cpu.nombre;
        }
    }
    
    private Tropa[] configurandoAtaquesJugador(){
        Tropa[] tropas = new Tropa[2]; // 0 = camino1 , 1= camino 2;

        if(!usuario.getCaminoUno().colaVacia()){ //Si la cola no está vacía
            tropas[0]  = usuario.getCaminoUno().getFrente();
        }else{ //Cola vacía entonces ataca al castillo
            tropas[0] = usuario.getCastillo(); 
        }
        if(!usuario.getCaminoDos().colaVacia()){
            tropas[1]  = usuario.getCaminoDos().getFrente();
        
        }else{
            tropas[1]  = usuario.getCastillo();
        }
        /*
            No hay problema en que el castillo esté en ambas posiciones porque 
        significa que será atacado por ambos lados
        */
        return tropas;
    }
    private Tropa[] configurandoAtaquesCpu(){
        Tropa[] tropas = new Tropa[2]; // 0 = camino1 , 1= camino 2;

        if(!cpu.getCaminoUno().colaVacia()){ //Si la cola no está vacía
            tropas[0]  = cpu.getCaminoUno().getFrente();
        }else{ //Cola vacía entonces ataca al castillo
            tropas[0] = cpu.getCastillo(); 
        }
        if(!cpu.getCaminoDos().colaVacia()){
            tropas[1]  = cpu.getCaminoDos().getFrente();
        
        }else{
            tropas[1]  = cpu.getCastillo();
        }
        /*
            No hay problema en que el castillo esté en ambas posiciones porque 
        significa que será atacado por ambos lados
        */
        return tropas;
    }
    private void ejecutarDannos(Tropa[] frenteUsuario, Tropa[] frenteCpu){
        //Camino 1
        double danno = grafoAtaques.getdanno(frenteUsuario[0],frenteCpu[0]); //Daño para los del camino1
        frenteUsuario[0].atacar(frenteCpu[0], danno);
        danno = grafoAtaques.getdanno(frenteCpu[0], frenteUsuario[0]); //Daño para los del camino1
        frenteCpu[0].atacar(frenteUsuario[0], danno);
        //Camino 2 
        
        danno = grafoAtaques.getdanno(frenteUsuario[1],frenteCpu[1]); //Daño para los del camino2
        frenteUsuario[1].atacar(frenteCpu[1], danno);
        danno = grafoAtaques.getdanno(frenteCpu[1], frenteUsuario[1]); //Daño para los del camino2
        frenteCpu[1].atacar(frenteUsuario[1], danno);
        
        
    }
    private void purgarLista(Tropa[] frenteUsuario, Tropa[] frenteCpu){
        if(frenteUsuario[0].getVida() <= 0 
                && !frenteUsuario[0].getNombre().equals(EnumTropas.CASTILLO))
        {
            //Si fue derrotado y no es el castillo
            usuario.getCaminoUno().eliminar();
        }
        else if(frenteCpu[0].getVida() <=0 && 
                !frenteCpu[0].getNombre().equals(EnumTropas.CASTILLO))
        {
            cpu.getCaminoUno().eliminar();
        }    
        if(frenteUsuario[1].getVida() <= 0 && 
                !frenteUsuario[1].getNombre().equals(EnumTropas.CASTILLO))
        {
            //Si fue derrotado y no es el castillo
            usuario.getCaminoDos().eliminar();
        }else if(frenteCpu[0].getVida() <=0 && 
                !frenteCpu[1].getNombre().equals(EnumTropas.CASTILLO))
        {
                cpu.getCaminoDos().eliminar();
        }
   
    }

    public int getOleada() {
        return oleada;
    }

    public Jugador getUsuario() {
        return usuario;
    }

    public CPU getCpu() {
        return cpu;
    }

    
}  

