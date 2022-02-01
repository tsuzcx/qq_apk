package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.values.DateValue;

final class Generators$5
  extends Generator
{
  int i;
  int year = this.val$dtStart.year();
  
  Generators$5(DateValue paramDateValue, int[] paramArrayOfInt) {}
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    if (this.year != paramDTBuilder.year)
    {
      this.i = 0;
      this.year = paramDTBuilder.year;
    }
    if (this.i >= this.val$umonths.length) {
      return false;
    }
    int[] arrayOfInt = this.val$umonths;
    int j = this.i;
    this.i = (j + 1);
    paramDTBuilder.month = arrayOfInt[j];
    return true;
  }
  
  public String toString()
  {
    return "byMonthGenerator";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.5
 * JD-Core Version:    0.7.0.1
 */