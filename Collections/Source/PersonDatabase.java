package project4;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class PersonDatabase {

	private static final Comparator<Person> AS_A_GENERAL = Comparator.naturalOrder();
	private static final Comparator<Person> AS_A_NAME = new FirstNameComparator();
	private static final Comparator<Person> AS_A_DATE = new BirthDateComparator();

	private final List<Person> general;
	private final List<Person> date;
	private final List<Person> name;
	private final Map<Date, List<Person>> searchByDate;

	public PersonDatabase(File file) throws IOException, ParseException {
		this(InputParser.parse(file));
	}

	public PersonDatabase(List<Person> data) {
		general = data;
		general.sort(AS_A_GENERAL);

		name = new ArrayList<>(data);
		name.sort(AS_A_NAME);

		date = new ArrayList<>(data);
		date.sort(AS_A_DATE);

		searchByDate = data.stream().collect(Collectors.groupingBy(Person::getBirthdate, TreeMap::new,
				Collectors.mapping(p -> p, Collectors.toList())));
	}

	public List<Person> sortedByFirstName() {
		return name;
	}

	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		return general;
	}

	public List<Person> sortedByBirthdate() {
		return date;
	}

	public List<Person> bornOnDay(Date date) {
		return searchByDate.get(date);
	}

	public int size() {
		return general.size();
	}

}
