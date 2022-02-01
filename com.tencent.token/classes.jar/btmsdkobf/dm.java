package btmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class dm
{
  public static PendingIntent a(Context paramContext, String paramString, long paramLong)
  {
    Object localObject1 = new StringBuilder("添加闹钟 : ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramLong / 1000L);
    ((StringBuilder)localObject1).append("s");
    eh.f("AlarmerUtil", ((StringBuilder)localObject1).toString());
    Object localObject2 = null;
    localObject1 = localObject2;
    try
    {
      paramString = new Intent(paramString);
      localObject1 = localObject2;
      paramString.setPackage(bc.n().getPackageName());
      localObject1 = localObject2;
      paramString = PendingIntent.getBroadcast(paramContext, 0, paramString, 0);
      localObject1 = paramString;
      ((AlarmManager)paramContext.getSystemService("alarm")).set(0, System.currentTimeMillis() + paramLong, paramString);
      return paramString;
    }
    catch (Throwable paramContext)
    {
      eh.h("AlarmerUtil", "addAlarm: ".concat(String.valueOf(paramContext)));
    }
    return localObject1;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      paramString = new Intent(paramString);
      paramString.setPackage(bc.n().getPackageName());
      paramString = PendingIntent.getBroadcast(paramContext, 0, paramString, 0);
      ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      eh.h("AlarmerUtil", "delAlarm exception: ".concat(String.valueOf(paramContext)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dm
 * JD-Core Version:    0.7.0.1
 */