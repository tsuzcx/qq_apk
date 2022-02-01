package com.google.ical.iter;

import com.google.ical.values.DateValue;

public abstract interface RecurrenceIterable
  extends Iterable<DateValue>
{
  public abstract RecurrenceIterator iterator();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.RecurrenceIterable
 * JD-Core Version:    0.7.0.1
 */