package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.Predicate;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;

final class Filters$3
  implements Predicate<DateValue>
{
  DateValue wkStart;
  
  Filters$3(DateValue paramDateValue, Weekday paramWeekday, int paramInt)
  {
    paramDateValue = new DTBuilder(this.val$dtStart);
    paramDateValue.day -= (Weekday.valueOf(this.val$dtStart).javaDayNum + 7 - this.val$wkst.javaDayNum) % 7;
    this.wkStart = paramDateValue.toDate();
  }
  
  public boolean apply(DateValue paramDateValue)
  {
    int j = TimeUtils.daysBetween(paramDateValue, this.wkStart);
    int i = j;
    if (j < 0) {
      i = j + this.val$interval * 7 * (j / (this.val$interval * -7) + 1);
    }
    return i / 7 % this.val$interval == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Filters.3
 * JD-Core Version:    0.7.0.1
 */