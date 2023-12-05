package com.example.projeto2.Animals;

import java.util.HashMap;
import java.util.Map;

public abstract class Jabali extends Herbivorous{
    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        probabilityMap.put(Duck.class, 50);
        probabilityMap.put(Oruga.class, 90);
    }

    public Jabali() {
        super(400,50);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);}

    @Override
    public void actuar() {

    }
}
