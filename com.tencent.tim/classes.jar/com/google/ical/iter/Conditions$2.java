package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.values.DateValue;

final class Conditions$2
  implements Predicate<DateValue>
{
  Conditions$2(DateValue paramDateValue) {}
  
  public boolean apply(DateValue paramDateValue)
  {
    return paramDateValue.compareTo(this.val$until) <= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Conditions.2
 * JD-Core Version:    0.7.0.1
 */