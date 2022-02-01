package com.google.ical.compat.jodatime;

import com.google.ical.iter.RecurrenceIterable;
import com.google.ical.iter.RecurrenceIterator;
import com.google.ical.iter.RecurrenceIteratorFactory;
import com.google.ical.values.DateTimeValueImpl;
import com.google.ical.values.DateValue;
import com.google.ical.values.TimeValue;
import java.text.ParseException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;

public class DateTimeIteratorFactory
{
  public static DateTimeIterable createDateTimeIterable(String paramString, ReadableDateTime paramReadableDateTime, DateTimeZone paramDateTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIterableWrapper(RecurrenceIteratorFactory.createRecurrenceIterable(paramString, dateTimeToDateValue(paramReadableDateTime.toDateTime().withZone(paramDateTimeZone)), TimeZoneConverter.toTimeZone(paramDateTimeZone), paramBoolean));
  }
  
  public static DateTimeIterator createDateTimeIterator(RecurrenceIterator paramRecurrenceIterator)
  {
    return new RecurrenceIteratorWrapper(paramRecurrenceIterator);
  }
  
  public static DateTimeIterator createDateTimeIterator(String paramString, ReadableDateTime paramReadableDateTime, DateTimeZone paramDateTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIteratorWrapper(RecurrenceIteratorFactory.createRecurrenceIterator(paramString, dateTimeToDateValue(paramReadableDateTime.toDateTime().withZone(paramDateTimeZone)), TimeZoneConverter.toTimeZone(paramDateTimeZone), paramBoolean));
  }
  
  static DateValue dateTimeToDateValue(ReadableDateTime paramReadableDateTime)
  {
    return new DateTimeValueImpl(paramReadableDateTime.getYear(), paramReadableDateTime.getMonthOfYear(), paramReadableDateTime.getDayOfMonth(), paramReadableDateTime.getHourOfDay(), paramReadableDateTime.getMinuteOfHour(), paramReadableDateTime.getSecondOfMinute());
  }
  
  static DateTime dateValueToDateTime(DateValue paramDateValue)
  {
    if ((paramDateValue instanceof TimeValue))
    {
      TimeValue localTimeValue = (TimeValue)paramDateValue;
      return new DateTime(paramDateValue.year(), paramDateValue.month(), paramDateValue.day(), localTimeValue.hour(), localTimeValue.minute(), localTimeValue.second(), 0, DateTimeZone.UTC);
    }
    return new DateTime(paramDateValue.year(), paramDateValue.month(), paramDateValue.day(), 0, 0, 0, 0, DateTimeZone.UTC);
  }
  
  static final class RecurrenceIterableWrapper
    implements DateTimeIterable
  {
    private final RecurrenceIterable it;
    
    public RecurrenceIterableWrapper(RecurrenceIterable paramRecurrenceIterable)
    {
      this.it = paramRecurrenceIterable;
    }
    
    public DateTimeIterator iterator()
    {
      return new DateTimeIteratorFactory.RecurrenceIteratorWrapper(this.it.iterator());
    }
  }
  
  static final class RecurrenceIteratorWrapper
    implements DateTimeIterator
  {
    private final RecurrenceIterator it;
    
    RecurrenceIteratorWrapper(RecurrenceIterator paramRecurrenceIterator)
    {
      this.it = paramRecurrenceIterator;
    }
    
    public void advanceTo(ReadableDateTime paramReadableDateTime)
    {
      paramReadableDateTime = paramReadableDateTime.toDateTime().withZone(DateTimeZone.UTC);
      this.it.advanceTo(DateTimeIteratorFactory.dateTimeToDateValue(paramReadableDateTime));
    }
    
    public boolean hasNext()
    {
      return this.it.hasNext();
    }
    
    public DateTime next()
    {
      return DateTimeIteratorFactory.dateValueToDateTime(this.it.next());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.DateTimeIteratorFactory
 * JD-Core Version:    0.7.0.1
 */