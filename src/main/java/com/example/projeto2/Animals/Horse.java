package com.example.projeto2.Animals;

public abstract class Horse extends Herbivorous{
    public Horse() {
        super(400,60);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
