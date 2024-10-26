package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockRepositoryImplTest {
    EmployeeMockRepositoryImpl repoMock;

    @BeforeEach
    void modifyEmployeeFunction() {
        repoMock  = new EmployeeMockRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void modifyEmployeeFunction_TC1() {
        System.out.println("=== Start TC1\n");
        Employee Marius = repoMock.getEmployeeList().stream().filter(employee -> employee.getId() == 1).findFirst().get();

        assertNotNull(Marius, "Angajatul Marius nu a fost găsit în lista existentă");
        System.out.println("Funcția inițială a lui Marius: " + Marius.getFunction());

        assertEquals(DidacticFunction.ASSISTENT, Marius.getFunction(), "Funcția inițială a lui Marius nu este ASISTENT.");


        repoMock.modifyEmployeeFunction(Marius, DidacticFunction.LECTURER);
        System.out.println("Funcția după modificare a lui Marius: " + Marius.getFunction());

        assertEquals(DidacticFunction.LECTURER, Marius.getFunction(), "Funcția lui Marius nu a fost schimbată în LECTURER.");
        System.out.println("\n=== End TC1\n");
    }

    @Test
    void modifyEmployeeFunction_TC2() {
        System.out.println("=== Start TC2\n");
        Employee MariusNull = null;
        DidacticFunction newFunction = DidacticFunction.LECTURER;

        assertDoesNotThrow(() -> repoMock.modifyEmployeeFunction(MariusNull, newFunction));
        System.out.println("Nu s-a modificat functia");

        System.out.println("\n=== End TC2\n");
    }
}