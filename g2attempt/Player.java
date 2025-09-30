package g2attempt;

import java.awt.Color;

public class Player {
    private String name;
    private Planet homePlanet;
    private Color color;
    private int startShips;
    

    public Player(String name, Color color, int startShips) {
        this.name = name;
        this.color = color;
        this.startShips = startShips;

    }

    public int getTotalShips() {
    return startShips;
    }

    public String getName() { 
        return name; 
    }

    public Planet getHomePlanet() { 
        return homePlanet; 
    }

    public void setHomePlanet(Planet planet) {
    this.homePlanet = planet;
    this.homePlanet.setPlanetColor(this.color);       // set color
    this.homePlanet.setSizeAndShips(101, this.startShips); // set size & ships
}


    public Color getColor() { 
        return color; 
    }
}
