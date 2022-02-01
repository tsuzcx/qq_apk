package com.google.ical.iter;

import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;

final class Generators
{
  private static final int MAX_YEARS_BETWEEN_INSTANCES = 100;
  
  static Generator byDayGenerator(WeekdayNum[] paramArrayOfWeekdayNum, boolean paramBoolean, DateValue paramDateValue)
  {
    return new Generators.7(paramDateValue, paramBoolean, (WeekdayNum[])paramArrayOfWeekdayNum.clone());
  }
  
  static Generator byMonthDayGenerator(int[] paramArrayOfInt, DateValue paramDateValue)
  {
    return new Generators.6(paramDateValue, Util.uniquify(paramArrayOfInt));
  }
  
  static Generator byMonthGenerator(int[] paramArrayOfInt, DateValue paramDateValue)
  {
    return new Generators.5(paramDateValue, Util.uniquify(paramArrayOfInt));
  }
  
  static Generator byWeekNoGenerator(int[] paramArrayOfInt, Weekday paramWeekday, DateValue paramDateValue)
  {
    return new Generators.8(paramDateValue, paramWeekday, Util.uniquify(paramArrayOfInt));
  }
  
  static Generator byYearDayGenerator(int[] paramArrayOfInt, DateValue paramDateValue)
  {
    return new Generators.9(paramDateValue, Util.uniquify(paramArrayOfInt));
  }
  
  static Generator byYearGenerator(int[] paramArrayOfInt, DateValue paramDateValue)
  {
    return new Generators.4(Util.uniquify(paramArrayOfInt), paramDateValue);
  }
  
  static Generator serialDayGenerator(int paramInt, DateValue paramDateValue)
  {
    return new Generators.3(paramDateValue, paramInt);
  }
  
  static Generator serialMonthGenerator(int paramInt, DateValue paramDateValue)
  {
    return new Generators.2(paramDateValue, paramInt);
  }
  
  static ThrottledGenerator serialYearGenerator(int paramInt, DateValue paramDateValue)
  {
    return new Generators.1(paramDateValue, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators
 * JD-Core Version:    0.7.0.1
 */