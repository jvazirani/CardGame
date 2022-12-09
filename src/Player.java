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
    }

    public Player(String theName, ArrayList<Card> theHand)
    {
        name = theName;
        points = 0;
        hand = theHand;
    }

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

    public Card has(String answerRank)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if (hand.get(i).getRank().equals(answerRank))
            {
                return hand.remove(i);
            }
        }
        return null;
    }

    public String toString()
    {
        return name + " has " + points + "points" + "\n" +  name +  "cards: " + hand;
    }
}
