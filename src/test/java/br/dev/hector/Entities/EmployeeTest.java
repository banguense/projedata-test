package br.dev.hector.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  public void shouldIncreaseSalaryTenPercent() {

    Employee employee = new Employee("João",
        LocalDate.of(1990, 5, 12),
        new BigDecimal("2000.00"),
        "Operador");

    employee.increaseSalary(new BigDecimal("0.10"));

    BigDecimal expected = new BigDecimal("2200.00");
    assertEquals(0, expected.compareTo(employee.getSalary()));
  }
}
