import java.util.ArrayList;
public class Deck {
    private int cardsLeft;
    private ArrayList<Card> cards;

    public Deck(String[] rank, String[] suit, int[] points) {
        cards = new ArrayList<Card>();
        for(int i = 0; i < suit.length; i++)
        {
            for (int j = 0; j < rank.length; j++)
            {
                Card card = new Card(rank[j], suit[i], points[j]);
                cards.add(card);
            }
        }
        cardsLeft = cards.size();
    }

    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }

    public int getCardsLeft()
    {
        return cardsLeft;
    }

    public Card deal()
    {
        if(!isEmpty())
        {
            int index = cards.size() - cardsLeft;
            return cards.get(index);
        }
        return null;
    }

    public void shuffle()
    {
        cardsLeft = cards.size();

    }

}
