package br.dev.hector.Entities;

import java.math.BigDecimal;
import java.util.List;

public class Employees {

  private List<Employee> employees;

  public Employees(List<Employee> employees) {
    if (employees == null) {
      throw new IllegalArgumentException("Employees list cannot be null");
    }
    this.employees = employees;
  }

  public List<Employee> getEmployees() {
    return List.copyOf(employees);
  }

  public void addEmployee(Employee employee) {
    this.employees.add(employee);
  }

  public void addEmployee(List<Employee> employees) {
    this.employees.addAll(employees);
  }

  public void removeEmployee(String name) {
    this.employees.removeIf(e -> e.getName().equals(name));
  }

  public void showEmployees() {
    this.employees.forEach(
        employee -> System.out.println(employee.getEmployeeData()));
  }

  public void increaseSalaries(BigDecimal percentage) {
    this.employees.forEach(
        employee -> employee.increaseSalary(percentage));
  }

}
