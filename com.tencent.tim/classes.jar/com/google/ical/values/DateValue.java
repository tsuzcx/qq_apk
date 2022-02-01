package com.google.ical.values;

public abstract interface DateValue
  extends Comparable<DateValue>
{
  public abstract int day();
  
  public abstract int month();
  
  public abstract int year();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.DateValue
 * JD-Core Version:    0.7.0.1
 */