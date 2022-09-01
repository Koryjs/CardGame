import java.util.ArrayList;
public class Card {
    private Suit suit;
    private int number;
    private ArrayList<String> look;
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
    public int getNumber() {
        return number;
    }
    public Suit getSuit() {
        return suit;
    }
    public String toString() {
        String converted= "";
        for (int a = 0; a < look.size(); a++) {
            converted += look.get(a)+"\n";
        }
        return converted;
    }
}