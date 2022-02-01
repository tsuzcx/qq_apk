package com.tencent.moai.mailsdk.model;

public class Recurrence
{
  private int calendar_type;
  private long day_of_month = 0L;
  private long day_of_week = 0L;
  private int first_day_of_week;
  private long interval = 0L;
  private boolean is_leap_month;
  private long month_of_year = 0L;
  private long occurrences = 0L;
  private int type;
  private long until = 0L;
  private long week_of_month = 0L;
  
  public int getCalendar_type()
  {
    return this.calendar_type;
  }
  
  public long getDay_of_month()
  {
    return this.day_of_month;
  }
  
  public long getDay_of_week()
  {
    return this.day_of_week;
  }
  
  public int getFirst_day_of_week()
  {
    return this.first_day_of_week;
  }
  
  public long getInterval()
  {
    return this.interval;
  }
  
  public long getMonth_of_year()
  {
    return this.month_of_year;
  }
  
  public long getOccurrences()
  {
    return this.occurrences;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public long getUntil()
  {
    return this.until;
  }
  
  public long getWeek_of_month()
  {
    return this.week_of_month;
  }
  
  public boolean is_leap_month()
  {
    return this.is_leap_month;
  }
  
  public void setCalendar_type(int paramInt)
  {
    this.calendar_type = paramInt;
  }
  
  public void setDay_of_month(long paramLong)
  {
    this.day_of_month = paramLong;
  }
  
  public void setDay_of_week(long paramLong)
  {
    this.day_of_week = paramLong;
  }
  
  public void setFirst_day_of_week(int paramInt)
  {
    this.first_day_of_week = paramInt;
  }
  
  public void setInterval(long paramLong)
  {
    this.interval = paramLong;
  }
  
  public void setIs_leap_month(boolean paramBoolean)
  {
    this.is_leap_month = paramBoolean;
  }
  
  public void setMonth_of_year(long paramLong)
  {
    this.month_of_year = paramLong;
  }
  
  public void setOccurrences(long paramLong)
  {
    this.occurrences = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setUntil(long paramLong)
  {
    this.until = paramLong;
  }
  
  public void setWeek_of_month(long paramLong)
  {
    this.week_of_month = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.model.Recurrence
 * JD-Core Version:    0.7.0.1
 */