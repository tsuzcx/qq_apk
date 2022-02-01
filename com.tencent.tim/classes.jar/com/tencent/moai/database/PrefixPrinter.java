package com.tencent.moai.database;

import android.util.Printer;

public class PrefixPrinter
  implements Printer
{
  private final String mPrefix;
  private final Printer mPrinter;
  
  private PrefixPrinter(Printer paramPrinter, String paramString)
  {
    this.mPrinter = paramPrinter;
    this.mPrefix = paramString;
  }
  
  public static Printer create(Printer paramPrinter, String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return paramPrinter;
    }
    return new PrefixPrinter(paramPrinter, paramString);
  }
  
  public void println(String paramString)
  {
    this.mPrinter.println(this.mPrefix + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.PrefixPrinter
 * JD-Core Version:    0.7.0.1
 */