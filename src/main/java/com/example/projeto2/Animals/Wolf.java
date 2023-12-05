package com.example.projeto2.Animals;

import com.example.projeto2.Restriction;

import java.util.HashMap;
import java.util.Map;

@Restriction(maxPerCell = 30)
public abstract class Wolf extends Carnivorous{

    private static final Map<Class < ? extends Animal >, Integer> probabilityMap = new HashMap<>();
    static {
        probabilityMap.put(Horse.class, 10);
        probabilityMap.put(Ciervo.class, 15);
        probabilityMap.put(Rabbit.class, 60);
        probabilityMap.put(Mouse.class,80);
        probabilityMap.put(Cabra.class,60);
        probabilityMap.put(Oveja.class,70);
        probabilityMap.put(Jabali.class,15);
        probabilityMap.put(Buffalo.class,10);
        probabilityMap.put(Duck.class,40);

    }

    public Wolf() {
        super(50, 8);
    }

    public boolean seTeAntoja(Animal animal) {
        return super.seTeAntoja(animal, probabilityMap);
    }

    @Override
    public void actuar() {

    }
}
