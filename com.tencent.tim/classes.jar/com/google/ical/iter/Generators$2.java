package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.values.DateValue;

final class Generators$2
  extends Generator
{
  int month = this.val$dtStart.month() - this.val$interval;
  int year = this.val$dtStart.year();
  
  Generators$2(DateValue paramDateValue, int paramInt)
  {
    while (this.month < 1)
    {
      this.month += 12;
      this.year -= 1;
    }
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    int i;
    int j;
    if (this.year != paramDTBuilder.year)
    {
      i = paramDTBuilder.year;
      j = this.year;
      int k = this.month;
      i = (this.val$interval - ((i - j) * 12 - (k - 1)) % this.val$interval) % this.val$interval + 1;
      if (i > 12) {
        return false;
      }
      this.year = paramDTBuilder.year;
    }
    do
    {
      paramDTBuilder.month = i;
      this.month = i;
      return true;
      j = this.month + this.val$interval;
      i = j;
    } while (j <= 12);
    return false;
  }
  
  public String toString()
  {
    return "serialMonthGenerator:" + this.val$interval;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.2
 * JD-Core Version:    0.7.0.1
 */