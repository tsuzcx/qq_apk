package com.google.ical.compat.jodatime;

import com.google.ical.iter.RecurrenceIterable;
import com.google.ical.iter.RecurrenceIterator;
import com.google.ical.iter.RecurrenceIteratorFactory;
import com.google.ical.values.DateValue;
import com.google.ical.values.DateValueImpl;
import java.text.ParseException;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

public class LocalDateIteratorFactory
{
  public static LocalDateIterable createLocalDateIterable(String paramString, LocalDate paramLocalDate, DateTimeZone paramDateTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIterableWrapper(RecurrenceIteratorFactory.createRecurrenceIterable(paramString, localDateToDateValue(paramLocalDate), TimeZoneConverter.toTimeZone(paramDateTimeZone), paramBoolean));
  }
  
  public static LocalDateIterable createLocalDateIterable(String paramString, LocalDate paramLocalDate, boolean paramBoolean)
    throws ParseException
  {
    return createLocalDateIterable(paramString, paramLocalDate, DateTimeZone.UTC, paramBoolean);
  }
  
  public static LocalDateIterator createLocalDateIterator(RecurrenceIterator paramRecurrenceIterator)
  {
    return new RecurrenceIteratorWrapper(paramRecurrenceIterator);
  }
  
  public static LocalDateIterator createLocalDateIterator(String paramString, LocalDate paramLocalDate, DateTimeZone paramDateTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIteratorWrapper(RecurrenceIteratorFactory.createRecurrenceIterator(paramString, localDateToDateValue(paramLocalDate), TimeZoneConverter.toTimeZone(paramDateTimeZone), paramBoolean));
  }
  
  public static LocalDateIterator createLocalDateIterator(String paramString, LocalDate paramLocalDate, boolean paramBoolean)
    throws ParseException
  {
    return createLocalDateIterator(paramString, paramLocalDate, DateTimeZone.UTC, paramBoolean);
  }
  
  static LocalDate dateValueToLocalDate(DateValue paramDateValue)
  {
    return new LocalDate(paramDateValue.year(), paramDateValue.month(), paramDateValue.day());
  }
  
  static DateValue localDateToDateValue(LocalDate paramLocalDate)
  {
    return new DateValueImpl(paramLocalDate.getYear(), paramLocalDate.getMonthOfYear(), paramLocalDate.getDayOfMonth());
  }
  
  static final class RecurrenceIterableWrapper
    implements LocalDateIterable
  {
    private final RecurrenceIterable it;
    
    public RecurrenceIterableWrapper(RecurrenceIterable paramRecurrenceIterable)
    {
      this.it = paramRecurrenceIterable;
    }
    
    public LocalDateIterator iterator()
    {
      return new LocalDateIteratorFactory.RecurrenceIteratorWrapper(this.it.iterator());
    }
  }
  
  static final class RecurrenceIteratorWrapper
    implements LocalDateIterator
  {
    private final RecurrenceIterator it;
    
    RecurrenceIteratorWrapper(RecurrenceIterator paramRecurrenceIterator)
    {
      this.it = paramRecurrenceIterator;
    }
    
    public void advanceTo(LocalDate paramLocalDate)
    {
      this.it.advanceTo(LocalDateIteratorFactory.localDateToDateValue(paramLocalDate));
    }
    
    public boolean hasNext()
    {
      return this.it.hasNext();
    }
    
    public LocalDate next()
    {
      return LocalDateIteratorFactory.dateValueToLocalDate(this.it.next());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.LocalDateIteratorFactory
 * JD-Core Version:    0.7.0.1
 */