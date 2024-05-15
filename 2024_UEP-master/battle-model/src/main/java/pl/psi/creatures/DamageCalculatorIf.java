package pl.psi.creatures;

import pl.psi.obstacles.ObstaclesWithHP;

public interface DamageCalculatorIf
{
    int calculateDamage( Creature aAttacker, Creature aDefender );
}
