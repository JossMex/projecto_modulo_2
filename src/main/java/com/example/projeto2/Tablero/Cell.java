package com.example.projeto2.Tablero;

import com.example.projeto2.Animals.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Cell {
    private Map<Class<? extends Animal>, ConcurrentLinkedQueue<Animal>> animals;
    private int plantsCount;

    private int x;
    private int y;

    public Cell(int x, int y) {
        animals = new HashMap<>();
        this.x = x;
        this.y = y;
    }

    public void add(Animal animal) {

        Class<? extends Animal> classAnimal = animal.getClass();
        ConcurrentLinkedQueue<Animal> animalsList;

        if (animals.containsKey(classAnimal)) {
            animalsList = animals.get(classAnimal);
        } else {


            animalsList = new ConcurrentLinkedQueue<>();
            animals.put(classAnimal, animalsList);
        }

        animalsList.add(animal);
    }

    public void setPlantsCount(int plantsPerCell) {
        this.plantsCount = plantsPerCell;
    }

    public int getPlantsCount() {
        return plantsCount;
    }

    public int getAnimalsCount(Class<? extends Animal> animalClass) {
        return 0;
    }

    public Optional<Animal> getAnyOf(Set<Class<? extends Animal>> animalsToEat, Animal predator) {

        for (Class<? extends Animal> animalType : animalsToEat) {
            if (animals.containsKey(animalType)) {
                ConcurrentLinkedQueue<Animal> animalList = animals.get(animalType);

                Animal animalPeeked = animalList.peek();
                if (animalPeeked != null && predator.seTeAntoja(animalPeeked)) {
                    Animal animal = animalList.poll();

                    if (animalList.isEmpty()) {
                        animalsToEat.remove(animalType);
                    }

                    return Optional.of(animal);
                }

            }

        }

        return Optional.empty();
    }

    public void remove(Animal animal) {

    }

    public void act(SimulationBoard board) {

        Set<Map.Entry<Class<? extends Animal>, ConcurrentLinkedQueue<Animal>>> entries = animals.entrySet();

        for (Map.Entry<Class<? extends Animal>, ConcurrentLinkedQueue<Animal>> entry : entries) {
            for (Animal animal : entry.getValue()) {


                Optional<Direction> direction = animal.act(this);

                if (direction.isPresent()) {
                    entry.getValue().remove(animal);
                    board.moveAnimal(x, y, direction.get(), animal);
                }

                animal.setAlimentoSuministrado(animal.getAlimentoSuministrado() * 0.8);

                if (animal.getAlimentoSuministrado() == 0) {
                    entry.getValue().remove(animal);
                }
            }
        }
    }

    public void count(Map<Class<? extends Animal>, Integer> countByAnimal) {
        Set<Map.Entry<Class<? extends Animal>, ConcurrentLinkedQueue<Animal>>> entries = animals.entrySet();

        for (Map.Entry<Class<? extends Animal>, ConcurrentLinkedQueue<Animal>> entry : entries) {

            if(!countByAnimal.containsKey(entry.getKey())){
                countByAnimal.put(entry.getKey(), entry.getValue().size());
            } else {
                countByAnimal.put(entry.getKey(), countByAnimal.get(entry.getKey()) + entry.getValue().size());
            }
        }

    }
}