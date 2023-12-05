package com.example.projeto2.Animals;

public abstract class Ciervo extends Herbivorous{
    public Ciervo() {
        super(300,50);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
