package com.example.projeto2.Animals;

public abstract class Buffalo extends Herbivorous{

    public Buffalo() {
        super(700,100);
    }

    @Override
    public boolean seTeAntoja(Animal animal) {
        return false;
    }

    @Override
    public void actuar() {

    }
}
