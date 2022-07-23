package com.chainsys.bestPractices.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.BaseStream;

// stream is the based on collection
// Stream is sequence of elements computed on demand.
// Stream supports sequential and parallel aggregations operations.
// stream is not a data structure.
// stream cannot iterated directly.
// stream cannot be accessed using index value.
//stream represents single use sequence or data.
//stream should be operator on only once.
public class StreamLessons {
	public static void demoA() {
		Stream s1 = Stream.empty();
		Stream<Integer> intStream = Stream.of(10, 20, 30, 40, 50, 80);
//		long count=intStream.count();
//		 System.out.println("count : "+count);
//		//Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
//		int value = intStream.findFirst().get();
//		//findFirst() returns object of type Optional.
//		//get() method of Optional returns the first value.
//		System.out.println(value);
//      System.out.println(intStream.toList());
//	    System.out.println(intStream[0]);//Error
	}

	public static void demoB() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		// List<Integer>list2=Arrays.asList(5,10,15,20,25,30);
		Stream<Integer> intStream = list.stream();
		List<Integer> evenNum = intStream.filter(i -> i % 2 == 0).collect(Collectors.toList());// collect() returns a
																								// collections.
		System.out.println(evenNum);
	}

	public static void demoC() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		// reductionOfObjects/elements-returning a single value by a forming an
		// operation on elements of a collection
	}

	public static void demoD() {
		IntStream intstream = IntStream.of(1, 2, 3, 4, 5);
		System.out.println(intstream.sum());
		// System.out.println(intstream.count());
		LongStream longstream = LongStream.of(1, 2, 3, 4, 5);
		System.out.println(longstream.sum());
		DoubleStream doublestream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
		System.out.println(doublestream.sum());
	}

	public static void demoE() {
		Supplier<Stream<Integer>> intstream = () -> Stream.of(10, 2, 3, 4, 5);
		System.out.println("Count: " + intstream.get().count());
		System.out.println("First: " + intstream.get().findFirst().get());
		System.out.println("List: " + intstream.get().toList());
		// get() on the suppiler creates a new stream everytime.
	}

	public static void demoF() {
		Stream<Integer> intstream = IntStream.of(1, 2, 3, 4, 5).boxed();
		// converting primitive type stream to object
		System.out.println(intstream.findFirst().get());
	}

	public static void demoG() {
		Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		streamOne.forEach(p -> System.out.println(p));
		Stream<Integer> streamTwo = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		streamTwo.forEach(p -> System.out.println(p));
	}

	public static void demoH() {
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));

		randomNumbers.limit(5).forEach(System.out::println);
	}

	public static void demoI() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.add("Vijaysethu pathi");
		memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
		// filter() returns a stream - intermiate operations.
		// The map() intermediate operation converts each element in the stream into
		// another object via the given function.
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
	}

	public static void demoJ() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.add("Vijaysethu Pathi");
		memberNames.add("Dhuru Vikram");
		memberNames.add("VijaydevarKonda");
		// terminal operations
		// Terminal operations return a result of a certain type after processing all
		// the stream elements.
		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());

		// System.out.print(memNamesInUppercase);
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // true

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // false

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("E"));

		System.out.println(matchedResult); // true
		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();

		System.out.println(totalMatched);
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + " * " + s2);

		reduced.ifPresent(System.out::println);
	}

	public static void demoK() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			list.add(i);
		}
		System.out.println(list.parallelStream().findFirst().get());
		System.out.println(list.parallelStream().findAny().get());
	}

	public static void demoL() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

//        List<Integer> newList = list.stream()
//       .peek(System.out::println)
//       .collect(Collectors.toList());

		// System.out.println(newList);
		// list.stream().peek(System.out::println);
		// peek() is an intermediate operation and we didn't apply a terminal operation
		// to the pipeline.
		list.stream().forEach(System.out::println);
	}

	public static void demoM() {
		Stream.of("one", "seven", "three", "four")
				// .peek(e -> System.out.println("value: " + e))
				.peek(System.out::println) // both are same
				.collect(Collectors.toList());
	}

	public static void demoN() {
//		Stream.of("one", "two", "three", "four").peek(e -> e.toUpperCase()) // peek() doesn't manipulate the element
//				.forEach(System.out::println);
		Stream.of("one", "two", "three", "four").map(e -> e.toUpperCase()) // map() well manipulate the element
		.forEach(System.out::println);
	}

	// peek() can be useful in altering the inner state of an element
	// without replacing the element
	public static void demoO() {
		//
		Stream<Emp> empStream = Stream.of(new Emp(100, "Alice"), new Emp(101, "Bob"), new Emp(102, "Chuck"));
		// empStream.peek(e -> e.setName(e.getName().toLowerCase()))
		empStream.peek(e -> e.setName(e.getName().toUpperCase()))
		.forEach(System.out::println);
	}
}

//
class Emp {
	private int id;
	private String name;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
