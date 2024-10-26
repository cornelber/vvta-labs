package AngajatiApp.model;

public class SalaryCriteria implements SortingPattern<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o2.getSalary() - o1.getSalary());
	}

}
