package com.tencent.qqmail.trd.guava;

import java.util.Collection;
import java.util.Iterator;

public class Longs
{
  public static long[] toArray(Collection<Long> paramCollection)
  {
    long[] arrayOfLong = new long[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfLong[i] = ((Long)paramCollection.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.guava.Longs
 * JD-Core Version:    0.7.0.1
 */