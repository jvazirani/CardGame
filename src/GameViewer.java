import java.awt.*;
import javax.swing.*;
public class GameViewer extends JFrame{
    public static int WINDOW_WIDTH = 800;
    public static int WINDOW_HEIGHT = 800;
    public static int X_STARTING_POINT = 150;

    public static int Y_STARTING_POINT = 150;

    public static int CENTER_X = 300;

    public static int CENTER_Y = 300;
    private Image[] cards;
    private Game game;

    private Image background;

    private int status;

    public GameViewer(Game game){
        background = new ImageIcon("resources/background.png").getImage();
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

        if(status == 1){
            g.drawString("Player 1 won!! ", CENTER_X, CENTER_Y);
        }
        else if (status == 2){
            g.drawString("Player 2 won!!", CENTER_X, CENTER_Y);
        }
        else if (status == 3){
            g.drawString("TIE",CENTER_X, CENTER_Y);
        }
        else if(status == 4){
            g.drawString("PAIR",CENTER_X, CENTER_Y);
        }
        else if (status == 5){
            g.drawString("GO FISH",CENTER_X, CENTER_Y);
        }
        //TODO:
        // do background winning screen
        // make sure no more random constants and comment code
        // adjust coordinates when necessary
        // readme file
    }



}
