package com.google.ical.compat.jodatime;

import java.util.Iterator;
import org.joda.time.LocalDate;

public abstract interface LocalDateIterator
  extends Iterator<LocalDate>
{
  public abstract void advanceTo(LocalDate paramLocalDate);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.LocalDateIterator
 * JD-Core Version:    0.7.0.1
 */