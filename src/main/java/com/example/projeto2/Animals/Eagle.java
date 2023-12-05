package com.example.projeto2.Animals;

import java.util.HashMap;
import java.util.Map;

public abstract class Eagle extends Carnivorous{
    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        probabilityMap.put(Fox.class, 10);
        probabilityMap.put(Rabbit.class, 90);
        probabilityMap.put(Mouse.class, 90);
        probabilityMap.put(Duck.class, 80);
    }
    public Eagle() {
        super(6,1);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);
    }

    @Override
    public void actuar() {

    }
}
