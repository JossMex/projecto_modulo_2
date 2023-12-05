package com.example.projeto2.Animals;

public abstract class Rabbit extends Herbivorous{
    public Rabbit() {
        super(2, 0.45);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
