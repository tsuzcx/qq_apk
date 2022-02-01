package com.google.ical.values;

public class DateTimeValueImpl
  extends DateValueImpl
  implements DateTimeValue
{
  private final int hour;
  private final int minute;
  private final int second;
  
  public DateTimeValueImpl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.hour = paramInt4;
    this.minute = paramInt5;
    this.second = paramInt6;
  }
  
  public int hashCode()
  {
    return super.hashCode() ^ (this.hour << 12) + (this.minute << 6) + this.second;
  }
  
  public int hour()
  {
    return this.hour;
  }
  
  public int minute()
  {
    return this.minute;
  }
  
  public int second()
  {
    return this.second;
  }
  
  public String toString()
  {
    return String.format("%sT%02d%02d%02d", new Object[] { super.toString(), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.second) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.DateTimeValueImpl
 * JD-Core Version:    0.7.0.1
 */