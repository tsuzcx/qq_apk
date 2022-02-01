package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;

final class Filters$1
  implements Predicate<DateValue>
{
  Filters$1(boolean paramBoolean, Weekday paramWeekday, WeekdayNum[] paramArrayOfWeekdayNum) {}
  
  public boolean apply(DateValue paramDateValue)
  {
    Weekday localWeekday = Weekday.valueOf(paramDateValue);
    int i;
    Object localObject;
    int j;
    if (this.val$weeksInYear)
    {
      i = TimeUtils.yearLength(paramDateValue.year());
      localObject = Weekday.firstDayOfWeekInMonth(paramDateValue.year(), 1);
      j = TimeUtils.dayOfYear(paramDateValue.year(), paramDateValue.month(), paramDateValue.day());
      paramDateValue = (DateValue)localObject;
      if (this.val$wkst.javaDayNum > localWeekday.javaDayNum) {
        break label181;
      }
      j = j / 7 + 1;
    }
    label82:
    int m;
    for (int k = this.val$days.length;; k = m)
    {
      m = k - 1;
      if (m < 0) {
        break label222;
      }
      localObject = this.val$days[m];
      if (((WeekdayNum)localObject).wday == localWeekday)
      {
        int n = ((WeekdayNum)localObject).num;
        if (n == 0)
        {
          return true;
          i = TimeUtils.monthLength(paramDateValue.year(), paramDateValue.month());
          localObject = Weekday.firstDayOfWeekInMonth(paramDateValue.year(), paramDateValue.month());
          j = paramDateValue.day() - 1;
          paramDateValue = (DateValue)localObject;
          break;
          label181:
          j /= 7;
          break label82;
        }
        k = n;
        if (n < 0) {
          k = Util.invertWeekdayNum((WeekdayNum)localObject, paramDateValue, i);
        }
        if (j == k) {
          return true;
        }
      }
    }
    label222:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Filters.1
 * JD-Core Version:    0.7.0.1
 */