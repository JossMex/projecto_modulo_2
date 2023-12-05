package com.example.projeto2.Animals;

import com.example.projeto2.Tablero.Cell;
import com.example.projeto2.Tablero.Direction;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivorous extends Animal {

    public Herbivorous(double peso, double alimentoNecesario) {
        super(peso, alimentoNecesario);
    }


    public double comer(int availablePlants) {

        if (alimentoNecesario - alimentoSuministrado > availablePlants) {
            alimentoSuministrado = alimentoNecesario;
            return alimentoNecesario - alimentoSuministrado - availablePlants;
        } else {
            alimentoSuministrado += availablePlants;
            return 0;
        }

    }

    public Optional<Direction> mover(Cell cell) {

        if (alimentoSuministrado < alimentoNecesario && cell.getPlantsCount() > 0) {
            double leftFood = comer(cell.getPlantsCount());

            cell.setPlantsCount((int) leftFood);

            return Optional.empty();
        }

        if (cell.getAnimalsCount(this.getClass()) > 0) {
            cell.add(reproduce());
        }
        return getDirection();
    }
    private Optional<Direction> getDirection(){
        return switch (ThreadLocalRandom.current().nextInt(4)) {
            case 0 -> Optional.of(Direction.UP);
            case 1 -> Optional.of(Direction.DOWN);
            case 2 -> Optional.of(Direction.RIGHT);
            default -> Optional.of(Direction.LEFT);
        };
    }


}