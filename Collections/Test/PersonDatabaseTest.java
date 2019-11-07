package testProject4;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import project4.PersonDatabase;

class PersonDatabaseTest {

	private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static File file = new File("src/project4/informationTable.txt");
	PersonDatabase db;
	Date input;
	
	public void Before() throws Exception {
		input = FORMAT.parse("1988-05-25");
	}

	


	@Test
	public void testPersonDatabaseListOfPerson() throws ParseException, IOException {

		db = new PersonDatabase(file);
		Assert.assertEquals(25, db.size());
	}

	@Test
	public void sortedTest() throws Exception {

		db = new PersonDatabase(file);
		Assert.assertEquals(db.sortedByFirstName().get(24).getName(), "Tracey");
		Assert.assertEquals(db.sortedByBirthdate().get(0).getName(), "Sherry");
		Assert.assertEquals(db.sortedBySurnameFirstNameAndBirthdate().get(24).getName(), "Simon");

	}
}
