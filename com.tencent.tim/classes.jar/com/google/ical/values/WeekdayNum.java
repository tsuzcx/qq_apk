package com.google.ical.values;

public class WeekdayNum
{
  public final int num;
  public final Weekday wday;
  
  public WeekdayNum(int paramInt, Weekday paramWeekday)
  {
    if ((-53 > paramInt) || (53 < paramInt) || (paramWeekday == null)) {
      throw new IllegalArgumentException();
    }
    this.num = paramInt;
    this.wday = paramWeekday;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof WeekdayNum)) {}
    do
    {
      return false;
      paramObject = (WeekdayNum)paramObject;
    } while ((this.num != paramObject.num) || (this.wday != paramObject.wday));
    return true;
  }
  
  public int hashCode()
  {
    return this.num ^ this.wday.hashCode() * 53;
  }
  
  public String toIcal()
  {
    if (this.num != 0) {
      return String.valueOf(this.num) + this.wday;
    }
    return this.wday.toString();
  }
  
  public String toString()
  {
    return toIcal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.WeekdayNum
 * JD-Core Version:    0.7.0.1
 */