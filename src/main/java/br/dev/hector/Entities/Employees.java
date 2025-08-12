package br.dev.hector.Entities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Employees {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");
  private static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(LOCALE_BR);
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00", SYMBOLS);

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
        employee -> System.out.println(
            "Nome: " + employee.getName() + "\n"
                + "Data de nascimento: " + employee.getDateOfBirth().format(FORMATTER) + "\n"
                + "Salário: R$ " + DECIMAL_FORMAT.format(employee.getSalary()) + "\n"
                + "Função: " + employee.getRole() + "\n"));
  }
}
