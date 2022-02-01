package moai.daemon;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import moai.daemon.utils.DaemonBroadcastReceiver;
import moai.daemon.utils.DaemonSchedulers;
import moai.daemon.utils.DaemonSchedulers.Scheduler;
import moai.daemon.utils.Log;
import moai.daemon.utils.Log.ILogger;

public class DaemonManager
{
  private static final Runnable FINISH_DAEMON_ACTIVITY_TASK = new DaemonManager.2();
  private static final Runnable START_DAEMON_ACTIVITY_TASK;
  private static final String TAG = "DaemonManager";
  private static WeakReference<Context> sContextRef;
  private static long sShowDelay = 2000L;
  
  static
  {
    START_DAEMON_ACTIVITY_TASK = new DaemonManager.1();
  }
  
  private static boolean canStartDaemonActivity()
  {
    return DaemonActivityInterceptor.canDaemonActivityStart();
  }
  
  public static void finishDaemonActivity()
  {
    DaemonSchedulers.single.remove(START_DAEMON_ACTIVITY_TASK);
    DaemonSchedulers.single.run(FINISH_DAEMON_ACTIVITY_TASK);
  }
  
  public static Context getContext()
  {
    if (sContextRef != null) {
      return (Context)sContextRef.get();
    }
    return null;
  }
  
  public static void install(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("DaemonManager", "context is null!");
      return;
    }
    if ((paramContext instanceof Activity)) {
      Log.w("DaemonManager", "context is an Activity context, may be recycled");
    }
    sContextRef = new WeakReference(paramContext);
    DaemonBroadcastReceiver.register();
    Log.i("DaemonManager", "Daemon install success");
  }
  
  public static void setDaemonActivityInterceptor(DaemonActivityInterceptor.IDaemonActivityInterceptor paramIDaemonActivityInterceptor)
  {
    DaemonActivityInterceptor.setDaemonActivityInterceptor(paramIDaemonActivityInterceptor);
  }
  
  public static void setLogger(Log.ILogger paramILogger, int paramInt)
  {
    Log.setLogger(paramILogger);
    Log.setLevel(paramInt);
  }
  
  public static void setShowDaemonActivityDelay(long paramLong)
  {
    if (paramLong >= 0L) {
      sShowDelay = paramLong;
    }
  }
  
  public static void startDaemonActivity()
  {
    if (!canStartDaemonActivity()) {
      return;
    }
    Log.i("DaemonManager", "may start DaemonActivity after " + sShowDelay + "ms");
    DaemonSchedulers.single.run(START_DAEMON_ACTIVITY_TASK, sShowDelay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.DaemonManager
 * JD-Core Version:    0.7.0.1
 */