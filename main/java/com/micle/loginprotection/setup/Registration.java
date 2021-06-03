package com.micle.loginprotection.setup;

import com.micle.loginprotection.LoginProtection;
import com.micle.loginprotection.events.*;
import com.micle.loginprotection.network.C2SKeyPress;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registration {
    public static void register() {
        IEventBus mod_event_bus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(new OnPlayerJoinEventHandler());
        MinecraftForge.EVENT_BUS.register(new OnPlayerDamageEventHandler());
        MinecraftForge.EVENT_BUS.register(new OnPlayerTickEventHandler());
        MinecraftForge.EVENT_BUS.register(new OnKeyPressEventHandler());
        MinecraftForge.EVENT_BUS.register(new OnPlayerLeaveEventHandler());

        int id = 0;
        LoginProtection.INSTANCE.registerMessage(id++,
                C2SKeyPress.class,
                C2SKeyPress::encode,
                C2SKeyPress::decode,
                C2SKeyPress::handle
        );
    }
}
