package com.google.ical.iter;

import com.google.ical.values.DateValue;
import java.util.Comparator;

final class HeapElement
{
  static Comparator<HeapElement> CMP = new HeapElement.1();
  private long comparable;
  private DateValue head;
  final boolean inclusion;
  private RecurrenceIterator it;
  
  HeapElement(boolean paramBoolean, RecurrenceIterator paramRecurrenceIterator)
  {
    this.inclusion = paramBoolean;
    this.it = paramRecurrenceIterator;
  }
  
  void advanceTo(DateValue paramDateValue)
  {
    this.it.advanceTo(paramDateValue);
  }
  
  long comparable()
  {
    return this.comparable;
  }
  
  DateValue head()
  {
    return this.head;
  }
  
  boolean shift()
  {
    if (!this.it.hasNext()) {
      return false;
    }
    this.head = this.it.next();
    this.comparable = DateValueComparison.comparable(this.head);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[").append(this.head.toString());
    if (this.inclusion) {}
    for (String str = ", inclusion]";; str = ", exclusion]") {
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.HeapElement
 * JD-Core Version:    0.7.0.1
 */