package pl.psi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.psi.creatures.Creature;
import pl.psi.creatures.CreatureStats;
import pl.psi.obstacles.ObstaclesWithHP;
import pl.psi.obstacles.Obstacles;

class BoardTest
{
    @Test
    void unitsMoveProperly()
    {
        final Creature creature = new Creature.Builder().statistic( CreatureStats.builder()
            .moveRange( 5 )
            .build() )
            .build();
        final List< Creature > c1 = List.of( creature );
        final List< Creature > c2 = List.of();
        final Obstacles obstacle = new Obstacles();
        final ObstaclesWithHP obstaclesWithHP = new ObstaclesWithHP(100);


        final Board board = new Board( c1, c2);

        board.move( creature, new Point( 3, 3 ) );

        assertThat( board.getCreature( new Point( 3, 3 ) )
            .isPresent() ).isTrue();
    }

}