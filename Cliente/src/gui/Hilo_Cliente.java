package gui;

import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Hilo_Cliente extends Thread {

    // Variables pertinentes a la comunicacion con el hilo
    static PlayGame frame = new PlayGame();
    DataInputStream in;
    static DataOutputStream out;
    private String mensaje;
    
    // Variables pertinentes al manejo de la partida
    private static boolean turno;
    private JButton[][] botones;
    private static int indicador = 0;
    private ImageIcon img1;
    private ImageIcon img2;
    private JButton[] parbtns = new JButton[2];
    private static int puntaje = 0;
   
    /**
     * Construye un hilo para comunicarse con el servidor
     * @param s socket del hilo
     * @param pg interfaz individual manejada por el hilo
     * @throws IOException 
     */
    public Hilo_Cliente(Socket s, PlayGame pg) throws IOException {
        this.in = new DataInputStream(s.getInputStream());
        this.out = new DataOutputStream(s.getOutputStream());
        this.frame = pg;
        this.botones = frame.getBotones();
    }

    public void run() {
        String baraja = "";
        
        try {
            out.writeUTF("listo");
            
            // Se envia la baraja inicial en la interfaz y se establece el turno inicial del jugador
            baraja = in.readUTF();
            frame.setCards(baraja);   
            String[] x = baraja.split(";");
            turno = Boolean.valueOf(x[20]);
            
            while (true) {
                mensaje = in.readUTF();
                
                if (mensaje.equals("-1")) { // El jugador actual es el único conectado. Se le avisa para que se desconecte.
                    frame.disconnect();
                } else {
                    String[] mensajes = mensaje.split(";");
                    
                    /*
                        Se recibirá un mensaje dividido por ";", de forma que
                        [0] : fila seleccionada por uno de los jugadores
                        [1] : columna seleccionada por uno de los jugadores
                        [2] : indicador de la condición del juego
                        [3] : indicador de la finalización del juego o ronda
                    */
                    
                    int f = Integer.parseInt(mensajes[0]);
                    int c = Integer.parseInt(mensajes[1]);
                    indicador = Integer.parseInt(mensajes[2]);
                    int tr=Integer.parseInt(mensajes[3]);

                    if (tr!=0) { // El juego ha terminado, se inicia un nuevo juego
                        if(turno == false){  
                            JOptionPane.showMessageDialog(frame, "Que lastima, has perdido");
                        }
                        JOptionPane.showMessageDialog(frame, "Reiniciando partida... espere.");
                        Thread.currentThread().sleep(1000);
                        reiniciar(mensaje);
                    } else { // El juego no ha terminado
                        switch (indicador) {
                        case 0: // Levantar primera carta
                            botones[f][c].setEnabled(false);
                            img1 = (ImageIcon) botones[f][c].getDisabledIcon();
                            parbtns[0] = botones[f][c];
                            indicador = 1;
                            break;
                        case 1: // levantar segunda carta y comparar
                            botones[f][c].setEnabled(false);
                            img2 = (ImageIcon) botones[f][c].getDisabledIcon();
                            parbtns[1] = botones[f][c];
                            indicador = 2;
                            Thread.currentThread().sleep(500); // Se pausa el programa para que ambos jugadores tengan la oportunidad de ver las cartas por un breve momento
                            if (img1.getDescription().compareTo(img2.getDescription()) != 0) { // imagenes diferentes, cambio de turno
                                parbtns[0].setEnabled(true);
                                parbtns[1].setEnabled(true);
                                turno = !turno;
                            } else { // imagenes iguales, incremento de puntaje
                                if (turno==true) {
                                     puntaje += 1;
                                     frame.punto();
                                }

                                // Verificacion del puntaje para la victoria del jugador 
                                if (puntaje>=5) {
                                    String  datos = "";
                                    datos += f + ";";
                                    datos += c + ";";
                                    datos += indicador + ";";
                                    datos+=1;
                                    out.writeUTF(datos);
                                    JOptionPane.showMessageDialog(frame, "¡Felicitaciones! ¡Has ganado!");
                                    Thread.currentThread().sleep(3000);

                                }
                            }   
                            indicador = 0;
                            break;
                        default:
                            break;
                        }
                    }
                }
                
                
            }
            
        } catch (IOException ex) {

        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Envia los datos del turno del jugador actual al servidor
     * Envia la fila y la columna presionadas, el indicador de la condicion del juego y el indicador de la finalizacion del juego
     * Los datos solo se envían si es el turno del jugador actual
     * 
     * @param f fila presionada por el jugador actual
     * @param c columna presionada por el jugador actual
     */
    static public void enviarTurno(int f,int c){
        try {
            if(turno){
                String  datos = "";
                datos += f + ";";
                datos += c + ";";
                datos += indicador + ";";
                datos+= 0+";";
                out.writeUTF(datos);
            } else { 
                JOptionPane.showMessageDialog(frame, "Espera tu turno");
            }
        } catch (HeadlessException | IOException e) {
            e.printStackTrace();
        }
    }
   
    /**
     * Se encarga de reiniciar todas las variables pertinentes del hilo y de la interfaz para que se pueda jugar una nueva partida
     * @param newbaraja nueva baraja aleatoria enviada por el servidor
     */
    public void reiniciar(String newbaraja) {
        puntaje = 0;
        indicador = 0;
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                botones[i][j].setEnabled(true);
            }
        }
        frame.setCards(newbaraja);
        frame.reset();

        System.out.println("reinicio completado");
        
        
    }
}
    
    
