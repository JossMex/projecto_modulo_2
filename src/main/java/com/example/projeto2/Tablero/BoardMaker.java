package com.example.projeto2.Tablero;

import com.example.projeto2.Animals.*;
import com.example.projeto2.Planta;
import com.example.projeto2.Restriction;

import java.util.concurrent.ThreadLocalRandom;

public class BoardMaker {
    private final BoardSettings boardSettings;
    public BoardMaker(BoardSettings boardSettings){
        this.boardSettings = boardSettings;
    }
    public SimulationBoard createWorld(){
        SimulationBoard simulationBoard = new SimulationBoard(boardSettings.getBoard().getRows(), boardSettings.getBoard().getColumns());
        for (int i = 0; i < boardSettings.getBoard().getRows(); i++){
            for (int j = 0; j < boardSettings.getBoard().getColumns(); j++){
                poblarplantas(simulationBoard.get(i, j));
                poblarAnimales(simulationBoard.get(i, j));
            }
        }
        return simulationBoard;
    }
    private static void populateAnimal(Cell celda, Class<? extends Animal> classAnimal){
        Restriction restriction = classAnimal.getAnnotation(Restriction.class);
        int maxPerCell = restriction != null ? restriction.maxPerCell() : 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int realCount = random.nextInt(maxPerCell);

        for (int i = 0;  i < realCount; i++){
            try {
                Animal animal = classAnimal.getConstructor().newInstance();
                celda.add(animal);
            }catch (ReflectiveOperationException e){
                throw new RuntimeException(e);
            }
        }
    }
    private void poblarplantas(Cell cell){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int plantsPerCell = random.nextInt(Planta.MAX_PER_CELL);
        cell.setPlantsCount(plantsPerCell);
    }
    private void poblarAnimales(Cell cell) {
        Class[] animalClasses = {
                Bear.class, Boa.class, Buffalo.class, Cabra.class, Ciervo.class,
                Duck.class, Eagle.class, Fox.class, Horse.class, Jabali.class,
                Mouse.class, Oruga.class, Oveja.class, Rabbit.class, Wolf.class
        };

        for (Class animalClass : animalClasses) {
            populateAnimal(cell, animalClass);
        }
    }
}
