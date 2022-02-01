package com.tencent.superplayer.utils;

import java.util.Iterator;
import java.util.List;

public class MathUtils
{
  public static int avgIntList(List<Integer> paramList)
  {
    int i = 0;
    int j = paramList.size();
    if (j > 0)
    {
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = ((Integer)paramList.next()).intValue() + i) {}
      i /= j;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.MathUtils
 * JD-Core Version:    0.7.0.1
 */