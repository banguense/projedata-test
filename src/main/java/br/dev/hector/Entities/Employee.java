package br.dev.hector.Entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private BigDecimal salary;
  private String role;

  public Employee(String name, LocalDate dateOfBirth, BigDecimal salary, String role) {
    super(name, dateOfBirth);
    this.salary = salary;
    this.role = role;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public String getRole() {
    return role;
  }

  public String getEmployeeData(CurrencyFormatter formatter) {
    return "Nome: " + this.getName() + "\n"
        + "Data de nascimento: " + this.getDateOfBirth().format(FORMATTER) + "\n"
        + "Salário: R$ " + formatter.format(this.getSalary()) + "\n"
        + "Função: " + this.getRole() + "\n";
  }

  public void increaseSalary(BigDecimal percentage) {
    BigDecimal increase = this.salary.multiply(percentage);
    this.salary = this.salary.add(increase);
  }
}
