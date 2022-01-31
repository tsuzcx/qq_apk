package com.tencent.token;

import android.text.format.Time;

public final class gc
{
  public static final gc a = new gc();
  
  public static String a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2)
  {
    long l = paramLong % 1000L;
    Time localTime = new Time();
    localTime.set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    switch (paramInt)
    {
    default: 
      str = "-";
      localStringBuilder.append(str).append('/').append(localTime.format("%Y-%m-%d %H:%M:%S")).append('.');
      if (l < 10L)
      {
        localStringBuilder.append("00");
        label141:
        localStringBuilder.append(l).append(' ').append('[');
        if (paramThread != null) {
          break label277;
        }
        localStringBuilder.append("N/A");
      }
      break;
    }
    for (;;)
    {
      localStringBuilder.append(']').append('[').append(paramString1).append(']').append(' ').append(paramString2).append('\n');
      return localStringBuilder.toString();
      str = "D";
      break;
      str = "I";
      break;
      str = "W";
      break;
      str = "E";
      break;
      str = "V";
      break;
      str = "A";
      break;
      if (l >= 100L) {
        break label141;
      }
      localStringBuilder.append('0');
      break label141;
      label277:
      localStringBuilder.append(paramThread.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gc
 * JD-Core Version:    0.7.0.1
 */