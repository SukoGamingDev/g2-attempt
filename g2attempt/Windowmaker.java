package g2attempt;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Windowmaker {
    
    public static JLayeredPane layeredPane = new JLayeredPane();
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowScaleX = screenSize.width;
    public static int windowScaleY = screenSize.height;

    public Windowmaker(){

        JFrame window1 = new JFrame();
        window1.setBounds(0, 0, windowScaleX, windowScaleY);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        layeredPane.setPreferredSize(new Dimension(windowScaleX, windowScaleY));

        //background panel 1 lowest layer - 0 
        JPanel backGround = new JPanel();
        backGround.setBackground(Color.BLACK);
        backGround.setBounds(0,0,windowScaleX,windowScaleY);
        layeredPane.add(backGround, Integer.valueOf(0));
        
        
        
        window1.add(layeredPane);
        window1.setVisible(true);
    }
}
