// Jaya Vazirani
// December 9th, 2022
import java.util.Scanner;
public class Game
{
    private Player player1;
    private Player player2;
    private Deck deck;
    final private String[] RANKS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    final private String[] SUITS = {"Clubs", "Spades", "Hearts", "Diamonds"};
    final private int[] POINTS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public Game()
    {
        // ask players for their names and create player objects
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, What is your name?");
        String name1 = scanner.nextLine();
        System.out.println("Player 2, What is your name?");
        String name2 = scanner.nextLine();
        player1 = new Player(name1);
        player2 = new Player(name2);
        deck = new Deck(RANKS, SUITS, POINTS);
    }

    public void printInstructions()
    {
        String instructions = "Each player will start with 7 cards \n" +
                            "State how many rounds you want to play\n" +
                            "The goal of the game is to make as many pairs as possible\n" +
                            "Ask your opponent if they have one of the cards with the same rank as you\n" +
                            "If they do, you get a pair (aka a point). If they don't, go fish! This means you " +
                            "have to draw another card.\n" +
                            "Whoever has the most cards in the end wins. Good luck!";
        System.out.println(instructions);
    }

    public void playGame()
    {
        // shuffle deck
        deck.shuffle();
        printInstructions();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rounds would you like to play?");
        int numRounds = scanner.nextInt();
        deck.dealHand(player1);
        deck.dealHand(player2);
        System.out.println(player1);
        System.out.println(player2);
        //user gets to choose num of rounds to play for
        for (int i = 0; i < numRounds; i++)
        {
            playTurn(player1, player2);
            playTurn(player2, player1);
        }
        printWinner();
    }

    public void playTurn(Player player, Player other)
    {
        System.out.println("Player " + player.getName() + " What card are you asking for?");
        Scanner scanner = new Scanner(System.in);
        String answerRank = scanner.nextLine();
        //find out if that card is in player 2's hand
        Card c = other.has(answerRank);
        // check player to make sure they have the card they asked for
        Card d = player.has(answerRank);
        if((c != null) && (d != null))
        {
            // if yes, both cards get removed from each deck
            player.remove(answerRank);
            other.remove(answerRank);
            // add points to player who guessed
            player.addPoints(1);
            //print status of hand and points
            System.out.println(player1);
            System.out.println(player2);
            // if yes, player1 gets to go again
            playTurn(player, other);

        }
        else
        {
            // player has to deal another card and their turn is over
            System.out.println("Go fish");
            deck.dealCard(player);
            System.out.println(player1);
            System.out.println(player2);
        }

    }

    public void printWinner()
    {
        //compare number of points of players to determine the winner
        //player with most points wins
        if (player1.getPoints() > player2.getPoints())
        {
            System.out.println(player1.getName() + " Won!!!!");
        }
        else if (player2.getPoints() > player1.getPoints())
        {
            System.out.println(player2.getName() + " Won!!!!");
        }
        else
        {
            System.out.println("TIE!!!");
        }
    }

    public static void main(String[] args)
    {
        Game g = new Game();
        g.playGame();
    }
}
