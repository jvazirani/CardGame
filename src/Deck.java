import java.awt.*;
import java.util.ArrayList;
// test
import javax.swing.*;
public class Deck
{
    private int cardsLeft;
    // deck is an arraylist of cards
    private ArrayList<Card> cards;
    public static int NUM_CARDS = 52;

    private Image[] cardsImages;

    public Deck(String[] rank, String[] suit, int[] points)
    {
        cardsImages = new Image[NUM_CARDS];
        // assign cards images to each card image
        for (int i = 0; i < NUM_CARDS; i++){
            cardsImages[i] = new ImageIcon("resources/Cards/" + (i + 1) + ".png").getImage();
        }
        // assign correct card to image
        cards = new ArrayList<Card>();
        int counter = 0;
        for(int i = 0; i < rank.length; i++)
        {
            for (int j = 0; j < suit.length; j++)
            {
                Card card = new Card(rank[i], suit[j], points[i], cardsImages[counter]);
                cards.add(card);
                counter++;
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
