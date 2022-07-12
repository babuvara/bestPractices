package com.chainsys.bestPractices.defaultmethod;

public interface Ivehicle {
    void start();
    default void move() {
        System.out.println("Vehicle is Moving");
    }

}
class Car implements Ivehicle{
    
    @Override
    public void start() {
        System.out.println("Car is Starting");
    }    
}
class Bike implements Ivehicle{
    
    @Override
    public void start() {
        System.out.println("Bike is Starting");
    }    
}
