package com.chainsys.bestPractices.sam;

import java.util.ArrayList;

// SAM - Single Abstract Method(an interface is only one abstract method)
interface IntegerFunction {
	Integer doOperations(int x, int y);// abstract metod
}

interface StringFunction {
	String execute(String s);
}

interface NumberFunction {
	Integer doOperations(int x, int y, int z);
}

class ImplementerA implements IntegerFunction {

	@Override
	public Integer doOperations(int x, int y) {
		return x + y;
	}

}

public class SamLessons {
	public static void demoA() {
		IntegerFunction total = new ImplementerA();
		IntegerFunction add = (x, y) -> x + y;// LAMBDA expression
		// (x,y)this is parameter for the method
		// ->x+y this is the implemetation for the method
		// add is an implementation of dooperations method of interface integerfunction
		NumberFunction sum = (x, y, z) -> x + y + z;
		IntegerFunction multiply = (x, y) -> x * y;// right side-->anonymous function
		IntegerFunction divide = (x, y) -> x / y;
		Integer result = add.doOperations(2, 8);
		// using wrapper class to treat it as object(Boxing)
		// wrapper class primitive types covert to object
		System.out.println("result add: " + result);
		result = total.doOperations(5, 6);
		System.out.println("result: " + result);
		result = multiply.doOperations(2, 8);
		System.out.println("result multiply: " + result);
		result = divide.doOperations(8, 4);
		System.out.println("result divide: " + result);
	}

	public static void demoB() {
		StringFunction upper = (s) -> s.toUpperCase();
		StringFunction lower = (s) -> s.toLowerCase();
		String result = upper.execute("weLcome");
		System.out.println("result in upper : " + result);
		result = lower.execute("BONus");
		System.out.println("result in lower: " + result);
	}

	public static void demoC() {
		ArrayList<Integer> nos = new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		nos.forEach((n) -> System.out.println(n));
		// Single line statement
	}

	public static void demoD() {
		IntegerFunction getTotal = (x, y) -> x + y;
		ArrayList<Integer> nos = new ArrayList<Integer>();
		nos.add(100);
		nos.add(20);
		nos.add(30);
		nos.add(25);
		nos.add(80);
		int i = 100;
		nos.forEach((n) -> {
			int result = 0;
			result = getTotal.doOperations(n, i);
			System.out.println(" total: " + result);
		});
		// multiline statements
	}

}