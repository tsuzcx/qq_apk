package moai.patch.handle;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.patch.log.PatchLog;

public class ProcessKiller
{
  private static List<Integer> getAllPid(Context paramContext)
  {
    int i = Process.myUid();
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    paramContext = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.uid == i)) {
        paramContext.add(Integer.valueOf(localRunningAppProcessInfo.pid));
      }
    }
    return paramContext;
  }
  
  public static void killAll(Context paramContext, boolean paramBoolean)
  {
    paramContext = getAllPid(paramContext);
    if (paramContext.size() > 0)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        int i = ((Integer)paramContext.next()).intValue();
        if (i != Process.myPid())
        {
          PatchLog.i(9005, "kill process:" + i);
          Process.killProcess(i);
        }
      }
    }
    if (!paramBoolean)
    {
      PatchLog.i(9005, "kill main process:" + Process.myPid());
      Process.killProcess(Process.myPid());
    }
  }
  
  public static void killSelf(long paramLong)
  {
    int i = Process.myPid();
    PatchLog.i(9005, "kill self process:" + i);
    if (paramLong <= 0L)
    {
      Process.killProcess(i);
      return;
    }
    new ProcessKiller.1(paramLong, i).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.handle.ProcessKiller
 * JD-Core Version:    0.7.0.1
 */