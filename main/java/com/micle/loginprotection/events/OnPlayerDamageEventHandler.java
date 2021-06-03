package com.micle.loginprotection.events;

import com.micle.loginprotection.LoginProtection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnPlayerDamageEventHandler {
    @SubscribeEvent
    public void LivingDamageEvent(LivingDamageEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) { return; }
        PlayerEntity player = (PlayerEntity) event.getEntity();

        if (LoginProtection.protected_players.getPlayer(player.getUUID()) != null) {
            event.setCanceled(true);
        }
    }
}
