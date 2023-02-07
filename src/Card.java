import java.awt.*;
import javax.swing.*;
public class Card {
    // card with instance variables rank, suit, and points
    private String rank;
    private String suit;
    private int points;

    private Image[] cards;

    private GameViewer game;
    public Card(String rank, String suit, int points, GameViewer game)
    {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
        this.game = game;
        // for loop to initialize cards
        cards = new ImageIcon(//)
    }
    //getters and setters
    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        rank = rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String toString()
    {
        return rank + " of " + suit;
    }

    public void draw(Graphics g, Player p){
        int x = 50;
        int y = 50;
        for (int i = 0; i < p.getHand().size(); i++){
            // don't do i b/c it won't be random
            g.drawImage(cards[i], (x + (i * 50)), y, game);
        }
    }
}
