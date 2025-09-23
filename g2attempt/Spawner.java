package g2attempt;

import java.util.Random;

public class Spawner {
    
    int planetCount;
    int minSize;
    int maxSize;
    public Spawner(int planetCount, int minSize, int maxSize){
        this.planetCount = planetCount;
        this.minSize = minSize;
        this.maxSize = maxSize;


        Planet[] planets = {};

        for (int i = 0; i < planetCount; i++) {

            Random ranny = new Random();
            int rannyX = ranny.nextInt(Windowmaker.windowScaleX - 100);
            int rannyY = ranny.nextInt(Windowmaker.windowScaleY - 100);
            int rannyProd = ranny.nextInt(30,100);
            int mirrorX = Windowmaker.windowScaleX - rannyX - rannyProd;
            int mirrorY = Windowmaker.windowScaleY - rannyY - rannyProd;

            
            Planet rPlanet = new Planet(rannyX, rannyY, rannyProd);
            Planet rPlanet2 = new Planet(mirrorX, mirrorY, rannyProd);
            
            rPlanet.setBounds(0, 0, Windowmaker.windowScaleX, Windowmaker.windowScaleY);
            rPlanet2.setBounds(0, 0, Windowmaker.windowScaleX, Windowmaker.windowScaleY);
            
            
            Windowmaker.layeredPane.add(rPlanet, Integer.valueOf(1));
            Windowmaker.layeredPane.add(rPlanet2, Integer.valueOf(1));
            
            if(rPlanet.getBounds().intersects(rPlanet.getBounds())){
                System.out.println("planets overlapping");
                //i -=1;
            }else{



            }
            
        } 
    }
}
