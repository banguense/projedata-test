package br.dev.hector.Entities;

import java.math.BigDecimal;

public interface CurrencyFormatter {

  public String format(BigDecimal amount);
}
