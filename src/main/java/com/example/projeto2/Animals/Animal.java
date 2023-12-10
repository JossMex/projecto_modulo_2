package com.example.projeto2.Animals;

import com.example.projeto2.Tablero.Cell;
import com.example.projeto2.Tablero.Direction;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public abstract class Animal {
    private final double peso;

    protected final double alimentoNecesario;
    protected double alimentoSuministrado;

    private boolean comido;

    public Animal(double peso, double alimentoNecesario) {
        this.peso = peso;
        this.alimentoNecesario = alimentoNecesario;
    }

    public abstract boolean seTeAntoja(Animal animal);

    public abstract void actuar();
    public Set<Class<? extends Animal>> animalsToEat(){
        return Collections.emptySet();
    }

    public double getPeso() {
        return peso;
    }


    public abstract Optional<Direction> act(Cell cell);

    protected Animal reproduce() {
        try {
            Constructor<? extends Animal> constructor = this.getClass().getConstructor();
            return constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error al reproducir el animal "+ e.getMessage(), e);
        }
    }

    public void run() {
        while (alimentoSuministrado > 0 && !Thread.currentThread().isInterrupted() && !comido) {
            actuar();
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void fuisteComido() {
        comido = true;
    }

    protected boolean seTeAntoja(Animal animal, Map<Class<? extends Animal>, Integer> probabilityMap) {
        int probabilidad = probabilityMap.getOrDefault(animal.getClass(), 0);


        return generarNumeroAleatorio() < probabilidad;
    }
    private int generarNumeroAleatorio() {
        return ThreadLocalRandom.current().nextInt(100);
    }
    public double getAlimentoSuministrado(){
        return alimentoSuministrado;
    }
    public void setAlimentoSuministrado(double alimentoSuministrado){
        this.alimentoSuministrado = alimentoSuministrado;
    }
}