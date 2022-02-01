package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;

final class Generators$8
  extends Generator
{
  int[] dates;
  int doyOfStartOfWeek1;
  int i = 0;
  int month = this.val$dtStart.month();
  int weeksInYear;
  int year = this.val$dtStart.year();
  
  Generators$8(DateValue paramDateValue, Weekday paramWeekday, int[] paramArrayOfInt)
  {
    checkYear();
    checkMonth();
  }
  
  void checkMonth()
  {
    int n = TimeUtils.dayOfYear(this.year, this.month, 1);
    int i1 = (n - this.doyOfStartOfWeek1) / 7 + 1;
    int i2 = TimeUtils.monthLength(this.year, this.month);
    IntSet localIntSet = new IntSet();
    int j = 0;
    int k;
    if (j < this.val$uWeekNos.length)
    {
      k = this.val$uWeekNos[j];
      if (k >= 0) {
        break label170;
      }
      k += this.weeksInYear + 1;
    }
    label170:
    for (;;)
    {
      if ((k >= i1 - 1) && (k <= i1 + 6))
      {
        int m = 0;
        while (m < 7)
        {
          int i3 = (k - 1) * 7 + m + this.doyOfStartOfWeek1 - n + 1;
          if ((i3 >= 1) && (i3 <= i2)) {
            localIntSet.add(i3);
          }
          m += 1;
        }
      }
      j += 1;
      break;
      this.dates = localIntSet.toIntArray();
      return;
    }
  }
  
  void checkYear()
  {
    int j = 7 - (Weekday.firstDayOfWeekInMonth(this.year, 1).javaDayNum + 7 - this.val$wkst.javaDayNum) % 7;
    int k;
    if (j < 4) {
      k = 7;
    }
    for (;;)
    {
      this.doyOfStartOfWeek1 = (k - 7 + j);
      this.weeksInYear = ((TimeUtils.yearLength(this.year) - j + 6) / 7);
      return;
      k = j;
      j = 0;
    }
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    if ((this.year != paramDTBuilder.year) || (this.month != paramDTBuilder.month))
    {
      if (this.year != paramDTBuilder.year)
      {
        this.year = paramDTBuilder.year;
        checkYear();
      }
      this.month = paramDTBuilder.month;
      checkMonth();
      this.i = 0;
    }
    if (this.i >= this.dates.length) {
      return false;
    }
    int[] arrayOfInt = this.dates;
    int j = this.i;
    this.i = (j + 1);
    paramDTBuilder.day = arrayOfInt[j];
    return true;
  }
  
  public String toString()
  {
    return "byWeekNoGenerator";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.8
 * JD-Core Version:    0.7.0.1
 */