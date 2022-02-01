package com.tencent.qqmail.calendar.data;

import java.util.ArrayList;

public class QMCalendar
{
  private ArrayList<CalendarDayData> days;
  private int month;
  private int weeks;
  private int year;
  
  public QMCalendar()
  {
    this.days = new ArrayList();
  }
  
  public QMCalendar(int paramInt1, int paramInt2)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.days = new ArrayList();
  }
  
  public QMCalendar(int paramInt1, int paramInt2, ArrayList<CalendarDayData> paramArrayList)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.days = paramArrayList;
  }
  
  public QMCalendar(int paramInt1, int paramInt2, ArrayList<CalendarDayData> paramArrayList, int paramInt3)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.days = paramArrayList;
    this.weeks = paramInt3;
  }
  
  public ArrayList<CalendarDayData> getDays()
  {
    return this.days;
  }
  
  public int getMonth()
  {
    return this.month;
  }
  
  public int getWeeks()
  {
    return this.weeks;
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public void setDays(ArrayList<CalendarDayData> paramArrayList)
  {
    this.days = paramArrayList;
  }
  
  public void setMonth(int paramInt)
  {
    this.month = paramInt;
  }
  
  public void setWeeks(int paramInt)
  {
    this.weeks = paramInt;
  }
  
  public void setYear(int paramInt)
  {
    this.year = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMCalendar
 * JD-Core Version:    0.7.0.1
 */