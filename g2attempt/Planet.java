package g2attempt;

import javax.swing.JPanel;

import java.awt.*;

public class Planet extends JPanel{
    int x;
    int y;
    int size;
    int ships;

    public Planet(int x, int y, int size, int ships){
        this.x = x;
        this.y = y;
        this.size = size;
        this.ships = ships;
        setOpaque(false);

    }
    public void setSizeAndShips(int size, int ships) {
    this.size = size;
    this.ships = ships;
    setBounds(getX(), getY(), size, size); // update display
    repaint();
    }

    private Color planetColor = Color.GRAY; // default color
    public void setPlanetColor(Color color) {
    this.planetColor = color;
    repaint(); // redraw the planet with the new color
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(planetColor);
        g.fillOval(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        String shipCount = String.valueOf(ships); // your int variable
        int textWidth = g.getFontMetrics().stringWidth(shipCount);
        int textHeight = g.getFontMetrics().getHeight();

        int x = (getWidth() - textWidth) / 2+1;
        int y = (getHeight() + textHeight / 2) / 2+2;
        g.drawString(shipCount, x, y);
    }



    
}
