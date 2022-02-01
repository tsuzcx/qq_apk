package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;

class Filters
{
  static Predicate<DateValue> byDayFilter(WeekdayNum[] paramArrayOfWeekdayNum, boolean paramBoolean, Weekday paramWeekday)
  {
    return new Filters.1(paramBoolean, paramWeekday, paramArrayOfWeekdayNum);
  }
  
  static Predicate<DateValue> byMonthDayFilter(int[] paramArrayOfInt)
  {
    return new Filters.2(paramArrayOfInt);
  }
  
  static Predicate<DateValue> weekIntervalFilter(int paramInt, Weekday paramWeekday, DateValue paramDateValue)
  {
    return new Filters.3(paramDateValue, paramWeekday, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Filters
 * JD-Core Version:    0.7.0.1
 */