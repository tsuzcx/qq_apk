package tmsdk.common.c.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static a d;
  private static Object e = new Object();
  ConcurrentHashMap a = new ConcurrentHashMap();
  private Handler b = null;
  private Context c = tmsdk.common.a.a();
  
  public static a a()
  {
    if (d == null) {
      synchronized (e)
      {
        if (d == null) {
          d = new a();
        }
      }
    }
    return d;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("注销闹钟任务 : action : ");
    localStringBuilder.append(paramString);
    localStringBuilder.toString();
    paramString = (b)this.a.remove(paramString);
    if (paramString != null) {
      this.c.unregisterReceiver(paramString);
    }
  }
  
  public void a(String paramString, long paramLong, Runnable paramRunnable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("添加闹钟任务 : action : ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    ((StringBuilder)localObject).append(paramLong / 1000L);
    ((StringBuilder)localObject).append("s");
    ((StringBuilder)localObject).toString();
    localObject = new b(this);
    this.c.registerReceiver((BroadcastReceiver)localObject, new IntentFilter(paramString));
    ((b)localObject).b = paramRunnable;
    ((b)localObject).a = paramString;
    paramRunnable = new Intent(paramString);
    paramRunnable = PendingIntent.getBroadcast(this.c, 0, paramRunnable, 0);
    AlarmManager localAlarmManager = (AlarmManager)this.c.getSystemService("alarm");
    this.a.put(paramString, localObject);
    localAlarmManager.set(0, System.currentTimeMillis() + paramLong, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.a
 * JD-Core Version:    0.7.0.1
 */