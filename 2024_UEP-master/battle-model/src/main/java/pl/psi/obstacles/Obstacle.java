package pl.psi.obstacles;

import pl.psi.Point;

import java.util.HashSet;
import java.util.Random;


public class Obstacle {
    private  final HashSet<Point> obstacles = new HashSet<>();

    public Obstacle(){
        addRandomObstacles(10,14,9);
    }

    public  void addRandomObstacles(int amount, int maxWidth, int maxHeight) {
        Random random = new Random();
        while (obstacles.size() < amount) {
            int x = random.nextInt(maxWidth);
            int y = random.nextInt(maxHeight);

            while ((x == 0 && y == 1) || (x == 14 && y == 1)) {
                x = random.nextInt(maxWidth);
                y = random.nextInt(maxHeight);
            }
            obstacles.add(new Point(x, y));
        }
    }
    public  boolean isObstacle(Point point) {
        return obstacles.contains(point);
    }
    public  HashSet<Point> getObstacles() {
        return new HashSet<>(obstacles);
    }

    public  void addObstacleManually(int x, int y){
        if((x != 0 && y != 1) || (x != 14 && y != 1)){
            obstacles.add(new Point(x,y));
        }

    }
}
