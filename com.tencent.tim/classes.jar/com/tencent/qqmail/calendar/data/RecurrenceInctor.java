package com.tencent.qqmail.calendar.data;

import android.util.Log;
import com.tencent.qqmail.calendar.util.QMLunarCalendarUtils;
import java.util.Calendar;

public abstract class RecurrenceInctor
{
  protected int mInterval = 1;
  
  protected RecurrenceInctor(QMCalendarEvent paramQMCalendarEvent)
  {
    this.mInterval = paramQMCalendarEvent.getInterval();
    if (this.mInterval <= 0) {
      this.mInterval = 1;
    }
  }
  
  public static void correctStartTimeForLunarCalendar(Calendar paramCalendar, QMCalendarEvent paramQMCalendarEvent)
  {
    int j = 0;
    QMLunarCalendar localQMLunarCalendar = QMLunarCalendarUtils.getLunarCalendarDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
    int i;
    if ((paramQMCalendarEvent.getRecurrenceType() == 5) && ((paramQMCalendarEvent.getDayOfMonth() != localQMLunarCalendar.getDay()) || (paramQMCalendarEvent.getMonthOfYear() != localQMLunarCalendar.getMonth())))
    {
      localQMLunarCalendar.setDay(paramQMCalendarEvent.getDayOfMonth());
      localQMLunarCalendar.setMonth(paramQMCalendarEvent.getMonthOfYear());
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramQMCalendarEvent = QMLunarCalendarUtils.lunarToSolar(localQMLunarCalendar);
        paramCalendar.set(1, paramQMCalendarEvent.getYear());
        paramCalendar.set(2, paramQMCalendarEvent.getMonth() - 1);
        paramCalendar.set(5, paramQMCalendarEvent.getDay());
      }
      return;
      i = j;
      if (paramQMCalendarEvent.getRecurrenceType() == 2)
      {
        i = j;
        if (paramQMCalendarEvent.getDayOfMonth() != localQMLunarCalendar.getDay())
        {
          localQMLunarCalendar.setDay(paramQMCalendarEvent.getDayOfMonth());
          i = 1;
        }
      }
    }
  }
  
  public static RecurrenceInctor createInstance(QMCalendarEvent paramQMCalendarEvent)
  {
    switch (paramQMCalendarEvent.getRecurrenceType())
    {
    case 4: 
    default: 
      return new DefaultInctor(paramQMCalendarEvent);
    case 0: 
      return new DailyInctor(paramQMCalendarEvent);
    case 1: 
    case 7: 
      return new WeeklyInctor(paramQMCalendarEvent);
    case 2: 
      return new MonthlyInctor(paramQMCalendarEvent);
    case 3: 
      return new MonthlyNthInctor(paramQMCalendarEvent);
    case 5: 
      return new YearlyInctor(paramQMCalendarEvent);
    }
    return new YearlyNthInctor(paramQMCalendarEvent);
  }
  
  public static void increaseForLunarCalendar(Calendar paramCalendar, QMCalendarEvent paramQMCalendarEvent)
  {
    Object localObject = QMLunarCalendarUtils.getLunarCalendarDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
    if (paramQMCalendarEvent.getRecurrenceType() == 5)
    {
      ((QMLunarCalendar)localObject).setDay(paramQMCalendarEvent.getDayOfMonth());
      ((QMLunarCalendar)localObject).setMonth(paramQMCalendarEvent.getMonthOfYear());
      ((QMLunarCalendar)localObject).setYear(((QMLunarCalendar)localObject).getYear() + 1);
      ((QMLunarCalendar)localObject).setIsLeapMonth(((QMLunarCalendar)localObject).isLeapMonth());
      if ((((QMLunarCalendar)localObject).isLeapMonth()) && (QMLunarCalendarUtils.leapMonth(((QMLunarCalendar)localObject).getYear()) != ((QMLunarCalendar)localObject).getMonth())) {
        ((QMLunarCalendar)localObject).setIsLeapMonth(false);
      }
      if (paramQMCalendarEvent.getSubject().contains("enter")) {
        Log.d("baggiotest1", "fuck1 : " + ((QMLunarCalendar)localObject).getYear() + "/" + ((QMLunarCalendar)localObject).getMonth() + "/" + ((QMLunarCalendar)localObject).getDay() + "; " + ((QMLunarCalendar)localObject).isLeapMonth());
      }
    }
    while (paramQMCalendarEvent.getRecurrenceType() != 2)
    {
      localObject = QMLunarCalendarUtils.lunarToSolar((QMLunarCalendar)localObject);
      paramCalendar.set(1, ((QMSimpleDate)localObject).getYear());
      paramCalendar.set(2, ((QMSimpleDate)localObject).getMonth() - 1);
      paramCalendar.set(5, ((QMSimpleDate)localObject).getDay());
      if (paramQMCalendarEvent.getSubject().contains("enter")) {
        Log.d("baggiotest1", "fuck2 : " + paramCalendar.get(1) + "/" + paramCalendar.get(2) + "/" + paramCalendar.get(5));
      }
      return;
    }
    ((QMLunarCalendar)localObject).setDay(paramQMCalendarEvent.getDayOfMonth());
    label400:
    for (;;)
    {
      label283:
      if ((QMLunarCalendarUtils.leapMonth(((QMLunarCalendar)localObject).getYear()) == ((QMLunarCalendar)localObject).getMonth()) && (!((QMLunarCalendar)localObject).isLeapMonth())) {
        ((QMLunarCalendar)localObject).setIsLeapMonth(true);
      }
      for (;;)
      {
        if ((((QMLunarCalendar)localObject).isLeapMonth()) && (QMLunarCalendarUtils.leapMonthDays(((QMLunarCalendar)localObject).getYear()) < paramQMCalendarEvent.getDayOfMonth())) {
          break label400;
        }
        if (((QMLunarCalendar)localObject).isLeapMonth()) {
          break;
        }
        if (QMLunarCalendarUtils.monthDays(((QMLunarCalendar)localObject).getYear(), ((QMLunarCalendar)localObject).getMonth()) < paramQMCalendarEvent.getDayOfMonth()) {
          break label283;
        }
        break;
        ((QMLunarCalendar)localObject).setIsLeapMonth(false);
        int i = ((QMLunarCalendar)localObject).getMonth() + 1;
        if (i <= 12)
        {
          ((QMLunarCalendar)localObject).setMonth(i);
        }
        else
        {
          ((QMLunarCalendar)localObject).setMonth(1);
          ((QMLunarCalendar)localObject).setYear(((QMLunarCalendar)localObject).getYear() + 1);
        }
      }
    }
  }
  
  public static boolean modifyStartTime(QMCalendarEvent paramQMCalendarEvent, Calendar paramCalendar)
  {
    return createInstance(paramQMCalendarEvent).modifyStartTime(paramCalendar);
  }
  
  public abstract boolean increment(Calendar paramCalendar);
  
  public boolean increment(Calendar paramCalendar, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!increment(paramCalendar)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public abstract boolean modifyStartTime(Calendar paramCalendar);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.RecurrenceInctor
 * JD-Core Version:    0.7.0.1
 */