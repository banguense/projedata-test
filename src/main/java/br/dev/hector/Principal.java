package br.dev.hector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.dev.hector.Entities.CurrencyFormatter;
import br.dev.hector.Entities.Employee;
import br.dev.hector.Entities.Employees;
import br.dev.hector.Entities.RealFormatter;

public class Principal {
  public static void main(String[] args) {
    List<Employee> listEmployee = new ArrayList<>(List.of(
        new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
        new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
        new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
        new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
        new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
        new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
        new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
        new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
        new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
        new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")));
    Employees employees = new Employees(listEmployee);

    System.out.println("==================3.3==============");

    employees.removeEmployee("João");
    employees.showEmployees();

    System.out.println("=================3.4===============");

    employees.increaseSalaries(new BigDecimal("10"));
    employees.showEmployees();

    System.out.println("================3.5/3.6================");

    Map<String, List<Employee>> group = employees.groupByRole();

    for (Map.Entry<String, List<Employee>> entry : group.entrySet()) {
      System.out.println(entry.getKey());
      for (Employee employee : entry.getValue()) {
        System.out.println(employee.getEmployeeData());
      }
      System.out.println("-------------------------");
    }

    System.out.println("===============3.8=================");

    List<Employee> employeesBirthOnOctuberAndDecember = employees.getEmployees().stream()
        .filter(employee -> {
          int month = employee.getDateOfBirth().getMonthValue();
          return month == 10 || month == 12;
        }).collect(Collectors.toList());

    employeesBirthOnOctuberAndDecember.forEach(e -> System.out.println(e.getEmployeeData()));

    System.out.println("================3.9================");

    Optional<Employee> oldest = employees.getEmployees().stream()
        .min(Comparator.comparing(Employee::getDateOfBirth));

    oldest.ifPresent(e -> System.out.println(
        "Nome: " + e.getName() + "\n"
            + "Idade: " + (LocalDate.now().getYear() - e.getDateOfBirth().getYear())));

    System.out.println("================3.10================");

    employees.getEmployees().stream().sorted(Comparator.comparing(Employee::getName)).forEach(
        e -> System.out.println(e.getEmployeeData()));

    System.out.println("==================3.11==============");

    CurrencyFormatter formatter = RealFormatter.getInstance();

    BigDecimal salariesSum = employees.getAllSalariesSum();

    System.out.println("Total de Salários: R$ " + formatter.format(salariesSum));

    System.out.println("=================3.12===============");

    BigDecimal minimum = new BigDecimal("1212.00");
    employees.getEmployees().forEach(
        employee -> {
          BigDecimal salary = employee.getSalary();
          System.out.println(
              "Nome: " + employee.getName() + "\n"
                  + "Salários mínimos: " + salary.divide(minimum, 2, RoundingMode.HALF_UP)
                  + "\n--------------------------");
        });
  }
}
