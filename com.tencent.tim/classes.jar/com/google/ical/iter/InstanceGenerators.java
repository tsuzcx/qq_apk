package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.values.DateValue;
import com.google.ical.values.Frequency;
import com.google.ical.values.Weekday;

class InstanceGenerators
{
  static Generator bySetPosInstanceGenerator(int[] paramArrayOfInt, Frequency paramFrequency, Weekday paramWeekday, Predicate<? super DateValue> paramPredicate, Generator paramGenerator1, Generator paramGenerator2, Generator paramGenerator3)
  {
    boolean bool = false;
    paramArrayOfInt = Util.uniquify(paramArrayOfInt);
    paramPredicate = serialInstanceGenerator(paramPredicate, paramGenerator1, paramGenerator2, paramGenerator3);
    int i = paramArrayOfInt[(paramArrayOfInt.length - 1)];
    if (paramArrayOfInt[0] > 0) {
      bool = true;
    }
    return new InstanceGenerators.2(paramFrequency, paramGenerator1, paramGenerator2, paramWeekday, paramPredicate, bool, i, paramArrayOfInt);
  }
  
  static Generator serialInstanceGenerator(Predicate<? super DateValue> paramPredicate, Generator paramGenerator1, Generator paramGenerator2, Generator paramGenerator3)
  {
    return new InstanceGenerators.1(paramGenerator3, paramGenerator2, paramGenerator1, paramPredicate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.InstanceGenerators
 * JD-Core Version:    0.7.0.1
 */