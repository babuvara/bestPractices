package com.chainsys.bestPractices.decoupled;

public class DieselEngine implements Iengine {
	public void start() {
		System.out.println("Diesel engine start");
	}

	public void stop() {
		System.out.println(("Diesel engine stop"));
	}
}