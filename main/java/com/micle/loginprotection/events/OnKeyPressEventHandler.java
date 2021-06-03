package com.micle.loginprotection.events;

import com.micle.loginprotection.LoginProtection;
import com.micle.loginprotection.network.C2SKeyPress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnKeyPressEventHandler {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void KeyPressEvent(InputEvent.KeyInputEvent event) {
        ServerData server = Minecraft.getInstance().getCurrentServer();
        if (server == null) { return; }
        try {
            LoginProtection.INSTANCE.sendToServer(new C2SKeyPress());
        } catch (NullPointerException ignored) { }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void MouseClickEvent(InputEvent.ClickInputEvent event) {
        ServerData server = Minecraft.getInstance().getCurrentServer();
        if (server == null) { return; }
        try {
            LoginProtection.INSTANCE.sendToServer(new C2SKeyPress());
        } catch (NullPointerException ignored) { }
    }
}
