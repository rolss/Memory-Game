/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_memoria;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor_Memoria {

    static Hilo_jugador[] players = new Hilo_jugador[5];
    static  int i = 0;
    static int a[] = getCardNumbers();
    String baraja = "";
    private int turnos = 1;
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();

    /**
     * Crea el servidor con una IP, un puerto, y su respectivo hilo para realizar las comunicaciones con el cliente
     */
    public void createserver() {
        
        // Variables propias del servidor
        InetAddress ipAddress = null;   
        int portNumber = 3000;          
        int backlog = 0;               

        //Transforma el vector de numeros a un string para enviar la baraja al jugador
        for (int j = 0; j < 20; j++) {
            baraja = baraja + String.valueOf(a[j]) + ";";   
        }

        try {
            ipAddress = InetAddress.getByName("127.0.0.1"); // Dirección IP donde se creará el servidor
        } catch (UnknownHostException u) {
            System.out.println("No se puede obtener la dirección IP");
        }

        try {
            // Creación del servidor
            ServerSocket servidor = new ServerSocket(portNumber, backlog, ipAddress);
            System.out.println("Servidor Creado y Corriendo...");

            // Servidor acepta conexiones
            while (true) {
                Socket jp = servidor.accept();
                System.out.println("Se conecta el Jugador: " + jp);
                
                // Se añade a la lista de usuarios y se manejan los turnos
                usuarios.add(jp); 
                int parimpar = turnos % 2 == 0 ? 1 : 0; // Obtiene 1 si turnos es par, 0 si es impar
                turnos++; 
                
                // Creación del hilo
                Hilo_jugador j = new Hilo_jugador(jp, parimpar, usuarios); 
                
                // Controlar la cantidad de jugadores conectados en un vector
                if ( i < 2){
                    players[i] = j;
                    i++; 
                    if (i==2) {
                        i=0;
                    }
                } else {
                    System.out.println("Max  de players alcanzados");
                }
                
                // Envía la información de la baraja
                for (Hilo_jugador p : Servidor_Memoria.players) {
                    if (p != null) {
                        p.baraja = baraja;
                    }
                }
                j.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor_Memoria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new Servidor_Memoria().createserver();
    }

    /**
     * Crea una un vector con 10 pares de números repartidos aleatoriamente. 
     * El vector contiene números del 1 al 10 repetidos dos veces.
     * 
     * @return vector de 20 posiciones
     */
    public static int[] getCardNumbers() {  
        int[] numbers = new int[20];
        int count = 0;

        while (count < 20) {
            Random r = new Random();
            int na = r.nextInt(10) + 1;
            int nvr = 0;

            for (int i = 0; i < 20; i++) {
                if (numbers[i] == na) {
                    nvr++;
                }
            }
            if (nvr < 2) {
                numbers[count] = na;
                count++;
            }

        }
        return numbers;
    }
}
