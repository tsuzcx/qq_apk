package com.google.ical.compat.jodatime;

import org.joda.time.LocalDate;

public abstract interface LocalDateIterable
  extends Iterable<LocalDate>
{
  public abstract LocalDateIterator iterator();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.LocalDateIterable
 * JD-Core Version:    0.7.0.1
 */