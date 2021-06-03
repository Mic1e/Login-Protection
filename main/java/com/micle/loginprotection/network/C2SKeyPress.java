package com.micle.loginprotection.network;

import com.micle.loginprotection.LoginProtection;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class C2SKeyPress {
    public C2SKeyPress() { }

    public static void encode(final C2SKeyPress msg, final PacketBuffer packet_buffer) { }

    public static C2SKeyPress decode(final PacketBuffer packet_buffer) {
        return new C2SKeyPress();
    }

    public static void handle(final C2SKeyPress msg, final Supplier<NetworkEvent.Context> context_supplier) {
        final NetworkEvent.Context context = context_supplier.get();
        context.enqueueWork(() -> {
            final ServerPlayerEntity sender = context.getSender();
            if (sender == null) { return; }
            if (LoginProtection.protected_players.getPlayer(sender.getUUID()) == null) { return; }
            if (!LoginProtection.protected_players.getPlayer(sender.getUUID()).isLoading()) { return; }

            LoginProtection.protected_players.getPlayer(sender.getUUID()).setLoading(false);
            sender.sendMessage(new StringTextComponent("Grace Period started!"), sender.getUUID());
            if (sender.isInWater()) {
                sender.setAirSupply(sender.getMaxAirSupply());
            }
        });
        context.setPacketHandled(true);
    }
}
