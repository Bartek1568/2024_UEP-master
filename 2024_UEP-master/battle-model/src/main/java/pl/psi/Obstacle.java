package pl.psi;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Obstacle {
    private static final Set<Point> obstacles = new HashSet<>();
    public Obstacle(){
        addRandomObstacleFields(10,14,10);
    }
    public static void addObstacleManualy(int x, int y){
        obstacles.add(new Point(x,y));
    }

    public static void addRandomObstacleFields(int amount, int maxWidth, int maxHeight) {
        Random random = new Random();
        while (obstacles.size() < amount) {
            int x = random.nextInt(maxWidth);
            int y = random.nextInt(maxHeight);
            obstacles.add(new Point(x, y));
        }
    }
    public static boolean isObstacle(Point point) {
        return obstacles.contains(point);
    }
    public static Set<Point> getObstacles() {
        return new HashSet<>(obstacles);
    }
}
