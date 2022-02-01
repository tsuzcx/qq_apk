package com.tencent.qqmail.calendar.data;

public class QMLunarCalendar
{
  private int day;
  private boolean isLeapMonth = false;
  private String lunarString = null;
  private int month;
  private int year;
  
  public int getDay()
  {
    return this.day;
  }
  
  public String getLunarString()
  {
    return this.lunarString;
  }
  
  public int getMonth()
  {
    return this.month;
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public boolean isLeapMonth()
  {
    return this.isLeapMonth;
  }
  
  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }
  
  public void setIsLeapMonth(boolean paramBoolean)
  {
    this.isLeapMonth = paramBoolean;
  }
  
  public void setLunarString(String paramString)
  {
    this.lunarString = paramString;
  }
  
  public void setMonth(int paramInt)
  {
    this.month = paramInt;
  }
  
  public void setYear(int paramInt)
  {
    this.year = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMLunarCalendar
 * JD-Core Version:    0.7.0.1
 */