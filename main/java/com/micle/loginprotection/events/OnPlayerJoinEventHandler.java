package com.micle.loginprotection.events;

import com.micle.loginprotection.LoginProtection;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnPlayerJoinEventHandler {
    @SubscribeEvent
    @OnlyIn(Dist.DEDICATED_SERVER)
    public void EntityJoinWorldEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) { return; }
        PlayerEntity player = (PlayerEntity) event.getEntity();

        LoginProtection.protected_players.addPlayer(player.getUUID());
        System.out.println(player.getUUID() + " (" + player.getDisplayName().getString() + ") is being protected!");
    }
}
