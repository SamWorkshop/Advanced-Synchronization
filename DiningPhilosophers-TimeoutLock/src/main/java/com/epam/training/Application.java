package com.epam.training;

public class Application {

    public static void main(String[] args) {
        Fork fork1 = new Fork("fork1");
        Fork fork2 = new Fork("fork2");
        Fork fork3 = new Fork("fork3");
        Fork fork4 = new Fork("fork4");
        Fork fork5 = new Fork("fork5");

        Philosopher philosopher1 = new Philosopher("Aristotle", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("Plato", fork3, fork2);
        Philosopher philosopher3 = new Philosopher("Descartes", fork3, fork4);
        Philosopher philosopher4 = new Philosopher("Confucius", fork5, fork4);
        Philosopher philosopher5 = new Philosopher("John Locke", fork1, fork5);

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }

}
