package com.tencent.qapmsdk.impl.util;

import android.content.Context;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.appstate.AppState;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TraceUtil
{
  public static final int ANR_ACTIONS_MAX_COUNT = 20;
  public static final int ANR_THRESHOLD = 5000;
  public static final String COLD_LAUNCH = "COLD_LAUNCH";
  public static final String FIRST_TIME_LAUNCH = "FIRST_TIME_LAUNCH";
  public static final int HOT_START_THRESHOLD = 180;
  public static final int HTTP_MONITOR_REPORT_THRESHOLD = 60000;
  public static final String LAUNCH_ACTIVITY_LOAD = "LAUNCH_ACTIVITY_LOAD";
  public static final String LAUNCH_APPLICATION_INIT = "LAUNCH_APPLICATION_INIT";
  public static final List<String> LAUNCH_KATEGRORY = Arrays.asList(new String[] { "FIRST_TIME_LAUNCH", "COLD_LAUNCH", "WARM_LAUNCH" });
  public static final String LAUNCH_MAIN_ACTIVITY_INIT = "LAUNCH_MAIN_ACTIVITY_INIT";
  private static final Random RANDOM;
  public static final int REPORT_THRESHOLD = 5000;
  public static final int SLOW_START_THRESHOLD = 3000;
  public static final long SLOW_USER_ACTION_THRESHOLD = 3000L;
  public static final int S_DOM_THR = 2100;
  public static final int S_FIRSTPAINT_THR = 1400;
  public static final int S_PAGE_THR = 7000;
  public static final String WARM_LAUNCH = "WARM_LAUNCH";
  public static AtomicInteger appState = new AtomicInteger(AppState.INIT.getValue());
  public static boolean canInstrumentMonitor = true;
  private static boolean canMonitorHttp = false;
  private static Context context;
  private static boolean firstVisit;
  public static int versionCode = 0;
  
  static
  {
    RANDOM = new Random();
    firstVisit = true;
  }
  
  public static boolean getCanMonitorHttp()
  {
    return canMonitorHttp;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static boolean getFirstVisit()
  {
    return firstVisit;
  }
  
  public static Random getRandom()
  {
    return RANDOM;
  }
  
  public static void saveContext(Context paramContext)
  {
    context = paramContext;
  }
  
  public static void setCanMonitorHttp(boolean paramBoolean)
  {
    canMonitorHttp = paramBoolean;
    NetworkWatcher.INSTANCE.setNetMonitor(canMonitorHttp);
  }
  
  public static void setFirstVisit(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      firstVisit = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.util.TraceUtil
 * JD-Core Version:    0.7.0.1
 */