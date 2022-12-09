import java.util.ArrayList;
// test
public class Deck
{
    private int cardsLeft;
    // deck is an arraylist of cards
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
    // checks if deck is empty by comparing cards left to zero
    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }
    //getters and setters
    public int getCardsLeft()
    {
        return cardsLeft;
    }
    // deal the top card in the deck
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
            // get a random card in the deck
            int r = (int) (Math.random() * cardsLeft);
            Card cardI = cards.get(i);
            Card cardR = cards.get(r);
            // swap i with the random card
            cards.set(i, cardR);
            cards.set(r, cardI);
        }
    }
    // deals one card to a player
    public void dealHand(Player player)
    {
        for(int i = 0; i < 7; i++)
        {
            Card newCard = deal();
            player.addCard(newCard);
        }
    }
}
