package btmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.ConcurrentHashMap;

public class dv
{
  private static Object lock = new Object();
  private static dv nC;
  private static Object nD = new Object();
  ConcurrentHashMap<String, a> nB = new ConcurrentHashMap();
  private Context ny = bc.n();
  
  public static dv cQ()
  {
    if (nC == null) {
      synchronized (lock)
      {
        if (nC == null) {
          nC = new dv();
        }
      }
    }
    return nC;
  }
  
  public void D(String paramString)
  {
    synchronized (nD)
    {
      a locala = (a)this.nB.remove(paramString);
      if (locala != null)
      {
        dm.a(this.ny, paramString);
        this.ny.unregisterReceiver(locala);
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong, Runnable paramRunnable, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    try
    {
      synchronized (nD)
      {
        a locala = new a();
        this.ny.registerReceiver(locala, new IntentFilter(paramString));
        locala.b = paramRunnable;
        locala.a = paramString;
        paramRunnable = new Intent(paramString);
        paramRunnable = PendingIntent.getBroadcast(this.ny, 0, paramRunnable, 0);
        AlarmManager localAlarmManager = (AlarmManager)this.ny.getSystemService("alarm");
        this.nB.put(paramString, locala);
        localAlarmManager.set(paramInt, System.currentTimeMillis() + paramLong, paramRunnable);
        return;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  class a
    extends BroadcastReceiver
  {
    public String a = null;
    public Runnable b = null;
    
    a() {}
    
    public void onReceive(final Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext == null) {
        return;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("action:");
      paramIntent.append(paramContext);
      eg.f("cccccc", paramIntent.toString());
      if (this.a.equals(paramContext))
      {
        if (this.b == null) {
          return;
        }
        ee.cT().addTask(new Runnable()
        {
          public void run()
          {
            dv.a.this.b.run();
            dv.this.D(paramContext);
          }
        }, "AlarmerTaskReceiver");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dv
 * JD-Core Version:    0.7.0.1
 */