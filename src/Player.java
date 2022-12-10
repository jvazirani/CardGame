import java.util.ArrayList;
public class Player
{
    private String name;
    private int points;
    private ArrayList <Card> hand;

    public Player(String theName)
    {
        name = theName;
        points = 0;
        hand = new ArrayList<Card>();
    }

    public Player(String theName, ArrayList<Card> theHand)
    {
        name = theName;
        points = 0;
        hand = theHand;
    }
    //getters and setters
    public String getName()
    {
        return name;
    }

    public int getPoints()
    {
        return points;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void addPoints(int newPoints)
    {
        points += newPoints;
    }

    public void addCard(Card newCard)
    {
        hand.add(newCard);
    }
    //method to see if a player has a hard with a certain rank
    public Card has(String answerRank)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if (hand.get(i).getRank().equalsIgnoreCase(answerRank))
            {
                return hand.get(i);
            }
        }
        return null;
    }
    //removes a card from a players hand
    public Card remove(String answerRank)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            //if that card is found, remove it
            if (hand.get(i).getRank().equalsIgnoreCase(answerRank))
            {
                return hand.remove(i);
            }
        }
        return null;
    }

    public String toString()
    {
        return name + " has " + points + " points" + "\n" +  name +  "'s cards: " + hand;
    }
}
