package pl.psi;


import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObstacleTest {

    @Test
    void eachRandomObstacleIsCorrectlyAdded() {
        Obstacle.addRandomObstacleFields(10, 15, 10);
        Set<Point> obstacles = Obstacle.getObstacles();

        for (Point obstacle : obstacles) {
            assertTrue(Obstacle.isObstacle(obstacle));
        }
    }

    @Test
     void fieldIsObstacle(){
         Obstacle.addObstacleManualy(5, 5);
        assertTrue(Obstacle.isObstacle(new Point(5,5)));

    }

}
