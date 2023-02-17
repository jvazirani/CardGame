import java.awt.*;
import javax.swing.*;
public class GameViewer extends JFrame{
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 800;
    public static int X_STARTING_POINT = 150;
    public static int Y_STARTING_POINT = 150;
    public static int CENTER_X = 200;

    public static int CENTER_Y = 500;
    private Image[] cards;
    private Game game;

    private Image background;

    private Image winImage;

    private int status;

    public GameViewer(Game game){
        background = new ImageIcon("resources/background.png").getImage();
        winImage = new ImageIcon("resources/winner.jpg").getImage();
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Go Fish");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        status = 0;
    }

    public Image[] getImages(){
        return cards;
    }

    public void setStatus(int newStatus){
        status = newStatus;
    }

    @Override
    public void paint(Graphics g){
        // Draw background image and set fonts
        g.drawImage(background, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.BOLD, 30));
        // Say [players] turn
        g.drawString(game.getCurrentPlayer().getName() + "'s turn", X_STARTING_POINT, Y_STARTING_POINT);
        // Ask player what they want
        g.drawString(game.getCurrentPlayer().getName() + ", what card do you want?", X_STARTING_POINT, Y_STARTING_POINT + 50);
        // Show score
        g.drawString("Score: ", X_STARTING_POINT + 350, 550);
        g.drawString(game.getPlayer1().getName() + ": " + game.getPlayer1().getPoints(), X_STARTING_POINT + 350, 600);
        g.drawString("" + game.getPlayer2().getName() + ": " + game.getPlayer2().getPoints(), X_STARTING_POINT + 350, 650);
        // Then paint current players hand
        for(int i = 0; i < game.getCurrentPlayer().getHand().size(); i++){
            game.getCurrentPlayer().drawHand(g, this);
        }
        // Check for cases
        // If someone has one, made a pair, or gotten a go fish
        g.setFont(new Font("Sans", Font.BOLD, 80));
        g.setColor(Color.blue);
        if(status == 1){
            g.drawImage(winImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.drawString("" + game.getPlayer1().getName() + " won!!!!!", CENTER_X, CENTER_Y);
        }
        else if (status == 2){
            g.drawImage(winImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.drawString("" + game.getPlayer2().getName() + " won!!!!!", CENTER_X, CENTER_Y);
        }
        else if (status == 3){
            g.drawImage(winImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
            g.drawString("TIE!!!!!!!!!",CENTER_X, CENTER_Y);
        }
        else if(status == 4){
            g.drawString("PAIR",CENTER_X, CENTER_Y);
        }
        else if (status == 5){
            g.drawString("GO FISH",CENTER_X, CENTER_Y);
        }
    }
}
