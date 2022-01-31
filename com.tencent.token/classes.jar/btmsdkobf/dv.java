package btmsdkobf;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.ConcurrentHashMap;

public class dv
{
  private static Object lock = new Object();
  private static dv nC = null;
  private static Object nD = new Object();
  ConcurrentHashMap nB = new ConcurrentHashMap();
  private Context ny = bc.n();
  
  public static dv cQ()
  {
    if (nC == null) {}
    synchronized (lock)
    {
      if (nC == null) {
        nC = new dv();
      }
      return nC;
    }
  }
  
  public void D(String paramString)
  {
    synchronized (nD)
    {
      im localim = (im)this.nB.remove(paramString);
      if (localim != null)
      {
        dm.a(this.ny, paramString);
        this.ny.unregisterReceiver(localim);
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
        im localim = new im(this);
        this.ny.registerReceiver(localim, new IntentFilter(paramString));
        localim.b = paramRunnable;
        localim.a = paramString;
        paramRunnable = new Intent(paramString);
        paramRunnable = PendingIntent.getBroadcast(this.ny, 0, paramRunnable, 0);
        AlarmManager localAlarmManager = (AlarmManager)this.ny.getSystemService("alarm");
        this.nB.put(paramString, localim);
        localAlarmManager.set(paramInt, System.currentTimeMillis() + paramLong, paramRunnable);
        return;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dv
 * JD-Core Version:    0.7.0.1
 */