import java.awt.*;
import javax.swing.*;
public class GameViewer extends JFrame{
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 800;
    public static int X_STARTING_POINT = 150;

    public static int Y_STARTING_POINT = 150;
    private Image[] cards;
    private Game game;

    private Image background;

    public GameViewer(Game game){
        background = new ImageIcon("resources/background.png").getImage();
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
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        // say [players] turn
        g.drawString(game.getCurrentPlayer().getName() + "'s turn", X_STARTING_POINT, Y_STARTING_POINT);
        // ask player what they want
        g.drawString(game.getCurrentPlayer().getName() + ", what card do you want?", X_STARTING_POINT, Y_STARTING_POINT + 50);
        // show score
        g.drawString("Score: ", X_STARTING_POINT + 350, 550);
        g.drawString(game.getPlayer1().getName() + ": " + game.getPlayer1().getPoints(), X_STARTING_POINT + 350, 600);
        g.drawString("" + game.getPlayer2().getName() + ": " + game.getPlayer2().getPoints(), X_STARTING_POINT + 350, 650);
        // then paint current players hand
        for(int i = 0; i < game.getCurrentPlayer().getHand().size(); i++){
            game.getCurrentPlayer().drawHand(g, this);
        }
        //TODO:
        // if there is a pair, print pair
        // if there is a go fish, print go fish
        //if there is a winner, print the win screen
        // make sure no more random constants and comment code
    }



}
