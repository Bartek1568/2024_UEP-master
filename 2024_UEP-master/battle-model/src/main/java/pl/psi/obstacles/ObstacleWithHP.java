package pl.psi.obstacles;


import pl.psi.Point;
import java.util.HashMap;
import java.util.Random;


public class ObstacleWithHP implements ObstaclesIF {

    private int maxHp;
    private int currentHp;




    public ObstacleWithHP(int maxHp) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;

    }




    public void takeDamage(int damage) {

    }

//    public double getHP(Point point) {
//        if (obstaclesWithHP.containsKey(point)) {
//            return obstaclesWithHP.get(point).currentHp;
//        } else {
//            return 0;
//        }
//    }

}
