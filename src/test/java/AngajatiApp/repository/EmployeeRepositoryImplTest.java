package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {

    private EmployeeRepositoryInterface employeeRepo;
    private int initEmployeeListLength;

    @BeforeEach
    void setUp() {
        employeeRepo = new EmployeeRepositoryImpl();
        initEmployeeListLength = employeeRepo.getEmployeeList().size();
    }

    @AfterEach
    void tearDown() {
        employeeRepo = null;
        initEmployeeListLength = 0;
    }

    // Test Case 1: Valid Employee
    // [TC1_EC  TC1_BVA]
    // [TC1_EC	TC7_BVA]
    // [TC1_EC	TC13_BVA]
    // [TC1_EC	TC14_BVA]
    // [TC1_EC	TC15_BVA]
    // [TC1_EC	TC19_BVA]
    // [TC1_EC	TC25_BVA]
    @Test
    void addEmployee_ValidEmployee_TC1() {
        try {
            System.out.println("Test Case 1: Valid Employee");
            Employee employee = new Employee("John", "Doe", "1234557890878", DidacticFunction.ASSISTENT, 4000d);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertTrue(result, "UTILIZATOR-UL nu este adăugat cu succes / Se arunca o excepție");
            assertEquals(initEmployeeListLength + 1, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați ar trebui să crească cu 1 după adăugarea unui angajat valid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 2: Invalid firstName length = 2 [TC2_BVA]
    @Test
    void addEmployee_InvalidFirstNameLength_TC2() {
        try {
            System.out.println("Test Case 2: Invalid firstName length = 2");
            Employee employee = new Employee("Jo", "Doe", "1234567890123", DidacticFunction.LECTURER, 5000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 3: Invalid secondName contains numbers [TC3_EC;TC8_BVA]
    @Test
    void addEmployee_InvalidSecondName_TC3() {
        try {
            System.out.println("Test Case 3: Invalid secondName contains numbers");
            Employee employee = new Employee("John", "D123", "9345817264093", DidacticFunction.CONFERENTIAR, 6000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 4: Invalid CNP with special characters [TC6_EC;TC17_BVA]
    @Test
    void addEmployee_InvalidCNPWithSpecialCharacters_TC4() {
        try {
            System.out.println("Test Case 4: Invalid CNP with special characters");
            Employee employee = new Employee("John", "Doe", "123JD34567890", DidacticFunction.ASSISTENT, 4000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 5: Invalid CNP is duplicated [TC4_EC;TC16_BVA]
    @Test
    void addEmployee_InvalidCNPIsDuplicated_TC5() {
        try {
            System.out.println("Test Case 5: Invalid CNP is duplicated");
            Employee employee = new Employee("John", "Doe", "1235567892876", DidacticFunction.ASSISTENT, 4000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 6: Invalid CNP is less or more than 13 characters [TC5_EC;TC18_BVA]
    @Test
    void addEmployee_InvalidCNPLength_TC6() {
        try {
            System.out.println("Test Case 6: Invalid CNP is less or more than 13 characters");
            Employee employee = new Employee("John", "Doe", "12345678", DidacticFunction.CONFERENTIAR, 6000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 7: Invalid function is diff from the enum [TC7_EC;TC20_BVA]
    @Test
    void addEmployee_InvalidFunctionRole_TC7() {
        try {
            System.out.println("Test Case 7: Invalid function is diff from the enum");
            Employee employee = new Employee("John", "Doe", "12345678", DidacticFunction.valueOf("MANAGER"), 6000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (IllegalArgumentException eia) {
            System.out.println(eia.getMessage());
            assertTrue(true, "UTILIZATOR-UL este adăugat / Nu sa aruncat o excepție");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 8: Invalid Salary < 0 [TC8_EC;TC27_BVA]
    @Test
    void addEmployee_InvalidSalaryNegative_TC8() {
        try {
            System.out.println("Test Case 8: Invalid Salary < 0");
            Employee employee = new Employee("John", "Doe", "1234567890123", DidacticFunction.TEACHER, -2000.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }

    // Test Case 9: Invalid Employee with salary = 0 [TC26_BVA]
    @Test
    void addEmployee_ValidSalaryZero_TC9() {
        try {
            System.out.println("Test Case 9: Invalid Employee with salary = 0");
            Employee employee = new Employee("John", "Doe", "1234567890123", DidacticFunction.ASSISTENT, 0.0);
            System.out.println("Employee created: " + employee);

            boolean result = employeeRepo.addEmployee(employee);
            System.out.println("Employee added: " + result);

            assertFalse(result, "UTILIZATOR-UL este adăugat cu succes / Nu s-a aruncat o excepție");
            assertEquals(initEmployeeListLength, employeeRepo.getEmployeeList().size(), "Lungimea listei de angajați nu ar trebui să se schimbe după încercarea de a adăuga un angajat invalid");
        } catch (RuntimeException e) {
            fail(e.getMessage());
        }
    }
}