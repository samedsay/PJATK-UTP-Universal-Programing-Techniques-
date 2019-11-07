package project4;

import java.util.Comparator;

public final class BirthDateComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {

		return person1.getBirthdate().compareTo(person2.getBirthdate());

	}
}
