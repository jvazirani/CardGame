import java.util.ArrayList;
// test
public class Deck
{
    private int cardsLeft;
    private ArrayList<Card> cards;

    public Deck(String[] rank, String[] suit, int[] points)
    {
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
            cardsLeft--;
            return cards.get(index);
        }
        return null;
    }

    public void shuffle()
    {
        cardsLeft = cards.size();
        for (int i = 0; i < cardsLeft; i++)
        {
            int r = (int) (Math.random() * cardsLeft);
            Card cardI = cards.get(i);
            Card cardR = cards.get(r);
            cards.set(i, cardR);
            cards.set(r, cardI);
            //need a temp variable?

        }
    }
    public void dealHand(Player player)
    {
        for(int i = 0; i < 7; i++)
        {
            Card newCard = deal();
            player.addCard(newCard);
        }
    }
}
