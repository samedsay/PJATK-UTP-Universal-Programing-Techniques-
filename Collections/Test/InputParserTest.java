package testProject4;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import project4.InputParser;
import project4.Person;

class InputParserTest {

	private static File file = new File("src/project4/informationTable.txt");
	List<Person> person;

	@Before
	public void Before() throws IOException {
		Assert.assertTrue(file.exists());
	}

	@Test
	public void testParse() throws Exception {

		Assert.assertTrue(file.exists());
		person = InputParser.parse(file);
		Assert.assertEquals(person.get(0).getName(), "Bretty");
		Assert.assertEquals(person.get(1).getName(), "Simon");

	}

	@Test
	public void parse() throws Exception {
		InputParser.parse(file);
		Assert.assertNotNull(InputParser.parse(file));

	}

	@Test
	public void sizeTest() throws Exception {

		person = InputParser.parse(file);
		Assert.assertEquals(25, person.size());
	}

}
