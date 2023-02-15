# Memory-Game
2-Player memory game made in java using threads and sockets. Can be played online or local. 

To run this locally (2 players on the same computer), do the following.
1. Run Server/src/servidor_memoria.java
2. Run two instances of Cliente/src/gui/PlayGame.java
  2.1. Add your name in the "Nombre" field of each instance and click on "Conectar"
  Warning: if the same window to connect opens, please ignore it. This bug is currently being fixed
3. There should be two windows showing two decks of cards. Enjoy the game!

To run this online (2 players on different computers), do the following.
1. Run Radmin VPN and make sure both players are in the same Radmin VPN network
2. Run Server/src/servidor_memoria.java on one computer
3. Run two instances of Cliente/src/gui/PlayGame.java, one on each computer
  3.1. Add your name in the "Nombre" field of each instance and click on "Conectar"
  Warning: if the same window to connect opens, please ignore it. This bug is currently being fixed
4. The actions of one players computer should reflect on the other. Enjoy the game!

## Rules
The same deck of 20 cards is displayed for Player A and Player B.
All actions on the board will be displayed for both players to see

Player A starts by clicking on two cards to turn them around. 
If both cards have the same image, Player A will get a point. 
If both cards are different, the turn will change to Player B. Now its Player B's turn to reveal two cards.

Each time a player reveals two cards that are identical, they will stay revealed and the player will be granted with a point.
The first player to reach 5 points wins.

### Credit
This project was made by Raul Vergara, David Tache and Gabriel Ayala.
