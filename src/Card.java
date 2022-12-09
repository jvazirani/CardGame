public class Card {
    // card with instance variables rank, suit, and points
    private String rank;
    private String suit;
    private int points;
    public Card(String rank, String suit, int points)
    {
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
}
