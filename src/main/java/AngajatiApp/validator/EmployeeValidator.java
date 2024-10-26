package AngajatiApp.validator;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;


public class EmployeeValidator {

	public EmployeeValidator(){}

	public boolean isValid(Employee employee) {
		return isNameAndCnpValid(employee)
				&& isFunctionValid(employee)
				&& isSalaryValid(employee);
	}

	private boolean isNameAndCnpValid(Employee employee) {
		return isFirstNameValid(employee) && isLastNameValid(employee) && isCnpValid(employee);
	}

	private boolean isSalaryValid(Employee employee) {
		return employee.getSalary() > 0;
	}

	private boolean isFunctionValid(Employee employee) {
		DidacticFunction function = employee.getFunction();
		return function == DidacticFunction.ASSISTENT
				|| function == DidacticFunction.LECTURER
				|| function == DidacticFunction.TEACHER
				|| function == DidacticFunction.CONFERENTIAR;
	}

	private boolean isCnpValid(Employee employee) {
		if(!employee.getCnp().matches("[0-9]{13}")) {
			System.out.println("Invalid CNP: " + employee.getCnp());
			return false;
		}

		return true;
	}

	private boolean isLastNameValid(Employee employee) {

		if (!employee.getLastName().matches("^[a-zA-Z]+$") || employee.getLastName().length() <= 2) {
			System.out.println("Invalid last name: " + employee.getLastName());
			return false;
		}

		return true;
	}

	private boolean isFirstNameValid(Employee employee) {
		if (!employee.getFirstName().matches("^[a-zA-Z]+$") || employee.getFirstName().length() <= 2) {
			System.out.println("Invalid first name: " + employee.getFirstName());
			return false;
		}
		return true;
	}
	
}


