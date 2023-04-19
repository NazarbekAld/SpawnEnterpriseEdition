package me.nazarxexe.enterprise.impl.strategy;

import me.nazarxexe.enterprise.interfaces.strategy.IConfigSetStrategy;
import me.nazarxexe.enterprise.interfaces.strategy.ISetSpawnStrategy;

public class SetSpawnStrategy implements ISetSpawnStrategy {

    private final IConfigSetStrategy strategy;

    public SetSpawnStrategy(IConfigSetStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doSet() {
        strategy.setLocation();
    }
}
