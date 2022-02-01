package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;

final class Generators$6
  extends Generator
{
  int i = 0;
  int month = this.val$dtStart.month();
  int[] posDates;
  int year = this.val$dtStart.year();
  
  Generators$6(DateValue paramDateValue, int[] paramArrayOfInt)
  {
    convertDatesToAbsolute();
  }
  
  private void convertDatesToAbsolute()
  {
    IntSet localIntSet = new IntSet();
    int n = TimeUtils.monthLength(this.year, this.month);
    int j = 0;
    while (j < this.val$udates.length)
    {
      int m = this.val$udates[j];
      int k = m;
      if (m < 0) {
        k = m + (n + 1);
      }
      if ((k >= 1) && (k <= n)) {
        localIntSet.add(k);
      }
      j += 1;
    }
    this.posDates = localIntSet.toIntArray();
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    if ((this.year != paramDTBuilder.year) || (this.month != paramDTBuilder.month))
    {
      this.year = paramDTBuilder.year;
      this.month = paramDTBuilder.month;
      convertDatesToAbsolute();
      this.i = 0;
    }
    if (this.i >= this.posDates.length) {
      return false;
    }
    int[] arrayOfInt = this.posDates;
    int j = this.i;
    this.i = (j + 1);
    paramDTBuilder.day = arrayOfInt[j];
    return true;
  }
  
  public String toString()
  {
    return "byMonthDayGenerator";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.6
 * JD-Core Version:    0.7.0.1
 */