package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.values.DateValue;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;

class Util
{
  static
  {
    if (!Util.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  static int countInPeriod(Weekday paramWeekday1, Weekday paramWeekday2, int paramInt)
  {
    if (paramWeekday1.javaDayNum >= paramWeekday2.javaDayNum) {
      return (paramInt - (paramWeekday1.javaDayNum - paramWeekday2.javaDayNum) - 1) / 7 + 1;
    }
    return (paramInt - (7 - (paramWeekday2.javaDayNum - paramWeekday1.javaDayNum)) - 1) / 7 + 1;
  }
  
  static int dayNumToDate(Weekday paramWeekday1, int paramInt1, int paramInt2, Weekday paramWeekday2, int paramInt3, int paramInt4)
  {
    int i = (paramWeekday2.javaDayNum + 7 - paramWeekday1.javaDayNum) % 7 + 1;
    if (paramInt2 > 0) {}
    for (paramInt1 = i + (paramInt2 - 1) * 7 - paramInt3;; paramInt1 = i - (i - paramInt1 + 6) / 7 * 7 + (paramInt2 + 1) * 7 - paramInt3)
    {
      if (paramInt1 > 0)
      {
        paramInt2 = paramInt1;
        if (paramInt1 <= paramInt4) {}
      }
      else
      {
        paramInt2 = 0;
      }
      return paramInt2;
      i += 378;
    }
  }
  
  static int invertWeekdayNum(WeekdayNum paramWeekdayNum, Weekday paramWeekday, int paramInt)
  {
    assert (paramWeekdayNum.num < 0);
    return countInPeriod(paramWeekdayNum.wday, paramWeekday, paramInt) + paramWeekdayNum.num + 1;
  }
  
  static DateValue nextWeekStart(DateValue paramDateValue, Weekday paramWeekday)
  {
    DTBuilder localDTBuilder = new DTBuilder(paramDateValue);
    localDTBuilder.day += (7 - (Weekday.valueOf(paramDateValue).javaDayNum - paramWeekday.javaDayNum + 7) % 7) % 7;
    return localDTBuilder.toDate();
  }
  
  static void rollToNextWeekStart(DTBuilder paramDTBuilder, Weekday paramWeekday)
  {
    DateValue localDateValue = paramDTBuilder.toDate();
    int i = paramDTBuilder.day;
    paramDTBuilder.day = ((7 - (Weekday.valueOf(localDateValue).javaDayNum - paramWeekday.javaDayNum + 7) % 7) % 7 + i);
    paramDTBuilder.normalize();
  }
  
  static int[] uniquify(int[] paramArrayOfInt)
  {
    IntSet localIntSet = new IntSet();
    int i = paramArrayOfInt.length;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localIntSet.add(paramArrayOfInt[i]);
    }
    return localIntSet.toIntArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Util
 * JD-Core Version:    0.7.0.1
 */