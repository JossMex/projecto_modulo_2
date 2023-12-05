package com.example.projeto2.Animals;

public abstract class Oruga extends Herbivorous{
    public Oruga() {
        super(0.01,0);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
