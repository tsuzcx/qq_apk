package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;

final class Generators$9
  extends Generator
{
  int[] dates;
  int i = 0;
  int month = this.val$dtStart.month();
  int year = this.val$dtStart.year();
  
  Generators$9(DateValue paramDateValue, int[] paramArrayOfInt)
  {
    checkMonth();
  }
  
  void checkMonth()
  {
    int n = TimeUtils.dayOfYear(this.year, this.month, 1);
    int i1 = TimeUtils.monthLength(this.year, this.month);
    int i2 = TimeUtils.yearLength(this.year);
    IntSet localIntSet = new IntSet();
    int j = 0;
    while (j < this.val$uYearDays.length)
    {
      int m = this.val$uYearDays[j];
      int k = m;
      if (m < 0) {
        k = m + (i2 + 1);
      }
      k -= n;
      if ((k >= 1) && (k <= i1)) {
        localIntSet.add(k);
      }
      j += 1;
    }
    this.dates = localIntSet.toIntArray();
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    if ((this.year != paramDTBuilder.year) || (this.month != paramDTBuilder.month))
    {
      this.year = paramDTBuilder.year;
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
    return "byYearDayGenerator";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.9
 * JD-Core Version:    0.7.0.1
 */