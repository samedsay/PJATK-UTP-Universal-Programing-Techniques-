package project1;

public class Student implements IAggregable<Student, Integer>, IDeeplyCloneable<Student> {

	private String name;
	private Integer scholarship;

	public Student(String name, int scholarship) {
		this.name = name;
		this.scholarship = scholarship;
	}

	@Override
	public Integer aggregate(Integer intermediateResult) {
		if (intermediateResult == null) {
			return scholarship;
		}
		if (scholarship > intermediateResult) {
			return intermediateResult;
		} else {
			return scholarship;
		}
	}

	@Override
	public Student deepClone() {
		Student newStudent = new Student(name, scholarship);
		return newStudent;
	}

	public String getName() {
		return name;
	}

	public Integer getScholarship() {
		return scholarship;
	}

}
