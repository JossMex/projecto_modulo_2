package com.example.projeto2;

import com.example.projeto2.Animals.*;
import com.example.projeto2.Tablero.Cell;
import com.example.projeto2.Tablero.SimulationBoard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SimulationBoardStatistics extends Thread {

    private final SimulationBoard simulationBoard;

    private boolean finished;

    public SimulationBoardStatistics(SimulationBoard simulationBoard) {

        this.simulationBoard = simulationBoard;

    }

    public void run(){
        int rows = simulationBoard.getTotalRows();
        int columns = simulationBoard.getTotalColumns();

        while(!finished) {
            Map<Class<? extends Animal>, Integer> countByAnimal = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Cell cell = simulationBoard.get(i, j);

                    cell.count(countByAnimal);
                }
            }

            Set<Map.Entry<Class<? extends Animal>, Integer>> countEntries = countByAnimal.entrySet();

            for(Map.Entry<Class<? extends Animal>, Integer> entry: countEntries){
                print(entry);
            }

            System.out.println("========================================================");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static final Map<Class<? extends Animal>, String> animalEmojiMap = new HashMap<>();
    static {
        animalEmojiMap.put(Wolf.class, "🐺");
        animalEmojiMap.put(Boa.class, "🐍");
        animalEmojiMap.put(Bear.class, "🐻");
        animalEmojiMap.put(Buffalo.class, "🐃");
        animalEmojiMap.put(Cabra.class, "🐐");
        animalEmojiMap.put(Ciervo.class, "🦌");
        animalEmojiMap.put(Duck.class, "🦆");
        animalEmojiMap.put(Eagle.class, "🦅");
        animalEmojiMap.put(Fox.class, "🦊");
        animalEmojiMap.put(Horse.class, "🐎");
        animalEmojiMap.put(Jabali.class, "🐗");
        animalEmojiMap.put(Mouse.class, "🐁");
        animalEmojiMap.put(Oruga.class, "🐛");
        animalEmojiMap.put(Oveja.class, "🐑");
        animalEmojiMap.put(Rabbit.class, "🐇");
    }
    private void print(Map.Entry<Class<? extends Animal>, Integer>entry){
        String emoji = animalEmojiMap.getOrDefault(entry.getKey(), entry.getKey().getName());
        System.out.println(emoji + ": " + entry.getValue());
    }
}
