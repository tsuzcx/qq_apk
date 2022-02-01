package moai.patch.log;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class MemoryMonitor
{
  private ActivityManager activityManager;
  private int pid1 = -1;
  
  public MemoryMonitor(Context paramContext)
  {
    this.activityManager = ((ActivityManager)paramContext.getSystemService("activity"));
    paramContext = this.activityManager.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == Process.myPid()) {
        this.pid1 = localRunningAppProcessInfo.pid;
      }
    }
  }
  
  public void run()
  {
    if (this.pid1 == -1) {
      return;
    }
    int i = this.pid1;
    try
    {
      for (;;)
      {
        Thread.sleep(700L);
        label20:
        PatchLog.i(9001, "totalPss:" + this.activityManager.getProcessMemoryInfo(new int[] { i })[0].getTotalPss());
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label20;
    }
  }
  
  public void start()
  {
    new Thread(new MemoryMonitor.1(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.MemoryMonitor
 * JD-Core Version:    0.7.0.1
 */