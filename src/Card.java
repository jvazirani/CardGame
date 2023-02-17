import java.awt.*;
import javax.swing.*;
public class Card {
    // card with instance variables rank, suit, and points
    private String rank;
    private String suit;
    private int points;
    public static int CARD_WIDTH = 80;
    public static int CARD_HEIGHT = 140;
    private Image cardImage;
    //instance variable for image of card
    public Card(String rank, String suit, int points, Image cardImage)
    {
        this.cardImage = cardImage;
        this.rank = rank;
        this.suit = suit;
        this.points = points;

    }
    // Getters and setters
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

    public void draw(Graphics g, GameViewer game, int x, int y){
        // Just draw one card
        g.drawImage(cardImage, x, y, CARD_WIDTH, CARD_HEIGHT, game);
    }
}
