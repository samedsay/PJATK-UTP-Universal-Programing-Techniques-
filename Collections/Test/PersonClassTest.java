package testProject4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project4.Person;

class PersonClassTest {

	private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private static final String firstName = "Barbara", secondName = "Khopnik", thirdName = "Austin";
	private static final String firstSurname = "Jane", secondSurname = "Austin", thirdSurname = "Khopnik";
	private static final String firstDate = "1996-01-15", secondDate = "2002-12-07", thirdDate = "2002-12-07";
	private static Person firstPerson, secondPerson,thirdPerson;

	@BeforeAll
	public static void beforeTest() {
		System.out.println("Before PersonClass Tests Compilation...");
	}

	@BeforeEach
	public void Before() throws Exception {
		firstPerson = new Person(firstName, firstSurname, FORMAT.parse(firstDate));
		secondPerson = new Person(secondName, secondSurname, FORMAT.parse(secondDate));
		thirdPerson = new Person(thirdName, thirdSurname, FORMAT.parse(thirdDate));

	}

	@Test
	public void testPerson() throws Exception {
		Assert.assertEquals(firstName, firstPerson.getName());
		Assert.assertEquals(thirdName, secondPerson.getSurname());
		Assert.assertEquals(FORMAT.parse(thirdDate), secondPerson.getBirthdate());

		Assert.assertEquals(thirdSurname, secondPerson.getName());
		Assert.assertEquals(secondSurname, secondPerson.getSurname());
		Assert.assertEquals(FORMAT.parse(secondDate), thirdPerson.getBirthdate());

	}

	@Test
	public void testCompareTo() {
		Assert.assertTrue(firstPerson.compareTo(secondPerson) > 0);
		Assert.assertTrue(secondPerson.compareTo(firstPerson) < 0);
	}

}
