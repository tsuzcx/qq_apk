package com.tencent.token;

import android.text.format.Time;
import android.util.Log;

public final class dy
{
  public static final dy a = new dy();
  
  public final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "-";
    case 2: 
      return "D";
    case 4: 
      return "I";
    case 8: 
      return "W";
    case 16: 
      return "E";
    case 1: 
      return "V";
    }
    return "A";
  }
  
  public String a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    long l = paramLong % 1000L;
    Time localTime = new Time();
    localTime.set(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramInt)).append('/').append(localTime.format("%Y-%m-%d %H:%M:%S")).append('.');
    if (l < 10L)
    {
      localStringBuilder.append("00");
      localStringBuilder.append(l).append(' ').append('[');
      if (paramThread != null) {
        break label199;
      }
      localStringBuilder.append("N/A");
    }
    for (;;)
    {
      localStringBuilder.append(']').append('[').append(paramString1).append(']').append(' ').append(paramString2).append('\n');
      if (paramThrowable != null) {
        localStringBuilder.append("* Exception : \n").append(Log.getStackTraceString(paramThrowable)).append('\n');
      }
      return localStringBuilder.toString();
      if (l >= 100L) {
        break;
      }
      localStringBuilder.append('0');
      break;
      label199:
      localStringBuilder.append(paramThread.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dy
 * JD-Core Version:    0.7.0.1
 */