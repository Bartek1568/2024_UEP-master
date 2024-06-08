package pl.psi;


import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;
import pl.psi.obstacles.ObstaclesIF;
import pl.psi.obstacles.ObstaclesWithHP;

import static org.junit.jupiter.api.Assertions.*;


class ObstaclesTest {

//    @Test
//    void creatureCanAttackObstacle(){
//        final Creature creature = new Creature.Builder().statistic( CreatureStats.builder()
//                        .moveRange( 5 )
//                        .build() )
//                .build();
//        final List< Creature > c1 = List.of( creature );
//        final List< Creature > c2 = List.of();
//        final Board board = new Board( c1, c2);
//        final ObstaclesWithHP obstacleWithHP = new ObstaclesWithHP(ObstaclesIF.maxHP,board);
//
//
//
//
//
//        creature.attackObstacle(obstacleWithHP);
//        assertEquals(100 , obstacleWithHP.getHP());
//
//
//    }

    @Test
    void creatureCannotEnterObstacle() throws ObstacleException {
        final Creature creature = new Creature.Builder().statistic(CreatureStats.builder()
                        .moveRange(5)
                        .build())
                .build();
        final List<Creature> c1 = List.of(creature);
        final List<Creature> c2 = List.of();
        final Board board = new Board(c1, c2);


        for (int x = 0; x < ObstaclesIF.MAX_WITDH; x++) {
            for (int y = 0; y < ObstaclesIF.MAX_HEIGHT; y++) {
                Point point = new Point(x, y);
                if (x != 0 && x != 1) {
                    if (board.isObstacle(point) || board.isObstacleWithHP(point)) {
                        board.move(creature, point);
                        if (!board.getCreature(point).isPresent()){
                            throw new ObstacleException("Creature cannot move into : " + point + ", because it's an obstacle");
                        }
                        //assertFalse(board.getCreature(point).isPresent(), "Creature should not move into an obstacle at " + point);
                    }
                }
            }
        }
    }


      class ObstacleException extends Exception {
        public ObstacleException(String message) {
            super(message);
        }
    }

}