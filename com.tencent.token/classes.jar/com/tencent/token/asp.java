package com.tencent.token;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class asp
{
  public static PendingIntent a(Context paramContext, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("添加闹钟 : ");
    localStringBuilder.append(paramLong / 1000L);
    localStringBuilder.append("s");
    paramString = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramString), 0);
    ((AlarmManager)paramContext.getSystemService("alarm")).set(0, System.currentTimeMillis() + paramLong, paramString);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramString), 0);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asp
 * JD-Core Version:    0.7.0.1
 */