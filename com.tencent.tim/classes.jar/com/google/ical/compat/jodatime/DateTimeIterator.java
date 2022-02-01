package com.google.ical.compat.jodatime;

import java.util.Iterator;
import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;

public abstract interface DateTimeIterator
  extends Iterator<DateTime>
{
  public abstract void advanceTo(ReadableDateTime paramReadableDateTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.DateTimeIterator
 * JD-Core Version:    0.7.0.1
 */