package com.google.ical.values;

public abstract interface PeriodValue
{
  public abstract boolean contains(PeriodValue paramPeriodValue);
  
  public abstract DateValue end();
  
  public abstract boolean intersects(PeriodValue paramPeriodValue);
  
  public abstract DateValue start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.PeriodValue
 * JD-Core Version:    0.7.0.1
 */