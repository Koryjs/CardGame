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
        look.add("|        |");
        look.add("|        |");
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