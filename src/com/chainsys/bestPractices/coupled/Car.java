package com.chainsys.bestPractices.coupled;
// objects of this class can work only with petrol engine and steel wheels.
// the car classes is tightly coupled with PetrolEngine class and SteelWheel class.
public class Car {
	private PetrolEngine engine;  // early bound with petrol engine
	public SteelWheel[] wheels;   // early bound with steel wheel
	
	public Car()
	{
		engine=new PetrolEngine();
		wheels=new SteelWheel[4];
		wheels[0]=new SteelWheel();
		wheels[0].location="front left";
		wheels[1]=new SteelWheel();
		wheels[1].location="front right";
		wheels[2]=new SteelWheel();
		wheels[2].location="back left";
		wheels[3]=new SteelWheel();
		wheels[3].location="back left";
	}
	public Car(PetrolEngine engine, SteelWheel[] wheel)
	{
		this.engine=engine;
		this.wheels=wheel;
		wheels[0].location="front left";
		wheels[1].location="front right";
		wheels[2].location="back left";
		wheels[3].location="back left";
	}
public void StartCar() {
	engine.start();
	wheels[0].rotate();
	wheels[1].rotate();
	wheels[2].rotate();
	wheels[3].rotate();
}
public SteelWheel[] getWheels() {
	return this.wheels;
}
}
