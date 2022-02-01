package com.google.ical.values;

import com.google.ical.util.TimeUtils;

public enum Weekday
{
  private static Weekday[] VALUES;
  public final int javaDayNum;
  public final int jsDayNum;
  
  static
  {
    MO = new Weekday("MO", 1, 1);
    TU = new Weekday("TU", 2, 2);
    WE = new Weekday("WE", 3, 3);
    TH = new Weekday("TH", 4, 4);
    FR = new Weekday("FR", 5, 5);
    SA = new Weekday("SA", 6, 6);
    $VALUES = new Weekday[] { SU, MO, TU, WE, TH, FR, SA };
    VALUES = new Weekday[7];
    System.arraycopy(values(), 0, VALUES, 0, 7);
  }
  
  private Weekday(int paramInt)
  {
    this.jsDayNum = paramInt;
    this.javaDayNum = (paramInt + 1);
  }
  
  public static Weekday firstDayOfWeekInMonth(int paramInt1, int paramInt2)
  {
    paramInt1 = TimeUtils.fixedFromGregorian(paramInt1, paramInt2, 1) % 7;
    Weekday[] arrayOfWeekday = VALUES;
    if (paramInt1 >= 0) {}
    for (;;)
    {
      return arrayOfWeekday[paramInt1];
      paramInt1 += 7;
    }
  }
  
  public static Weekday valueOf(DateValue paramDateValue)
  {
    int j = TimeUtils.fixedFromGregorian(paramDateValue.year(), paramDateValue.month(), paramDateValue.day()) % 7;
    int i = j;
    if (j < 0) {
      i = j + 7;
    }
    return VALUES[i];
  }
  
  public Weekday predecessor()
  {
    return VALUES[((ordinal() - 1 + 7) % 7)];
  }
  
  public Weekday successor()
  {
    return VALUES[((ordinal() + 1) % 7)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.Weekday
 * JD-Core Version:    0.7.0.1
 */