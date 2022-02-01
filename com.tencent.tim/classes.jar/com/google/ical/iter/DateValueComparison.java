package com.google.ical.iter;

import com.google.ical.values.DateValue;
import com.google.ical.values.TimeValue;

final class DateValueComparison
{
  static long comparable(DateValue paramDateValue)
  {
    long l = ((paramDateValue.year() << 4) + paramDateValue.month() << 5) + paramDateValue.day();
    if ((paramDateValue instanceof TimeValue))
    {
      paramDateValue = (TimeValue)paramDateValue;
      return (((l << 5) + paramDateValue.hour() << 6) + paramDateValue.minute() << 6) + paramDateValue.second() + 1L;
    }
    return l << 17;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.DateValueComparison
 * JD-Core Version:    0.7.0.1
 */