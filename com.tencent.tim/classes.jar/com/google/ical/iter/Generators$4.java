package com.google.ical.iter;

import com.google.ical.util.DTBuilder;
import com.google.ical.values.DateValue;

final class Generators$4
  extends Generator
{
  int i;
  
  Generators$4(int[] paramArrayOfInt, DateValue paramDateValue)
  {
    while ((this.i < this.val$uyears.length) && (this.val$dtStart.year() > this.val$uyears[this.i])) {
      this.i += 1;
    }
  }
  
  boolean generate(DTBuilder paramDTBuilder)
  {
    if (this.i >= this.val$uyears.length) {
      return false;
    }
    int[] arrayOfInt = this.val$uyears;
    int j = this.i;
    this.i = (j + 1);
    paramDTBuilder.year = arrayOfInt[j];
    return true;
  }
  
  public String toString()
  {
    return "byYearGenerator";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Generators.4
 * JD-Core Version:    0.7.0.1
 */