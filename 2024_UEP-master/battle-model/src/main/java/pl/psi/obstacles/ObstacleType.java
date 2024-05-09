package pl.psi.obstacles;

import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class ObstacleType {

    private final String name;
    private final boolean canBeDestroyed;
    private final boolean canDealDamageToGroundUnits;
    private final boolean canDealDamageToAirUnits;
    private final boolean canApplyBuffs;
    private final boolean canApplyDebuffs;
    private final int maxHp;




}
