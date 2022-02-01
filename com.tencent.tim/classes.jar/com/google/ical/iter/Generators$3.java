package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.DateValueImpl;

final class Generators$3
  extends Generator
{
  int date;
  int month;
  int nDays;
  int year;
  
  Generators$3(DateValue paramDateValue, int paramInt)
  {
    paramDateValue = new DTBuilder(this.val$dtStart);
    paramDateValue.day -= this.val$interval;
    paramDateValue = paramDateValue.toDate();
    this.year = paramDateValue.year();
    this.month = paramDateValue.month();
    this.date = paramDateValue.day();
    this.nDays = TimeUtils.monthLength(this.year, this.month);
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    int j;
    int i;
    if ((this.year == paramDTBuilder.year) && (this.month == paramDTBuilder.month))
    {
      j = this.date + this.val$interval;
      i = j;
      if (j > this.nDays) {
        return false;
      }
    }
    else
    {
      this.nDays = TimeUtils.monthLength(paramDTBuilder.year, paramDTBuilder.month);
      if (this.val$interval != 1)
      {
        i = TimeUtils.daysBetween(new DateValueImpl(paramDTBuilder.year, paramDTBuilder.month, 1), new DateValueImpl(this.year, this.month, this.date));
        j = (this.val$interval - i % this.val$interval) % this.val$interval + 1;
        i = j;
        if (j > this.nDays) {
          return false;
        }
      }
      else
      {
        i = 1;
      }
      this.year = paramDTBuilder.year;
      this.month = paramDTBuilder.month;
    }
    paramDTBuilder.day = i;
    this.date = i;
    return true;
  }
  
  public String toString()
  {
    return "serialDayGenerator:" + this.val$interval;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.3
 * JD-Core Version:    0.7.0.1
 */