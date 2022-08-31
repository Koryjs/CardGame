import java.util.ArrayList;
public class GameDriver {
    private ArrayList<Card> deck;
    private int position;
    public GameDriver() {
        deck = new ArrayList<Card>();
        position = 0;
    }
    public void makeDeck() {
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 13; b++) {
                if (a == 0) {
                    deck.add(new Card(Suit.CLUBS, b+1));
                } else if (a == 1) {
                    deck.add(new Card(Suit.DIAMONDS, b+1));
                } else if (a == 2) {
                    deck.add(new Card(Suit.HEARTS, b+1));
                } else {
                    deck.add(new Card(Suit.SPADES, b+1));
                }
            }
        }
    }
    public void displayCard() {
        for (int a = 0; a < deck.size(); a++) {
            System.out.println(deck.get(a));
        }
    }
    public void run() {
        makeDeck();
        displayCard();
    }
    public static void main(String args[]) {
        GameDriver gameDriver = new GameDriver();
        gameDriver.run();
    }
}
