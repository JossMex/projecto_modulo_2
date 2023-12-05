package com.example.projeto2.Animals;

public abstract class Cabra extends Herbivorous{
    public Cabra() {
        super(60,10);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
