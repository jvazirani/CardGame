import java.awt.*;
import java.util.ArrayList;
// test
import javax.swing.*;
public class Deck
{
    private int cardsLeft;
    // deck is an arraylist of cards
    private ArrayList<Card> cards;
    private Image cardsImage;
    public static int NUM_CARDS = 52;

    private Image[] cardsImages;

    public Deck(String[] rank, String[] suit, int[] points)
    {
        cardsImages = new Image[NUM_CARDS];
        for (int i = 0; i < NUM_CARDS; i++){
            cardsImages[i] = new ImageIcon("resources/Cards 3/" + (i + 1) + ".png").getImage();
        }
        // assign correct card to image
        cards = new ArrayList<Card>();
        for(int i = 0; i < suit.length; i++)
        {
            for (int j = 0; j < rank.length; j++)
            {
                Card card = new Card(rank[j], suit[i], points[j], cardsImages[0]);
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
        //reset cards left
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
    // deals a hand to a player (7 cards)
    public void dealHand(Player player)
    {
        for(int i = 0; i < 7; i++)
        {
            Card newCard = deal();
            player.addCard(newCard);
        }
    }
    //deals only one card to a player
    public void dealCard(Player player)
    {
        Card newCard = deal();
        player.addCard(newCard);
    }
}
