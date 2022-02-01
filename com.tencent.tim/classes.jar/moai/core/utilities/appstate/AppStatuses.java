package moai.core.utilities.appstate;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;
import moai.log.MLog;
import moai.log.MLogManager;

public class AppStatuses
{
  private static final String TAG = "AppStatuses";
  private static boolean bIsAppOnBackground = true;
  private static boolean bIsNetworkConnected;
  private static final MLog logger = MLogManager.getLogger("moailog");
  private static Application.ActivityLifecycleCallbacks sLifecycleCallbacks = new AppStatuses.1();
  
  public static void didGotoBackground(Context paramContext)
  {
    setAppStatus(false);
    ((GotoBackgroundWatcher)Watchers.of(GotoBackgroundWatcher.class)).onGotoBackground();
  }
  
  public static boolean didGotoForeground()
  {
    setAppStatus(true);
    ((GotoForegroundWatcher)Watchers.of(GotoForegroundWatcher.class)).onGotoForeground();
    return true;
  }
  
  public static ActivityManager.RunningAppProcessInfo getMainProcessInfo(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = paramContext.getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.processName.equals(paramContext)) {
        return localRunningAppProcessInfo;
      }
    }
    return null;
  }
  
  public static boolean isAppOnBackGround()
  {
    return bIsAppOnBackground;
  }
  
  @Deprecated
  public static boolean isAppOnForeground(Context paramContext)
  {
    if (isScreenLocked(paramContext)) {}
    do
    {
      return false;
      paramContext = getMainProcessInfo(paramContext);
    } while ((paramContext == null) || (paramContext.importance != 100));
    return true;
  }
  
  @Deprecated
  public static boolean isApplicationActive(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localList != null) && (localList.size() >= 1)) {
      return ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName().equals(paramContext.getApplicationInfo().packageName);
    }
    return false;
  }
  
  public static boolean isNetworkConnected()
  {
    return bIsNetworkConnected;
  }
  
  public static final boolean isScreenLocked(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static void registerActivityLifecycleCalbacks(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(sLifecycleCallbacks);
  }
  
  private static void setAppStatus(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bIsAppOnBackground = bool;
      logger.d("AppStatuses", "setAppStatus:" + paramBoolean);
      return;
    }
  }
  
  public static void setNetworkConnected(boolean paramBoolean)
  {
    bIsNetworkConnected = paramBoolean;
  }
  
  public static void unRegisterAcitivityLifecycleCallbacks(Application paramApplication)
  {
    paramApplication.unregisterActivityLifecycleCallbacks(sLifecycleCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.appstate.AppStatuses
 * JD-Core Version:    0.7.0.1
 */