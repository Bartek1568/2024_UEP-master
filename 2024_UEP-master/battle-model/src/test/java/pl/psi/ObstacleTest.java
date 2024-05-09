package pl.psi;


import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;
import pl.psi.obstacles.Obstacles;
import pl.psi.obstacles.ObstacleWithHP;

import static org.junit.jupiter.api.Assertions.*;


class ObstacleTest {

    @Test
    void creatureCanAttackObstacle(){
        final Creature creature = new Creature.Builder().statistic( CreatureStats.builder()
                        .moveRange( 5 )
                        .build() )
                .build();
        final List< Creature > c1 = List.of( creature );
        final List< Creature > c2 = List.of();
        final ObstacleWithHP obstacle = new ObstacleWithHP();
        final Board board = new Board( c1, c2 , obstacle);

        //creature.attack(obstacle);
        assertEquals(obstacle.getHP() == 100 , obstacle.getHP());


    }

    @Test
    void creatureCannotEnterObstacle()
    {
        final Creature creature = new Creature.Builder().statistic( CreatureStats.builder()
                        .moveRange( 5 )
                        .build() )
                .build();
        final List< Creature > c1 = List.of( creature );
        final List< Creature > c2 = List.of();
        final Obstacles obstacle = new Obstacles();
        final Board board = new Board( c1, c2,obstacle );


        obstacle.addObstacleManually(3, 3);
        board.move( creature, new Point( 3, 3 ) );

        assertTrue(obstacle.isObstacle(new Point(3,3)));
        assertFalse(board.getCreature( new Point( 3, 3 ) )
            .isPresent() );
    }

 //   @Test
//    void eachObstacleIsCorrectlyAdded() {
//        final Obstacles obstacle = new Obstacles();
//        obstacle.addRandomObstacles(10, 14, 9);
//        HashSet<Point> obstacles = obstacle.getObstacles();
//
//        for (Point obstacle1 : obstacles) {
//            assertTrue(obstacle.isObstacle(obstacle1));
//        }
//    }

    @Test
    void startingPointIsNotObstacle(){
        final Obstacles obstacle = new Obstacles();
        obstacle.addObstacleManually(0,1);
        obstacle.addObstacleManually(14,1);
        assertFalse(obstacle.isObstacle(new Point(0,1)));
        assertFalse(obstacle.isObstacle(new Point(14,1)));


    }

}
