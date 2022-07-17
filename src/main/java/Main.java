import javax.imageio.ImageIO;
import javax.swing.*;


public class Main extends JFrame {
    public static final int H=800;
    public static final int W=1000;
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        Panel panel=new Panel(0,0,W,H);
        this.add(panel);
        this.setSize(W,H);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
