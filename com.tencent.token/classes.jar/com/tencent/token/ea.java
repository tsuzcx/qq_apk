package com.tencent.token;

import android.text.format.Time;
import android.util.Log;

public final class ea
{
  public static final ea a = new ea();
  
  public final String a(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt != 32)
          {
            switch (paramInt)
            {
            default: 
              return "-";
            case 2: 
              return "D";
            }
            return "V";
          }
          return "A";
        }
        return "E";
      }
      return "W";
    }
    return "I";
  }
  
  public String a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    long l = paramLong % 1000L;
    Time localTime = new Time();
    localTime.set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt));
    localStringBuilder.append('/');
    localStringBuilder.append(localTime.format("%Y-%m-%d %H:%M:%S"));
    localStringBuilder.append('.');
    if (l < 10L) {
      localStringBuilder.append("00");
    } else if (l < 100L) {
      localStringBuilder.append('0');
    }
    localStringBuilder.append(l);
    localStringBuilder.append(' ');
    localStringBuilder.append('[');
    if (paramThread == null) {
      localStringBuilder.append("N/A");
    } else {
      localStringBuilder.append(paramThread.getName());
    }
    localStringBuilder.append(']');
    localStringBuilder.append('[');
    localStringBuilder.append(paramString1);
    localStringBuilder.append(']');
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString2);
    localStringBuilder.append('\n');
    if (paramThrowable != null)
    {
      localStringBuilder.append("* Exception : \n");
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ea
 * JD-Core Version:    0.7.0.1
 */