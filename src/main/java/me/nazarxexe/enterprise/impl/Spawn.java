package me.nazarxexe.enterprise.impl;

import me.nazarxexe.enterprise.impl.strategy.TeleportToSpawn;
import me.nazarxexe.enterprise.interfaces.ISpawn;

public class Spawn implements ISpawn {

    private final TeleportToSpawn strategy;

    public Spawn(TeleportToSpawn strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doSpawn() {
        strategy.doTeleport();
    }
}
