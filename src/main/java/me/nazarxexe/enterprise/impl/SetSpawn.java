package me.nazarxexe.enterprise.impl;

import me.nazarxexe.enterprise.interfaces.ISpawn;
import me.nazarxexe.enterprise.interfaces.strategy.ISetSpawnStrategy;

public class SetSpawn implements ISpawn {

    private final ISetSpawnStrategy strategy;

    public SetSpawn(ISetSpawnStrategy strategy) {
        this.strategy = strategy;
    }


    @Override
    public void doSpawn() {
        strategy.doSet();
    }
}
