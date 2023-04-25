package me.nazarxexe.enterprise.impl;

import me.nazarxexe.enterprise.impl.strategy.Teleport;

public class Spawn implements me.nazarxexe.enterprise.interfaces.Spawn {

    private final Teleport strategy;

    public Spawn(Teleport strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doSpawn() {
        strategy.doTeleport();
    }
}
