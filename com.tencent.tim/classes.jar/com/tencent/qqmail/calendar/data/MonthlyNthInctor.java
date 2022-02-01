package com.tencent.qqmail.calendar.data;

import java.util.Calendar;

class MonthlyNthInctor
  extends WeeklyInctor
{
  protected static final int LAST_WEEK_OF_MONTH = 5;
  protected int mWeekOfMonth;
  
  MonthlyNthInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
    this.mWeekOfMonth = paramQMCalendarEvent.getWeekOfMonth();
    if ((this.mWeekOfMonth < 1) || (this.mWeekOfMonth > 5))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramQMCalendarEvent.getStartTime());
      this.mWeekOfMonth = localCalendar.get(4);
    }
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    if (this.mDayOfWeek == 127)
    {
      paramCalendar.add(2, this.mInterval);
      paramCalendar.set(5, paramCalendar.getActualMaximum(5));
      return true;
    }
    return super.increment(paramCalendar);
  }
  
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    if (this.mDayOfWeek == 127) {
      paramCalendar.set(5, paramCalendar.getActualMaximum(5));
    }
    int i;
    do
    {
      return true;
      i = paramCalendar.get(4);
      if (i != this.mWeekOfMonth) {
        break;
      }
    } while ((1 << paramCalendar.get(7) - 1 & this.mDayOfWeek) > 0);
    for (;;)
    {
      return increment(paramCalendar);
      if (this.mWeekOfMonth != 5)
      {
        if (i < this.mWeekOfMonth) {
          paramCalendar.add(2, -this.mInterval);
        }
      }
      else
      {
        int k = paramCalendar.get(7);
        int j = paramCalendar.get(5);
        int m = paramCalendar.getActualMaximum(5);
        if (j <= m - 7)
        {
          paramCalendar.add(2, -this.mInterval);
        }
        else
        {
          if ((1 << k - 1 & this.mDayOfWeek) > 0) {
            break;
          }
          i = j;
          while (i <= m)
          {
            if ((1 << (k + i - j - 1) % 7 + 1 - 1 & this.mDayOfWeek) > 0)
            {
              paramCalendar.set(5, i);
              return true;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  protected void nextRecurrence(Calendar paramCalendar, int paramInt)
  {
    paramCalendar.add(2, this.mInterval);
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
 * Qualified Name:     com.tencent.qqmail.calendar.data.MonthlyNthInctor
 * JD-Core Version:    0.7.0.1
 */