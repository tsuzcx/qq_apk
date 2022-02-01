package tmsdk.common.d.a.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class a
{
  public static PendingIntent a(Context paramContext, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("添加闹钟 : ");
    localStringBuilder.append(paramLong / 1000L);
    localStringBuilder.append("s");
    localStringBuilder.toString();
    paramString = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramString), 0);
    ((AlarmManager)paramContext.getSystemService("alarm")).set(0, System.currentTimeMillis() + paramLong, paramString);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("删除闹钟 : ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    paramString = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramString), 0);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */