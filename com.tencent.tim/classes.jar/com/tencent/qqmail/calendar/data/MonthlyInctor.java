package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import java.util.ArrayList;
import java.util.Calendar;

class MonthlyInctor
  extends RecurrenceInctor
{
  protected int mDayOfMonth;
  protected int mDayOfWeek;
  protected ArrayList<Integer> mDaysOfWeekArrayList;
  private int mDaysOfWeekIndex = 0;
  protected int mWeekOfMonth;
  
  MonthlyInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    super(paramQMCalendarEvent);
    this.mDayOfMonth = paramQMCalendarEvent.getDayOfMonth();
    this.mWeekOfMonth = paramQMCalendarEvent.getWeekOfMonth();
    this.mDaysOfWeekArrayList = paramQMCalendarEvent.getDaysOfMonth();
    this.mDayOfWeek = QMCalendarUtil.getDayOfWeekByProtocolValue(paramQMCalendarEvent.getDayOfWeek());
    if ((this.mDaysOfWeekArrayList != null) && (this.mDaysOfWeekArrayList.size() > 1)) {
      this.mDaysOfWeekIndex = 1;
    }
    if ((this.mDayOfMonth < 1) || (this.mDayOfMonth > 31))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramQMCalendarEvent.getStartTime());
      this.mDayOfMonth = localCalendar.get(5);
    }
  }
  
  public boolean increment(Calendar paramCalendar)
  {
    if (this.mDaysOfWeekIndex == 0) {
      paramCalendar.add(2, this.mInterval);
    }
    int i = paramCalendar.getActualMaximum(5);
    if ((this.mDaysOfWeekArrayList != null) && (this.mDaysOfWeekArrayList.size() > 1))
    {
      int j = ((Integer)this.mDaysOfWeekArrayList.get(this.mDaysOfWeekIndex)).intValue();
      this.mDaysOfWeekIndex += 1;
      if (i >= j)
      {
        paramCalendar.set(5, j);
        if (this.mDaysOfWeekArrayList.size() == this.mDaysOfWeekIndex) {
          this.mDaysOfWeekIndex = 0;
        }
      }
    }
    for (;;)
    {
      return true;
      if (this.mDaysOfWeekArrayList.size() == this.mDaysOfWeekIndex) {
        this.mDaysOfWeekIndex = 0;
      }
      return increment(paramCalendar);
      if ((this.mWeekOfMonth != 0) && (this.mDayOfWeek != 0))
      {
        paramCalendar.set(7, this.mDayOfWeek);
        paramCalendar.set(8, this.mWeekOfMonth);
      }
      else
      {
        if (i < this.mDayOfMonth) {
          break;
        }
        paramCalendar.set(5, this.mDayOfMonth);
      }
    }
    return increment(paramCalendar);
  }
  
  public boolean modifyStartTime(Calendar paramCalendar)
  {
    if (paramCalendar.get(5) > this.mDayOfMonth) {
      paramCalendar.add(2, this.mInterval);
    }
    paramCalendar.set(5, this.mDayOfMonth);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.MonthlyInctor
 * JD-Core Version:    0.7.0.1
 */