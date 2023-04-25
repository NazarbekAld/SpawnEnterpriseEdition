package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.strategy.ConfigWriteStrategy;
import me.nazarxexe.enterprise.interfaces.strategy.SpawnWriteStrategy;

public class SetSpawnWriteStrategy implements SpawnWriteStrategy {

    private final ConfigWriteStrategy strategy;

    public SetSpawnWriteStrategy(ConfigWriteStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doSet() {
        strategy.setLocation();
    }
}
