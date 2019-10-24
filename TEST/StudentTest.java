package project1Test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project1.Student;

class StudentTest {

	private static final String firstName = "Helena";
	private static final String secondName = "Denis";
	private static final int firstScholarship = 1500;
	private static final int secondScholarship = 2200;
	private static int counter = 0;

	final Student firstStudent = new Student(firstName, firstScholarship);
	final Student secondStudent = new Student(secondName, secondScholarship);

	@BeforeAll
	public static void beforeTest() {
		System.out.println("Before Student Tests Compilation...");
	}

	@BeforeEach
	public void before() {

		System.out.println(1 + counter++ + ". Compilation");
	}

	@Test
	public void getNS() {

		Assert.assertEquals(firstName, firstStudent.getName());
		Assert.assertEquals(firstScholarship, (int) firstStudent.getScholarship());

		Assert.assertEquals(secondName, secondStudent.getName());
		Assert.assertEquals(secondScholarship, (int) secondStudent.getScholarship());

		Assert.assertNotEquals(firstStudent.getName(), secondStudent.getName());
		Assert.assertNotEquals(firstStudent.getScholarship(), secondStudent.getScholarship());
	}

	@Test
	public void aggregate() {
		int aggregateOne = firstStudent.aggregate(null);
		Assert.assertEquals(firstScholarship, aggregateOne);

		int aggregateTwo = secondStudent.aggregate(null);
		Assert.assertEquals(secondScholarship, aggregateTwo);

	}

	@Test
	public void deepClone() {
		Student firstClone = firstStudent.deepClone();
		Student secondClone = secondStudent.deepClone();

		Assert.assertNotEquals(firstStudent, firstClone);
		Assert.assertNotEquals(secondStudent, secondClone);

		Assert.assertEquals(firstStudent.getName(), firstClone.getName());
		Assert.assertEquals(secondStudent.getName(), secondClone.getName());

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
