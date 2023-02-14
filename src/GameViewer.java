import java.awt.*;
import javax.swing.*;
public class GameViewer extends JFrame{
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 800;
    private Image[] cards;
    private Game game;

    public GameViewer(Game game){
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Go Fish");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages(){
        return cards;
    }

    @Override
    public void paint(Graphics g){
//        g.drawImage(backgroundImage, 0, 0, this);
        g.setColor(Color.pink);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // say [players] cards
        // say [player], what are u asking for?
        // then paint current players hand
        for(int i = 0; i < game.getCurrentPlayer().getHand().size(); i++){
            game.getCurrentPlayer().drawHand(g, this);
        }
    }



}
