package br.dev.hector.Entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Employee extends Person {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");
  private static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(LOCALE_BR);
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00", SYMBOLS);

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

  public String getEmployeeData() {
    return "Nome: " + this.getName() + "\n"
        + "Data de nascimento: " + this.getDateOfBirth().format(FORMATTER) + "\n"
        + "Salário: R$ " + DECIMAL_FORMAT.format(this.getSalary()) + "\n"
        + "Função: " + this.getRole() + "\n";
  }
}
