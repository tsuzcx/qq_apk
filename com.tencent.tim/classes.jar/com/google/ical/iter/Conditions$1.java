package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.values.DateValue;

final class Conditions$1
  implements Predicate<DateValue>
{
  int count_ = this.val$count;
  
  Conditions$1(int paramInt) {}
  
  public boolean apply(DateValue paramDateValue)
  {
    int i = this.count_ - 1;
    this.count_ = i;
    return i >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.Conditions.1
 * JD-Core Version:    0.7.0.1
 */