# CasinoRoyale
APCS1 final project

To launch:
javac Woo.java
java Woo
Follow prompts

Welcome to the Casino Royale! We have a wide selection of 3 whole games to play, an entire ONE of them being a card game!
It's simple, give us your name, give us your balance, and start playing.

Watch your balance, you don't want your money to run out, or you'll be kicked out. Sorry :c

No cheating! You can't bet more than you have. You can't play no-stakes either; your bet MUST be greater than 0.

Blackjack: An array to used to simulate the deck of cards for this game. The array is filled with 52 strings, each one composed of a letter and number. The letter represents the suit (S for Spades etc.) and the number represents the value of the card from low to high (1 for aces, then the numerical cards, then 11-13 for the face cards). When a card is drawn, the first element in the array is removed. Since suits don't matter in blackjack, we splice off the letter, then read the integer in the rest of the string.
The game starts with the player being dealt two cards, then being asked whether to "hit" (receive another card) or "stand". This repeats until the player busts or stands. If the player stands, the "dealer" hits until their value of their hand is greater than the player's. After the dealer's turn, a boolean is returned to Woo.java (true if the player won, false if not) and the player's balance is changed accordingly. 