package pl.psi;


import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;
import pl.psi.obstacles.Obstacles;
import pl.psi.obstacles.ObstacleWithHP;
import pl.psi.obstacles.ObstaclesIF;

import static org.junit.jupiter.api.Assertions.*;


class ObstacleTest {

//    @Test
//    void creatureCanAttackObstacle(){
//        final Creature creature = new Creature.Builder().statistic( CreatureStats.builder()
//                        .moveRange( 5 )
//                        .build() )
//                .build();
//        final List< Creature > c1 = List.of( creature );
//        final List< Creature > c2 = List.of();
//        final ObstacleWithHP obstacleWithHP = new ObstacleWithHP(100);
//        final Obstacles obstacle = new Obstacles();
//        final Board board = new Board( c1, c2 , obstacle,obstacleWithHP);
//
//        creature.attackObstacle(obstacle,Point point);
//        assertEquals(obstacleWithHP.getHP() == 100 , obstacleWithHP.getHP());
//
//
//    }

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
        final ObstacleWithHP obstacleWithHP  = new ObstacleWithHP(ObstaclesIF.maxHP);
        final Board board = new Board( c1, c2,obstacle, obstacleWithHP );


        obstacle.addObstacleManually(3, 3);
        board.move( creature, new Point( 3, 3 ) );

        assertTrue(obstacle.isObstacle(new Point(3,3))
                || obstacleWithHP.isObstacleWithHP(new Point(3,3)));
        assertFalse(board.getCreature( new Point( 3, 3 ) )
            .isPresent() );
    }



    @Test
    void startingPointIsNotObstacle(){
        final Obstacles obstacle = new Obstacles();
        obstacle.addObstacleManually(0,1);
        obstacle.addObstacleManually(14,1);
        assertFalse(obstacle.isObstacle(new Point(0,1)));
        assertFalse(obstacle.isObstacle(new Point(14,1)));


    }

}
