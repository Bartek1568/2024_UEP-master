package pl.psi.creatures;

import pl.psi.obstacles.ObstaclesWithHP;

public interface DamageCalculatorIf
{
    int calculateDamage( Creature aAttacker, Creature aDefender );
    int calculateDamageToObstacle(Creature attacker, ObstaclesWithHP obstacleWithHP);
}
