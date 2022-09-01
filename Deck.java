import java.util.ArrayList;
import java.util.Random;
/**
 * @author Kory Singleton
 * A Deck to contain all of the cards
 */
public class Deck {
    private ArrayList<Card> deck;
    private int position;
    public Random rand;
    /**
     * The constructor to initialize the Deck.
     */
    public Deck() {
        deck = new ArrayList<Card>();
        position = 0;
        rand = new Random();
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
        shuffle();
    }
    /**
     * Returns the currently indexed card
     * @return the current Card object
     */
    public Card getCard() {
        return deck.get(position);
    }
    /**
     * Checks to see if the game is still running
     * @return a boolean to determine if the entire deck has been used.
     */
    public boolean playing() {
        if (position == 51) {
            return false;
        }
        return true;
    }
    /**
     * Randomly shuffles the Cards in the ArrayList containing them.
     */
    public void shuffle() {
        for (int a = 0; a < 52; a++) {
            int first = rand.nextInt(52);
            int second = rand.nextInt(52);
            if (first != second) {
                Card holder = deck.get(first);
                deck.set(first, deck.get(second));
                deck.set(second, holder);
            }
        }
    }
    /**
     * Prints out the currently indexed card.
     */
    public void displayCard() {
        System.out.println(deck.get(position));
    }
    /**
     * Retrieves the card immediately following the currently indexed one.
     * @return the Card following the current one
     */
    public Card getNextCard() {
        if (position != 51) {
            return deck.get(position+1);
        }
        return null;
    }
    /**
     * increases the position pointer.
     */
    public void incrPosition() {
        position += 1;
    }
}