package com.tencent.qqmail.utilities.patch;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.qqmail.QuickLaunchActivity;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import moai.patch.extra.QuickLaunch;

public class QMQuickLauncher
  implements QuickLaunch
{
  private static final String TAG = "QMQuickLauncher";
  
  private boolean isApplicationActiveAfterLollipop(Context paramContext)
  {
    try
    {
      Field localField1 = ActivityManager.class.getDeclaredField("PROCESS_STATE_TOP");
      localField1.setAccessible(true);
      Field localField2 = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
      localField2.setAccessible(true);
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if ((paramContext.getPackageName().equals(localRunningAppProcessInfo.processName)) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.importanceReasonCode == 0))
        {
          int i = localField2.getInt(localRunningAppProcessInfo);
          int j = localField1.getInt(null);
          return i == j;
        }
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean isApplicationActiveBeforeLollipop(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getPackageName();
      return paramContext.getPackageName().equals(localObject);
    }
    return false;
  }
  
  public boolean isApplicationActive(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return isApplicationActiveAfterLollipop(paramContext);
    }
    return isApplicationActiveBeforeLollipop(paramContext);
  }
  
  public void launch(Context paramContext, String paramString, boolean paramBoolean, long paramLong)
  {
    Log.i("QMQuickLauncher", "quick launch: " + paramString + ", oat: " + paramBoolean);
    if ((paramBoolean) && (paramContext.getPackageName().equals(paramString)) && (isApplicationActive(paramContext))) {
      paramContext.startActivity(new Intent(paramContext, QuickLaunchActivity.class).addFlags(268435456).putExtra("begin", paramLong));
    }
  }
  
  public void onFinish(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMQuickLauncher
 * JD-Core Version:    0.7.0.1
 */