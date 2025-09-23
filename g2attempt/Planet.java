package g2attempt;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class Planet extends JPanel{
    int x;
    int y;
    int size;

    public Planet(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
        setOpaque(false);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(x, y, size, size);


    }



    
}
