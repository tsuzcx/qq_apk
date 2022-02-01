package com.google.ical.iter;

import com.google.ical.values.DateValue;
import java.util.Iterator;

public abstract interface RecurrenceIterator
  extends Iterator<DateValue>
{
  public abstract void advanceTo(DateValue paramDateValue);
  
  public abstract boolean hasNext();
  
  public abstract DateValue next();
  
  public abstract void remove();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.RecurrenceIterator
 * JD-Core Version:    0.7.0.1
 */