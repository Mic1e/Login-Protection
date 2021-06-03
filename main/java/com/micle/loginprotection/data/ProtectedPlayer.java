package com.micle.loginprotection.data;

import java.util.UUID;

public class ProtectedPlayer {
    private final UUID player_uuid;
    private int grace_period;
    private boolean is_loading;

    public ProtectedPlayer(UUID player_uuid) {
        this.player_uuid = player_uuid;
        this.grace_period = 400;
        this.is_loading = true;
    }

    public UUID getPlayerUUID() {
        return this.player_uuid;
    }

    public int getGracePeriod() {
        return this.grace_period;
    }

    public void setGracePeriod(int new_grace_period) {
        this.grace_period = new_grace_period;
    }

    public boolean isLoading() {
        return this.is_loading;
    }

    public void setLoading(boolean new_loading) {
        this.is_loading = new_loading;
    }
}
