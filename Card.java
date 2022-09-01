import java.util.ArrayList;
/**
 * A Card to simulate a real life playing card
 */
public class Card {
    private Suit suit;
    private int number;
    private ArrayList<String> look;
    /**
     * Constructor to intialize a Card object
     * @param suit an enum to declare the Cards+'s Suit
     * @param number an int containing the value of the card
     */
    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
        look = new ArrayList<String>();
        look.add("----------");
        if (number > 9 ) {
            look.add("|"+number+"      |");
        } else {
            look.add("|"+number+"       |");
        }
        look.add("|        |");
        if (suit.equals(Suit.CLUBS)) {
            look.add("|  CLUBS |");
        } else if (suit.equals(Suit.DIAMONDS)) {
            look.add("|DIAMONDS|");
        } else if (suit.equals(Suit.HEARTS)) {
            look.add("| HEARTS |");
        } else {
            look.add("| SPADES |");
        }
        look.add("|        |");
        if (number > 9 ) {
            look.add("|      "+number+"|");
        } else {
            look.add("|       "+number+"|");
        }
        
        look.add("----------");
    }
    /**
     * Returns the value of the card
     * @return an int containing the value/number on the card.
     */
    public int getNumber() {
        return number;
    }
    /**
     * Returns the suit of the card
     * @return the Suit enum assigned to the card. 
     */
    public Suit getSuit() {
        return suit;
    }
    /**
     * Returns a printable instance of the Card
     * @return a String containing the printable version of the Card.
     */
    public String toString() {
        String converted= "";
        for (int a = 0; a < look.size(); a++) {
            converted += look.get(a)+"\n";
        }
        return converted;
    }
}