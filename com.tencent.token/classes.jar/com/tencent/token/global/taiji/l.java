package com.tencent.token.global.taiji;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

public class l
{
  private static HashMap a = new HashMap();
  private static HandlerThread b;
  private static HandlerThread c;
  
  public static HandlerThread a(String paramString, int paramInt, long paramLong)
  {
    try
    {
      paramString = new k(paramString, paramInt, paramLong);
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
    if (1L == paramLong)
    {
      try
      {
        if (b != null) {
          if (!b.isAlive())
          {
            b = new k("hostHandlerThread", 5, paramLong, true);
            b.start();
          }
        }
        for (;;)
        {
          Looper localLooper1 = b.getLooper();
          return localLooper1;
          b = new k("hostHandlerThread", 5, paramLong, true);
          b.start();
        }
        if (c == null) {
          break label133;
        }
      }
      finally {}
    }
    else if (!c.isAlive())
    {
      c = new k("otherHandlerThread", 5, paramLong, true);
      c.start();
    }
    for (;;)
    {
      Looper localLooper2 = c.getLooper();
      break;
      label133:
      c = new k("otherHandlerThread", 5, paramLong, true);
      c.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.l
 * JD-Core Version:    0.7.0.1
 */