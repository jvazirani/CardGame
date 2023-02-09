import java.awt.*;
import javax.swing.*;
public class Card {
    // card with instance variables rank, suit, and points
    private String rank;
    private String suit;
    private int points;

    public static int NUM_CARDS = 52;

    private Image cardImage;
    //instance variable for image of card
    public Card(String rank, String suit, int points, Image cardImage)
    {
        this.cardImage = cardImage;
        this.rank = rank;
        this.suit = suit;
        this.points = points;

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

    public void draw(Graphics g, GameViewer game){
        int x = 50;
        int y = 50;
            // don't do i b/c it won't be random
            g.drawImage(cardImage, (x + (50)), y, game);
        }



    // if is face up
    // draw players hand
    // how to draw actual card if know what the players hand is?
    // else draw face down card
}
