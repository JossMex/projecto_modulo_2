package com.example.projeto2.Animals;

import java.util.HashMap;
import java.util.Map;

public abstract class Mouse extends Herbivorous{
    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        probabilityMap.put(Oruga.class, 90);
    }
    public Mouse() {
        super(0.05,0.01);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);
    }

    @Override
    public void actuar() {

    }
}
