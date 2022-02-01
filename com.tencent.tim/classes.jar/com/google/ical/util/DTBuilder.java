package com.google.ical.util;

import com.google.ical.values.DateTimeValue;
import com.google.ical.values.DateTimeValueImpl;
import com.google.ical.values.DateValue;
import com.google.ical.values.DateValueImpl;
import com.google.ical.values.TimeValue;

public class DTBuilder
{
  public int day;
  public int hour;
  public int minute;
  public int month;
  public int second;
  public int year;
  
  public DTBuilder() {}
  
  public DTBuilder(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
  }
  
  public DTBuilder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
    this.hour = paramInt4;
    this.minute = paramInt5;
    this.second = paramInt6;
  }
  
  public DTBuilder(DateValue paramDateValue)
  {
    this.year = paramDateValue.year();
    this.month = paramDateValue.month();
    this.day = paramDateValue.day();
    if ((paramDateValue instanceof TimeValue))
    {
      paramDateValue = (TimeValue)paramDateValue;
      this.hour = paramDateValue.hour();
      this.minute = paramDateValue.minute();
      this.second = paramDateValue.second();
    }
  }
  
  private void normalizeDate()
  {
    int i;
    if (this.day <= 0)
    {
      if (this.month > 2) {}
      for (i = this.year;; i = this.year - 1)
      {
        this.day = (TimeUtils.yearLength(i) + this.day);
        this.year -= 1;
        break;
      }
    }
    if (this.month <= 0)
    {
      i = this.month / 12 - 1;
      this.year += i;
      this.month -= i * 12;
    }
    for (;;)
    {
      if (this.month == 1)
      {
        i = TimeUtils.yearLength(this.year);
        if (this.day > i)
        {
          this.year += 1;
          this.day -= i;
        }
      }
      i = TimeUtils.monthLength(this.year, this.month);
      if (this.day <= i) {
        break;
      }
      this.day -= i;
      i = this.month + 1;
      this.month = i;
      if (i > 12)
      {
        this.month -= 12;
        this.year += 1;
        continue;
        if (this.month > 12)
        {
          i = (this.month - 1) / 12;
          this.year += i;
          this.month -= i * 12;
        }
      }
    }
  }
  
  private void normalizeTime()
  {
    if (this.second < 0)
    {
      i = this.second - 59;
      i /= 60;
      this.second -= i * 60;
      this.minute = (i + this.minute);
      if (this.minute >= 0) {
        break label138;
      }
      i = this.minute - 59;
      label58:
      i /= 60;
      this.minute -= i * 60;
      this.hour = (i + this.hour);
      if (this.hour >= 0) {
        break label146;
      }
    }
    label138:
    label146:
    for (int i = this.hour - 23;; i = this.hour)
    {
      i /= 24;
      this.hour -= i * 24;
      this.day = (i + this.day);
      return;
      i = this.second;
      break;
      i = this.minute;
      break label58;
    }
  }
  
  public int compareTo(DateValue paramDateValue)
  {
    long l1 = paramDateValue.year();
    long l2 = paramDateValue.month();
    long l4 = paramDateValue.day() + ((l1 << 4) + l2 << 5);
    long l3 = ((this.year << 4) + this.month << 5) + this.day;
    l2 = l3;
    l1 = l4;
    if ((paramDateValue instanceof TimeValue))
    {
      paramDateValue = (TimeValue)paramDateValue;
      l1 = (((l4 << 5) + paramDateValue.hour() << 6) + paramDateValue.minute() << 6) + paramDateValue.second();
      l2 = (((l3 << 5) + this.hour << 6) + this.minute << 6) + this.second;
    }
    l1 = l2 - l1;
    if (l1 < 0L) {
      return -1;
    }
    if (l1 == 0L) {
      return 0;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DTBuilder)) {}
    do
    {
      return false;
      paramObject = (DTBuilder)paramObject;
    } while ((this.year != paramObject.year) || (this.month != paramObject.month) || (this.day != paramObject.day) || (this.hour != paramObject.hour) || (this.minute != paramObject.minute) || (this.second != paramObject.second));
    return true;
  }
  
  public int hashCode()
  {
    return (((((this.year << 4) + this.month << 5) + this.day << 5) + this.hour << 6) + this.minute << 6) + this.second;
  }
  
  public void normalize()
  {
    normalizeTime();
    normalizeDate();
  }
  
  public DateValue toDate()
  {
    normalize();
    return new DateValueImpl(this.year, this.month, this.day);
  }
  
  public DateTimeValue toDateTime()
  {
    normalize();
    return new DateTimeValueImpl(this.year, this.month, this.day, this.hour, this.minute, this.second);
  }
  
  public String toString()
  {
    return this.year + "-" + this.month + "-" + this.day + " " + this.hour + ":" + this.minute + ":" + this.second;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.util.DTBuilder
 * JD-Core Version:    0.7.0.1
 */