package com.chainsys.bestPractices.references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Lessons {
	public static void testA() {
		List<Phone> phoneListA = new ArrayList<Phone>();
		// Phone::print; // direct call not worked
		//
		phoneListA.add(new Phone());
		phoneListA.add(new Phone());
		phoneListA.add(new Phone());
		phoneListA.add(new Phone());
		phoneListA.add(new Phone());
		phoneListA.forEach(System.out::println);
	}

	public static void testB() {
		List<Long> phoneNumbers = new ArrayList<Long>();
		phoneNumbers.add(8124986715L);
		phoneNumbers.add(8124986714L);
		phoneNumbers.add(8124986713L);
		phoneNumbers.add(8124986712L);
		phoneNumbers.add(8124986711L);
		phoneNumbers.forEach(Phone::print); // static method call -> using class
		// to call static method
		Phone iphone = new Phone();
		System.out.println(iphone.hashCode() + "\n " + iphone.getClass());

		phoneNumbers.forEach(iphone::makeACall); // non static method -> using object reference to call instance method
	}

// constructor reference
	public static void testC() {
		PhoneEmpty mobileA = Phone::new;
		// constructor reference
		Phone firstPhone = mobileA.get();
		firstPhone.makeACall(8428551647L);
		PhoneWithNumberAndModel mobileB = Phone::new;
		Phone secondPhone = mobileB.get(8181818181L, "4Gvivo");
		secondPhone.makeACall(7878787878L);
		System.out.println(secondPhone.toString());
	}

	public static void testD() {
		Map<Long, String> phoneMap = new HashMap<Long, String>();
		phoneMap.put(8976503458L, "samsung");
		phoneMap.put(8976505698L, "nokia");
		phoneMap.put(8976503788L, "oppo");
		phoneMap.put(8976502348L, "vivo");
		phoneMap.put(8976503897L, "redmi");
		// map does not have stream because it is not a collection
		// phoneMap.stream()
		Set<Long> longSet = phoneMap.keySet(); 
		Stream<Long> numberStream = phoneMap.keySet().stream();
		// map has to be converted to a set and stream method should be called on a set
		Phone[] phonearray = numberStream.map(Phone::new) //constructor reference of phone
				.toArray(Phone[]::new);    // constructor reference of array
//		int count = phonearray.length;
//		for (int i = 0; i < count; i++) {
//			System.out.println(phonearray[i]);
//		}
		// Stream<Phone> phoneArr = phonearray.stream(); // cannot use Stream method on array directly
		// creating a stream from arrays
		Stream<Phone> phoneStream = Arrays.stream(phonearray);
		phoneStream.forEach(System.out::println);
	}
}

// functional Interface for non parameterized constructor
interface PhoneEmpty {
	Phone get();
}

// functional Interface for parameterized constructor
interface PhoneWithNumberAndModel {
	Phone get(long num, String mod);
}

class Phone {
	private long number;
	private String model;

	public Phone() {
		System.out.println("default constructor");
	}

	// also create this constructor
	public Phone(long number) {
		System.out.println("Single parameter constructor");
		this.number = number;
		this.model = "not assigned";
	}

	public Phone(long number, String model) {
		System.out.println("parameterized constructor");
		this.number = number;
		this.model = model;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void makeACall(long number) {
		System.out.println("call made: " + number);
	}

	public static void print(long numer) {
		System.out.println("print document" + numer);
	}

	@Override
	public String toString() {
		// return this.hashCode() + " ";
		return this.number + " " + this.model;
	}

}