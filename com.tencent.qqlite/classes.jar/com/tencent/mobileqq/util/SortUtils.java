package com.tencent.mobileqq.util;

import android.util.Pair;
import euy;
import java.util.ArrayList;
import java.util.Arrays;

public class SortUtils
{
  public static ArrayList a(ArrayList paramArrayList)
  {
    Object[] arrayOfObject = new Object[paramArrayList.size()];
    int i = 0;
    Object localObject;
    while (i < paramArrayList.size())
    {
      localObject = (Pair)paramArrayList.get(i);
      arrayOfObject[i] = { (String)((Pair)localObject).first, String.valueOf(((Pair)localObject).second) };
      i += 1;
    }
    Arrays.sort(arrayOfObject, new euy());
    paramArrayList.clear();
    i = 0;
    while (i < arrayOfObject.length)
    {
      localObject = (String[])arrayOfObject[i];
      paramArrayList.add(Pair.create(localObject[0], Long.valueOf(Long.parseLong(localObject[1]))));
      i += 1;
    }
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.SortUtils
 * JD-Core Version:    0.7.0.1
 */