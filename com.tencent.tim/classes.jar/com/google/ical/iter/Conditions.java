package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.values.DateValue;

final class Conditions
{
  static Predicate<DateValue> countCondition(int paramInt)
  {
    return new Conditions.1(paramInt);
  }
  
  static Predicate<DateValue> untilCondition(DateValue paramDateValue)
  {
    return new Conditions.2(paramDateValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Conditions
 * JD-Core Version:    0.7.0.1
 */