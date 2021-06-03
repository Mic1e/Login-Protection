package com.micle.loginprotection.events;

import com.micle.loginprotection.LoginProtection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnPlayerLeaveEventHandler {
    @SubscribeEvent
    @OnlyIn(Dist.DEDICATED_SERVER)
    public void PlayerLeaveEvent(PlayerEvent.PlayerLoggedOutEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) { return; }
        PlayerEntity player = event.getPlayer();

        LoginProtection.protected_players.removePlayer(player.getUUID());
    }
}
