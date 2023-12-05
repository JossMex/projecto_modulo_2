package com.example.projeto2.Animals;

public abstract class Oveja extends Herbivorous{
    public Oveja() {
        super(70,15);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
