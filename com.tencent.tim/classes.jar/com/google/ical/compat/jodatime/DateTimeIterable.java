package com.google.ical.compat.jodatime;

import org.joda.time.DateTime;

public abstract interface DateTimeIterable
  extends Iterable<DateTime>
{
  public abstract DateTimeIterator iterator();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.DateTimeIterable
 * JD-Core Version:    0.7.0.1
 */