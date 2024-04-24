package pl.psi;


import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;
import pl.psi.obstacles.Obstacle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ObstacleTest {

    @Test
    void creatureCannotEnterObstacle()
    {
        final Creature creature = new Creature.Builder().statistic( CreatureStats.builder()
                        .moveRange( 5 )
                        .build() )
                .build();
        final List< Creature > c1 = List.of( creature );
        final List< Creature > c2 = List.of();
        final Obstacle obstacle = new Obstacle();
        final Board board = new Board( c1, c2,obstacle );


        obstacle.addObstacleManually(3, 3);
        board.move( creature, new Point( 3, 3 ) );

        assertTrue(obstacle.isObstacle(new Point(3,3)));
        assertFalse(board.getCreature( new Point( 3, 3 ) )
            .isPresent() );
    }

    @Test
    void eachObstacleIsCorrectlyAdded() {
        final Obstacle obstacle = new Obstacle();
        obstacle.addRandomObstacles(10, 14, 9);
        HashSet<Point> obstacles = obstacle.getObstacles();

        for (Point obstacle1 : obstacles) {
            assertTrue(obstacle.isObstacle(obstacle1));
        }
    }

    @Test
    void startingPointIsNotObstacle(){
        final Obstacle obstacle = new Obstacle();
        obstacle.addObstacleManually(0,1);
        obstacle.addObstacleManually(14,1);
        assertFalse(obstacle.isObstacle(new Point(0,1)));
        assertFalse(obstacle.isObstacle(new Point(14,1)));


    }

}
