package com.tencent.qqmail.calendar.data;

public class CalendarDayData
{
  private int day;
  private int dayOfWeek;
  private boolean hasSchedule;
  private QMHolidayCalendar holidayCalendar = null;
  private QMLunarCalendar lunarCalendar = null;
  
  public CalendarDayData(int paramInt1, int paramInt2, QMLunarCalendar paramQMLunarCalendar, QMHolidayCalendar paramQMHolidayCalendar, boolean paramBoolean)
  {
    this.day = paramInt1;
    this.dayOfWeek = paramInt2;
    this.lunarCalendar = paramQMLunarCalendar;
    this.holidayCalendar = paramQMHolidayCalendar;
    this.hasSchedule = paramBoolean;
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public int getDayOfWeek()
  {
    return this.dayOfWeek;
  }
  
  public QMHolidayCalendar getHolidayCalendar()
  {
    return this.holidayCalendar;
  }
  
  public String getLunar()
  {
    if (this.lunarCalendar == null) {
      return null;
    }
    return this.lunarCalendar.getLunarString();
  }
  
  public boolean hasSchedule()
  {
    return this.hasSchedule;
  }
  
  public boolean isLunarFirstDayOfMonth()
  {
    boolean bool = true;
    if (this.lunarCalendar == null) {
      return false;
    }
    if (this.lunarCalendar.getDay() == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }
  
  public void setDayOfWeek(int paramInt)
  {
    this.dayOfWeek = paramInt;
  }
  
  public void setHasSchedule(boolean paramBoolean)
  {
    this.hasSchedule = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarDayData
 * JD-Core Version:    0.7.0.1
 */