package pl.psi.creatures;

import pl.psi.obstacles.ObstacleWithHP;
import pl.psi.obstacles.Obstacles;

public interface DamageCalculatorIf
{
    int calculateDamage( Creature aAttacker, Creature aDefender );
    int calculateDamage(Creature aAttacker, ObstacleWithHP obstacleWithHP);
}
