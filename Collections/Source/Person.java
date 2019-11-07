package project4;

import java.util.Date;

public class Person implements Comparable<Person> {

	private final String name;
	private final String surname;
	private final Date birthdate;

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public Person(String name, String surname, Date birthdate) {
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
	}

	@Override
	public int compareTo(Person otherPerson) {

		int result = this.getSurname().compareTo(otherPerson.getSurname());
		if (result != 0)
			return result;

		result = this.getName().compareTo(otherPerson.getSurname());
		if (result != 0)
			return result;

		return this.getBirthdate().compareTo(otherPerson.getBirthdate());

	}
	
	public String toString() {
		return name + "-" + surname + "-" + birthdate;
	}

}
