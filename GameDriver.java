public class GameDriver {
    public GameDriver() {
    }
    public static void main(String args[]) {
        Deck deck = new Deck();
        for (int a = 0; a < 52; a++) {
            deck.displayCard();
            deck.incrPosition();
        }
    }
}
