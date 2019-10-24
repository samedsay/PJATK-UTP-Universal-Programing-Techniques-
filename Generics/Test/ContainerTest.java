package project1Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project1.Car;
import project1.Container;
import project1.Student;

class ContainerTest {

	public Container<Car, Integer> container = new Container<>();
	public Container<Student, Integer> container2 = new Container<>();
	private static int counter = 0;

	@BeforeAll
	public static void beforeTest() {
		System.out.println("Before Container Tests Compilation...");
	}

	@BeforeEach
	public void before() {
		System.out.println(1 + counter++ + ". Compilation");

		container.elements().add(new Car("Fiat", 2012));
		container.elements().add(new Car("Tesla", 2017));
		container.elements().add(new Car("BMW", 2013));
		container.elements().add(new Car("Jaguar", 2015));

		container2.adds(new Student("Helena", 2500));
		container2.adds(new Student("Mike", 1750));

	}

	@Test
	public void testAggregateAllElements() {
		System.out.println("TEST : testAggregateAllElements");
		Integer checker = container.aggregateAllElements();
		Assert.assertEquals((Integer) 2012, checker);
	}

	@Test
	public void testCloneElementAtIndex() {
		System.out.println("TEST : testCloneElementAtIndex");

		Car cloneCar = container.cloneElementAtIndex(0);
		Assert.assertEquals(cloneCar.getBrand(), container.get(0).getBrand());
		Assert.assertNotEquals(cloneCar, container.get(1));

	}

	@Test
	public void testElementsAdds() {

		System.out.println("TEST : testElementsAdds");
		List<Student> list = new ArrayList<>();
		list.add(new Student("Helena", 2500));
		list.add(new Student("Mike", 1750));

		Assert.assertEquals(list.get(1).getName(), container2.elements().get(1).getName());

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
