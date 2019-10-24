package project1Test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project1.Car;

class CarTest {

	private final static String brand = "Opel";
	private final static int model = 2014;

	private Car car = new Car(brand, model);
	private static int counter = 0;

	@BeforeAll
	public static void beforeTest() {
		System.out.println("Before Car Tests Compilation...");
	}


	@BeforeEach
	public void before() {
		
		System.out.println(1+counter++ + ". Compilation");
	}

	@Test
	public void test() {
		Assert.assertEquals(brand, car.getBrand());
		Assert.assertEquals(model, car.getModel());

	}

	@Test
	public void testAggregate() {
		int aggregate = car.aggregate(null);
		Assert.assertEquals(aggregate, model);

	}

	@Test
	public void testDeepClone() {
		Car firstClone = car.deepClone();

		Assert.assertNotEquals(car, firstClone);

		Assert.assertEquals(car.getBrand(), firstClone.getBrand());
	}
	@AfterEach
	public void after() {
		System.out.println("Successful Compilation :) \n");
	}
	@AfterAll
	public static void afterTest() {
		System.out.println("After Tests Compilation...");
}
}
