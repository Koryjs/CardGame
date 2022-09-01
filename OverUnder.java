import java.util.Scanner;
public class OverUnder {
    private Card current;
    private Card next;
    private int pointsFor;
    private int pointsAgainst;
    private Scanner sc;
    /**
     * Constructor to initialize GameDriver
     */
    public OverUnder() {
        sc = new Scanner(System.in);
        pointsFor = 0;
        pointsAgainst = 0;
    }
    /**
     * Compares the current and next card to see if the user guessed correctly.
     * @param answer a String containing the User's guess of higher or lower
     */
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
    /**
     * Clears the screen
     */ 
    public void clear() {
        System.out.println("\033[H\033[2J");
    }
    public boolean decideToPlay() {
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
        return input;
    }
    /**
     * Runs the game and serves as the user interface.
     */
    public void run() {
        if (decideToPlay()) {
            Deck deck = new Deck();
            while (deck.playing()) {
                System.out.println("\nUser Points:"+pointsFor+"\nHouse Points:"+pointsAgainst);
                deck.displayCard();
                current = deck.getCard();
                next = deck.getNextCard();
                System.out.println("Do you think the next card will be Higher(h) or Lower(l)?");
                String answer = sc.nextLine();
                boolean check = true;
                if ( !(answer.equals("h")||answer.equals("l")))
                    check = false;
                while (!check) {
                    System.out.println("Invalid Response. Please try again.");
                    answer = sc.nextLine().toLowerCase().trim();
                    if (answer.equals("h") || answer.equals("l"))
                        check = true;
                }
                compareCards(answer);
                deck.incrPosition();
                clear();
            }
        }
        if (pointsFor >= pointsAgainst) {
            System.out.println("Congratulations, you won "+pointsFor+" to "+pointsAgainst);
        } else {
            System.out.println("Uh oh! You lost.");
        }
    }
}
