package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.values.DateValue;

final class Generators$1
  extends ThrottledGenerator
{
  int throttle = 100;
  int year = this.val$dtStart.year() - this.val$interval;
  
  Generators$1(DateValue paramDateValue, int paramInt) {}
  
  boolean generate(DTBuilder paramDTBuilder)
    throws Generator.IteratorShortCircuitingException
  {
    int i = this.throttle - 1;
    this.throttle = i;
    if (i < 0) {
      throw Generator.IteratorShortCircuitingException.instance();
    }
    i = this.year + this.val$interval;
    this.year = i;
    paramDTBuilder.year = i;
    return true;
  }
  
  public String toString()
  {
    return "serialYearGenerator:" + this.val$interval;
  }
  
  void workDone()
  {
    this.throttle = 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.1
 * JD-Core Version:    0.7.0.1
 */