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

    private void print(Map.Entry<Class<? extends Animal>, Integer> entry) {
        if(entry.getKey().equals(Wolf.class)){
            System.out.println("🐺: "+ entry.getValue());
        }else if(entry.getKey().equals(Boa.class)) {
            System.out.println("🐍: " + entry.getValue());
        }else if(entry.getKey().equals(Bear.class)) {
            System.out.println( "🐻:"  + entry.getValue());
        }else if(entry.getKey().equals(Buffalo.class)) {
            System.out.println(  "🐃:" + entry.getValue());
        } else if(entry.getKey().equals(Cabra.class)) {
            System.out.println( "🐐 : " + entry.getValue());
        }else if(entry.getKey().equals(Ciervo.class)) {
            System.out.println("🦌 : " + entry.getValue());
        }else if(entry.getKey().equals(Duck.class)) {
            System.out.println( "🦆 : " + entry.getValue());
        }else if(entry.getKey().equals(Eagle.class)) {
            System.out.println( "🦅 : " + entry.getValue());
        }else if(entry.getKey().equals(Fox.class)) {
            System.out.println(" 🦊 : " + entry.getValue());
        }else if(entry.getKey().equals(Horse.class)) {
            System.out.println( "🐎 : " + entry.getValue());
        }else if(entry.getKey().equals(Jabali.class)) {
            System.out.println( "🐗 : " + entry.getValue());
        }else if(entry.getKey().equals(Mouse.class)) {
            System.out.println("🐁 : " + entry.getValue());
        }else if(entry.getKey().equals(Oruga.class)) {
            System.out.println( "🐛 : " + entry.getValue());
        }else if(entry.getKey().equals(Oveja.class)) {
            System.out.println( "🐑 : " + entry.getValue());
        }else if(entry.getKey().equals(Rabbit.class)){
            System.out.println( "🐇  : "+ entry.getValue());
        }else {
            System.out.println(entry.getKey().getName() + ": "+ entry.getValue());
        }
    }
}
