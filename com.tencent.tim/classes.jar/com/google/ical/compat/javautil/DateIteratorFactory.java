package com.google.ical.compat.javautil;

import com.google.ical.iter.RecurrenceIterable;
import com.google.ical.iter.RecurrenceIterator;
import com.google.ical.iter.RecurrenceIteratorFactory;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateTimeValueImpl;
import com.google.ical.values.DateValue;
import com.google.ical.values.DateValueImpl;
import com.google.ical.values.TimeValue;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateIteratorFactory
{
  public static DateIterable createDateIterable(String paramString, Date paramDate, TimeZone paramTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIterableWrapper(RecurrenceIteratorFactory.createRecurrenceIterable(paramString, dateToDateValue(paramDate, true), paramTimeZone, paramBoolean));
  }
  
  public static DateIterator createDateIterator(RecurrenceIterator paramRecurrenceIterator)
  {
    return new RecurrenceIteratorWrapper(paramRecurrenceIterator);
  }
  
  public static DateIterator createDateIterator(String paramString, Date paramDate, TimeZone paramTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIteratorWrapper(RecurrenceIteratorFactory.createRecurrenceIterator(paramString, dateToDateValue(paramDate, true), paramTimeZone, paramBoolean));
  }
  
  static DateValue dateToDateValue(Date paramDate, boolean paramBoolean)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeUtils.utcTimezone());
    localGregorianCalendar.setTime(paramDate);
    int i = localGregorianCalendar.get(11);
    int j = localGregorianCalendar.get(12);
    int k = localGregorianCalendar.get(13);
    if ((paramBoolean) && ((i | j | k) == 0)) {
      return new DateValueImpl(localGregorianCalendar.get(1), localGregorianCalendar.get(2) + 1, localGregorianCalendar.get(5));
    }
    return new DateTimeValueImpl(localGregorianCalendar.get(1), localGregorianCalendar.get(2) + 1, localGregorianCalendar.get(5), i, j, k);
  }
  
  static Date dateValueToDate(DateValue paramDateValue)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeUtils.utcTimezone());
    localGregorianCalendar.clear();
    if ((paramDateValue instanceof TimeValue))
    {
      TimeValue localTimeValue = (TimeValue)paramDateValue;
      localGregorianCalendar.set(paramDateValue.year(), paramDateValue.month() - 1, paramDateValue.day(), localTimeValue.hour(), localTimeValue.minute(), localTimeValue.second());
    }
    for (;;)
    {
      return localGregorianCalendar.getTime();
      localGregorianCalendar.set(paramDateValue.year(), paramDateValue.month() - 1, paramDateValue.day(), 0, 0, 0);
    }
  }
  
  static final class RecurrenceIterableWrapper
    implements DateIterable
  {
    private final RecurrenceIterable it;
    
    public RecurrenceIterableWrapper(RecurrenceIterable paramRecurrenceIterable)
    {
      this.it = paramRecurrenceIterable;
    }
    
    public DateIterator iterator()
    {
      return new DateIteratorFactory.RecurrenceIteratorWrapper(this.it.iterator());
    }
  }
  
  static final class RecurrenceIteratorWrapper
    implements DateIterator
  {
    private final RecurrenceIterator it;
    
    RecurrenceIteratorWrapper(RecurrenceIterator paramRecurrenceIterator)
    {
      this.it = paramRecurrenceIterator;
    }
    
    public void advanceTo(Date paramDate)
    {
      this.it.advanceTo(DateIteratorFactory.dateToDateValue(paramDate, true));
    }
    
    public boolean hasNext()
    {
      return this.it.hasNext();
    }
    
    public Date next()
    {
      return DateIteratorFactory.dateValueToDate(this.it.next());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.javautil.DateIteratorFactory
 * JD-Core Version:    0.7.0.1
 */