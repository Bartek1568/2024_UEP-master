package pl.psi;

import java.util.*;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import pl.psi.creatures.Creature;
import pl.psi.obstacles.Obstacles;



/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class Board
{
    public static final int MAX_WITDH = 14;
    private final BiMap< Point, Creature > map = HashBiMap.create();
    private final Obstacles obstacle;



    public Board( final List< Creature > aCreatures1, final List< Creature > aCreatures2, Obstacles obstacle )
    {
        addCreatures( aCreatures1, 0 );
        addCreatures( aCreatures2, MAX_WITDH );
        this.obstacle = obstacle;
    }
    private void addCreatures( final List< Creature > aCreatures, final int aXPosition )
    {
        for( int i = 0; i < aCreatures.size(); i++ )
        {
            map.put( new Point( aXPosition, i * 2 + 1 ), aCreatures.get( i ) );
        }
    }

    Optional< Creature > getCreature( final Point aPoint )
    {
        return Optional.ofNullable( map.get( aPoint ) );
    }

    void move( final Creature aCreature, final Point aPoint )
    {
        if( canMove( aCreature, aPoint ) )
        {
            map.inverse()
                .remove( aCreature );
            map.put( aPoint, aCreature );
        }
    }

    boolean canMove( final Creature aCreature, final Point aPoint )
    {
        if( map.containsKey( aPoint ) || obstacle.isObstacle(aPoint) )
        {
            return false;
        }
        final Point oldPosition = getPosition( aCreature );
        return aPoint.distance( oldPosition.getX(), oldPosition.getY() ) < aCreature.getMoveRange();
    }

    Point getPosition( Creature aCreature )
    {
        return map.inverse()
            .get( aCreature );
    }
}
