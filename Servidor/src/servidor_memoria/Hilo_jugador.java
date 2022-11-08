package servidor_memoria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo_jugador extends Thread {

    // Variables iniciales
    String Nombre;
    String baraja;
    
    // Variables de comunicación del servidor
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    
    // Variables para manejar turnos iniciales
    private int parimpar;
    private boolean turno;
    
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    String cad;

    /**
     * Construye un hilo para comunicarse con un cliente
     * Debe iniciarse en el servidor
     * 
     * @param s socket del hilo
     * @param ParImpar variable utilizada para determinar el turno inicial del jugador conectado
     * @param users lista de usuarios que se han conectado al servidor
     * @throws IOException 
     */
    public Hilo_jugador(Socket s, int ParImpar, LinkedList users) throws IOException {
        this.socket = s;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.parimpar = ParImpar;
        this.usuarios = users;
    }

    @Override
    public void run() {
        try {
            Boolean connected = true;
            if (in.readUTF().equals("listo")) { 
                try {
                    turno = parimpar == 1; // Determina el turno inicial del jugador. Esto se maneja desde el servidor
                    baraja += turno;
                    
                    this.out.writeUTF(baraja);  // Se envia la baraja y turno iniciales al jugador. 
                    
                    while (connected) {
                        String recibidos = in.readUTF();
                        
                        /*
                            Se recibirá un mensaje dividido por ";", de forma que
                            [0] : fila seleccionada por el jugador
                            [1] : columna seleccionada por el jugador
                            [2] : indicador de la condición del juego, manejado en el hilo del cliente
                            [3] : indicador de la finalización del juego o ronda
                        */
                        
                        String recibido[] = recibidos.split(";");
                        System.out.println(recibido[0]);
                        if (recibido[0].equals("fin")) {
                             socket.close();
                        }
                        int f = Integer.parseInt(recibido[0]);
                        int c = Integer.parseInt(recibido[1]);
                        int ind = Integer.parseInt(recibido[2]);
                        int fd=Integer.parseInt(recibido[3]);
                        cad = "";
                        
                        if (fd == 1) { // El juego ha finalizado, se envía una nueva baraja al azar
                            int a[] = getCardNumbers();
                            for (int j = 0; j < 20; j++) {
                                cad = cad + String.valueOf(a[j]) + ";";
                            }
                            
                        } else { // El juego no ha finalizado, se forma una cadena con la información para comunicarsela a todos los clientes
                            cad += f+";";
                            cad += c+";";
                            cad += ind+";";
                            cad+=fd+";";
                        }
                        
                        for (Socket usuario : usuarios) {
                            out = new DataOutputStream(usuario.getOutputStream());
                            out.writeUTF(cad);
                        }
                            
                    }
                
                } catch (IOException ex) {
                    
                }
            
                // El usuario se ha desconectado. Se elimina de la lista de usuarios y se le comunica al resto de usuarios. 
                usuarios.remove(this.socket);
                for (Socket usuario : usuarios) {
                     out = new DataOutputStream(usuario.getOutputStream());
                     out.writeUTF("-1");
                }
                
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException ex) {

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo_jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            }//fin

        }
        return numbers;
    }
}
