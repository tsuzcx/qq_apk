package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;
import java.util.Arrays;

final class Generators$7
  extends Generator
{
  int[] dates;
  int i = 0;
  int month = this.val$dtStart.month();
  int year = this.val$dtStart.year();
  
  Generators$7(DateValue paramDateValue, boolean paramBoolean, WeekdayNum[] paramArrayOfWeekdayNum)
  {
    generateDates();
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    if ((this.year != paramDTBuilder.year) || (this.month != paramDTBuilder.month))
    {
      this.year = paramDTBuilder.year;
      this.month = paramDTBuilder.month;
      generateDates();
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
  
  void generateDates()
  {
    int i1 = TimeUtils.monthLength(this.year, this.month);
    int j;
    Weekday localWeekday;
    int k;
    int i2;
    IntSet localIntSet;
    int m;
    label68:
    WeekdayNum localWeekdayNum;
    int n;
    if (this.val$weeksInYear)
    {
      j = TimeUtils.yearLength(this.year);
      localWeekday = Weekday.firstDayOfWeekInMonth(this.year, 1);
      k = TimeUtils.dayOfYear(this.year, this.month, 1);
      i2 = k / 7;
      localIntSet = new IntSet();
      m = 0;
      if (m >= this.val$udays.length) {
        break label207;
      }
      localWeekdayNum = this.val$udays[m];
      if (localWeekdayNum.num == 0) {
        break label154;
      }
      n = Util.dayNumToDate(localWeekday, j, localWeekdayNum.num, localWeekdayNum.wday, k, i1);
      if (n != 0) {
        localIntSet.add(n);
      }
    }
    for (;;)
    {
      m += 1;
      break label68;
      localWeekday = Weekday.firstDayOfWeekInMonth(this.year, this.month);
      k = 0;
      j = i1;
      break;
      label154:
      n = i2;
      while (n <= i2 + 6)
      {
        int i3 = Util.dayNumToDate(localWeekday, j, n, localWeekdayNum.wday, k, i1);
        if (i3 != 0) {
          localIntSet.add(i3);
        }
        n += 1;
      }
    }
    label207:
    this.dates = localIntSet.toIntArray();
  }
  
  public String toString()
  {
    return "byDayGenerator:" + Arrays.toString(this.val$udays);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.7
 * JD-Core Version:    0.7.0.1
 */