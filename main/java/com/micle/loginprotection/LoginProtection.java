package com.micle.loginprotection;

import com.micle.loginprotection.data.ProtectedPlayers;
import com.micle.loginprotection.setup.Registration;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod(LoginProtection.MOD_ID)
public class LoginProtection {
    public static final String MOD_ID = "loginprotection";
    public static ProtectedPlayers protected_players = new ProtectedPlayers();
    public static boolean has_pressed_key = false;

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(LoginProtection.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public LoginProtection() {
        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
