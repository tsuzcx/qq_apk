package com.google.ical.values;

import com.google.ical.util.TimeUtils;

public class PeriodValueImpl
  implements PeriodValue
{
  private DateValue end;
  private DateValue start;
  
  protected PeriodValueImpl(DateValue paramDateValue1, DateValue paramDateValue2)
  {
    if (paramDateValue1.compareTo(paramDateValue2) > 0) {
      throw new IllegalArgumentException("Start (" + paramDateValue1 + ") must precede end (" + paramDateValue2 + ")");
    }
    if ((paramDateValue1 instanceof TimeValue ^ paramDateValue2 instanceof TimeValue)) {
      throw new IllegalArgumentException("Start (" + paramDateValue1 + ") and end (" + paramDateValue2 + ") must both have times or neither have times.");
    }
    this.start = paramDateValue1;
    this.end = paramDateValue2;
  }
  
  public static PeriodValue create(DateValue paramDateValue1, DateValue paramDateValue2)
  {
    return new PeriodValueImpl(paramDateValue1, paramDateValue2);
  }
  
  public static PeriodValue createFromDuration(DateValue paramDateValue1, DateValue paramDateValue2)
  {
    DateValue localDateValue = TimeUtils.add(paramDateValue1, paramDateValue2);
    paramDateValue2 = paramDateValue1;
    if ((localDateValue instanceof TimeValue))
    {
      paramDateValue2 = paramDateValue1;
      if (!(paramDateValue1 instanceof TimeValue)) {
        paramDateValue2 = TimeUtils.dayStart(paramDateValue1);
      }
    }
    return new PeriodValueImpl(paramDateValue2, localDateValue);
  }
  
  public boolean contains(PeriodValue paramPeriodValue)
  {
    DateValue localDateValue1 = this.start;
    DateValue localDateValue2 = this.end;
    DateValue localDateValue3 = paramPeriodValue.start();
    paramPeriodValue = paramPeriodValue.end();
    return (localDateValue3.compareTo(localDateValue1) >= 0) && (localDateValue2.compareTo(paramPeriodValue) >= 0);
  }
  
  public DateValue end()
  {
    return this.end;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PeriodValue)) {}
    do
    {
      return false;
      paramObject = (PeriodValue)paramObject;
    } while ((!start().equals(paramObject.start())) || (!end().equals(paramObject.end())));
    return true;
  }
  
  public int hashCode()
  {
    return this.start.hashCode() ^ this.end.hashCode() * 31;
  }
  
  public boolean intersects(PeriodValue paramPeriodValue)
  {
    DateValue localDateValue1 = this.start;
    DateValue localDateValue2 = this.end;
    DateValue localDateValue3 = paramPeriodValue.start();
    return (localDateValue1.compareTo(paramPeriodValue.end()) < 0) && (localDateValue3.compareTo(localDateValue2) < 0);
  }
  
  public DateValue start()
  {
    return this.start;
  }
  
  public String toString()
  {
    return start().toString() + "/" + end().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.PeriodValueImpl
 * JD-Core Version:    0.7.0.1
 */