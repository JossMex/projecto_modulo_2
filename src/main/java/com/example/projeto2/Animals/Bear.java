package com.example.projeto2.Animals;

import com.example.projeto2.Restriction;

import java.util.HashMap;
import java.util.Map;

@Restriction(maxPerCell = 5, feedingFactorDecrease = 10)
public abstract class Bear extends Carnivorous{
    private static final Map<Class<? extends Animal>, Integer> probabilityMap = new HashMap<>();

    static {
        initializeProbabilityMap();
    }
    private static void initializeProbabilityMap(){
        addProbability(Boa.class, 80);
        addProbability(Horse.class, 40);
        addProbability(Ciervo.class, 80);
        addProbability(Rabbit.class, 80);
        addProbability(Mouse.class, 90);
        addProbability(Cabra.class, 70);
        addProbability(Oveja.class, 70);
        addProbability(Jabali.class, 50);
        addProbability(Buffalo.class, 20);
        addProbability(Duck.class, 10);
    }
    private static void addProbability(Class<? extends Animal> animalClass, int probability) {
        probabilityMap.put(animalClass, probability);

    }
    public Bear(){
        super(500, 80);
    }
    @Override
    public boolean seTeAntoja(Animal animal){
        return super.seTeAntoja(animal, probabilityMap);
    }
    @Override
    public void actuar(){

    }
}
