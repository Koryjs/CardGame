import java.util.Scanner;
public class GameDriver {
    private Card current;
    private Card next;
    private int pointsFor;
    private int pointsAgainst;
    private Scanner sc;
    public GameDriver() {
        sc = new Scanner(System.in);
        pointsFor = 0;
        pointsAgainst = 0;
    }
    public void compareCards(String answer) {
        if (answer.equals("h")) {
            if (current.getNumber() >= next.getNumber()) {
                pointsAgainst+= 1;
            } else {
                pointsFor+= 1;
            }
        } else {
            if (current.getNumber() >= next.getNumber()) {
                pointsFor+= 1;
            } else {
                pointsAgainst+= 1;
            }
        }
    } 
    public void clear() {
        System.out.println("\033[H\033[2J");
    }
    public void run() {
        /*for (int a = 0; a < 52; a++) {
            deck.displayCard();
            deck.incrPosition();
        }*/
        System.out.println("Welcome to Over/Under! Would you like to play? Insert y for yes or n for no.");
        String response = sc.nextLine();
        boolean input = true;
        if ( !(response.equals("y")||response.equals("n")))
            input = false;
        while (!input) {
            System.out.println("Invalid Response. Please try again.");
            response = sc.nextLine();
            if (response.equals("y") || response.equals("n"))
                input = true;
        }
        clear();
        Deck deck = new Deck();
        while (deck.playing()) {
            System.out.println("\nUser Points:"+pointsFor+"\nHouse Points:"+pointsAgainst);
            deck.displayCard();
            current = deck.getCard();
            next = deck.getNextCard();
            System.out.println("Do you think the next card will be Higher(h) or Lower(l)?");
            String answer = sc.nextLine();
            boolean check = true;
            if ( !(answer.equals("h")||response.equals("l")))
                check = false;
            while (!check) {
                System.out.println("Invalid Response. Please try again.");
                answer = sc.nextLine();
                if (answer.equals("h") || answer.equals("l"))
                    check = true;
            }
            compareCards(answer);
            deck.incrPosition();
        }
    }
    public static void main(String args[]) {
        GameDriver gameDriver = new GameDriver();
        gameDriver.run();
    }
}
