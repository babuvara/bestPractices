package com.chainsys.bestPractices.decoupled;

public class SteelWheel implements Iwheel {
	public String location;
	public void rotate()
	{
		System.out.println(" Steel Wheel rotate");
	}
	public void stop()
	{
		System.out.println("Steel Wheel stop");
	}
	@Override
	public void stopRotation() {
		
	}

}
