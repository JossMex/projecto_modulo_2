package com.example.projeto2.Animals;

import com.example.projeto2.Tablero.Cell;
import com.example.projeto2.Tablero.Direction;


import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Set;

public abstract class Carnivorous extends Animal{
    public Carnivorous(int peso, double alimentoNecesario) {
        super(peso, alimentoNecesario);
    }

    public void comer(Animal animal) {
        alimentoSuministrado += animal.getPeso();
        if (alimentoSuministrado > alimentoNecesario) {
            alimentoSuministrado = alimentoNecesario;
        }
    }

    public Optional<Direction> act(Cell cell) {

        Set<Class<? extends Animal>> animalsToEat = animalsToEat();

        if (alimentoSuministrado < alimentoNecesario) {
            Optional<Animal> animal = cell.getAnyOf(animalsToEat, this);
            if (animal.isPresent()) {
                comer(animal.get());
                return Optional.empty();
            } else {
                return getDirection();
            }
        }


        if (cell.getAnimalsCount(this.getClass()) > 0) {
            cell.add(reproduce());

            return Optional.empty();
        }
        return getDirection();
    }
        private static Optional<Direction> getDirection(){
        int randomNum = ThreadLocalRandom.current().nextInt(4);
        return switch (randomNum) {
            case 0 -> Optional.of(Direction.UP);
            case 1 -> Optional.of(Direction.DOWN);
            case 2 -> Optional.of(Direction.RIGHT);
            default -> Optional.of(Direction.LEFT);
        };
    }
}