package com.google.ical.values;

public class DateValueImpl
  implements DateValue
{
  private final int day;
  private final int month;
  private final int year;
  
  public DateValueImpl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
  }
  
  public final int compareTo(DateValue paramDateValue)
  {
    int i = day() + (month() << 5) + (year() << 9);
    int j = paramDateValue.day() + (paramDateValue.month() << 5) + (paramDateValue.year() << 9);
    if (i != j) {
      return i - j;
    }
    if (!(this instanceof TimeValue))
    {
      if ((paramDateValue instanceof TimeValue)) {
        return -1;
      }
      return 0;
    }
    TimeValue localTimeValue = (TimeValue)this;
    if (!(paramDateValue instanceof TimeValue)) {
      return 1;
    }
    paramDateValue = (TimeValue)paramDateValue;
    return localTimeValue.second() + (localTimeValue.minute() << 6) + (localTimeValue.hour() << 12) - (paramDateValue.second() + (paramDateValue.minute() << 6) + (paramDateValue.hour() << 12));
  }
  
  public int day()
  {
    return this.day;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DateValue)) {}
    while (compareTo((DateValue)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return (this.year << 9) + (this.month << 5) + this.day;
  }
  
  public int month()
  {
    return this.month;
  }
  
  public String toString()
  {
    return String.format("%04d%02d%02d", new Object[] { Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day) });
  }
  
  public int year()
  {
    return this.year;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.DateValueImpl
 * JD-Core Version:    0.7.0.1
 */