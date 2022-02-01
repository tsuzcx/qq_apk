package com.tencent.token.global.taiji;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

public class e
{
  private static HashMap<Thread, i.c> a = new HashMap();
  private static HandlerThread b;
  private static HandlerThread c;
  
  public static HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    try
    {
      paramString = new d(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Looper a(long paramLong)
  {
    if (1L == paramLong) {}
    try
    {
      if (b != null)
      {
        if (!b.isAlive())
        {
          b = new d("hostHandlerThread", 5, paramLong, true);
          b.start();
        }
      }
      else
      {
        b = new d("hostHandlerThread", 5, paramLong, true);
        b.start();
      }
      localLooper = b.getLooper();
      return localLooper;
    }
    finally {}
    if (c != null)
    {
      if (!c.isAlive())
      {
        c = new d("otherHandlerThread", 5, paramLong, true);
        c.start();
      }
    }
    else
    {
      c = new d("otherHandlerThread", 5, paramLong, true);
      c.start();
    }
    Looper localLooper = c.getLooper();
    return localLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.e
 * JD-Core Version:    0.7.0.1
 */