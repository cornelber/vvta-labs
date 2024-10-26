package AngajatiApp.model;

public class AgeCriteria implements SortingPattern<Employee> {

	private static final int CNP_BIRTH_DATE_LENGTH = 7;

	@Override
	public int compare(Employee o1, Employee o2) {
		int employee1Age = Integer.parseInt(o1.getCnp().substring(1,CNP_BIRTH_DATE_LENGTH));
		int employee2Age = Integer.parseInt(o2.getCnp().substring(1,CNP_BIRTH_DATE_LENGTH));
		return employee2Age - employee1Age;
	}

}
