package me.nazarxexe.enterprise.impl;

import me.nazarxexe.enterprise.interfaces.Spawn;
import me.nazarxexe.enterprise.interfaces.strategy.SpawnWriteStrategy;

public class SetSpawn implements Spawn {

    private final SpawnWriteStrategy strategy;

    public SetSpawn(SpawnWriteStrategy strategy) {
        this.strategy = strategy;
    }


    @Override
    public void doSpawn() {
        strategy.doSet();
    }
}
