package com.chainsys.bestPractices.decoupled;

public class WoodenWheel implements Iwheel {
	public String location;
	public void rotate() {
		System.out.println("Wooden wheel rotate"); 
	}
	public void stop() {
		System.out.println("Wooden wheel stop"); 
	}
	@Override
	public void stopRotation() {
		// TODO Auto-generated method stub
		
	}

}
