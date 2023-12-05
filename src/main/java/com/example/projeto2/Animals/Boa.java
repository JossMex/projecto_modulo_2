package com.example.projeto2.Animals;

import com.example.projeto2.Restriction;

import java.util.HashMap;
import java.util.Map;

@Restriction(maxPerCell = 30)
public abstract class Boa extends Carnivorous{
    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        probabilityMap.put(Fox.class, 15);
        probabilityMap.put(Rabbit.class, 20);
        probabilityMap.put(Mouse.class, 40);
        probabilityMap.put(Duck.class, 10);
    }

    public Boa() {
        super(15, 3);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);
    }

    @Override
    public void actuar() {

    }
}
