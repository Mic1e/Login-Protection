package com.micle.loginprotection.events;

import com.micle.loginprotection.LoginProtection;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnPlayerTickEventHandler {
    @SubscribeEvent
    public void PlayerTickEvent(TickEvent.PlayerTickEvent event) {
        if (LoginProtection.protected_players.getPlayer(event.player.getUUID()) == null) { return; }

        LoginProtection.protected_players.updateGracePeriod(event.player.getUUID());
    }
}
