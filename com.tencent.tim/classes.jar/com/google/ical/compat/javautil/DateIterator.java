package com.google.ical.compat.javautil;

import java.util.Date;
import java.util.Iterator;

public abstract interface DateIterator
  extends Iterator<Date>
{
  public abstract void advanceTo(Date paramDate);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.javautil.DateIterator
 * JD-Core Version:    0.7.0.1
 */