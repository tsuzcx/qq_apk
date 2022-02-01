package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateValue;

final class Filters$2
  implements Predicate<DateValue>
{
  Filters$2(int[] paramArrayOfInt) {}
  
  public boolean apply(DateValue paramDateValue)
  {
    int m = TimeUtils.monthLength(paramDateValue.year(), paramDateValue.month());
    int j;
    for (int i = this.val$monthDays.length;; i = j)
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      int k = this.val$monthDays[j];
      i = k;
      if (k < 0) {
        i = k + (m + 1);
      }
      if (i == paramDateValue.day()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Filters.2
 * JD-Core Version:    0.7.0.1
 */