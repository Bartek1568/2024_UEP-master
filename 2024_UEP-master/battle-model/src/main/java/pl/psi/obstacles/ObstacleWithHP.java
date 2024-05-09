package pl.psi.obstacles;


import pl.psi.Point;
import java.util.HashMap;
import java.util.Random;


public class ObstacleWithHP implements ObstaclesIF {
    private  final HashMap<Point,ObstacleWithHP> obstaclesWithHP = new HashMap<>();
    private int maxHp;
    private int currentHp;




    public ObstacleWithHP(int maxHp) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;

    }

    public void addRandomObstaclesWithHP(int amount, int maxWidth, int maxHeight) {
        Random random = new Random();
        maxHeight = MAX_HEIGHT;
        maxWidth = MAX_WITDH;
        while (obstaclesWithHP.size() < amount) {
            int x = random.nextInt(maxWidth);
            int y = random.nextInt(maxHeight);

            while (x == 0 && y == 1) {
                x = random.nextInt(maxWidth);
                y = random.nextInt(maxHeight);
            }
            obstaclesWithHP.put(new Point(x, y),new ObstacleWithHP(1));
        }
    }
    public  boolean isObstacleWithHP(Point point) {
        return obstaclesWithHP.containsKey(point);
    }

    public void takeDamage(Point point, int damage) {
        if (obstaclesWithHP.containsKey(point)) {
            ObstacleWithHP obstacleWithHP = obstaclesWithHP.get(point);
            obstacleWithHP.currentHp -= damage;
            if (obstacleWithHP.currentHp <= 0) {
                obstaclesWithHP.remove(point);
            }
        }
    }

//    public double getHP(Point point) {
//        if (obstaclesWithHP.containsKey(point)) {
//            return obstaclesWithHP.get(point).currentHp;
//        } else {
//            return 0;
//        }
//    }

}
