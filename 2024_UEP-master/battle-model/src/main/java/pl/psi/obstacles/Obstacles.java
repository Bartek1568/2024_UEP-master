package pl.psi.obstacles;

import pl.psi.Point;

import java.util.HashMap;
import java.util.Random;



public class Obstacles implements ObstaclesIF {

    private  final HashMap<Point,Obstacle> obstacles = new HashMap<>();
    ObstacleWithHP obstacleWithHP = new ObstacleWithHP(maxHP);

    public Obstacles(){
        addRandomObstacles(8,MAX_WITDH,MAX_HEIGHT);
        obstacleWithHP.addRandomObstaclesWithHP(2,MAX_WITDH,MAX_HEIGHT);

    }

     public void addRandomObstacles(int amount, int maxWidth, int maxHeight) {
        Random random = new Random();
        maxHeight = MAX_HEIGHT;
        maxWidth = MAX_WITDH;
        while (obstacles.size() < amount) {
            int x = random.nextInt(maxWidth);
            int y = random.nextInt(maxHeight);

            while (x == 0 && y == 1) {
                x = random.nextInt(maxWidth);
                y = random.nextInt(maxHeight);
            }
            obstacles.put(new Point(x, y),new Obstacle());
        }
    }

    public  boolean isObstacle(Point point) {
        return obstacles.containsKey(point);
    }
    public boolean isObstacleWithHP(final Point aPoint){
        return obstacleWithHP.isObstacleWithHP(aPoint);
    }



    public  void addObstacleManually(int x, int y){
        if((x != 0 && y != 1) || (x != 14 && y != 1)){
            obstacles.put(new Point(x,y),new Obstacle());
        }

    }
}
