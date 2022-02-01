package com.tencent.qqmail.calendar.data;

import java.util.Calendar;

class YearlyNthInctor
  extends MonthlyNthInctor
{
  protected int mMonthOfYear;
  
  YearlyNthInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
    this.mMonthOfYear = paramQMCalendarEvent.getMonthOfYear();
    if ((this.mMonthOfYear < 1) || (this.mMonthOfYear > 12))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramQMCalendarEvent.getStartTime());
      this.mMonthOfYear = (localCalendar.get(2) + 1);
    }
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    if (this.mDayOfWeek == 127)
    {
      paramCalendar.add(1, this.mInterval);
      paramCalendar.set(2, this.mMonthOfYear - 1);
      paramCalendar.set(5, paramCalendar.getActualMaximum(5));
      return true;
    }
    return super.increment(paramCalendar);
  }
  
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    boolean bool = true;
    int i = paramCalendar.get(2);
    if (i < this.mMonthOfYear) {
      paramCalendar.add(1, -this.mInterval);
    }
    for (;;)
    {
      bool = increment(paramCalendar);
      int k;
      int j;
      int m;
      do
      {
        return bool;
        if (i != this.mMonthOfYear) {
          break;
        }
        if (this.mDayOfWeek == 127)
        {
          paramCalendar.set(5, paramCalendar.getActualMaximum(5));
          return true;
        }
        i = paramCalendar.get(4);
        if (i == this.mWeekOfMonth)
        {
          if ((1 << paramCalendar.get(7) - 1 & this.mDayOfWeek) <= 0) {
            break;
          }
          return true;
        }
        if (this.mWeekOfMonth != 5)
        {
          if (i >= this.mWeekOfMonth) {
            break;
          }
          paramCalendar.add(1, -this.mInterval);
          break;
        }
        k = paramCalendar.get(7);
        j = paramCalendar.get(5);
        m = paramCalendar.getActualMaximum(5);
        if (j <= m - 7)
        {
          paramCalendar.add(1, -this.mInterval);
          break;
        }
      } while ((1 << k - 1 & this.mDayOfWeek) > 0);
      i = j;
      while (i <= m)
      {
        int n = (k + i - j - 1) % 7 + 1;
        if ((n & this.mDayOfWeek) > 0)
        {
          paramCalendar.set(5, i);
          return true;
        }
        i += 1;
      }
    }
  }
  
  protected void nextRecurrence(Calendar paramCalendar, int paramInt)
  {
    paramCalendar.add(1, this.mInterval);
    paramCalendar.set(2, this.mMonthOfYear - 1);
    int i = paramCalendar.get(5);
    int j = paramCalendar.get(8);
    int k = paramCalendar.get(7);
    paramInt = i + (this.mWeekOfMonth - j) * 7 + (paramInt - k);
    i = paramInt - ((paramInt + 6) / 7 - this.mWeekOfMonth) * 7;
    paramInt = i;
    if (i > paramCalendar.getActualMaximum(5)) {
      paramInt = i - 7;
    }
    paramCalendar.set(5, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.YearlyNthInctor
 * JD-Core Version:    0.7.0.1
 */