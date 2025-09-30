package g2attempt;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {
    
    int planetCount;
    int minSize;
    int maxSize;
    int minCost;
    int maxCost;
    // experimental distance 
    int minDistance;
    int maxDistance;



        private List<Planet> allPlanets = new ArrayList<>();
        private Player player1;
        private Player player2;

    public Spawner(int planetCount, int minSize, int maxSize, int minCost, int maxCost, int minDistance, int maxDistance){
        this.planetCount = planetCount;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.minCost = minCost;
        this.maxCost = maxCost;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;


        

        for (int i = 0; i < planetCount; i++) {

            Random ranny = new Random();
            int rannyX = ranny.nextInt(Windowmaker.windowScaleX - 100);
            int rannyY = ranny.nextInt(Windowmaker.windowScaleY - 100);
            int rannyProd = ranny.nextInt(minSize,maxSize);
            int mirrorX = Windowmaker.windowScaleX - rannyX - rannyProd;
            int mirrorY = Windowmaker.windowScaleY - rannyY - rannyProd;
            int rannyCost = ranny.nextInt(minCost, maxCost);


            Planet rPlanet = new Planet(rannyX, rannyY, rannyProd, rannyCost);
            Planet rPlanet2 = new Planet(mirrorX, mirrorY, rannyProd, rannyCost);
            
            
            int planetSize = rannyProd; // size = production
            rPlanet.setBounds(rannyX, rannyY, planetSize, planetSize);
            rPlanet2.setBounds(mirrorX, mirrorY,planetSize, planetSize);

            
 
            // checking if they overlap and only spawning the planet if it doesnt 
            boolean tooClose = false;
            boolean overlapping = false;

            // only check distance if there are existing planets
            if (!allPlanets.isEmpty()) {
                double closestDistance = Double.MAX_VALUE;

                for (Planet existing : allPlanets) {
                    int rCenterX = rPlanet.getX() + rPlanet.getWidth() / 2;
                    int rCenterY = rPlanet.getY() + rPlanet.getHeight() / 2;
                    int eCenterX = existing.getX() + existing.getWidth() / 2;
                    int eCenterY = existing.getY() + existing.getHeight() / 2;

                    double distance = Math.hypot(rCenterX - eCenterX, rCenterY - eCenterY);
                    if (distance < closestDistance) closestDistance = distance;
                }

                if (closestDistance < minDistance || closestDistance > maxDistance) {
                    tooClose = true;
                }
            }
            // add both planets if allowed
            if (!tooClose) {
                Windowmaker.layeredPane.add(rPlanet, Integer.valueOf(1));
                Windowmaker.layeredPane.add(rPlanet2, Integer.valueOf(1));

                allPlanets.add(rPlanet);
                allPlanets.add(rPlanet2);
            } else {
                i--; // retry if fail
            }
            
        } 
        Windowmaker.layeredPane.repaint();
        assignPlayerSpawns();
    }
    private void assignPlayerSpawns() {
    if (allPlanets.size() < 2) return; // safety check
        // assign to the instance variables, not local variables
        player1 = new Player("Player 1", Color.RED, 100);
        player2 = new Player("Player 2", Color.BLUE, 100);

        // Example: leftmost = player1, rightmost = player2
        Planet leftMost = allPlanets.stream().min((a, b) -> Integer.compare(a.getX(), b.getX())).get();
        Planet rightMost = allPlanets.stream().max((a, b) -> Integer.compare(a.getX(), b.getX())).get();

        player1.setHomePlanet(leftMost);
        player2.setHomePlanet(rightMost);

        System.out.println(player1.getName() + " spawns at " + player1.getHomePlanet().getX() + "," + player1.getHomePlanet().getY());
        System.out.println(player2.getName() + " spawns at " + player2.getHomePlanet().getX() + "," + player2.getHomePlanet().getY());
    }
    // Getter for all planets if needed
    public List<Planet> getAllPlanets() {
        return allPlanets;
    }

    // Getter for players if needed
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
