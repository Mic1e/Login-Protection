package com.micle.loginprotection.data;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProtectedPlayers {
    private final List<ProtectedPlayer> protected_players = new ArrayList<>();

    public ProtectedPlayers() { }

    public int size() {
        return protected_players.size();
    }

    public void addPlayer(UUID player_uuid) {
        protected_players.add(new ProtectedPlayer(player_uuid));
    }

    public ProtectedPlayer getPlayer(UUID player_uuid) {
        ProtectedPlayer player;
        for (ProtectedPlayer protected_player : protected_players) {
            player = protected_player;
            if (player.getPlayerUUID() == player_uuid) {
                return player;
            }
        }
        return null;
    }

    public void removePlayer(UUID player_uuid) {
        ProtectedPlayer protected_player = getPlayer(player_uuid);
        if (protected_player == null) { return; }
        protected_players.remove(protected_player);

        ServerPlayerEntity player = ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayer(player_uuid);
        if (player == null) { return; }
        player.sendMessage(new StringTextComponent("Grace Period over!"), player_uuid);
    }

    public void updateGracePeriod(UUID player_uuid) {
        ProtectedPlayer protected_player = getPlayer(player_uuid);
        if (protected_player.isLoading()) { return; }

        int grace_period = protected_player.getGracePeriod()-1;
        protected_player.setGracePeriod(grace_period);
        if (grace_period <= 0) {
            removePlayer(player_uuid);
            System.out.println(protected_player.getPlayerUUID() + " is no longer being protected!");
        }
    }
}
