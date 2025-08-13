package br.dev.hector.Entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class RealFormatter implements CurrencyFormatter {
  private static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");
  private static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(LOCALE_BR);
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00", SYMBOLS);

  private static final RealFormatter INSTANCE = new RealFormatter();

  private RealFormatter() {
  }

  public static RealFormatter getInstance() {
    return INSTANCE;
  }

  @Override
  public String format(BigDecimal amount) {
    return DECIMAL_FORMAT.format(amount);
  }

}
