import java.util.ArrayList;
import java.util.Random;
public class Deck {
    private ArrayList<Card> deck;
    private int position;
    public Random rand;
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
    public Card getCard() {
        return deck.get(position);
    }
    public boolean playing() {
        if (position == 51) {
            return false;
        }
        return true;
    }
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
    public void displayCard() {
        System.out.println(deck.get(position));
    }
    public Card getNextCard() {
        if (position != 51) {
            return deck.get(position+1);
        }
        return null;
    }
    public void incrPosition() {
        position += 1;
    }
}