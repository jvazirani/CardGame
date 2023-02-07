import java.awt.*;
import javax.swing.*;
public class GameViewer extends JFrame{
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Image[] cards;
    private Game g;

    public GameViewer(Game g){
        this.g = g;
//        cards = new ImageIcon(//).getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Go Fish");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages(){
        return cards;
    }

    public void paint(Graphics g, Player p){
        g.drawImage(backgroundImage, 0, 0, this);
        for(int i = 0; i < p.getHand().size(); i++){
            g.draw(g, p);
    }



}
