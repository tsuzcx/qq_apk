package com.tencent.mobileqq.statistics;

import acfp;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CaughtException
  extends Exception
{
  public static final String ADVICE = acfp.m(2131703518);
  private static HashSet<String> bx = new CaughtException.1();
  
  public CaughtException(String paramString)
  {
    this(paramString, null);
  }
  
  public CaughtException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    dRY();
    dRZ();
  }
  
  private boolean a(StackTraceElement paramStackTraceElement)
  {
    Iterator localIterator = bx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramStackTraceElement.toString().contains(str)) {
        return true;
      }
    }
    return false;
  }
  
  private void dRY()
  {
    StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
    ArrayList localArrayList = new ArrayList(arrayOfStackTraceElement.length);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!a(localStackTraceElement)) {
        localArrayList.add(localStackTraceElement);
      }
      i += 1;
    }
    setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[localArrayList.size()]));
  }
  
  private void dRZ()
  {
    String str = getMessage();
    try
    {
      Field localField = Throwable.class.getDeclaredField("detailMessage");
      localField.setAccessible(true);
      localField.set(this, ADVICE + str);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaughtException
 * JD-Core Version:    0.7.0.1
 */