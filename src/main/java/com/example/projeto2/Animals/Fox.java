package com.example.projeto2.Animals;

import java.util.HashMap;
import java.util.Map;

public abstract class Fox extends Carnivorous{
    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        probabilityMap.put(Rabbit.class, 70);
        probabilityMap.put(Mouse.class, 90);
        probabilityMap.put(Duck.class, 60);
        probabilityMap.put(Oruga.class, 40);
    }
    public Fox() {
        super(8,2);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);
    }

    @Override
    public void actuar() {

    }
}
