package pl.psi.obstacles;


public class ObstaclesWithHP implements ObstaclesIF {

    private int maxHp;
    private int currentHp;




    public ObstaclesWithHP(int maxHp) {
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
