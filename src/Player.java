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

    public int addPoints()
}
