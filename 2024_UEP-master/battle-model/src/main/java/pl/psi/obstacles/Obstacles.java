package pl.psi.obstacles;

import pl.psi.Point;

import java.util.HashMap;
import java.util.Random;

import static pl.psi.Board.MAX_WITDH;


public class Obstacles {
    private static final int MAX_HEIGHT = 9;
    private  final HashMap<Point,Obstacle> obstacles = new HashMap<>();
    public Obstacles(){
        addRandomObstacles(10,MAX_WITDH,MAX_HEIGHT);
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

    public  void addObstacleManually(int x, int y){
        if((x != 0 && y != 1) || (x != 14 && y != 1)){
            obstacles.put(new Point(x,y),null);
        }

    }
}
