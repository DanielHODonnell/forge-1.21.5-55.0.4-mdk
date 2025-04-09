package com.dojima.demo.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;


public class RodOfLightningItem extends Item {
    public RodOfLightningItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        if (!pLevel.isClientSide) {
            HitResult hitResult = pPlayer.pick(100, 0.0F, false);

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHit = (BlockHitResult) hitResult;
                BlockPos pos = blockHit.getBlockPos();

                LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, pLevel);
                lightningBolt.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                pLevel.addFreshEntity(lightningBolt);

                pLevel.playSound(null, pos, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 1.0F, 1.0F);
            } else {
                Vec3 eye = pPlayer.getEyePosition(1.0F);
                Vec3 look = pPlayer.getLookAngle();
                Vec3 target = eye.add(look.scale(30));

                LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, pLevel);
                lightningBolt.setPos(target.x, target.y, target.z);
                pLevel.addFreshEntity(lightningBolt);

                pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
