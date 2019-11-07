package project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

	private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	private static final String LINE_PATTERN = "\\w+\\s\\w+\\s[0-9]{4}\\-[0-1][0-9]\\-[0-3][0-9]";
	private static final Pattern LINE_REGEX = Pattern.compile(LINE_PATTERN, Pattern.CASE_INSENSITIVE);

	public static List<Person> parse(File file) throws IOException {

		List<Person> personList = new ArrayList<>();

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferReader.readLine()) != null) {

				if (!parse(line))
					continue;

				String[] array = line.split(" ");

				String name = array[0];
				String surname = array[1];
				Date birthdate = null;

				try {
					birthdate = birthdate(array[2]);
				} catch (ParseException e) {
					continue;

				}
				personList.add(new Person(name, surname, birthdate));

			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return personList;

	}

	private static boolean parse(String line) {
		Matcher matcher = LINE_REGEX.matcher(line);
		return matcher.matches();
	}

	private static Date birthdate(String match) throws ParseException {

		Date input = FORMAT.parse(match);
		return input;

	}
}
