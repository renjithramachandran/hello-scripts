/**
 * HelloScriptJava.java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author RBz
 *
 */
public class HelloScriptJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/* A Simple Console Output */
		System.out.println("Hello");

		/*
		 * Demonstrates formatted output, %d placeholder for decimal,
		 * %s-->string, %f-->float, "/n"-->next line
		 */
		System.out.printf("Formatting %s is easy %d %f\n", "with Java", 10,
				98.6);
		/*
		 * String.format returns a formatted string, '-' makes the result left
		 * justified, 32 is the width of the first string
		 */
		System.out.println(String.format("%-32s= %s", "label", "content"));

		/* If,else condition */
		int year = 2016;
		if (year > 2008)
			System.out
					.println("You are in india and you have already enrolled for engineering. Game Over!\n");
		else if (year < 2008)
			System.out
					.println("Stay away from ready made custom advices please!\n");
		else
			System.out
					.println("Anything wrong with your time machine? You have not gone anywhere, kiddo.\n");

		/* Range based for loop */
		IntStream.range(0, 3).forEachOrdered(n -> {
			System.out.println(n + " : Hi there");
		});

		/* copying range value to a variable */
		List<Integer> newArray = new ArrayList<Integer>();
		IntStream.range(0, 3).forEachOrdered(n -> {
			newArray.add(n);
		});
		System.out.println(newArray);

		/* Array demo */
		/* Numerical Array, While */
		String[] rules = { "Do no harm", "Obey", "Continue Living" };
		int i = 0;
		while (i < rules.length) {
			System.out.println("Rule " + Integer.toString(i + 1) + " : "
					+ rules[i]);
			i = i + 1;
			System.out.println("");
		}
		/* Associating array */

		/* Associated array, foreach */
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "world");
		map.put("foo", "bar");
		map.put("lorem", "ipsum");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			System.out.println("");
		}
		/*
		 * Example of a Nested Loop To calculate pythagorean Triplets
		 */
		int n = 11;
		System.out.println("-------------------------------------\n");
		IntStream
				.range(0, n)
				.forEach(
						a -> {
							IntStream
									.range(a, n)
									.forEach(
											b -> {
												int cSquare = (int) Math.pow(a,
														2)
														+ (int) Math.pow(b, 2);
												int c = (int) Math
														.sqrt(cSquare);
												if ((cSquare - (c * c)) == 0) {
													System.out
															.printf("a=%d, b=%d, c=%d\n",
																	a, b, c);
													System.out
															.println("-------------------------------------\n");
												}
											});
						});

		/* Iterating over a List using range and len */

		System.out.println("-------------------------------------\n");
		Integer[] fibonacci = { 0, 1, 1, 2, 3, 5, 8, 13, 21 };
		IntStream.range(0, fibonacci.length).forEachOrdered(t -> {
			System.out.println(t + " : " + fibonacci[t]);
		});

		System.out.println("-------------------------------------\n");

		/* Parsing a line */

		String[] csv_values = "hello*world*how*are*you\n".trim().split("\\*");
		System.out.println(Arrays.toString(csv_values) + "\n");
		System.out.println(String.join(" : ", csv_values));

		/*
		 * A Single Argument Functioncall
		 */
		System.out.println(hello("Praseed"));

		/*
		 * A simple classOne for the OOP fanboys - Class, members, object and
		 * stuff
		 */
		class Movie {
			String name = "";
			int rating = 0;

			public Movie(String name) {
				this.name = name;
				this.rateMovie();
			}

			public void rateMovie() {
				this.rating = (((this.name).length()) % 10) + 1; /*
																 * IMDBs rating
																 * algorithm.
																 * True story!
																 */
			}

			public void printMovieDetails() {
				System.out.println("Movie : " + this.name);
				System.out.println("Rating : " + '*' * this.rating + "("
						+ this.rating + ")\n");
			}
		}

		/* Create the object */
		Movie ncfom = new Movie("New Country for Old Men"); /* It's a sequel! */
		ncfom.printMovieDetails();

		/*--------------------------------------
		---------------------------------------
		---------------------------------------*/
		class Pet {

			String name = "";
			String species = "";

			public Pet(String name, String species) {
				this.name = name;
				this.species = species;
			}

			public String getName() {
				return this.name;
			}

			public String getSpecies() {
				return this.species;
			}

			public String toString() {
				return String.format("%s %s", this.name, this.species);
			}

		}
		Pet polly = new Pet("Polly", "Parrot");
		System.out.println(polly.getName());
		System.out.println(polly.getSpecies());
		System.out.println(polly.toString());

		class Dog extends Pet {
			boolean chases_cats = false;

			public Dog(String name, boolean chases_cats) {
				super(name, "Dog");
				this.chases_cats = chases_cats;
			}

			public boolean chasesCats() {
				return this.chases_cats;
			}
		}

		class Cat extends Pet {
			boolean hates_dogs = false;

			public Cat(String name, boolean hates_dogs) {
				super(name, "Cat");
				this.hates_dogs = hates_dogs;
			}

			public boolean hatesDogs() {
				return this.hates_dogs;
			}

		}

		/*----------invocations-------------*/
		Dog fido = new Dog("Fido", true);
		Dog rover = new Dog("Rover", false);
		Cat mittens = new Cat("Mittens", true);
		Cat fluffy = new Cat("Fluffy", false);

		System.out.println(fido);
		System.out.println(rover);
		System.out.println(mittens);
		System.out.println(fluffy);

		System.out.printf("%s chases cats: %b %s", fido.getName(),
				fido.chasesCats(), "\n");
		System.out.printf("%s chases cats: %s %s", rover.getName(),
				rover.chasesCats(), "\n");
		System.out.printf("%s hates dogs: %s %s", mittens.getName(),
				mittens.hatesDogs(), "\n");
		System.out.printf("%s hates dogs: %s %s", fluffy.getName(),
				fluffy.hatesDogs(), "\n");

		/* List comprehension examples */
		List<Integer> listExample = new ArrayList<Integer>();
		IntStream.range(0, 10).forEachOrdered(l -> {
			listExample.add((int) Math.pow(l, 2));
		});
		System.out.println(listExample);

		double celsius[] = { 39.2f, 36.5f, 37.3f, 37.8f };
		double[] fahrenheit = DoubleStream.of(celsius)
				.map(x -> (float) 9 / 5 * x + 32).toArray();
		System.out.println(Arrays.toString(fahrenheit));

		List<Integer> list = IntStream.range(0, 100).boxed()
				.collect(Collectors.toList());
		List<Integer> primeList = new ArrayList<Integer>();
		List<Integer> nonPrimeList = new ArrayList<Integer>();
		list.stream()
				.filter((u) -> u > 1
						&& LongStream.range(2, u - 1).parallel()
								.noneMatch(e -> (u) % e == 0))
				.forEach((u) -> primeList.add(u));
		list.stream()
				.filter((u) -> u > 1
						&& LongStream.range(2, u - 1).parallel()
								.anyMatch(e -> (u) % e == 0))
				.forEach((u) -> nonPrimeList.add(u));
		System.out.println(primeList + "\n");
		System.out.println(nonPrimeList + "\n");

		/* A collection of value of pairs ( tuples ? ) */
		java.util.Map.Entry<Integer, Float> pair1 = new java.util.AbstractMap.SimpleEntry<>(
				12, 34.56f);
		java.util.Map.Entry<String, String> pair2 = new java.util.AbstractMap.SimpleEntry<>(
				"abc", "xyz");
		System.out.println(pair1);
		System.out.println(pair2);

	}

	/*
	 * A Single Argument FunctionFunction, argument, return
	 */

	public static String hello(String name) {
		return String.format("%s %s %s", "Hello", name, "\n");
	}

}
