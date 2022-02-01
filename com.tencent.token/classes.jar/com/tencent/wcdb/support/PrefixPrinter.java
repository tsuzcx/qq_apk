package com.tencent.wcdb.support;

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
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramPrinter;
      }
      return new PrefixPrinter(paramPrinter, paramString);
    }
    return paramPrinter;
  }
  
  public void println(String paramString)
  {
    Printer localPrinter = this.mPrinter;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPrefix);
    localStringBuilder.append(paramString);
    localPrinter.println(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.PrefixPrinter
 * JD-Core Version:    0.7.0.1
 */