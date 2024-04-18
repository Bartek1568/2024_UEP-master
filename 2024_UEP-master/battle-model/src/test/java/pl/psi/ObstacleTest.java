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
        final Board board = new Board( c1, c2 );

        Obstacle.addObstacleManually(3, 3);
        board.move( creature, new Point( 3, 3 ) );

        assertTrue(Obstacle.isObstacle(new Point(3,3)));
        assertFalse( board.getCreature( new Point( 3, 3 ) )
                .isPresent() );
    }

    @Test
    void eachObstacleIsCorrectlyAdded() {
        Obstacle.addRandomObstacles(10, 14, 9);
        HashSet<Point> obstacles = Obstacle.getObstacles();

        for (Point obstacle : obstacles) {
            assertTrue(Obstacle.isObstacle(obstacle));
        }
    }

    @Test
    void startingPointIsNotObstacle(){
        Obstacle.addObstacleManually(0,1);
        Obstacle.addObstacleManually(14,1);
        assertFalse(Obstacle.isObstacle(new Point(0,1)));
        assertFalse(Obstacle.isObstacle(new Point(14,1)));


    }

}
