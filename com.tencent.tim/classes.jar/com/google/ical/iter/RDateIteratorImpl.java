package com.google.ical.iter;

import com.google.ical.values.DateValue;

final class RDateIteratorImpl
  implements RecurrenceIterator
{
  private DateValue[] datesUtc;
  private int i;
  
  static
  {
    if (!RDateIteratorImpl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  RDateIteratorImpl(DateValue[] paramArrayOfDateValue)
  {
    this.datesUtc = ((DateValue[])paramArrayOfDateValue.clone());
    assert (increasing(paramArrayOfDateValue));
  }
  
  private static <C extends Comparable<C>> boolean increasing(C[] paramArrayOfC)
  {
    boolean bool2 = true;
    int j = paramArrayOfC.length;
    int k;
    do
    {
      k = j - 1;
      bool1 = bool2;
      if (k < 1) {
        break;
      }
      j = k;
    } while (paramArrayOfC[(k - 1)].compareTo(paramArrayOfC[k]) <= 0);
    boolean bool1 = false;
    return bool1;
  }
  
  public void advanceTo(DateValue paramDateValue)
  {
    long l = DateValueComparison.comparable(paramDateValue);
    while ((this.i < this.datesUtc.length) && (l > DateValueComparison.comparable(this.datesUtc[this.i]))) {
      this.i += 1;
    }
  }
  
  public boolean hasNext()
  {
    return this.i < this.datesUtc.length;
  }
  
  public DateValue next()
  {
    DateValue[] arrayOfDateValue = this.datesUtc;
    int j = this.i;
    this.i = (j + 1);
    return arrayOfDateValue[j];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.RDateIteratorImpl
 * JD-Core Version:    0.7.0.1
 */