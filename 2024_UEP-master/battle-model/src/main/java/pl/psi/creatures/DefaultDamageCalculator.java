package pl.psi.creatures;

import pl.psi.obstacles.ObstaclesWithHP;

import java.util.Random;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
class DefaultDamageCalculator extends AbstractCalculateDamageStrategy
{
    public DefaultDamageCalculator( final Random aRand )
    {
        super( aRand );
    }

    @Override
    public int calculateDamage(Creature attacker, ObstaclesWithHP obstacle) {
        return attacker.getAttack();
    }
}
