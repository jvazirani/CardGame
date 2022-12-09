import java.util.Scanner;
public class Game
{
    private Player player1;
    private Player player2;
    private Deck deck;
    private Player winner;
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
        winner = player1;
    }

    public void printInstructions()
    {
        System.out.println("instructions");
    }

    public void playGame()
    {
        // shuffle deck
        deck.shuffle();
        printInstructions();
        deck.dealHand(player1);
        deck.dealHand(player2);
        System.out.println(player1);
        System.out.println(player2);
        while(gameNotOver())
        {
            playTurn(player1, player2);
            playTurn(player2, player1);
        }
        printWinner(winner);
    }

    public boolean gameNotOver()
    {
        //if one player's hand is empty, game is over
        if (player1.getHand().isEmpty())
        {
            return false;
        }
        else if (player2.getHand().isEmpty())
        {
            return false;
        }
        //otherwise game is not over
        return true;
    }

    public Player getWinner()
    {
        if(player1.getPoints() > player2.getPoints())
        {
            winner = player1;
        }
        else if (player2.getPoints() > player1.getPoints())
        {
            winner = player2;
        }
        return winner;
    }

    public void playTurn(Player player, Player other)
    {
        System.out.println("Player " + player.getName() + " What card are you asking for?");
        Scanner scanner = new Scanner(System.in);
        String answerRank = scanner.nextLine();
        //find out if that card is in player 2's hand
        Card c = other.has(answerRank);
        if(c != null)
        {
            // if yes, transfer cards (other gives
            player.has(answerRank);
            // add points to player
            player.addPoints(1);
            // if yes, player1 gets to go again
            playTurn(player, other);
        }
        else
        {
            System.out.println("Go fish");
        }

    }

    public void printWinner(Player winner)
    {
        String name = winner.getName();
        System.out.println("Winner is " + name);
    }

    public static void main(String[] args)
    {
        Game g = new Game();
        g.playGame();
    }
}
