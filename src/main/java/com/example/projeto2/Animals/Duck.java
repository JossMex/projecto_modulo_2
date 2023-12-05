package com.example.projeto2.Animals;

import java.util.HashMap;
import java.util.Map;

public abstract class Duck extends Herbivorous{
    private static final Map<Class < ? extends Animal >, Integer> probabilityMap = new HashMap<>();
    static {
        probabilityMap.put(Oruga.class, 10);
    }
    public Duck() {
        super(1,1.05);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);
    }

    @Override
    public void actuar() {

    }
}
