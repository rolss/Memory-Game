/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlayGame extends javax.swing.JFrame {
    
    private int puntos = 0;
    private JButton[][] botones = new JButton[4][5];
    Socket jugador;
    int g=0;
    public PlayGame() {
        initComponents();
     
        til.setFont(new Font("megatron",Font.BOLD,18));
        if (0==g) {
            a.setLocationRelativeTo(null);
        a.setVisible(true);
        g=g+1;
        }
       
        
        // Botones del frame se añaden a una matriz de botones
        botones[0][0] = C00;
        botones[0][1] = C01;
        botones[0][2] = C02;
        botones[0][3] = C03;
        botones[0][4] = C04;
        
        botones[1][0] = C10;
        botones[1][1] = C11;
        botones[1][2] = C12;
        botones[1][3] = C13;
        botones[1][4] = C14;
        
        botones[2][0] = C20;
        botones[2][1] = C21;
        botones[2][2] = C22;
        botones[2][3] = C23;
        botones[2][4] = C24;
        
        botones[3][0] = C30;
        botones[3][1] = C31;
        botones[3][2] = C32;
        botones[3][3] = C33;
        botones[3][4] = C34;
    }
    

    /**
     * Funcion para conectar al cliente con el servidor
     */
    public void iniciarclient() {                                      
        try {
            jugador = new Socket(iptxt.getText(), 3000);              
            System.out.println("Cliente conectado..." + jugador);      
            Hilo_Cliente hilo = new Hilo_Cliente(jugador, this);
            hilo.start();                                              
        } catch (IOException e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

    /**
     * Funcion para colocar las imagenes en el frame a partir de una lista de numeros organizados aleatoriamente
     * Los numeros contienen numeros del 1 al 10 repetidos, organizados de manera aleatoria
     * 
     * @param baraja cadena de numeros separados por ";"
     */
    public void setCards(String baraja) {
        String numbers[] = baraja.split(";");
        
        C00.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[0]) + ".png")));
        C01.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[1]) + ".png")));
        C02.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[2]) + ".png")));
        C03.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[3]) + ".png")));
        C10.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[4]) + ".png")));
        C11.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[5]) + ".png")));
        C12.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[6]) + ".png")));
        C14.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[7]) + ".png")));
        C20.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[8]) + ".png")));
        C21.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[9]) + ".png")));
        C22.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[10]) + ".png")));
        C23.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[11])+ ".png")));
        C30.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[12]) + ".png")));
        C31.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[13]) + ".png")));
        C32.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[14]) + ".png")));
        C33.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[15]) + ".png")));
        C13.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[16]) + ".png")));
        C24.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[17]) + ".png")));
        C34.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + Integer.parseInt(numbers[18]) + ".png")));
        C04.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[19] + ".png")));
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        conectar_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        iptxt = new javax.swing.JTextField();
        jPanel1 = new FondoPanel();
        puntaje_txt = new javax.swing.JLabel();
        C00 = new javax.swing.JButton();
        C01 = new javax.swing.JButton();
        C02 = new javax.swing.JButton();
        C03 = new javax.swing.JButton();
        C14 = new javax.swing.JButton();
        C12 = new javax.swing.JButton();
        C11 = new javax.swing.JButton();
        C10 = new javax.swing.JButton();
        C23 = new javax.swing.JButton();
        C22 = new javax.swing.JButton();
        C21 = new javax.swing.JButton();
        C20 = new javax.swing.JButton();
        C33 = new javax.swing.JButton();
        C32 = new javax.swing.JButton();
        C31 = new javax.swing.JButton();
        C30 = new javax.swing.JButton();
        C13 = new javax.swing.JButton();
        C24 = new javax.swing.JButton();
        C34 = new javax.swing.JButton();
        C04 = new javax.swing.JButton();
        til = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();

        a.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        a.setMinimumSize(new java.awt.Dimension(515, 239));
        a.setResizable(false);
        a.setSize(new java.awt.Dimension(515, 239));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        conectar_btn.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        conectar_btn.setText("Conectar");
        conectar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectar_btnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ss.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel4.setText("IP:");

        iptxt.setText("localhost");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(conectar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(iptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(conectar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout aLayout = new javax.swing.GroupLayout(a.getContentPane());
        a.getContentPane().setLayout(aLayout);
        aLayout.setHorizontalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        aLayout.setVerticalGroup(
            aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego Dos Caras");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(497, 532));

        puntaje_txt.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        puntaje_txt.setForeground(new java.awt.Color(255, 255, 255));
        puntaje_txt.setText("0");

        C00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C00.setBorder(null);
        C00.setBorderPainted(false);
        C00.setContentAreaFilled(false);
        C00.setFocusable(false);
        C00.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C00ActionPerformed(evt);
            }
        });

        C01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C01.setBorder(null);
        C01.setBorderPainted(false);
        C01.setContentAreaFilled(false);
        C01.setFocusable(false);
        C01.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C01ActionPerformed(evt);
            }
        });

        C02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C02.setBorder(null);
        C02.setBorderPainted(false);
        C02.setContentAreaFilled(false);
        C02.setFocusable(false);
        C02.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C02ActionPerformed(evt);
            }
        });

        C03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C03.setBorder(null);
        C03.setBorderPainted(false);
        C03.setContentAreaFilled(false);
        C03.setFocusable(false);
        C03.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C03ActionPerformed(evt);
            }
        });

        C14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C14.setBorder(null);
        C14.setBorderPainted(false);
        C14.setContentAreaFilled(false);
        C14.setFocusable(false);
        C14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C14ActionPerformed(evt);
            }
        });

        C12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C12.setBorder(null);
        C12.setBorderPainted(false);
        C12.setContentAreaFilled(false);
        C12.setFocusable(false);
        C12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C12ActionPerformed(evt);
            }
        });

        C11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C11.setBorder(null);
        C11.setBorderPainted(false);
        C11.setContentAreaFilled(false);
        C11.setFocusable(false);
        C11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C11ActionPerformed(evt);
            }
        });

        C10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C10.setBorder(null);
        C10.setBorderPainted(false);
        C10.setContentAreaFilled(false);
        C10.setFocusable(false);
        C10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C10ActionPerformed(evt);
            }
        });

        C23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C23.setBorder(null);
        C23.setBorderPainted(false);
        C23.setContentAreaFilled(false);
        C23.setFocusable(false);
        C23.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C23ActionPerformed(evt);
            }
        });

        C22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C22.setBorder(null);
        C22.setBorderPainted(false);
        C22.setContentAreaFilled(false);
        C22.setFocusable(false);
        C22.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C22ActionPerformed(evt);
            }
        });

        C21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C21.setBorder(null);
        C21.setBorderPainted(false);
        C21.setContentAreaFilled(false);
        C21.setFocusable(false);
        C21.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C21ActionPerformed(evt);
            }
        });

        C20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C20.setBorder(null);
        C20.setBorderPainted(false);
        C20.setContentAreaFilled(false);
        C20.setFocusable(false);
        C20.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C20ActionPerformed(evt);
            }
        });

        C33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C33.setBorder(null);
        C33.setBorderPainted(false);
        C33.setContentAreaFilled(false);
        C33.setFocusable(false);
        C33.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C33ActionPerformed(evt);
            }
        });

        C32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C32.setBorder(null);
        C32.setBorderPainted(false);
        C32.setContentAreaFilled(false);
        C32.setFocusable(false);
        C32.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C32ActionPerformed(evt);
            }
        });

        C31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C31.setBorder(null);
        C31.setBorderPainted(false);
        C31.setContentAreaFilled(false);
        C31.setFocusable(false);
        C31.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C31ActionPerformed(evt);
            }
        });

        C30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C30.setBorder(null);
        C30.setBorderPainted(false);
        C30.setContentAreaFilled(false);
        C30.setFocusable(false);
        C30.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C30ActionPerformed(evt);
            }
        });

        C13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C13.setBorder(null);
        C13.setBorderPainted(false);
        C13.setContentAreaFilled(false);
        C13.setFocusable(false);
        C13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C13ActionPerformed(evt);
            }
        });

        C24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C24.setBorder(null);
        C24.setBorderPainted(false);
        C24.setContentAreaFilled(false);
        C24.setFocusable(false);
        C24.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C24ActionPerformed(evt);
            }
        });

        C34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C34.setBorder(null);
        C34.setBorderPainted(false);
        C34.setContentAreaFilled(false);
        C34.setFocusable(false);
        C34.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C34ActionPerformed(evt);
            }
        });

        C04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/DS.jpeg"))); // NOI18N
        C04.setBorder(null);
        C04.setBorderPainted(false);
        C04.setContentAreaFilled(false);
        C04.setFocusable(false);
        C04.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tutu.jpeg")));
        C04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C04ActionPerformed(evt);
            }
        });

        til.setFont(new java.awt.Font("Modern No. 20", 1, 24)); // NOI18N
        til.setForeground(new java.awt.Color(255, 255, 255));
        til.setText("¿Crees tener buena memoria?");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Puntaje:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        nom.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        nom.setForeground(new java.awt.Color(255, 255, 255));
        nom.setText("si");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntaje_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(C30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(C20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(C01)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C00)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C03)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(C10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C04)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C02)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(til)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(til, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntaje_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C01)
                            .addComponent(C00)
                            .addComponent(C03)
                            .addComponent(C13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(C11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(C10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(C12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(C04, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(C14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(C02)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(C21)
                    .addComponent(C20)
                    .addComponent(C22)
                    .addComponent(C23)
                    .addComponent(C24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(C31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(C30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(C32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(C33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(C34, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(462, 580));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void C00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C00ActionPerformed
        enviarTurno(0,0);
    }//GEN-LAST:event_C00ActionPerformed

    private void C01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C01ActionPerformed
        enviarTurno(0,1);
    }//GEN-LAST:event_C01ActionPerformed

    private void C02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C02ActionPerformed
        enviarTurno(0,2);
    }//GEN-LAST:event_C02ActionPerformed

    private void C03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C03ActionPerformed
        enviarTurno(0,3);
    }//GEN-LAST:event_C03ActionPerformed

    private void C10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C10ActionPerformed
        enviarTurno(1,0);
    }//GEN-LAST:event_C10ActionPerformed

    private void C11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C11ActionPerformed
        enviarTurno(1,1);
    }//GEN-LAST:event_C11ActionPerformed

    private void C12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C12ActionPerformed
        enviarTurno(1,2);
    }//GEN-LAST:event_C12ActionPerformed

    private void C14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C14ActionPerformed
        enviarTurno(1,4);
    }//GEN-LAST:event_C14ActionPerformed

    private void C20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C20ActionPerformed
        enviarTurno(2,0);
    }//GEN-LAST:event_C20ActionPerformed

    private void C21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C21ActionPerformed
        enviarTurno(2,1);
    }//GEN-LAST:event_C21ActionPerformed

    private void C22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C22ActionPerformed
        enviarTurno(2,2);
    }//GEN-LAST:event_C22ActionPerformed

    private void C23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C23ActionPerformed
        enviarTurno(2,3);
    }//GEN-LAST:event_C23ActionPerformed

    private void C30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C30ActionPerformed
        enviarTurno(3,0);
    }//GEN-LAST:event_C30ActionPerformed

    private void C31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C31ActionPerformed
        enviarTurno(3,1);
    }//GEN-LAST:event_C31ActionPerformed

    private void C32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C32ActionPerformed
        enviarTurno(3,2);
    }//GEN-LAST:event_C32ActionPerformed

    private void C33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C33ActionPerformed
        enviarTurno(3,3);
    }//GEN-LAST:event_C33ActionPerformed

    private void C13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C13ActionPerformed
        enviarTurno(1,3);
    }//GEN-LAST:event_C13ActionPerformed

    private void C24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C24ActionPerformed
         enviarTurno(2,4);
    }//GEN-LAST:event_C24ActionPerformed

    private void C34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C34ActionPerformed
     enviarTurno(3,4);
    }//GEN-LAST:event_C34ActionPerformed

    private void C04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C04ActionPerformed
        enviarTurno(0,4);
    }//GEN-LAST:event_C04ActionPerformed

    private void conectar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectar_btnActionPerformed
        a.setVisible(false);
        iniciarclient();
        String f = "";
        f = nombretxt.getText();
        nom.setText(f);
        a.setVisible(false);
        a.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_conectar_btnActionPerformed

    /**
     * Metodo para obtener la matriz de botones de la interfaz
     * @return matriz de botones que usa la interfaz grafica
     */
    public JButton[][] getBotones(){
        return botones;
    }
    
    /**
     * Envia al hilo cliente los datos de la fila y la columna que presiona el usuario en el frame
     * @param f posicion de la fila, desde cero
     * @param c posicion de la columna, desde cero
     */
    public void enviarTurno(int f,int c){
        Hilo_Cliente.enviarTurno(f, c); 
    }
    
    /**
     * Manejo del fondo de la interfaz grafica
     */
    class FondoPanel extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagenes/ma_1.jpg")).getImage();
            System.out.println("ola");
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    
    /**
     * Aumenta el valor de la puntuacion mostrada al jugador
     */
    public void punto() {
        puntos++;
        puntaje_txt.setText(String.valueOf(puntos));
    }
    
    /**
     * Reinicia el valor de la puntuacion mostrada al jugador
     */
    public void reset() {
        puntos = 0;
        puntaje_txt.setText(String.valueOf(puntos));
    }
    
    /**
     * Avisa al jugador conectado que es el único que sigue en linea
     */
    public void disconnect() {
        JOptionPane.showMessageDialog(null, "El contrincante se ha desconectado. Puede abandonar el juego.");
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayGame().setVisible(false);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton C00;
    private javax.swing.JButton C01;
    private javax.swing.JButton C02;
    private javax.swing.JButton C03;
    private javax.swing.JButton C04;
    private javax.swing.JButton C10;
    private javax.swing.JButton C11;
    private javax.swing.JButton C12;
    private javax.swing.JButton C13;
    private javax.swing.JButton C14;
    private javax.swing.JButton C20;
    private javax.swing.JButton C21;
    private javax.swing.JButton C22;
    private javax.swing.JButton C23;
    private javax.swing.JButton C24;
    private javax.swing.JButton C30;
    private javax.swing.JButton C31;
    private javax.swing.JButton C32;
    private javax.swing.JButton C33;
    private javax.swing.JButton C34;
    private javax.swing.JFrame a;
    private javax.swing.JButton conectar_btn;
    private javax.swing.JTextField iptxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JLabel puntaje_txt;
    private javax.swing.JLabel til;
    // End of variables declaration//GEN-END:variables
}
