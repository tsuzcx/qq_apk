package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import java.util.Calendar;

class YearlyInctor
  extends RecurrenceInctor
{
  protected int mDayOfMonth;
  protected int mMonthOfYear;
  
  YearlyInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
    this.mMonthOfYear = paramQMCalendarEvent.getMonthOfYear();
    this.mDayOfMonth = paramQMCalendarEvent.getDayOfMonth();
    if ((this.mMonthOfYear < 1) || (this.mMonthOfYear > 12) || (this.mDayOfMonth < 1) || (this.mDayOfMonth > 31))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramQMCalendarEvent.getStartTime());
      this.mMonthOfYear = (localCalendar.get(2) + 1);
      this.mDayOfMonth = localCalendar.get(5);
    }
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    if ((this.mMonthOfYear == 2) && (this.mDayOfMonth == 29))
    {
      int i = paramCalendar.get(1) + this.mInterval;
      while (!QMCalendarUtil.isLeapYear(i)) {
        i += this.mInterval;
      }
      paramCalendar.set(1, i);
      paramCalendar.set(2, this.mMonthOfYear - 1);
    }
    for (;;)
    {
      paramCalendar.set(5, this.mDayOfMonth);
      return true;
      paramCalendar.add(1, this.mInterval);
    }
  }
  
  @Deprecated
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    int i = paramCalendar.get(2);
    int j = paramCalendar.get(5);
    if ((i > this.mMonthOfYear) || ((i == this.mMonthOfYear) && (j > this.mDayOfMonth))) {
      paramCalendar.add(1, this.mInterval);
    }
    paramCalendar.set(2, this.mMonthOfYear - 1);
    paramCalendar.set(5, this.mDayOfMonth);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.YearlyInctor
 * JD-Core Version:    0.7.0.1
 */